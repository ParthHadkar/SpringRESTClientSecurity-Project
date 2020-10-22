package com.student_crm.contraintValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.student_crm.validation.FieldMatch;

public class FieldConstraintValidator implements ConstraintValidator<FieldMatch, Object>{

	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}



	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = false;
		try {
			final Object firstObj = new BeanWrapperImpl(value).getPropertyValue(firstFieldName);
			final Object secondObj = new BeanWrapperImpl(value).getPropertyValue(secondFieldName);
			valid = firstObj == null && secondObj == null || firstObj!=null && firstObj.equals(secondObj);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		if(!valid) {
			context.buildConstraintViolationWithTemplate(message)
			.addPropertyNode(firstFieldName)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		}
		return valid;
	}
	
	

}
