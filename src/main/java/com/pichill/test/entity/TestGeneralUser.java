package com.pichill.test.entity;

import java.util.List;

import com.pichill.test.model.GeneralUserDAO;
import com.pichill.test.model.GeneralUserDAOImpl;

import com.pichill.test.entity.GeneralUser;

public class TestGeneralUser {
	public static void main(String[] args) throws Exception {
		GeneralUserDAO dao = new GeneralUserDAOImpl();

		// 新增
//		GeneralUser gen = new GeneralUser();
//		gen.setgName("吳大成");
//		gen.setgTelephone("0922000321");
//		gen.setgEmail("cmg321@gmail.com");
//		gen.setgAddress("新北市土城區學士路28巷3號");
//		gen.setStatus(0);
//		gen.setgGender(0);
//		gen.setgPassword("qaz123");
//		gen.setgIDNum("Q222156886");
//		gen.setNicknameID(null);
//		gen.setPiAmount(null);

//		gen.setgPostAmount(3);
//		gen.setCommentAmount(5);
//		gen.setgReportCnt(0);
//		gen.setgRegistDate(java.sql.Date.valueOf("2023-09-10"));
//		gen.setgLastLogTime(java.sql.Timestamp.valueOf("2023-10-15 10:10:10"));
//		gen.setgBirth(java.sql.Date.valueOf("2000-02-20"));
//		gen.setPurchaseCnt(5);
//		gen.setYoyakuCnt(3);
//		gen.setgProfilePic(null);
//		dao.add(gen);

		// 修改
		GeneralUser gen1 = new GeneralUser();
		gen1.setgUserID(11000002);
		gen1.setgName("無痾痾");
		gen1.setgTelephone("0921000456");
		gen1.setgEmail("abc456@gmail.com");
		gen1.setgAddress("新北市南港區八德路215號");
		gen1.setStatus(0);
		gen1.setgGender(1);
		gen1.setgPassword("qaz12345");
		gen1.setgIDNum("A222142123");
		gen1.setNicknameID(null);
		gen1.setPiAmount(null);
//		gen1.setCouponAmount(null);
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

		// 查詢單筆
//		GeneralUser gen3 = dao.findByPK(11000010);
//		System.out.print(gen3.getgUserID() + ",");
//		System.out.print(gen3.getgName() + ",");
//		System.out.print(gen3.getgTelephone() + ",");
//		System.out.print(gen3.getgEmail() + ",");
//		System.out.print(gen3.getgAddress() + ",");
//		System.out.print(gen3.getStatus() + ",");
//		System.out.print(gen3.getgGender() + ",");
//		System.out.print(gen3.getgPassword() + ",");
//		System.out.print(gen3.getgIDNum() + ",");
//		System.out.print(gen3.getNicknameID() + ",");
//		System.out.print(gen3.getPiAmount() + ",");
//		System.out.print(gen3.getCouponAmount() + ",");
//		System.out.print(gen3.getgPostAmount() + ",");
//		System.out.print(gen3.getCommentAmount() + ",");
//		System.out.print(gen3.getgReportCnt() + ",");
//		System.out.print(gen3.getgRegistDate() + ",");
//		System.out.print(gen3.getgLastLogTime() + ",");
//		System.out.print(gen3.getgBirth() + ",");
//		System.out.print(gen3.getPurchaseCnt() + ",");
//		System.out.print(gen3.getYoyakuCnt() + ",");
//		System.out.println(gen3.getgProfilePic());
//		System.out.println("---------------------");

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
//			System.out.println();
//		}
	}}
