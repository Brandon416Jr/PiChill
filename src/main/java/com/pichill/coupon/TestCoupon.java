package com.pichill.coupon;

import java.util.Scanner;

public class TestCoupon {

	public static void main(String[] args) {
		//查詢
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入要新增的編號");
		int couponID = sc.nextInt();
		System.out.println("輸入要新增的部門名");
		int productID = sc.nextInt();


		sc.close();
		//新增
CouponDAO dao = new CouponDAOImpl();
CouponDAOImpl coupon = new CouponDAOImpl(couponID);
	dao.add(coupon);
		System.out.println("=====================");
		//修改
		
		
		//刪除
		
	}

}
