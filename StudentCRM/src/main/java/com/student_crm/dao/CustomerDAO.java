package com.student_crm.dao;

import java.util.List;

import com.student_crm.entity.Customer;
import com.student_crm.entity.User;

public interface CustomerDAO {
	
	public List<Customer> getCustomers(User sessionUser);
	
	public void saveOrUpdate(Customer customer,User sessionUser);
	
	public Customer getCustomer(int id,User sessionUser);
	
	public void deleteCustomer(int id,User sessionUser);
	
}
