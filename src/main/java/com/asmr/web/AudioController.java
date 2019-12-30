package com.asmr.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asmr.service.AudioService;
import com.asmr.vo.AudioVO;

@RestController
public class AudioController {
	@Autowired
	AudioService audioservice;

	// 재생 목록 저장
	@RequestMapping(value = "/audio", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> insertAudio(@RequestBody List<AudioVO> playList) {
		for (AudioVO audiovo : playList) {
			//System.out.print(audiovo.getUserid() + " ");
			//System.out.print(audiovo.getSlot() + " ");
			//System.out.print(audiovo.getMusicnumber() + " ");
			//System.out.print(audiovo.getTrack() + " ");
			//System.out.println(audiovo.getVolume() + " ");
			audioservice.insertAudio(audiovo);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}

	// 재생 목록 로드
	@RequestMapping(value = "/audio/{slot}", method = RequestMethod.GET)
	public Map<String, Object> getAudioList(@PathVariable int slot, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		List<AudioVO> playList = audioservice.getAudioList(userid, slot);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("playList", playList);
		result.put("result", Boolean.TRUE);
		return result;
	}
}
