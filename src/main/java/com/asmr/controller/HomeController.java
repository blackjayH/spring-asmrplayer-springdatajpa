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

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	UserService userservice;
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "main_layout";
	}
	
	@RequestMapping(value = "/v/login")
	public String login() {
		return "main_login";
	}
	
	@RequestMapping(value = "/v/join")
	public String join() {
		return "main_join";
	}
	
	@RequestMapping(value = "/v/update")
	public String update() {
		return "main_update";
	}
}
