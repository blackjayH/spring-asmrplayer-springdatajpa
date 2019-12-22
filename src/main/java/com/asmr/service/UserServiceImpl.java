package com.asmr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asmr.repository.UserRepository;
import com.asmr.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userrepository;

	@Override
	@Transactional
	public void insertUser(UserVO uservo) {
		userrepository.insertUser(uservo);
	}
	
	//public void selectUser() {
		//userrepository.insertUser(uservo);
	//}

	@Override
	@Transactional
	public UserVO checkUser(String id) {
		return userrepository.checkUser(id);
	}
}
