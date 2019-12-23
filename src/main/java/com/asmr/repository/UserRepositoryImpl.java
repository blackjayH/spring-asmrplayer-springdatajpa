package com.asmr.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.asmr.vo.UserVO;

@Repository
public class UserRepositoryImpl implements UserRepository {
	@PersistenceContext
	EntityManager em;

	@Override
	public void insertUser(UserVO uservo) {
		em.persist(uservo);
	}
	
	@Override
	public UserVO checkUserId(String id) {
		return em.find(UserVO.class, id);
	}
	
	@Override
	public UserVO loginUser(UserVO uservo) {
		return em.find(UserVO.class, uservo.getId());
	}
	
	@Override
	public void updateUser(UserVO uservo) {
		UserVO temp = em.find(UserVO.class, uservo.getId());
		temp.setPw(uservo.getPw());
		em.persist(temp);
	}
	
	@Override
	public void deleteUser(String id) {
		em.remove(em.find(UserVO.class, id));
	}

}
