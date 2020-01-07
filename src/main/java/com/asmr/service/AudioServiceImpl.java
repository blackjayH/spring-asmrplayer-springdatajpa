package com.asmr.service;

import java.util.List;

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
		audiorepository.save(audiovo);
	}

	@Override
	@Transactional
	public List<AudioVO> getAudioList(String id, int slot) {
		return audiorepository.getAudioList(id, slot);
	}

}
