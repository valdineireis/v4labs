package br.com.valdineireis.v4labs.validators;

import br.com.caelum.vraptor.environment.Environment;
import javax.inject.Inject;

public class UrlValidator {

    private String siteUrl;

    @Deprecated
    public UrlValidator() {
    }

    @Inject
    public UrlValidator(Environment env) {
        this.siteUrl = env.get("host");
    }

    public boolean isValid(String url) {
        return url == null || url.startsWith(siteUrl);
    }
}
