package com.asmr.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audio")
public class AudioVO {
	@Id
	@Column(name = "id")
	String id;
	@Column(name = "slot")
	int slot;
	@Column(name = "track")
	int track;
	@Column(name = "volume")
	float volume;

	protected AudioVO() {

	}

	protected AudioVO(String id, int slot, int track, float volume) {
		this.id = id;
		this.slot = slot;
		this.track = track;
		this.volume = volume;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
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
		return "Audio [id=" + id + ", slot=" + slot + ", track=" + track + ", volume=" + volume + "]";
	}
}
