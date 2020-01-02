package com.asmr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asmr.repository.UserVORepository;
import com.asmr.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserVORepository uservorepository;

	@Override
	@Transactional
	public void insertUser(UserVO uservo) {
		uservorepository.save(uservo);
	}

	@Override
	@Transactional
	public boolean checkUserId(String id) {
		if (uservorepository.findById(id).size() == 0)
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean loginUser(UserVO uservo) {
		if (uservorepository.findByIdPw(uservo.getId(), uservo.getPw()).size() == 1)
			return true;
		return false;
	}

	@Override
	@Transactional
	public void updateUser(UserVO uservo) {
		uservorepository.updateUser(uservo.getId(), uservo.getPw());
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		uservorepository.delete(id);
	}
}
