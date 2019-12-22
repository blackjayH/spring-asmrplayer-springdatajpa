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
	public UserVO checkUser(String id) {
		// Member findMember = em.find(Member.class, member.getId());
		//UserVO findUser = 
		return em.find(UserVO.class, id);
		//return findUser;
	}

}
