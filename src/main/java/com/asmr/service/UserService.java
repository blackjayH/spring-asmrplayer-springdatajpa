package com.asmr.service;

import com.asmr.vo.UserVO;

public interface UserService {
	public void insertUser(UserVO uservo);
	public UserVO checkUser(String id);
	
}
