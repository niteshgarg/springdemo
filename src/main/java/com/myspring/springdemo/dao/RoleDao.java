package com.myspring.springdemo.dao;

import com.myspring.springdemo.domain.Role;

public interface RoleDao extends GenericDao<Role, Long> {
	
	public Role getRoleByType(String Type);
}
