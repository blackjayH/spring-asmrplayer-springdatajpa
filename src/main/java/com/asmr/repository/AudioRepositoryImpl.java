package com.asmr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import com.asmr.vo.AudioVO;
import com.asmr.vo.QAudioVO;
import com.mysema.query.jpa.impl.JPAQuery;

public class AudioRepositoryImpl extends QueryDslRepositorySupport implements AudioRepositoryCustom {
	public AudioRepositoryImpl() {
		super(AudioVO.class);
	}

	@PersistenceContext
	EntityManager em;

	@Override
	public List<AudioVO> getAudioList(String userid, int slot) {
		JPAQuery query = new JPAQuery(em);
		QAudioVO audiovo = QAudioVO.audioVO;
		return query.from(audiovo).where((audiovo.userid.eq(userid)).and(audiovo.slot.eq(slot))).list(audiovo);
	}

}
