package br.com.valdineireis.v4labs.controller;

import static java.util.Arrays.asList;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.valdineireis.v4labs.dao.UsuarioDAO;
import br.com.valdineireis.v4labs.factory.MessageFactory;
import br.com.valdineireis.v4labs.model.Usuario;
import br.com.valdineireis.v4labs.validators.UrlValidator;
import br.com.valdineireis.v4labs.infra.security.UserSession;

import javax.inject.Inject;

import com.google.common.base.Strings;

/**
 *
 * @author valdineireis
 */
@Controller
public class HomeController {

    private Result result;
    private Validator validator;
    private UsuarioDAO dao;
    private MessageFactory messageFactory;
    private UrlValidator urlValidator;
    private UserSession userSession;

    //CDI eyes only
    @Deprecated
    public HomeController() {
    }

    /**
     * You can receive any dependency on constructor. If VRaptor knows all
     * dependencies, this class will be created with no problem. You can use as
     * dependencies: - all VRaptor components, e.g {@link Result} and
     * {@link Validator} - all of your CDI classes, e.g {@link DefaultUserDao}
     * @param dao UsuarioDAO
     * @param result
     * @param validator
     * @param userSession
     * @param messageFactory
     * @param urlValidator
     */
    @Inject
    public HomeController(UsuarioDAO dao, Result result, Validator validator, 
            UserSession userSession, MessageFactory messageFactory, UrlValidator urlValidator) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        this.messageFactory = messageFactory;
        this.urlValidator = urlValidator;
        this.userSession = userSession;
    }

    /**
     * Since we are using the convention, the URI for this method is /home/login
     *
     * The method parameters are set with request parameters named login and
     * password. Thus if we have the request:
     *
     * POST /home/login login=john password=nobodyknows
     *
     * VRaptor will call: homeController.login("john", "nobodyknows");
     *
     * This method only accept POST requests
     * @param login
     * @param password
     * @param remember
     * @param redirectUrl
     */
    @Post
    public void login(String login, String password, boolean remember, String redirectUrl) {
        // search for the user in the database
        final Usuario dbUser = dao.busca(login, password);

        // if no user is found, adds an error message to the validator
        // "invalid_login_or_password" is the message key from messages.properties,
        // and that key is used with the fmt taglib in index.jsp, for example: <fmt:message key="error.key">
        validator.check(dbUser != null, new SimpleMessage("login", "invalid_login_or_password"));

        // you can use "this" to redirect to another logic from this controller
        validator.onErrorUsePageOf(this).login(redirectUrl);

        // the login was valid, add user to session
        userSession.login(dbUser);

        // Apresenta uma mensagem de sucesso para o usuário.
        result.include("success", asList(messageFactory.build("login", "login_success")));

        // we don't want to go to default page (/WEB-INF/jsp/home/login.jsp)
        // we want to redirect to the user's home
        redirectToRightUrl(redirectUrl);
    }

    /**
     * Using the convention, the URI for this method is /home/logout
     */
    public void logout() {
        userSession.logout();

        // after logging out, we want to be redirected to home index.
        // redirect to another logic from this controller
        result.redirectTo(this).login(null);
    }

    /**
     * We should not provide direct access to jsps, so we need to have an empty
     * method for redirecting to jsp. In this case we will use the root URI,
     * which will be redirected to jsp /WEB-INF/jsp/home/login.jsp
     *
     * This method only accepts GET requests
     * @param redirectUrl
     */
    @Get("/login")
    public void login(String redirectUrl) {
        if (!Strings.isNullOrEmpty(redirectUrl)) {
            result.include("redirectUrl", redirectUrl);
        }
    }

    private void redirectToRightUrl(String redirectUrl) {
        boolean valid = urlValidator.isValid(redirectUrl);
        if (!valid) {
            result.include("warning", asList(messageFactory.build("error", "error.invalid.url", redirectUrl)));
        }
        if (!Strings.isNullOrEmpty(redirectUrl) && valid) {
            result.redirectTo(redirectUrl);
        } else {
            result.redirectTo(IndexController.class).index();
        }
    }
}
