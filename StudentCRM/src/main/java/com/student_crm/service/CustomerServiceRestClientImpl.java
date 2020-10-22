package com.student_crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student_crm.dao.CustomerDAO;
import com.student_crm.entity.Customer;
import com.student_crm.entity.User;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	// Inject CustomerDAO
		@Autowired
		private CustomerDAO customerDAO;
		
	@Override
	public List<Customer> getCustomers(User sessionUser) {
		List<Customer> customers = customerDAO.getCustomers(sessionUser);
		return customers;
	}

	@Override
	public void saveOrUpdate(Customer customer,User sessionUser) {
		customerDAO.saveOrUpdate(customer,sessionUser);
	}

	@Override
	public Customer getCustomer(int id,User sessionUser) {
		Customer customer = customerDAO.getCustomer(id,sessionUser);
		return customer;
	}

	@Override
	public void deleteCustomer(int id,User sessionUser) {
		customerDAO.deleteCustomer(id,sessionUser);
	}

	
}
