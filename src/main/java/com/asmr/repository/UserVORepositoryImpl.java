package com.asmr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.asmr.vo.QUserVO;
import com.asmr.vo.UserVO;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;

public class UserVORepositoryImpl extends QueryDslRepositorySupport implements UserVORepositoryCustom {
	public UserVORepositoryImpl() {
		super(UserVO.class);
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public List<UserVO> findById(String id) {
		JPAQuery query = new JPAQuery(em);
		QUserVO uservo = QUserVO.userVO;
		return query.from(uservo).where(uservo.id.eq(id)).list(uservo);
	}

	@Override
	public List<UserVO> findByIdPw(String id, String pw) {
		JPAQuery query = new JPAQuery(em);
		QUserVO uservo = QUserVO.userVO;
		return query.from(uservo).where((uservo.id.eq(id)).and(uservo.pw.eq(pw))).list(uservo);
	}

	@Override
	public void updateUser(String id, String pw) {
		QUserVO uservo = QUserVO.userVO;
		Long affectedRow = new JPAUpdateClause(em, uservo).where(uservo.id.eq(id)).set(uservo.pw, pw).execute();
	}
}
