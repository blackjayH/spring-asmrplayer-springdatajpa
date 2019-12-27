package com.asmr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

	// 회원가입
	@RequestMapping(value = "/audio", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> insertAudio(@RequestBody List<AudioVO> playList, HttpSession session) {
		String userid = (String) session.getAttribute("id");
		int number = 0;
		for (AudioVO audiovo : playList) {
			audiovo.setUserid(userid);
			audiovo.setMusicnumber(number++);
			audioservice.insertAudio(audiovo);
			//System.out.print(audiovo.getUserid() + " ");
			//System.out.print(audiovo.getSlot() + " ");
			//System.out.print(audiovo.getMusicnumber() + " ");
			//System.out.print(audiovo.getTrack() + " ");
			//System.out.print(audiovo.getVolume() + " ");
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", Boolean.TRUE);
		return result;
	}
}

