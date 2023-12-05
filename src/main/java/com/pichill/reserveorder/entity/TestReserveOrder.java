package com.pichill.reserveorder.entity;

import java.util.List;

import com.pichill.reserveorder.model.ReserveOrderDAO;
import com.pichill.reserveorder.model.ReserveOrderDAOImpl;

import com.pichill.reserveorder.entity.ReserveOrder;

public class TestReserveOrder {
	
	public static void main(String[] args) throws Exception {
		ReserveOrderDAO dao = new ReserveOrderDAOImpl();

		// 新增
		ReserveOrder res = new ReserveOrder();
		res.setgUserID(11000001);
		res.setoUserID(12000001);
		res.setTimeID(8);
		res.setPlaceID(62000001);
		res.setOrderTime(java.sql.Timestamp.valueOf("2023-11-09 08:08:08"));
		res.setOrderNum(3);
		res.setOrderStatus(1);
		res.setTotalCost(1500);
		dao.add(res);

		// 修改
//		ReserveOrder res1 = new ReserveOrder();
//		res1.setReserveOrderID(63000010);
//		res1.setgUserID(11000002);
//		res1.setoUserID(12000002);
//		res1.setTimeID(9);
//		res1.setPlaceID(62000002);
//		res1.setOrderTime(java.sql.Timestamp.valueOf("2023-11-10 08:08:08"));
//		res1.setOrderNum(4);
//		res1.setOrderStatus(1);
//		res1.setTotalCost(2000);
//		dao.update(res1);
		
		// 刪除
//		dao.delete(63000011);


		// 查詢單筆
//		ReserveOrder res2 = dao.findByPK(63000002);
//		System.out.print(res2.getReserveOrderID() + ",");
//		System.out.print(res2.getgUserID() + ",");
//		System.out.print(res2.getoUserID() + ",");
//		System.out.print(res2.getTimeID() + ",");
//		System.out.print(res2.getPlaceID() + ",");
//		System.out.print(res2.getOrderTime() + ",");
//		System.out.print(res2.getOrderNum() + ",");
//		System.out.print(res2.getOrderStatus() + ",");
//		System.out.print(res2.getTotalCost());
//		System.out.println();

		// 查詢多筆
//		List<ReserveOrder> list = dao.getAll();
//		for (ReserveOrder res3 : list) {
//			System.out.print(res3.getReserveOrderID() + ",");
//			System.out.print(res3.getgUserID() + ",");
//			System.out.print(res3.getoUserID() + ",");
//			System.out.print(res3.getTimeID() + ",");
//			System.out.print(res3.getPlaceID() + ",");
//			System.out.print(res3.getOrderTime() + ",");
//			System.out.print(res3.getOrderNum() + ",");
//			System.out.print(res3.getOrderStatus() + ",");
//			System.out.print(res3.getTotalCost());
//			System.out.println();
//		}
	}
}
