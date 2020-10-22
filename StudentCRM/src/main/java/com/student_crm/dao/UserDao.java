package com.student_crm.dao;

import com.student_crm.entity.User;

public interface UserDao {

	public User findUserByUserName(String name);
	public void save(User user);
	
}
