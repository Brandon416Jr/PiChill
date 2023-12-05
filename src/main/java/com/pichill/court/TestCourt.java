package com.pichill.court;

import java.util.List;
import java.sql.Timestamp;

public class TestCourt {
	public static void main(String[] args) {
		CourtDAO dao = new CourtDAOImpl();
		// 新增
//		Court court1 = new Court();
//		court1.setoUserID(12000001);
//		court1.setManageID(null);
//		court1.setCourtOnTime(null);
//		court1.setCourtApplyTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
//		court1.setCourtName("飛龍運動館1");
//		court1.setCourtPic(null);
//		court1.setCourtTelephone("0222883103");
//		court1.setCourtAddress("臺北市松山區南京東路5段84號1樓");
//		court1.setCourtRule("暫無");
//		court1.setLoc("松山區");
//		court1.setCourtApplyStatus(0);
//		court1.setCourtOpenTime(java.sql.Time.valueOf("07:00:00"));
//		court1.setCourtCloseTime(java.sql.Time.valueOf("22:00:00"));
//
//		// 修改
//		Court court2 = new Court();
//		court1.setPlaceID(62000001);
//		court1.setCourtID(61000011);
//		court1.setPlaceName("飛龍運動館");
//		court1.setPlaceFee(430);
//		court1.setBall(2);
//		dao.update(court2);
//
//		// 刪除
//		dao.delete(62000011);

//		// 查詢單筆
//		Court court3 = dao.findByPK(61000001);
//		System.out.print(court3.getoUserID() + ",");
//		System.out.print(court3.getManageID() + ",");
//		System.out.print(court3.getCourtOnTime() + ",");
//		System.out.print(court3.getCourtApplyTime() + ",");
//		System.out.print(court3.getCourtName() + ",");
//		System.out.print(court3.getCourtPic() + ",");
//		System.out.print(court3.getCourtTelephone() + ",");
//		System.out.print(court3.getCourtAddress() + ",");
//		System.out.print(court3.getCourtRule() + ",");
//		System.out.println(court3.getLoc() + ",");
//		System.out.println(court3.getCourtApplyStatus() + ",");
//		System.out.println(court3.getCourtOpenTime() + ",");
//		System.out.println(court3.getCourtCloseTime() + ",");
	
		System.out.println("---------------------");

//		// 查詢多筆
		List<Court>list = dao.getAll();
		for (Court court:list) {
			System.out.print(court.getCourtID() + ",");
			System.out.print(court.getoUserID() + ",");
			System.out.print(court.getManageID() + ",");
			System.out.print(court.getCourtOnTime() + ",");
			System.out.print(court.getCourtApplyTime() + ",");
			System.out.print(court.getCourtName() + ",");
			System.out.print(court.getCourtPic() + ",");
			System.out.print(court.getCourtTelephone() + ",");
			System.out.print(court.getCourtAddress() + ",");
			System.out.print(court.getCourtRule() + ",");
			System.out.print(court.getLoc() + ",");
			System.out.print(court.getCourtApplyStatus() + ",");
			System.out.print(court.getCourtOpenTime() + ",");
			System.out.print(court.getCourtCloseTime() + ",");
			
			System.out.println();
		}
	}
}
