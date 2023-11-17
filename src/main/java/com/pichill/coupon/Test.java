package com.pichill.coupon;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("輸入要新增的編號");
		int couponID = sc.nextInt();
		System.out.println("輸入要新增的部門名");
		int productID = sc.nextInt();


		sc.close();

		CouponDAO dao = new CouponDAOImpl();
		// 對資料庫一律透過dao物件的方法進行
		Coupon coupon = new Coupon(couponID, productID);
//		// 使用Department Bean 包裝要新增的資料
		dao.add(coupon);
		// 呼叫dao方法完成資料庫的新增動作

//		Coupon coupon = dao.getCouponByCouponID(couponID);
//		System.out.println(coupon);
//		System.out.println("COUPONID = " + coupon.getCouponID());
//		System.out.println("PRODUCTID = " + coupon.getProductID());

//		List<Department> departmentList = dao.getAll();
//		departmentList.forEach(System.out::println);
//		for (Department d : departmentList) {
//			System.out.println(d);
//		}
		System.out.println("=====================");
	}

}
