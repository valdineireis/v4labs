package br.com.valdineireis.v4labs.model.validation.impl;

import br.com.valdineireis.v4labs.dao.UsuarioDAO;
import br.com.valdineireis.v4labs.model.Usuario;
import br.com.valdineireis.v4labs.model.validation.LoginAvailable;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author valdineireis
 */
public class LoginAvailableValidator 
    implements ConstraintValidator<LoginAvailable, Usuario> {

    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public void initialize(LoginAvailable constraintAnnotation) {

    }

    @Override
    public boolean isValid(Usuario usuario, ConstraintValidatorContext context) {
        return !usuarioDAO.contemUsuarioComLogin(usuario.getLogin());
    }
}
