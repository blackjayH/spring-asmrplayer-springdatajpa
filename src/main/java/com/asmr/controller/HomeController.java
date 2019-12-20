package com.asmr.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asmr.service.UserService;
import com.asmr.vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	UserService userservice;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/board/home")
	public String sdhome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		
		return "home";
	}
	
	@RequestMapping(value = "/")
	public String shome(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		UserVO user = new UserVO("sibal", "sibal");
		userservice.insertjpaUser(user);
		
		
		
		return "home";
	}
	
}
