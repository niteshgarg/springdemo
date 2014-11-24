package com.myspring.springdemo.dao;

import com.myspring.springdemo.domain.User;

public interface UserDao extends GenericDao<User, Long> {

	public void saveUser(User user);
	
	public User getUserByEmail(String email);

}
