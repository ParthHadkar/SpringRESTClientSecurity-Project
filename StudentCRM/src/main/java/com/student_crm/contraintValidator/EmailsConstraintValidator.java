package com.student_crm.contraintValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.student_crm.validation.ValidEmail;

public class EmailsConstraintValidator implements ConstraintValidator<ValidEmail, String> {

	private Pattern pattern;
	private Matcher matcher;
	private String EMAILPATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private String[] emails;
	
	
	
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		emails = constraintAnnotation.value();
	}



	@Override
	public boolean isValid(String emailVal, ConstraintValidatorContext context) {
		boolean valid = false;
		try {
			pattern = Pattern.compile(EMAILPATTERN);
			if(emailVal != null) {
			matcher = pattern.matcher(emailVal);
			valid = matcher.matches();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

}
