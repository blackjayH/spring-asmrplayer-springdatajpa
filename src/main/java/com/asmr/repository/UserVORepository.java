package com.asmr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asmr.vo.UserVO;

@Repository
public interface UserVORepository extends JpaRepository<UserVO, String>, UserVORepositoryCustom {
	//void save(UserVO uservo);

	//void delete(String id);
	// boolean checkUserId(String id);
	// void updateUser(UserVO uservo);
	// UserVO loginUser(UserVO uservo);
}
