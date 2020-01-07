package com.asmr.repository;

import java.util.List;

import com.asmr.vo.AudioVO;

public interface AudioRepositoryCustom {
	public List<AudioVO> getAudioList(String userid, int slot);
}
