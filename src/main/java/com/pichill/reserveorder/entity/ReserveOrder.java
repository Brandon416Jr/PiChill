package com.pichill.reserveorder.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import com.pichill.time.TimeRef;

@Entity
@Table(name="reserveorder")
public class ReserveOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reserveOrderID", updatable = false)
	private Integer reserveOrderID;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "gUserID", referencedColumnName = "gUserID")//(name=自己(FK), referencedColumnName = 對應到的PK)
	private GeneralUser generalUser;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "oUserID", referencedColumnName = "oUserID")
	private OwnerUser ownerUser;
	
	@Column(name="reserveDate", updatable = false)
	private Date reserveDate;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "timeID", referencedColumnName = "timeID")
	private TimeRef timeRef;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "placeID", referencedColumnName = "placeID")
	private Place place;
	
	// fetch 預設為 EAGER
	@ManyToOne
	@JoinColumn(name = "courtID", referencedColumnName = "courtID")
	private Court court;
	
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

	public Integer getReserveOrderID() {
		return reserveOrderID;
	}

	public ReserveOrder(Integer reserveOrderID, GeneralUser generalUser, OwnerUser ownerUser, Date reserveDate,
			TimeRef timeRef, Place place, Court court, Timestamp orderTime, Integer orderNum, Integer orderStatus,
			Integer totalCost) {
		super();
		this.reserveOrderID = reserveOrderID;
		this.generalUser = generalUser;
		this.ownerUser = ownerUser;
		this.reserveDate = reserveDate;
		this.timeRef = timeRef;
		this.place = place;
		this.court = court;
		this.orderTime = orderTime;
		this.orderNum = orderNum;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
	}

	public void setReserveOrderID(Integer reserveOrderID) {
		this.reserveOrderID = reserveOrderID;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

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

	public TimeRef getTimeRef() {
		return timeRef;
	}

	public void setTimeRef(TimeRef timeRef) {
		this.timeRef = timeRef;
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
				+ ownerUser + ", reserveDate=" + reserveDate + ", timeRef=" + timeRef + ", place=" + place + ", court="
				+ court + ", orderTime=" + orderTime + ", orderNum=" + orderNum + ", orderStatus=" + orderStatus
				+ ", totalCost=" + totalCost + "]";
	}
}
