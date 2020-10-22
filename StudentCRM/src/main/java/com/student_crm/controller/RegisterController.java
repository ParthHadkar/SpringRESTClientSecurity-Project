package com.student_crm.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student_crm.entity.User;
import com.student_crm.model.CrmUser;
import com.student_crm.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	//@Autowired
	//private UserDetailsManager userDetailsManager;
	
	@Autowired
	public UserService userService;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private Map<String,String> roles;
	
	@InitBinder
	public void initBinder(WebDataBinder theDataBinder) {
		StringTrimmerEditor theEditor = new StringTrimmerEditor(true);
		theDataBinder.registerCustomEditor(String.class, theEditor);
	}
	
	@PostConstruct
	public void loadRoles() {
		roles = new LinkedHashMap<String, String>();
		roles.put("ROLE_EMPLOYEE", "Employee");
		roles.put("ROLE_MANAGER", "Manager");
		roles.put("ROLE_ADMIN", "Admin");
	}
	
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		theModel.addAttribute("CrmUser",new CrmUser());
		theModel.addAttribute("roles",roles);
		return "bootstrap-Register";
	}
	

	@GetMapping("/TestData")
	public String users(Model theModel) {
		User user = (User) userService.findUserByUserName("parth");
		logger.info(">>>> add user to session"+user);
		return "bootstrap-Login";
	}
	
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("CrmUser") CrmUser theCrmUser,
			BindingResult theBindingResult,Model theModel) {
		String userName = theCrmUser.getUsername();
		logger.info("Processing registration form for "+userName);
		logger.info("theBindingResult : "+theBindingResult);
		if(theBindingResult.hasErrors()) {
			//theModel.addAttribute("CrmUser",new CrmUser());
			theModel.addAttribute("roles",roles);
			return "bootstrap-Register";
		}
		// check database if user already exists
		User user = userService.findUserByUserName(userName);
		if(user != null) {
			if(user.getUsername() == null) {
				theModel.addAttribute("CrmUser",new CrmUser());
				theModel.addAttribute("registrationError","Database Error!!!!");
				logger.warning("Database Error!!!!");
				return "bootstrap-Register";
			}
			else {
			theModel.addAttribute("CrmUser",new CrmUser());
			theModel.addAttribute("roles",roles);
			theModel.addAttribute("registrationError","Username Already Exists!!!!");
			logger.warning("Username Already Exists!!!!");
			return "bootstrap-Register";
			}
		}
		
		// save to db
		userService.save(theCrmUser);
	
		logger.info("User Successfully created!!!! "+userName);
		return "registration-confirmation";
	}
	
/*	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmUser theCrmUser, 
				BindingResult theBindingResult, 
				Model theModel) {
						
		String userName = theCrmUser.getUserName();
		
		logger.info("Processing registration form for: " + userName);
		
		// form validation
		if (theBindingResult.hasErrors()) {

			theModel.addAttribute("crmUser", new CrmUser());
			
			// add roles to the model for form display
			theModel.addAttribute("roles", roles);
			
			theModel.addAttribute("registrationError", "User name/password can not be empty.");
			
			logger.warning("User name/password can not be empty.");
			
			return "registration-form";	
		}
		
		// check the database if user already exists
		boolean userExists = doesUserExist(userName);
		
		if (userExists) {
			theModel.addAttribute("crmUser", new CrmUser());

			// add roles to the model for form display
			theModel.addAttribute("roles", roles);
			
			theModel.addAttribute("registrationError", "User name already exists.");

			logger.warning("User name already exists.");
			
			return "registration-form";			
		}
		
		//
		// whew ... we passed all of the validation checks!
		// let's get down to business!!!
		//
		
		// encrypt the password
        String encodedPassword = passwordEncoder.encode(theCrmUser.getPassword());

        // prepend the encoding algorithm id
        encodedPassword = "{bcrypt}" + encodedPassword;
                 
		// give user default role of "employee"
        List<GrantedAuthority > authorities = AuthorityUtils.createAuthorityList();
        authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        
        // if the user selected role other than employee, 
        // then add that one too (multiple roles)
        String formRole = theCrmUser.getFormRole();

        if (!formRole.equals("ROLE_EMPLOYEE")) {
        		authorities.add(new SimpleGrantedAuthority(formRole));
        }
        
        // create user object (from Spring Security framework)
        User tempUser = new User(userName, encodedPassword, authorities);

        // save user in the database
        userDetailsManager.createUser(tempUser);		
		
        logger.info("Successfully created user: " + userName);
        
        return "registration-confirmation";		
	}
	
	private boolean doesUserExist(String userName) {
		
		logger.info("Checking if user exists: " + userName);
		
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		
		logger.info("User: " + userName + ", exists: " + exists);
		
		return exists;
	}*/
	
}
