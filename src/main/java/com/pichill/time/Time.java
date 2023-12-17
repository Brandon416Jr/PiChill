package com.pichill.time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="time")
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="timeID", updatable = false)
	private Integer timeID;
	
	@Column(name="reserveTime", updatable = false)
	private String reserveTime;
	
	@Column(name="courtID", updatable = false)
	private Integer courtID;
	
	public Time() {
		super();
	}

	public Time(Integer timeID, String reserveTime, Integer courtID) {
		super();
		this.timeID = timeID;
		this.reserveTime = reserveTime;
		this.courtID = courtID;
	}

	public Integer getTimeID() {
		return timeID;
	}

	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public Integer getCourtID() {
		return courtID;
	}

	public void setCourtID(Integer courtID) {
		this.courtID = courtID;
	}

	@Override
	public String toString() {
		return "Time [timeID=" + timeID + ", reserveTime=" + reserveTime + ", courtID=" + courtID + "]";
	}
	
	

}
