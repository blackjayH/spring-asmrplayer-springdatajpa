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

	@Override
	@Transactional
	public boolean checkUserId(String id) {
		if (userrepository.checkUserId(id) == null)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean loginUser(UserVO uservo) {
		UserVO temp = userrepository.loginUser(uservo);
		return uservo.getPw().equals(temp.getPw());
	}

	@Override
	@Transactional
	public void updateUser(UserVO uservo) {
		userrepository.updateUser(uservo);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		userrepository.deleteUser(id);
	}
}
