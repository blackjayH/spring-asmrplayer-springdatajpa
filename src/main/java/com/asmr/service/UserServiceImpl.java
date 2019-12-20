package com.asmr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asmr.repository.UserRepository;
import com.asmr.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userrepository;
	
	@Override
	public void insertjpaUser(UserVO uservo) {
		userrepository.insertjpaUser(uservo);
	}

}
