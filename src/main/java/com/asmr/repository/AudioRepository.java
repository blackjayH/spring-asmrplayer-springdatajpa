package com.asmr.repository;

import com.asmr.vo.AudioVO;

public interface AudioRepository {
	public void insertAudio(AudioVO audiovo);

	public void updateAudio(AudioVO audiovo);

	public void deleteAudio(AudioVO audiovo);
}