package com.pichill.place;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pichill.court.Court;


@Entity

@Table(name = "place")
public class Place {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "placeID", updatable = false) //PK鍵不用更新
	private Integer placeID;
	
	@Column(name = "courtID" , updatable = false)
	private Integer courtID;
	
	@Column(name = "placeName", columnDefinition = "varchar")
	private String placeName;
	
	@Column(name = "placeFee")
	private Integer placeFee;
	
	@Column(name = "ball")
	private Integer ball;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "courtID", referencedColumnName = "courtID")
//	private Court court;
	
	
	
	
	public Place() {
	}
	
	public Place(Integer placeID, Integer courtID, String placeName, Integer placeFee, Integer ball) {
		super();
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
