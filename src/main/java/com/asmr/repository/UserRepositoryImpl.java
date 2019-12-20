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
	public void insertjpaUser(UserVO uservo) {
		em.persist(uservo);
	}

}
