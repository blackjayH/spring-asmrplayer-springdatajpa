package com.asmr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asmr.vo.UserVO;

public interface UserVORepository extends JpaRepository<UserVO, String>{
	//boolean checkUserId(String id);
	//void updateUser(UserVO uservo);
	//UserVO loginUser(UserVO uservo);
}
