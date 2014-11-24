package com.myspring.springdemo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.springdemo.controllers.form.RegistrationForm;
import com.myspring.springdemo.domain.User;
import com.myspring.springdemo.service.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getLoginPage(ModelMap map) {
		RegistrationForm form = new RegistrationForm();
		map.addAttribute("registrationForm", form);
		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid RegistrationForm registrationForm,
			BindingResult result, ModelMap map, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "registration";
		}		
		
		boolean isUserExists = true;
		String email = registrationForm.getEmail();
	
		 String roleType = "user";
		 registrationForm.setRole(roleType);
		
		User user = userService.getUserByEmail(email);
		
		if (user == null) {
			userService.saveUser(registrationForm);
			isUserExists = false;
		} else {
			if(!user.getRole().getRoleType().equals(roleType)) {
				map.addAttribute("loginFailed", "loginFailed");
				return "registration";
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("roleType", roleType);

	
		return "redirect:/home.htm";
		
		
		/*if(roleType.equals("security")) {
			
		}*/
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
