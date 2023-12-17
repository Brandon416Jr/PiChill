package com.pichill.place;

import java.util.List;

public class TestPlace {
	public static void main(String[] args) {
		PlaceDAO dao = new PlaceDAOImpl();

		// 新增
//		Place place1 = new Place();
//		place1.setCourtID(61000011);
//		place1.setPlaceName("A");
//		place1.setPlaceFee(4600);
//		place1.setBall(1);
//		dao.add(place1);
//
//		// 修改
//		Place place2 = new Place();
//		place1.setPlaceID(62000001);
//		place1.setCourtID(61000011);
//		place1.setPlaceName("甲");
//		place1.setPlaceFee(430);
//		place1.setBall(2);
//		dao.update(place2);
//
//		// 刪除
//		dao.delete(62000011);

//		// 查詢單筆
//		Place place3 = dao.findByPK(62000001);
//		System.out.print(place3.getPlaceID() + ",");
//		System.out.print(place3.getCourtID() + ",");
//		System.out.print(place3.getPlaceName() + ",");
//		System.out.print(place3.getPlaceFee() + ",");
//		System.out.print(place3.getBall() + ",");

//		System.out.println("---------------------");

//		// 查詢多筆
//		List<Place> list = dao.getAll();
//		for (Place place : list) {
//			System.out.print(place.getPlaceID() + ",");
//			System.out.print(place.getCourtID() + ",");
//			System.out.print(place.getPlaceName() + ",");
//			System.out.print(place.getPlaceFee() + ",");
//			System.out.print(place.getBall() + ",");
//			System.out.println();
//		}
	}

}
