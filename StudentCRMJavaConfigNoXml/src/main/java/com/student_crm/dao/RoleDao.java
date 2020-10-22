package com.student_crm.dao;

import com.student_crm.entity.Role;

public interface RoleDao {
	
	public Role[] findRoleByName(String[] name);
	
}
