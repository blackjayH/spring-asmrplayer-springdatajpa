package com.asmr.repository;

import com.asmr.vo.UserVO;

public interface UserRepository {
	public void insertUser(UserVO uservo);
	public UserVO checkUser(String id);
	
}
