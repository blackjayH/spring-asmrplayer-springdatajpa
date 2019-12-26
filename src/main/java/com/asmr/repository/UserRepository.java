package com.asmr.repository;

import com.asmr.vo.UserVO;

public interface UserRepository {
	public void insertUser(UserVO uservo);

	public UserVO checkUserId(String id);

	public UserVO loginUser(UserVO uservo);

	public void updateUser(UserVO uservo);

	public void deleteUser(String id);
}
