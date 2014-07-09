package br.com.valdineireis.v4gf4.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.valdineireis.v4gf4.dao.UsuarioDAO;
import br.com.valdineireis.v4gf4.model.Usuario;
import javax.inject.Inject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author valdineireis
 */
@Controller
public class HomeController {

    private Result result;
    private Validator validator;
    private UsuarioDAO dao;
    
    private Subject currentUser;
    private Session session;
    private PasswordService passwordService;

    //CDI eyes only
    @Deprecated
    public HomeController() {
    }

    /**
     * You can receive any dependency on constructor. If VRaptor knows all
     * dependencies, this class will be created with no problem. You can use as
     * dependencies: - all VRaptor components, e.g {@link Result} and
     * {@link Validator} - all of your CDI classes, e.g {@link DefaultUserDao}
     */
    @Inject
    public HomeController(UsuarioDAO dao, 
            Result result, Validator validator, 
            Subject currentUser, Session session,
            PasswordService passwordService) {
        this.dao = dao;
        this.result = result;
        this.validator = validator;
        
        this.currentUser = currentUser;
        this.session = session;
        this.passwordService = passwordService;
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
     */
    @Post
    public void login(String login, String password, boolean remember) {
        String passwordCript = passwordService.encryptPassword(password);
        
        // search for the user in the database
        final Usuario dbUser = dao.busca(login, passwordCript);

        // if no user is found, adds an error message to the validator
        // "invalid_login_or_password" is the message key from messages.properties,
        // and that key is used with the fmt taglib in index.jsp, for example: <fmt:message key="error.key">
        validator.check(dbUser != null, new SimpleMessage("login", "invalid_login_or_password"));

        // you can use "this" to redirect to another logic from this controller
        validator.onErrorUsePageOf(this).login();

        // the login was valid, add user to session
        try {
            currentUser.login(new UsernamePasswordToken(login, passwordCript, remember));
//            session.setAttribute(key, value);
        } 
        catch (UnknownAccountException e) {} 
        catch (IncorrectCredentialsException e) {}
        catch (LockedAccountException e) {}
        catch (ExcessiveAttemptsException e) {}
        catch (AuthenticationException e) {} 

        // we don't want to go to default page (/WEB-INF/jsp/home/login.jsp)
        // we want to redirect to the user's home
        result.redirectTo(IndexController.class).index();
    }

    /**
     * Using the convention, the URI for this method is /home/logout
     */
    public void logout() {
        currentUser.logout();
        
        // after logging out, we want to be redirected to home index.
        // redirect to another logic from this controller
        result.redirectTo(this).login();
    }

    /**
     * We should not provide direct access to jsps, so we need to have an empty
     * method for redirecting to jsp. In this case we will use the root URI,
     * which will be redirected to jsp /WEB-INF/jsp/home/login.jsp
     *
     * This method only accepts GET requests
     */
    @Get("/login")
    public void login() {
    }
}
