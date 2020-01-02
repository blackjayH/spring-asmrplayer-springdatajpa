package com.asmr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asmr.vo.UserVO;

@Repository
public interface UserVORepository extends JpaRepository<UserVO, String>, UserVORepositoryCustom {
	
}
