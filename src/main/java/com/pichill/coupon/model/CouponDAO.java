package com.pichill.coupon.model;

import java.util.List;

import com.pichill.coupon.entity.Coupon;

public interface CouponDAO {
	public void add(Coupon coupon);

	void update(Coupon coupon);
	

	void delete(int CouponID);

	Coupon getCouponByCouponID(Integer couponID);
//	Product getProductByCouponID(Integer CouponID);
	List<Coupon> getAll();

}
