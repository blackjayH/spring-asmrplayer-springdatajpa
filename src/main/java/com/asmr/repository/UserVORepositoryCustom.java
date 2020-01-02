package com.asmr.repository;

import java.util.List;

import com.asmr.vo.UserVO;

public interface UserVORepositoryCustom {
	List<UserVO> findById(String id);

	List<UserVO> findByIdPw(String id, String pw);

	void updateUser(String id, String pw);
}
