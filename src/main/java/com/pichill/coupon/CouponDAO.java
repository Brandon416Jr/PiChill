package com.pichill.coupon;

import java.util.List;

public interface CouponDAO {
	public void add(Coupon coupon);

	void update(Coupon coupon);

	void delete(int CouponID);

	Coupon getCouponByCouponID(Integer couponID);
	
	List<Coupon> getAll();

}
