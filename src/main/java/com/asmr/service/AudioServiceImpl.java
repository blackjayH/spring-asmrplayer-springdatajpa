package com.asmr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asmr.repository.AudioRepository;
import com.asmr.vo.AudioVO;

@Service
public class AudioServiceImpl implements AudioService {
	@Autowired
	AudioRepository audiorepository;

	@Override
	@Transactional
	public void insertAudio(AudioVO audiovo) {
		audiorepository.insertAudio(audiovo);
	}

	@Override
	@Transactional
	public void updateAudio(AudioVO audiovo) {
		audiorepository.updateAudio(audiovo);
	}

	@Override
	@Transactional
	public void deleteAudio(AudioVO audiovo) {
		audiorepository.deleteAudio(audiovo);

	}
}
