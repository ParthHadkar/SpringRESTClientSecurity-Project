package com.student_crm.config;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.student_crm.entity.User;
import com.student_crm.service.UserService;

@Component
public class CustomAutenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		try {
			logger.info(">>>> In CustomAutenticationSuccessHandler");
			String username = authentication.getName();
			String password = request.getParameter("password");
			logger.info(">>>> username : "+username);
			logger.info(">>>> Check user in db password"+password);
			User user = (User) userService.findUserByUserName(username);
			logger.info(">>>> add user to session");
			HttpSession session = request.getSession();
			user.setPassword(password);
			session.setAttribute("user", user);
			logger.info(">>>> Forwarding to home page");
			response.sendRedirect(request.getContextPath()+"/");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
