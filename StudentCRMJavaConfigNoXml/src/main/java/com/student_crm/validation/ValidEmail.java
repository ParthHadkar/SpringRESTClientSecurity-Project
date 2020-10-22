package com.student_crm.validation;



import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.student_crm.contraintValidator.EmailsConstraintValidator;

@Constraint(validatedBy = EmailsConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidEmail {
	
	// define default value
	public String[] value() default {};
	// define default error
	public String message() default "EmailId Not Valid";
	// define default groups
	public Class<?>[] groups() default {};
	// define default payload
	public Class<? extends Payload>[] payload() default {};
	
}
