package com.student_crm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student_crm.dao.CustomerDAO;
import com.student_crm.entity.Customer;
import com.student_crm.entity.User;
import com.student_crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")//RequestMapping @GetMapping
	public String listCustomers(Model model,HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		//getting customers from customerService
		List<Customer> customers = customerService.getCustomers(sessionUser);
		//adding customers to model
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showCustomerFormForAdd")
	public String showCustomerFormForAdd(Model model) {
		
		//create the model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		return "add-customers";
	}
	
	@PostMapping("/saveORUpdateCustomer")
	public String saveORUpdateCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult bindingResult,HttpSession session) {
		if(bindingResult.hasErrors()) {
			return "add-customers";
		}
		else {
			//saving the customer using customer service
			User sessionUser = (User) session.getAttribute("user");
			customerService.saveOrUpdate(customer,sessionUser);
		}
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showCustomerFormForUpdate")
	public String showCustomerFormForUpdate(@RequestParam("Id") int id,Model model,HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		Customer customer = customerService.getCustomer(id,sessionUser);
		model.addAttribute("customer", customer);
		return "add-customers";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("Id") int id,HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		customerService.deleteCustomer(id,sessionUser);
		return "success";
	}
}
