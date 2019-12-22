package com.asmr.controller;

import java.util.HashMap;
import java.util.Map;

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

	// id 중복 체크
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Map<String, Object> checkUser(@PathVariable String id) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserVO uservo = userservice.checkUser(id);
		result.put("result", Boolean.TRUE);
		return result;
	}

	// 회원가입
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> insertUser(@RequestBody UserVO uservo) {
		Map<String, Object> result = new HashMap<String, Object>();
		userservice.insertUser(uservo);
		result.put("result", Boolean.TRUE);
		return result;
	}

	/*
	 * // Restful API 전체 로드
	 * 
	 * @RequestMapping(value = "/board2", method = RequestMethod.GET) public
	 * Map<String, Object> listBoard() { Map<String, Object> result = new
	 * HashMap<>(); List<BoardVO> list = boardservice.listAll(); result.put("list",
	 * list); result.put("result", Boolean.TRUE); return result; }
	 * 
	 * // Restful API 게시물 하나 로드
	 * 
	 * @RequestMapping(value = "/board2/{bbsID}", method = RequestMethod.GET) public
	 * Map<String, Object> detailBoard(@PathVariable int bbsID) { Map<String,
	 * Object> result = new HashMap<>(); BoardVO vo = boardservice.viewBoard(bbsID);
	 * result.put("list", vo); result.put("result", Boolean.TRUE); return result; }
	 * 
	 * // Restful API 게시물 작성
	 * 
	 * @RequestMapping(value = "/board2", method = RequestMethod.POST, headers = {
	 * "Content-type=application/json" }) public Map<String, Object>
	 * addBoard(@RequestBody BoardVO boardvo, HttpSession session) { String id =
	 * (String) session.getAttribute("userID"); boardvo.setUserID(id); Map<String,
	 * Object> result = new HashMap<>(); if (boardvo != null)
	 * boardservice.insertBoard(boardvo);
	 * 
	 * result.put("result", Boolean.TRUE); return result; }
	 * 
	 * // Restful API 게시물 수정
	 * 
	 * @RequestMapping(value = "/board2", method = RequestMethod.PUT, headers = {
	 * "Content-type=application/json" }) public Map<String, Object>
	 * updateBoard(@RequestBody BoardVO boardvo) { Map<String, Object> result = new
	 * HashMap<>(); System.out.println(boardvo.getBbsTitle()); if (boardvo != null)
	 * boardservice.updateBoard(boardvo);
	 * 
	 * result.put("result", Boolean.TRUE); return result; }
	 * 
	 * // Restful API 게시물 삭제
	 * 
	 * @RequestMapping(value = "/board2/{bbsID}", method = RequestMethod.DELETE)
	 * public Map<String, Object> deleteBoard(@PathVariable int bbsID) { Map<String,
	 * Object> result = new HashMap<>();
	 * 
	 * boardservice.deleteBoard(bbsID); result.put("result", Boolean.TRUE); return
	 * result; }
	 */
}
