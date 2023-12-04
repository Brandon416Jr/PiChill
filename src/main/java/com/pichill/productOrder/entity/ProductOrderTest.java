package com.pichill.productOrder.entity;

import java.util.List;

import com.pichill.productOrder.model.ProductOrderDAO;
import com.pichill.productOrder.model.ProductOrderDAOImpl;

public class ProductOrderTest {

	public static void main(String[] args) {
		ProductOrderDAO dao = new ProductOrderDAOImpl();

		// 新增
//		ProductOrder productOrderInsert = new ProductOrder();
//		productOrderInsert.setgUserID(11000003);
//		productOrderInsert.setCourtID(61000009);
//		productOrderInsert.setProductOrderTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
//		productOrderInsert.setConsume(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
//		productOrderInsert.setProductShipTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
//		productOrderInsert.setProductArriveTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
//		productOrderInsert.setProductShipStatus(1);
//		productOrderInsert.setgUserPiCnt(555);
//		productOrderInsert.setOrderTotalPrice(555);

//		dao.insert(productOrderInsert);
		System.out.println("=====================");
//		修改
		ProductOrder productOrderUpdate = new ProductOrder() ;
		productOrderUpdate.setgUserID(11000003);
		productOrderUpdate.setCourtID(61000009);
		productOrderUpdate.setProductOrderTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
		productOrderUpdate.setConsume(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
		productOrderUpdate.setProductShipTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
		productOrderUpdate.setProductArriveTime(java.sql.Timestamp.valueOf("2023-11-09 12:03:01"));
		productOrderUpdate.setProductShipStatus(1);
		productOrderUpdate.setgUserPiCnt(55);
		productOrderUpdate.setOrderTotalPrice(555);

		dao.update(productOrderUpdate);
		System.out.println("=====================");
		
		
		
		// 刪除
//		dao.delete(52000006);

		// 查詢單筆
		ProductOrder productOrderSelet = dao.getProductOrderByProductOrderID(54000008);
		System.out.println(productOrderSelet.getgUserID()+",");
		System.out.println(productOrderSelet.getCourtID()+",");
		System.out.println(productOrderSelet.getProductOrderTime()+",");
		System.out.println(productOrderSelet.getConsume()+",");
		System.out.println(productOrderSelet.getProductShipTime()+",");
		System.out.println(productOrderSelet.getProductArriveTime()+",");
		System.out.println(productOrderSelet.getProductShipStatus()+",");
		System.out.println(productOrderSelet.getgUserPiCnt()+",");
		System.out.println(productOrderSelet.getOrderTotalPrice()+",");
//		System.out.println("輸入要查詢的編號");
//		Scanner sc = new Scanner(System.in);
//		Integer couponID = sc.nextInt();
//		Coupon couponQuery = dao.getCouponByCouponID(couponID);
//		System.out.println("輸入要查詢的產品編號");
//		Integer productID = sc.nextInt();
//
//		sc.close();

		// 查多筆
		List<ProductOrder> list = dao.getAll();
		for (ProductOrder productOrderGetAll : list) {
			System.out.println(productOrderGetAll.getProductOrderID() + ",");
			System.out.println(productOrderGetAll.getgUserID()+",");
			System.out.println(productOrderGetAll.getCourtID()+",");
			System.out.println(productOrderGetAll.getProductOrderTime()+",");
			System.out.println(productOrderGetAll.getConsume()+",");
			System.out.println(productOrderGetAll.getProductShipTime()+",");
			System.out.println(productOrderGetAll.getProductArriveTime()+",");
			System.out.println(productOrderGetAll.getProductShipStatus()+",");
			System.out.println(productOrderGetAll.getgUserPiCnt()+",");
			System.out.println(productOrderGetAll.getOrderTotalPrice()+",");
			System.out.println();

		}

	}

}
