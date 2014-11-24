package com.myspring.springdemo.controllers.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {

	@NotEmpty(message="email must not be empty") 
	@Email(message="email format is incorrect")
	private String email;
	
	private String role;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
