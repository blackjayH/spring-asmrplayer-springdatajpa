package com.asmr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public List<AudioVO> getAudioList(String id, int slot) {
		String jpql = "SELECT m FROM AudioVO m where m.userid = :userid and m.slot = :slot";
		return em.createQuery(jpql, AudioVO.class).setParameter("userid",id).setParameter("slot", slot).getResultList();
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
