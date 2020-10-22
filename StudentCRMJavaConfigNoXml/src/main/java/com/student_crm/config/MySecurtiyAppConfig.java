package com.student_crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import javax.sql.DataSource;

import com.student_crm.service.UserService;

@Configuration
@EnableWebSecurity
public class MySecurtiyAppConfig extends WebSecurityConfigurerAdapter{

	@Autowired 
	private UserService userService;
	
	//@Autowired
	//private DataSource securityDataSource;
	
	@Autowired
	private CustomAutenticationSuccessHandler customAutenticationSuccessHandler;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.jdbcAuthentication().dataSource(securityDataSource);
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//.anyRequest().authenticated()
		.antMatchers("/customer/list").hasAnyRole("EMPLOYEE","MANAGER","ADMIN")
		.antMatchers("/customer/showCustomerFormForAdd").hasAnyRole("MANAGER","ADMIN")
		.antMatchers("/customer/showCustomerFormForUpdate").hasAnyRole("MANAGER","ADMIN")
		.antMatchers("/customer/deleteCustomer").hasRole("ADMIN")
		.antMatchers("/customer/**").hasRole("EMPLOYEE")
		.antMatchers("/resources/**").permitAll()
		.and()
		.formLogin()
		.loginPage("/Login")
		.loginProcessingUrl("/authenticateUser")
		.successHandler(customAutenticationSuccessHandler)
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}

	/*@Bean
	public UserDetailsManager userDetailsManager() {
		
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		
		return jdbcUserDetailsManager; 
	}*/
	 
}
