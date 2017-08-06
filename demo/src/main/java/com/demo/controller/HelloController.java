package com.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* The HelloController is a controller  class for for loading views    
*
* @author  Atinder
* @version 1.0
* @since   2017-08-01 
*/

@Controller
public class HelloController {

	@RequestMapping(value = { "/employe" })
	public String hello() {
		return "employe";
	}

	

	@RequestMapping(value={ "/" , "/login"})
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
}
