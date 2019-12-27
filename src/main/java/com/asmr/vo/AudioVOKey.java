package com.asmr.vo;

import java.io.Serializable;

class AudioVOKey implements Serializable {
	private String userid;
	private int musicnumber;
	private int slot;

	public AudioVOKey() {

	}

	public boolean equals(Object other) {
		if (other instanceof AudioVOKey) {
			final AudioVOKey otherAudioVOKey = (AudioVOKey) other;
			return (otherAudioVOKey.userid.equals(userid) && otherAudioVOKey.musicnumber == musicnumber
					&& otherAudioVOKey.slot == slot);
		}
		return false;
	}

	public int hashCode() {
		return super.hashCode();
	}
}
