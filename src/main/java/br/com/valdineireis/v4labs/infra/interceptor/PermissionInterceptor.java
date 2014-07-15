package br.com.valdineireis.v4labs.infra.interceptor;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.com.valdineireis.v4labs.dao.IUsuarioDAO;
import br.com.valdineireis.v4labs.infra.annotation.Permission;

import java.util.Arrays;
import java.util.Collection;

import javax.inject.Inject;

import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.valdineireis.v4labs.infra.UserSession;

/**
 *
 * @author valdineireis
 */
@Intercepts
@AcceptsWithAnnotations(Permission.class)
public class PermissionInterceptor {

    @Inject
    private Result result;

    @Inject
    private IUsuarioDAO usuarioDAO;

    @Inject
    private UserSession info;

    @AroundCall
    public void around(SimpleInterceptorStack stack, ControllerMethod controllerMethod) {

        Permission methodPermission = controllerMethod.getMethod().getAnnotation(Permission.class);

        if (this.hasAccess(methodPermission)) {
            stack.next();
        } else {
            result.use(Results.http())
                    .sendError(403, new SimpleMessage("Security", "seguranca.acesso.nao.permitido")
                            .getMessage());
        }
    }

    private boolean hasAccess(Permission permission) {

        if (permission == null) {
            return true;
        }

        Collection<String> permissoes = Arrays.asList(permission.value());

        return verifyPermission(permissoes);
    }

    private boolean verifyPermission(Collection<String> permissoes) {
        for (String permissao : permissoes) {
            if (usuarioDAO.isPermissionExist(info.getUser(), permissao)) {
                return true;
            }
        }
        return false;
    }
}
