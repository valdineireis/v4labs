package br.com.valdineireis.v4labs.infra;

import br.com.caelum.vraptor.security.strategy.ShiroInitConfigStrategy;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

public class InitConfigStrategy implements ShiroInitConfigStrategy {

    @Override
    public void init(DefaultWebSecurityManager securityManager, AuthorizingRealm realm) {
        // Ativa na inicialização do plugin para que o Apache Shiro 
        // passe a fazer autenticação usando do mesmo método de criptografia
        realm.setCredentialsMatcher(new PasswordMatcher());
    }
    
}
