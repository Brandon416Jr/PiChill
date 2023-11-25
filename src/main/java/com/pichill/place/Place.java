package com.pichill.place;

public class Place implements java.io.Serializable{
	private Integer placeID;
	private Integer courtID;
	private String placeName;
	private Integer placeFee;
	private Integer ball;
	
	public Place() {
	}
	
	public Place(Integer placeID, Integer courtID, String placeName, Integer placeFee, Integer ball) {
		this.placeID = placeID;
		this.courtID = courtID;
		this.placeName = placeName;
		this.placeFee = placeFee;
		this.ball = ball;
	}
	
	
	public Integer getPlaceID() {
		return placeID;
	}
	public void setPlaceID(Integer placeID) {
		this.placeID = placeID;
	}
	public Integer getCourtID() {
		return courtID;
	}
	public void setCourtID(int courtID) {
		this.courtID = courtID;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public Integer getPlaceFee() {
		return placeFee;
	}
	public void setPlaceFee(Integer placeFee) {
		this.placeFee = placeFee;
	}
	public Integer getBall() {
		return ball;
	}
	public void setBall(Integer ball) {
		this.ball = ball;
	}
	
}
