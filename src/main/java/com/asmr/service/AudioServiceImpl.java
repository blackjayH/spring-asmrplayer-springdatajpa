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
	
	public void insertAudio(AudioVO audiovo) {
		audiorepository.insertAudio(audiovo);
	}

	@Override
	
	public void updateAudio(AudioVO audiovo) {
		audiorepository.updateAudio(audiovo);
	}

	@Override
	
	public void deleteAudio(AudioVO audiovo) {
		audiorepository.deleteAudio(audiovo);

	}
}
