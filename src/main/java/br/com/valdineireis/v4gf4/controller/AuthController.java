package br.com.valdineireis.v4gf4.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;
import javax.inject.Inject;
import org.apache.shiro.authz.AuthorizationException;

@Controller
public class AuthController implements AuthorizationRestrictionListener {

    @Inject private Result result;
    
    @Override
    public void onAuthorizationRestriction(AuthorizationException e) {
        result.include("error", e.toString());
        result.forwardTo(HomeController.class).login();
    }
    
}
