package com.pichill.owneruser.entity;

import java.util.List;

import com.pichill.owneruser.OwnerUserDAO;
import com.pichill.owneruser.OwnerUserDAOImpl;

public class TestOwnerUser {
	public static void main(String[] args) {
		OwnerUserDAO dao = new OwnerUserDAOImpl();

		// 新增
//		OwnerUser ownerUser1 = new OwnerUser();
//		ownerUser1.setoUserName("hfhjfj888@gmail.com");
//		ownerUser1.setoPassword("aad2411119jH");
//		ownerUser1.setoIDNum("A1993928910");
//		ownerUser1.setCompiled("42694355");
//		ownerUser1.setoName("王曉明");
//		ownerUser1.setoGender(0);
//		ownerUser1.setoBirth(java.sql.Date.valueOf("1990-09-09"));
//		ownerUser1.setoTelephone("0926361110");
//		ownerUser1.setoAddress("臺北市萬華區寶興街38巷7號4樓");
//		ownerUser1.setoBankCode("008");
//		ownerUser1.setoBankAccount("810100097303");
//		ownerUser1.setoProfilePic(null);
//		ownerUser1.setoBankAccount("810100097303");
//		ownerUser1.setoProfilePic(null);
//		ownerUser1.setoRegisterDate(java.sql.Date.valueOf("2023-10-09"));
//		ownerUser1.setoPostAmount(0);
//		ownerUser1.setoReportCnt(0);
//		ownerUser1.setCourtArriveCnt(0);
//		ownerUser1.setCouponArriveCnt(0);
//		ownerUser1.setRsvdCnts(0);
//		ownerUser1.setoEmail("hfhjfj888@gmail.com");

//		dao.add(ownerUser1);
		// 修改
//		OwnerUser ownerUser2 = new OwnerUser();
//		ownerUser1.setoUserName("hfhjfj888@gmail.com");
//		ownerUser1.setoPassword("aad2411119jH");
//		ownerUser1.setoIDNum("A1993928910");
//		ownerUser1.setCompiled("42694355");
//		ownerUser1.setoName("王小明");
//		ownerUser1.setoGender(0);
//		ownerUser1.setoBirth(java.sql.Date.valueOf("19-09-09"));
//		ownerUser1.setoTelephone("0926361110");
//		ownerUser1.setoAddress("臺北市萬華區寶興街38巷7號4樓");
//		ownerUser1.setoBankCode("008");
//		ownerUser1.setoBankAccount("810100097303");
//		ownerUser1.setoProfilePic(null);
//		ownerUser1.setoBankAccount("810100097303");
//		ownerUser1.setoProfilePic(null);
//		ownerUser1.setoRegisterDate(java.sql.Date.valueOf("2023-10-09"));
//		ownerUser1.setoPostAmount(0);
//		ownerUser1.setoReportCnt(0);
//		ownerUser1.setCourtArriveCnt(0);
//		ownerUser1.setCouponArriveCnt(0);
//		ownerUser1.setRsvdCnts(0);
//		ownerUser1.setoEmail("hfhjfj888@gmail.com");
//		ownerUser2.setBackAuthorityID(12000011); //PK
//		dao.update(ownerUser2);

		// 刪除
//		dao.delete(12000011);

		// 查詢單筆
		OwnerUser ownerUser3 = dao.findByPK(12000001);
		System.out.print(ownerUser3.getoUserName() + ",");
		System.out.println(ownerUser3.getoPassword() + ",");
		System.out.println("---------------------");

		// 查詢多筆
//		List<OwnerUser> list = dao.getAll();
//		for (OwnerUser ownerUser : list) {
//			System.out.print(ownerUser.getoUserName() + ",");
//			System.out.print(ownerUser.getoPassword() + ",");
//			System.out.println();
//		}

	}
}
