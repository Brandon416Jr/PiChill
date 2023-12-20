package com.pichill.reserveorder.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.pichill.court.Court;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.place.Place;
import com.pichill.time.Time;

@Entity
@Table(name="reserveorder")
public class ReserveOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reserveOrderID", updatable = false)
	private Integer reserveOrderID;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "gUserID", referencedColumnName = "gUserID", updatable = false)//(name=自己(FK), referencedColumnName = 對應到的PK)
	private GeneralUser generalUser;
	
//	@Column(name="gUserID", updatable = false)
//	private Integer gUserID;
//	
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "oUserID", referencedColumnName = "oUserID", updatable = false)
	private OwnerUser ownerUser;
		
//	@Column(name="oUserID", updatable = false)
//	private Integer oUserID;
	
	@Column(name="reserveDate", updatable = false)
	private Date reserveDate;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "timeID", referencedColumnName = "timeID", updatable = false)
	private Time time;
		
//	@Column(name="timeID", updatable = false)
//	private Integer timeID;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "placeID", referencedColumnName = "placeID", updatable = false)
	private Place place;
		
//	@Column(name="placeID", updatable = false)
//	private Integer placeID;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "courtID", referencedColumnName = "courtID", updatable = false)
	private Court court;
		
//	@Column(name="courtID", updatable = false)
//	private Integer courtID;
	
	
	@Column(name="orderTime", updatable = false)
	@CreationTimestamp
	private Timestamp orderTime;
	
	@Column(name="orderNum", updatable = false)
	private Integer orderNum;
	
	@Column(name="orderStatus")
	private Integer orderStatus;
	
	@Column(name="totalCost", updatable = false)
	private Integer totalCost;

	public ReserveOrder() {
		super();
	}

//	public ReserveOrder(Integer reserveOrderID, Integer gUserID, Integer oUserID, Date reserveDate, Integer timeID,
//			Integer placeID, Timestamp orderTime, Integer orderNum, Integer orderStatus, Integer totalCost) {
//		super();
//		this.reserveOrderID = reserveOrderID;
//		this.gUserID = gUserID;
//		this.oUserID = oUserID;
//		this.reserveDate = reserveDate;
//		this.timeID = timeID;
//		this.placeID = placeID;
//		this.orderTime = orderTime;
//		this.orderNum = orderNum;
//		this.orderStatus = orderStatus;
//		this.totalCost = totalCost;
//	}

	public ReserveOrder(Integer reserveOrderID, GeneralUser generalUser, OwnerUser ownerUser, Date reserveDate,
			Time time, Place place, Timestamp orderTime, Integer orderNum, Integer orderStatus, Integer totalCost) {
		super();
		this.reserveOrderID = reserveOrderID;
		this.generalUser = generalUser;
		this.ownerUser = ownerUser;
		this.reserveDate = reserveDate;
		this.time = time;
		this.place = place;
		this.orderTime = orderTime;
		this.orderNum = orderNum;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
	}

	public Integer getReserveOrderID() {
		return reserveOrderID;
	}

	public void setReserveOrderID(Integer reserveOrderID) {
		this.reserveOrderID = reserveOrderID;
	}

//	public Integer getgUserID() {
//		return gUserID;
//	}
//
//	public void setgUserID(Integer gUserID) {
//		this.gUserID = gUserID;
//	}

//	public Integer getoUserID() {
//		return oUserID;
//	}
//
//	public void setoUserID(Integer oUserID) {
//		this.oUserID = oUserID;
//	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

//	public Integer getTimeID() {
//		return timeID;
//	}
//
//	public void setTimeID(Integer timeID) {
//		this.timeID = timeID;
//	}
//
//	public Integer getPlaceID() {
//		return placeID;
//	}
//
//	public void setPlaceID(Integer placeID) {
//		this.placeID = placeID;
//	}

//	public Integer getCourtID() {
//		return courtID;
//	}
//
//	public void setCourtID(Integer courtID) {
//		this.courtID = courtID;
//	}
	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}
	
	
	//=====================================================================//
	public GeneralUser getGeneralUser() {
		return generalUser;
	}

	public void setGeneralUser(GeneralUser generalUser) {
		this.generalUser = generalUser;
	}

	public OwnerUser getOwnerUser() {
		return ownerUser;
	}

	public void setOwnerUser(OwnerUser ownerUser) {
		this.ownerUser = ownerUser;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	
	public Court getCourt() {
		return court;
	}

	public void setCourt(Court court) {
		this.court = court;
	}

	@Override
	public String toString() {
		return "ReserveOrder [reserveOrderID=" + reserveOrderID + ", generalUser=" + generalUser + ", ownerUser="
				+ ownerUser + ", reserveDate=" + reserveDate + ", time=" + time + ", place=" + place + ", court="
				+ court + ", orderTime=" + orderTime + ", orderNum=" + orderNum + ", orderStatus=" + orderStatus
				+ ", totalCost=" + totalCost + "]";
	}



//	@Override
//	public String toString() {
//		return "ReserveOrder [reserveOrderID=" + reserveOrderID + ", generalUser=" + generalUser + ", ownerUser="
//				+ ownerUser + ", reserveDate=" + reserveDate + ", time=" + time + ", place=" + place + ", orderTime="
//				+ orderTime + ", orderNum=" + orderNum + ", orderStatus=" + orderStatus + ", totalCost=" + totalCost
//				+ "]";
//	}

	
	
//	 for join gName from gUserID
//    public com.pichill.generaluser.entity.GeneralUser getGeneralUser() {
//	    com.pichill.generaluser.service.GeneralUserService generaluserSvc = new com.pichill.generaluser.service.GeneralUserService();
//	    com.pichill.generaluser.entity.GeneralUser generalUser = generaluserSvc.getOneGeneralUser(gUserID);
//	    return generalUser;
//    }
//    
//     for join rsvdCnts from oUserID
//    public com.pichill.owneruser.entity.OwnerUser getOwnerUser() {
//    	com.pichill.owneruser.service.OwnerUserService owneruserSvc = new com.pichill.owneruser.service.OwnerUserService();
//    	com.pichill.owneruser.entity.OwnerUser ownerUser = owneruserSvc.getOneOwnerUser(oUserID);
//	    return ownerUser;
//    }
//    
//     for join reserveTime from timeID
//    public com.pichill.time.Time getTime() {
//	    com.pichill.time.TimeService timeSvc = new com.pichill.time.TimeService();
//	    com.pichill.time.Time time = timeSvc.getOneTime(timeID);
//	    return time;
//    }
//    
//     for join placeName from placeID
//    public com.pichill.place.Place getPlace() {
//    	com.pichill.place.PlaceService placeSvc = new com.pichill.place.PlaceService();
//    	com.pichill.place.Place place = placeSvc.getOnePlace(placeID);
//    	return place;
//    }
    
	

	

}
