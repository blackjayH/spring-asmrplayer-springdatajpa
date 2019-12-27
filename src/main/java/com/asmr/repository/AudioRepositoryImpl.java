package com.asmr.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.asmr.vo.AudioVO;

@Repository
public class AudioRepositoryImpl implements AudioRepository {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public void insertAudio(AudioVO audiovo) {
		em.persist(audiovo);
	}

	@Override
	@Transactional
	public void updateAudio(AudioVO audiovo) {

	}

	@Override
	@Transactional
	public void deleteAudio(AudioVO audiovo) {

	}
}
