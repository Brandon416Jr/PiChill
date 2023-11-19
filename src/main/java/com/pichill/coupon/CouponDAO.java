package com.pichill.coupon;

import java.util.List;

public interface CouponDAO {
	public void add(Coupon coupon);

	void update(Coupon coupon);

	void delete(Integer CouponID);

	Coupon getCouponByCouponID(Integer couponID);

	List<Coupon> getAll();

}
