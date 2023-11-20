package com.pichill.coupon;

import java.util.List;

public class TestCoupon {

	public static void main(String[] args) {
		CouponDAO dao = new CouponDAOImpl();
		//查詢
//		Scanner sc = new Scanner(System.in);
//		System.out.println("輸入要新增的編號");
//		int couponID = sc.nextInt();
//		System.out.println("輸入要新增的部門名");
//		int productID = sc.nextInt();
//
//
//		sc.close();
		//新增
		CouponDAOImpl couponAdd = new CouponDAOImpl();
		couponAdd.setCouponID(52000001);
		couponAdd.setProductID(51000001);
		dao.add(couponAdd);
		System.out.println("=====================");
		//修改
		Coupon couponUpdate = new Coupon(); 
		couponUpdate.setCouponID(52000002);
		couponUpdate.setProductID(51000002);
		dao.update(couponUpdate);
		
		//刪除
		dao.delete(52000006);
		
		//查單筆 
		Coupon couponSelet = dao.getCouponByCouponID(52000005);
		System.out.println(couponSelet.getCouponID()+ ",");
		System.out.print(couponSelet.getProductID()+",");
		
		
		//查多筆
		List<Coupon> list = dao.getAll();
		for (Coupon coupon : list) {
			System.out.print(coupon.getCouponID()+",");
			
			System.out.println(coupon.getProductID() + "");
			System.out.println(coupon.getProductID() + "");
		}
		
	}

}
