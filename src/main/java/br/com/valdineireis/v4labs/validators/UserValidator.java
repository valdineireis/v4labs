package br.com.valdineireis.v4labs.validators;

import br.com.caelum.vraptor.validator.Validator;
import br.com.valdineireis.v4labs.factory.MessageFactory;
import br.com.valdineireis.v4labs.model.Usuario;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserValidator {

    private Validator validator;
    private EmailValidator emailValidator;
    private MessageFactory messageFactory;

    @Deprecated
    public UserValidator() {
    }

    @Inject
    public UserValidator(Validator validator, EmailValidator emailValidator, MessageFactory messageFactory) {
        this.validator = validator;
        this.emailValidator = emailValidator;
        this.messageFactory = messageFactory;
    }

    public boolean validate(Usuario user) {
        if (user == null) {
            validator.add(messageFactory.build("error", "user.errors.wrong"));
            return false;
        }

        emailValidator.validate(user.getLogin());

        return !validator.hasErrors();
    }

    public <T> T onErrorRedirectTo(T controller) {
        return validator.onErrorRedirectTo(controller);
    }
}
