package kodlamaio.hrms.core.utilities.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueIdentificationNumberValidator.class})
public @interface UniqueIdentificationNumber {
	
	String message() default "Bu TC kimlik numarası zaten mevcut";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
