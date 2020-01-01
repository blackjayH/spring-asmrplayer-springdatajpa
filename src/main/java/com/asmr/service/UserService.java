package com.asmr.service;

import java.util.List;

import com.asmr.vo.UserVO;

public interface UserService {
	public void insertUser(UserVO uservo);

	public List<UserVO> checkUserId(String id);

	public boolean loginUser(UserVO uservo);

	public void updateUser(UserVO uservo);

	public void deleteUser(String id);
}
