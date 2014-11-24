package com.myspring.springdemo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.springdemo.controllers.form.RegistrationForm;
import com.myspring.springdemo.dao.RoleDao;
import com.myspring.springdemo.dao.UserDao;
import com.myspring.springdemo.domain.Role;
import com.myspring.springdemo.domain.User;
import com.myspring.springdemo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public void saveUser(RegistrationForm registrationForm) {
		String email = registrationForm.getEmail();
		String roleType = registrationForm.getRole();
		
		Role role = roleDao.getRoleByType(roleType);
		
		User user = new User();
		user.setEmail(email);
		user.setRole(role);
		user.setCreated(new Date());
		
		userDao.saveUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
}
