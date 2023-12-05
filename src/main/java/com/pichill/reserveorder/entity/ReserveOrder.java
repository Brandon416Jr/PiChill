package com.pichill.reserveorder.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserveorder")
public class ReserveOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reserveOrderID", updatable = false)
	private Integer reserveOrderID;
	private Integer gUserID;
	private Integer oUserID;
	private Integer timeID;
	private Integer placeID;
	private Integer couponID;
	private Timestamp orderTime;
	private Integer orderNum;
	private Integer orderStatus;
	private Integer totalCost;

	public ReserveOrder() {
		super();
	}

	public ReserveOrder(Integer reserveOrderID, Integer gUserID, Integer oUserID, Integer timeID, Integer placeID,
			Integer couponID, Timestamp orderTime, Integer orderNum, Integer orderStatus, Integer totalCost) {
		super();
		this.reserveOrderID = reserveOrderID;
		this.gUserID = gUserID;
		this.oUserID = oUserID;
		this.timeID = timeID;
		this.placeID = placeID;
		this.couponID = couponID;
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

	public Integer getgUserID() {
		return gUserID;
	}

	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public Integer getTimeID() {
		return timeID;
	}

	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}

	public Integer getPlaceID() {
		return placeID;
	}

	public void setPlaceID(Integer placeID) {
		this.placeID = placeID;
	}

	public Integer getCouponID() {
		return couponID;
	}

	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
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

	@Override
	public String toString() {
		return "ReserveOrder [reserveOrderID=" + reserveOrderID + ", gUserID=" + gUserID + ", oUserID=" + oUserID
				+ ", timeID=" + timeID + ", placeID=" + placeID + ", couponID=" + couponID + ", orderTime=" + orderTime
				+ ", orderNum=" + orderNum + ", orderStatus=" + orderStatus + ", totalCost=" + totalCost + "]";
	}


	

	

}
