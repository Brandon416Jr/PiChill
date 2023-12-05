package com.pichill.product.entity;

import java.util.List;

import com.pichill.product.model.ProductDAO;
import com.pichill.product.model.ProductDAOImpl;


public class ProductTest {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAOImpl();
		
		//新增
		Product productInsert = new Product();
		productInsert.setoUserID(12000019);
		productInsert.setManageID(13000005);
		productInsert.setCourtID(61000009);
		productInsert.setProductTypeID(2);
		productInsert.setProductName("Wison排球館券1");
		productInsert.setProductStatus(1);
		productInsert.setProductApplyStatus(0);
		productInsert.setStock(555);
		productInsert.setProductPic(null);
		productInsert.setProductOnCnt(5);
		productInsert.setProductApplyTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
		productInsert.setProductOnTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
		productInsert.setProductPrice(555);
		productInsert.setProductDescription("Wison排球館券");
		
		
		dao.insert(productInsert);
		System.out.println("=====================");
//		修改
//		Coupon couponUpdate = new Coupon(); 
//		couponUpdate.setCouponID(52000022);
//		couponUpdate.setProductID(51000022);
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
//
//		sc.close();
		
		//查多筆
		List<Product> list = dao.getAll();
		for (Product product : list) {
			System.out.println(product.getProductID() + "");
		}
		
	}

}
