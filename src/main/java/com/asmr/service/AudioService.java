package com.asmr.service;

import java.util.List;

import com.asmr.vo.AudioVO;

public interface AudioService {
	public void insertAudio(AudioVO audiovo);

	public List<AudioVO> getAudioList(String id, int slot);
	
	public void updateAudio(AudioVO audiovo);

	public void deleteAudio(AudioVO audiovo);
}
