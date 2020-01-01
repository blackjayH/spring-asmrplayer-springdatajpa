package com.asmr.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asmr.service.UserService;
import com.asmr.vo.UserVO;

@RestController
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userservice;

	// 회원가입
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> insertUser(@RequestBody UserVO uservo) {
		Map<String, Object> result = new HashMap<String, Object>();
		userservice.insertUser(uservo);
		result.put("result", Boolean.TRUE);
		return result;
	}

	// 회원가입 id 중복 체크
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Map<String, Object> checkUserId(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		//if (userservice.checkUserId(id))
			result.put("result", Boolean.TRUE); // 사용 가능
		//else
			result.put("result", Boolean.FALSE); // 사용 불가
		return result;
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> loginUser(@RequestBody UserVO uservo, HttpSession session) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (userservice.loginUser(uservo)) {
			session.setAttribute("id", uservo.getId());
			result.put("result", Boolean.TRUE); // 로그인 성공
			result.put("id", uservo.getId()); // 로그인 성공	
		}
		else
			result.put("result", Boolean.FALSE); // 로그인 실패
		return result;
	}

	// 회원정보 수정
	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public Map<String, Object> updateBoard(@RequestBody UserVO uservo) {
		Map<String, Object> result = new HashMap<String, Object>();
		userservice.updateUser(uservo);
		result.put("result", Boolean.TRUE);
		return result;
	}

	// 회원탈퇴
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteBoard(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		userservice.deleteUser(id);
		result.put("result", Boolean.TRUE);
		return result;
	}

}
