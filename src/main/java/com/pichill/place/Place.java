package com.pichill.place;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.pichill.court.Court;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.post.entity.Post;
import com.pichill.reserveorder.entity.ReserveOrder;


@Entity
@Table(name = "place")
public class Place {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "placeID", updatable = false) //PK鍵不用更新
	private Integer placeID;
	
	@Column(name = "courtID" , updatable = false ,insertable = false )
	private Integer courtID;
	
	@Column(name = "placeName", columnDefinition = "varchar")
	private String placeName;
	
	@Column(name = "placeFee")
	private Integer placeFee;
	
	@Column(name = "ball")
	private Integer ball;
	
	
	
	//球館
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courtID", referencedColumnName = "courtID")
	private Court court;
	

	public Court getCourt() {
	return court;
	}

	public void setCourt(Court court) {
	this.court = court;
	}
	

	
	//預約訂單
	// fetch 預設為 LAZY
	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
	// (mappedBy = "place")的generalUser指的是新增的Place "place"部門物件的屬性
	@OrderBy("reserveOrderID asc") 
	private Set<ReserveOrder> reserveOrder; // Set不重複
		
	
	//貼文
	// fetch 預設為 LAZY
//	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
//	// (mappedBy = "place")的generalUser指的是新增的Place "place"部門物件的屬性
//	@OrderBy("postID asc") 
//	private Set<Post> post; // Set不重
	
	
	
	
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
	
	
	//預約訂單
	public Set<ReserveOrder> getReserveOrder() {
		return reserveOrder;
	}

	public void setReserveOrder(Set<ReserveOrder> reserveOrder) {
		this.reserveOrder = reserveOrder;
	}
	
	//貼文
//	public Set<Post> getPost() {
//		return post;
//	}
//
//	public void setPost(Set<Post> post) {
//		this.post = post;
//	}
}
