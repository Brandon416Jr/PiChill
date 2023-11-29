package com.pichill.coupon.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Coupon implements Serializable {
	private Integer couponID;
	private Integer productID;
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupon(Integer couponID, Integer productID) {
		super();
		this.couponID = couponID;
		this.productID = productID;
	}
	public Integer getCouponID() {
		return productID;
	}
	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}
	public Integer getProductID() {
		return couponID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	@Override
	public String toString() {
		return "Coupon [couponID=" + couponID + ", productID=" + productID + "]";
	}
	
	
	
}
