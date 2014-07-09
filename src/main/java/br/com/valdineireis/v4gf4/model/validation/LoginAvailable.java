package br.com.valdineireis.v4gf4.model.validation;

import br.com.valdineireis.v4gf4.model.validation.impl.LoginAvailableValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author valdineireis
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { LoginAvailableValidator.class })
@Documented
public @interface LoginAvailable {
    String message() default "{login_already_exists}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
