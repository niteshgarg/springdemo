package com.myspring.springdemo.service;

import com.myspring.springdemo.controllers.form.RegistrationForm;
import com.myspring.springdemo.domain.User;

public interface UserService {

	public User getUserByEmail(String email);
	
	public void saveUser(RegistrationForm registrationForm);
}
