package com.student_crm.contraintValidator;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.student_crm.validation.ValidRoles;

public class RolesConstraintValidator implements ConstraintValidator<ValidRoles, String[]> {

	private String[] roles;
	
	
	@Override
	public void initialize(ValidRoles constraintAnnotation) {
		roles = constraintAnnotation.value();
	}


	@Override
	public boolean isValid(String[] value, ConstraintValidatorContext context) {
		boolean valid = false;
		try {
			for(String role:roles) {
				System.out.println(Arrays.deepToString(value)+" "+role+" "+(value.toString()).contains(role));
				if(Arrays.deepToString(value).toString().contains(role)) {
					valid = true;
					System.out.println(Arrays.deepToString(value)+" "+role+" "+(value.toString()).contains(role)+" "+valid);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valid;
	}

}
