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
		userrepository.save(uservo);
	}

	@Override
	@Transactional
	public boolean checkUserId(String id) {
		if (userrepository.findById(id).size() == 0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean loginUser(UserVO uservo) {
		if (userrepository.findByIdPw(uservo.getId(), uservo.getPw()).size() == 1)
			return true;
		return false;
	}

	@Override
	@Transactional
	public void updateUser(UserVO uservo) {
		userrepository.updateUser(uservo.getId(), uservo.getPw());
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		userrepository.delete(id);
	}
}
