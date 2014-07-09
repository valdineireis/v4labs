package br.com.valdineireis.v4labs.validators;

import br.com.caelum.vraptor.validator.Validator;
import br.com.valdineireis.v4labs.dao.IUsuarioDAO;
import br.com.valdineireis.v4labs.factory.MessageFactory;
import javax.inject.Inject;

public class EmailValidator {

    private IUsuarioDAO users;
    private Validator validator;
    private MessageFactory messageFactory;

    @Deprecated
    public EmailValidator() {
    }

    @Inject
    public EmailValidator(Validator validator, IUsuarioDAO users, MessageFactory messageFactory) {
        this.users = users;
        this.validator = validator;
        this.messageFactory = messageFactory;
    }

    public boolean validate(String email) {
        if (users.contemUsuarioComLogin(email)) {
            validator.add(messageFactory.build("error", "user.errors.email.used"));
        }
        if (email == null) {
            validator.add(messageFactory.build("error", "user.errors.email.required"));
        }

        return !validator.hasErrors();
    }
}
