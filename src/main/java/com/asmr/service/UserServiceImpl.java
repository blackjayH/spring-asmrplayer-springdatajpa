package com.asmr.service;

import java.util.List;

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
	public List<UserVO> checkUserId(String id) {
		//if (uservorepository.checkUserId(id) == null)
			//return true;
		//else
		return uservorepository.findById(id);
	}

	@Override
	@Transactional
	public boolean loginUser(UserVO uservo) {
		//UserVO temp = uservorepository.loginUser(uservo);
		//return uservo.getPw().equals(temp.getPw());
		return true;
	}

	@Override
	@Transactional
	public void updateUser(UserVO uservo) {
		//uservorepository.updateUser(uservo);
	}

	@Override
	@Transactional
	public void deleteUser(String id) {
		uservorepository.delete(id);
	}
}
