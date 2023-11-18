package com.pichill.generaluser;

import java.util.List;

public class TestGeneralUser {
	public static void main(String[] args) {
		
		GeneralUserDAO dao = new GeneralUserDAOImpl();
		
		// 新增
//		GeneralUser gen = new GeneralUser();
//		gen.setgName("王小明");
//		gen.setgTelephone("0921000123");
//		gen.setgEmail("hng123@gmail.com");
//		gen.setgAddress("新北市土城區學士路24巷5號");
//		gen.setStatus(0);
//		gen.setgGender(0);
//		gen.setgPassword("vul3ejo3");
//		gen.setgIDNum("F229514683");
//		gen.setNicknameID(null);
//		gen.setPiAmount(null);
//		gen.setCouponAmount(null);
//		gen.setgPostAmount(2);
//		gen.setCommentAmount(3);
//		gen.setgReportCnt(0);
//		gen.setgRegistDate(java.sql.Date.valueOf("2023-09-09"));
//		gen.setgLastLogTime(java.sql.Timestamp.valueOf("2023-10-11 09:09:09"));
//		gen.setgBirth(java.sql.Date.valueOf("1998-05-09"));
//		gen.setPurchaseCnt(5);
//		gen.setYoyakuCnt(3);
//		gen.setgProfilePic(null);
//		
//		dao.add(gen);
		
		// 修改
		GeneralUser gen1 = new GeneralUser();
		gen1.setgUserID(11000003);
		gen1.setgName("莊水水");
		gen1.setgTelephone("0921000456");
		gen1.setgEmail("abc456@gmail.com");
		gen1.setgAddress("新北市南港區八德路215號");
		gen1.setStatus(0);
		gen1.setgGender(1);
		gen1.setgPassword("qaz12345");
		gen1.setgIDNum("A222142123");
		gen1.setNicknameID(null);
		gen1.setPiAmount(null);
		gen1.setCouponAmount(null);
		gen1.setgPostAmount(null);
		gen1.setCommentAmount(4);
		gen1.setgReportCnt(0);
		gen1.setgRegistDate(java.sql.Date.valueOf("2023-09-10"));
		gen1.setgLastLogTime(java.sql.Timestamp.valueOf("2023-10-12 08:09:09"));
		gen1.setgBirth(java.sql.Date.valueOf("1990-05-13"));
		gen1.setPurchaseCnt(5);
		gen1.setYoyakuCnt(3);
		gen1.setgProfilePic(null);
		
		dao.update(gen1);

		// 刪除
//		dao.delete(11000002);

		// 查詢單筆
//		GeneralUser gen2 = dao.findByPK(11000001);
//		System.out.print(gen2.getgUserID() + ",");
//		System.out.print(gen2.getgName() + ",");
//		System.out.print(gen2.getgTelephone() + ",");
//		System.out.print(gen2.getgEmail() + ",");
//		System.out.print(gen2.getgAddress() + ",");
//		System.out.print(gen2.getStatus() + ",");
//		System.out.print(gen2.getgGender() + ",");
//		System.out.print(gen2.getgPassword() + ",");
//		System.out.print(gen2.getgIDNum() + ",");
//		System.out.print(gen2.getNicknameID() + ",");
//		System.out.print(gen2.getPiAmount() + ",");
//		System.out.print(gen2.getCouponAmount() + ",");
//		System.out.print(gen2.getgPostAmount() + ",");
//		System.out.print(gen2.getCommentAmount() + ",");
//		System.out.print(gen2.getgReportCnt() + ",");
//		System.out.print(gen2.getgRegistDate() + ",");
//		System.out.print(gen2.getgLastLogTime() + ",");
//		System.out.print(gen2.getgBirth() + ",");
//		System.out.print(gen2.getPurchaseCnt() + ",");
//		System.out.print(gen2.getYoyakuCnt() + ",");
//		System.out.println(gen2.getgProfilePic());

		// 查詢多筆
//		List<GeneralUser> list = dao.getAll();
//		for (GeneralUser gen3 : list) {
//			System.out.print(gen3.getgUserID() + ",");
//			System.out.print(gen3.getgName() + ",");
//			System.out.print(gen3.getgTelephone() + ",");
//			System.out.print(gen3.getgEmail() + ",");
//			System.out.print(gen3.getgAddress() + ",");
//			System.out.print(gen3.getStatus() + ",");
//			System.out.print(gen3.getgGender() + ",");
//			System.out.print(gen3.getgPassword() + ",");
//			System.out.print(gen3.getgIDNum() + ",");
//			System.out.print(gen3.getNicknameID() + ",");
//			System.out.print(gen3.getPiAmount() + ",");
//			System.out.print(gen3.getCouponAmount() + ",");
//			System.out.print(gen3.getgPostAmount() + ",");
//			System.out.print(gen3.getCommentAmount() + ",");
//			System.out.print(gen3.getgReportCnt() + ",");
//			System.out.print(gen3.getgRegistDate() + ",");
//			System.out.print(gen3.getgLastLogTime() + ",");
//			System.out.print(gen3.getgBirth() + ",");
//			System.out.print(gen3.getPurchaseCnt() + ",");
//			System.out.print(gen3.getYoyakuCnt() + ",");
//			System.out.println(gen3.getgProfilePic());
//		}
	}
}
