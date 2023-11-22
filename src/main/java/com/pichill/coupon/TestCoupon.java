package com.pichill.coupon;

import java.util.List;
import java.util.Scanner;

public class TestCoupon {

	public static void main(String[] args) {
		CouponDAO dao = new CouponDAOImpl();
		
		//新增
		Coupon couponAdd = new Coupon();
		couponAdd.setProductID(51000011);
		dao.add(couponAdd);
		System.out.println("=====================");
		//修改
//		Coupon couponUpdate = new Coupon(); 
//		couponUpdate.setCouponID(52000002);
//		couponUpdate.setProductID(51000002);
//		dao.update(couponUpdate);
		
		//刪除
//		dao.delete(52000006);
		
		//查詢單筆
//		System.out.println("輸入要查詢的編號");
//		Scanner sc = new Scanner(System.in);
//		Integer couponID = sc.nextInt();
//		Coupon couponQuery = dao.getCouponByCouponID(couponID);
//		System.out.println("輸入要查詢的產品編號");
//		Integer productID = sc.nextInt();

//		sc.close();
		
		//查多筆
//		List<Coupon> list = dao.getAll();
//		for (Coupon coupon : list) {
//			System.out.print(coupon.getCouponID()+",");
//			
//			System.out.println(coupon.getProductID() + "");
//			System.out.println(coupon.getProductID() + "");
//		}
		
	}

}
