package com.student_crm.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.student_crm.entity.Role;
import com.student_crm.entity.User;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory securitySessionFactory;
	
	@Override
	public Role[] findRoleByName(String[] name) {
		Role[] roles = new Role[name.length];
		Role role = null;
		try {
			// get current hibernate session
			Session session = securitySessionFactory.getCurrentSession();
			// create query to fetch user by username
			for(int i=0; i<name.length; i++) {
			Query<Role> query = session.createQuery("FROM Role r WHERE r.name=:rname", Role.class);
			query.setParameter("rname", name[i]);
			role = (Role) query.getSingleResult();
			roles[i] =role;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return roles;
	}

}
