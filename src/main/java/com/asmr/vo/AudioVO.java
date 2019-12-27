package com.asmr.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "audiolist")
@IdClass(AudioVOKey.class)
public class AudioVO {
	@Id
	@Column(name = "userid")
	String userid;

	@Id
	@Column(name = "musicnumber")
	int musicnumber;

	@Id
	@Column(name = "slot")
	int slot;

	@Column(name = "track")
	int track;

	@Column(name = "volume")
	float volume;

	protected AudioVO() {

	}

	protected AudioVO(String userid, int slot, int musicnumber, int track, float volume) {
		this.userid = userid;
		this.slot = slot;
		this.musicnumber = musicnumber;
		this.track = track;
		this.volume = volume;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public int getMusicnumber() {
		return musicnumber;
	}

	public void setMusicnumber(int musicnumber) {
		this.musicnumber = musicnumber;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public float getVolume() {
		return volume;
	}

	public void setVolume(float volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Audio [userid=" + userid + ", slot=" + slot + ", musicnumber=" + musicnumber + ", track=" + track + ", volume="
				+ volume + "]";
	}
}
