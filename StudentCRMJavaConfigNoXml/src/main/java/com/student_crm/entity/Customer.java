package com.student_crm.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.student_crm.validation.EmailValidation;


public class Customer {
	
	
	private int id;
	
	//Spring Validation
	@NotNull
	@Size(min = 1,message = "First Name Is Required")
	private String firstName;
	//Spring Validation
	@NotNull
	@Size(min = 1,message = "Last Name Is Required")
	private String lastName;
	//spring Validation
	@NotNull
	@Pattern(regexp = "\\b[a-zA-z0-9._%+-]{4,32}+@[a-zA-z]{5,32}+\\.[a-zA-z]{2,4}\\b",message = "Email Id Not valid")
	@EmailValidation(value = {"@gmail.com","@yahoo.in","@yahoo.com"},message = "Email Id Must End With @gmail.com OR @yahoo.in/com")
	private String email;
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
}
