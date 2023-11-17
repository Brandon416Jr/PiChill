package com.pichill.coupon;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CouponVO implements Serializable {
	private Integer couponID;
	private Integer productID;
	public Integer getCouponID() {
		return couponID;
	}
	public void setCouponID(Integer couponID) {
		this.couponID = couponID;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	@Override
	public String toString() {
		return "CouponVO [couponID=" + couponID + ", productID=" + productID + "]";
	}
	
	
}