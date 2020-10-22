package com.student_crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/Login")
	public String loginPage() {
		//return "plain-Login";
		return "bootstrap-login";
	}
	
	// Add mapping to access /access-denied
	@GetMapping("/access-denied")
	public String accessDenied() {
		//return "plain-Login";
		return "access-denied";
	}
}
