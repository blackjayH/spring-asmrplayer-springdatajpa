package com.asmr.web;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asmr.service.UserService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	UserService userservice;

	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		return "main_layout";
	}

	// 로그인 view
	@RequestMapping(value = "/v/login")
	public String login() {
		return "main_login";
	}

	// 로그아웃
	@RequestMapping(value = "/v/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main_layout";
	}

	// 회원가입 view
	@RequestMapping(value = "/v/join")
	public String join() {
		return "main_join";
	}

	// 회원정보 수정view
	@RequestMapping(value = "/v/update")
	public String update() {
		return "main_update";
	}
}
