package com.pichill.time;

import java.io.Serializable;

public class Time  implements Serializable  {
	private Integer timeID;
	private String reserveTime;
	private Integer courtID;
	
	public Time() {
		super();
		// TODO Auto-generated constructor stub
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
