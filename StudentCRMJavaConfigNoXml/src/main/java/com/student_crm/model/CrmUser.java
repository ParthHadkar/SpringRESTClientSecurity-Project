package com.student_crm.model;

import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.student_crm.validation.ValidEmail;
import com.student_crm.validation.ValidRoles;
import com.student_crm.validation.FieldMatch;

@FieldMatch.List(value = {
		@FieldMatch(first = "password",second = "confirmPassword",
				message = "Password Must Be Same")
})
public class CrmUser {
	
	@NotNull(message = "Username Is Required")
	@Size(min = 1,message = "Username Is Required")
	private String username;
	
	@NotNull(message = "Password Is Required")
	@Size(min = 1,message = "Password Is Required")
	private String password;
	
	@NotNull(message = "Confirm Password Is Required")
	@Size(min = 1,message = "Confirm Password Is Required")
	private String confirmPassword;
	
	@NotNull(message = "First Name Is Required")
	@Size(min = 1,message = "First Name Is Required")
	private String firstname;
	
	@NotNull(message = "Last Name Is Required")
	@Size(min = 1,message = "Last Name Is Required")
	private String lastName;
	
	@ValidEmail(message = "EmailId Is Required")
	@NotNull(message = "EmailId Is Required")
	@Size(min = 1,message = "EmailId Is Required")
	private String emailId;
	
	@NotNull(message = "Please Select Atleast One roles")
	@Size(min = 1,message = "Please Select Atleast One roles")
	@ValidRoles(value = {"ROLE_EMPLOYEE"},message = "Employee Selection Is Manditory")
	private String[] roles;

	public CrmUser() {}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "CrmUser [username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", firstname=" + firstname + ", lastName=" + lastName + ", emailId=" + emailId + ", roles="
				+ Arrays.toString(roles) + "]";
	}
	
}
