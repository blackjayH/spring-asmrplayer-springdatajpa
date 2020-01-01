package com.asmr.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.asmr.vo.QUserVO;
import com.asmr.vo.UserVO;
import com.mysema.query.jpa.impl.JPAQuery;

public class UserVORepositoryImpl extends QueryDslRepositorySupport implements UserVORepositoryCustom {
	public UserVORepositoryImpl() {
		super(UserVO.class);
	}
	
	@PersistenceContext
	EntityManager em;

	
	/*
	Member foundMember = 
	    queryFactory.selectFrom(member) // select + from
	    .where(customer.username.eq("joont"))
	    .fetchOne();
*/
	//JPAQueryFactory query = new JPAQueryFactory((Provider<EntityManager>) em);
		/*

	public UserVORepositoryImpl(JPAQueryFactory query) {
		super(UserVO.class);
		this.query = query;

	}
*/
	@Override
	public List<UserVO> findById(String id) {
		JPAQuery query = new JPAQuery(em);
		QUserVO uservo = QUserVO.userVO;
		return query.from(uservo).where(uservo.id.eq(id)).list(uservo);

		
		//return selectFrom(uservo).list();
				 //where(uservo.id.gt(id)).orderBy(uservo.id.desc()).fetch();
	
	}
	
}
