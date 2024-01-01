package com.pichill.manage.entity;

import java.io.File;
import java.util.List;

import com.pichill.manage.model.ManageDAO;
import com.pichill.manage.model.ManageDAOImpl;
import com.pichill.util.EncryptDataUtil;
import com.pichill.manage.entity.Manage;

public class ManageTest {
	public static void main(String[] args) {
		ManageDAO dao = new ManageDAOImpl();
//
//		// 新增
//		Manage manage1 = new Manage();
//		manage1.setmName("朝輝");
//		manage1.setmUserName("liugogo");
//		manage1.setmPassword("144kd4l4");
//		manage1.setmBirth(java.sql.Date.valueOf("1997-12-12"));
//		manage1.setmGender(1);
//		manage1.setmTelephone("0933773992");
//		manage1.setmEmgContact("劉致融");
//		manage1.setmEmgPhone("0933848504");
//		manage1.setmAddress("台北市中正區中正路一段117號之三19樓");
//		manage1.setmHiredate(java.sql.Date.valueOf("2016-11-30"));
//		manage1.setmID("A736125622");
//		manage1.setmEmail("fikoslfk444@gmail.com");
//		manage1.setmProfilePic(null);
//		manage1.setmStatus(null);
//		dao.insert(manage1);
		
//		 修改13000001
//		Manage manage1 = new Manage();
//		String mPassword ="ldjoedsk";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage1.setmName("林孝呈");
//		manage1.setmUserName("AndyLSSin");
//		manage1.setmPassword(rawPassword);
//		manage1.setmBirth(java.sql.Date.valueOf("1989-09-26"));
//		manage1.setmGender(0);
//		manage1.setmTelephone("0945642566");
//		manage1.setmEmgContact("連亭竹");
//		manage1.setmEmgPhone("0934974098");
//		manage1.setmAddress("台中市北區建仁路八段414號");
//		manage1.setmHiredate(java.sql.Date.valueOf("2012-03-21"));
//		manage1.setmID("H236618827");
//		manage1.setmEmail("evie3641@gmail.com");
//		manage1.setmProfilePic(null);
//		manage1.setmStatus(1);
//		manage1.setManageID(13000001);
//		dao.update(manage1);
		
//		 修改13000002
//		Manage manage2 = new Manage();
//		String mPassword ="jildsidclf";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("劉基鴻");
//		manage2.setmUserName("Liu4aaaa6");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("2001-02-06"));
//		manage2.setmGender(1);
//		manage2.setmTelephone("0935673124");
//		manage2.setmEmgContact("劉邦彥");
//		manage2.setmEmgPhone("0926600599");
//		manage2.setmAddress("臺南市龍崎區烏樹林88號");
//		manage2.setmHiredate(java.sql.Date.valueOf("2022-12-11"));
//		manage2.setmID("P223490356");
//		manage2.setmEmail("eliana3815@gmail.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(1);
//		manage2.setManageID(13000002);
//		dao.update(manage2);
		
//		 修改13000003
//		Manage manage2 = new Manage();
//		String mPassword ="18773kkdek";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("陳晨威");
//		manage2.setmUserName("Chenchen98");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("1993-09-06"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0938368335");
//		manage2.setmEmgContact("袁淑雨");
//		manage2.setmEmgPhone("0971686190");
//		manage2.setmAddress("屏東縣屏東市安心十橫巷65號3樓");
//		manage2.setmHiredate(java.sql.Date.valueOf("2020-12-01"));
//		manage2.setmID("L213699602");
//		manage2.setmEmail("peppernell6715@outlook.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(1);
//		manage2.setManageID(13000003);
//		dao.update(manage2);
		
//		 修改13000004
//		Manage manage2 = new Manage();
//		String mPassword ="f2FL22B72c";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("林立");
//		manage2.setmUserName("Lin3u4k5");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("1979-06-26"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0928565076");
//		manage2.setmEmgContact("藍建翊");
//		manage2.setmEmgPhone("0934378505");
//		manage2.setmAddress("臺北市中正區衡陽路71號8樓");
//		manage2.setmHiredate(java.sql.Date.valueOf("2022-04-11"));
//		manage2.setmID("F260681378");
//		manage2.setmEmail("haskell4757@yahoo.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(1);
//		manage2.setManageID(13000004);
//		dao.update(manage2);
		
//		 修改13000005
//		Manage manage2 = new Manage();
//		String mPassword ="JzwbM8S8";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("許基宏");
//		manage2.setmUserName("B948dllkcd");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("2007-08-02"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0911720555");
//		manage2.setmEmgContact("馬採筑");
//		manage2.setmEmgPhone("0987003632");
//		manage2.setmAddress("臺北市松山區市民大道５段30號之4");
//		manage2.setmHiredate(java.sql.Date.valueOf("2018-03-21"));
//		manage2.setmID("N238086961");
//		manage2.setmEmail("roberts2515@gmail.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(1);
//		manage2.setManageID(13000005);
//		dao.update(manage2);
		
//		 修改13000006
		Manage manage2 = new Manage();
		String mPassword ="1234567890";
		String rawPassword = EncryptDataUtil.encryptData(mPassword);
		manage2.setmName("林智勝");
		manage2.setmUserName("1234567890");
		manage2.setmPassword(rawPassword);
		manage2.setmBirth(java.sql.Date.valueOf("1995-09-20"));
		manage2.setmGender(0);
		manage2.setmTelephone("0956975066");
		manage2.setmEmgContact("陳姣慧");
		manage2.setmEmgPhone("0937532364");
		manage2.setmAddress("彰化縣社頭鄉員集路３段20號");
		manage2.setmHiredate(java.sql.Date.valueOf("2023-04-30"));
		manage2.setmID("U133209824");
		manage2.setmEmail("rodriguez4463@yahoo.com");
		manage2.setmProfilePic(null);
		manage2.setmStatus(1);
		manage2.setManageID(13000006);
		dao.update(manage2);
		
//		 修改13000007
//		Manage manage2 = new Manage();
//		String mPassword ="58SH5yWFi";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("陳金鋒");
//		manage2.setmUserName("garyfarye");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("1965-12-21"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0913013129");
//		manage2.setmEmgContact("趙潔玉");
//		manage2.setmEmgPhone("0958479177");
//		manage2.setmAddress("彰化縣彰化市彰南路２段65號");
//		manage2.setmHiredate(java.sql.Date.valueOf("2019-01-21"));
//		manage2.setmID("J151162996");
//		manage2.setmEmail("nestor6451@gmail.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(1);
//		manage2.setManageID(13000007);
//		dao.update(manage2);
		
//		 修改13000009
//		Manage manage2 = new Manage();
//		String mPassword ="2222222222";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("羅裕鵬");
//		manage2.setmUserName("2222222222");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("1998-04-16"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0971479487");
//		manage2.setmEmgContact("羅清文");
//		manage2.setmEmgPhone("0978640312");
//		manage2.setmAddress("新北市永和區環河西路１段30號15樓");
//		manage2.setmHiredate(java.sql.Date.valueOf("2011-07-24"));
//		manage2.setmID("F143949583");
//		manage2.setmEmail("brandon442@gmail.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(2);
//		manage2.setManageID(13000009);
//		dao.update(manage2);
		
//		 修改13000010
//		Manage manage2 = new Manage();
//		String mPassword ="1111111111";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("涂鴻欽");
//		manage2.setmUserName("1111111111");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("1988-12-12"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0915029956");
//		manage2.setmEmgContact("宋芝郁");
//		manage2.setmEmgPhone("0989051613");
//		manage2.setmAddress("桃園市龍潭區天龍二巷2號之11");
//		manage2.setmHiredate(java.sql.Date.valueOf("2015-11-11"));
//		manage2.setmID("Q198019682");
//		manage2.setmEmail("clementine1476@gmail.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(1);
//		manage2.setManageID(13000010);
//		dao.update(manage2);
		
//		 修改13000001
//		Manage manage2 = new Manage();
//		String mPassword ="1111111111";
//		String rawPassword = EncryptDataUtil.encryptData(mPassword);
//		manage2.setmName("涂鴻欽");
//		manage2.setmUserName("1111111111");
//		manage2.setmPassword(rawPassword);
//		manage2.setmBirth(java.sql.Date.valueOf("1988-12-12"));
//		manage2.setmGender(0);
//		manage2.setmTelephone("0922456788");
//		manage2.setmEmgContact("陳致融");
//		manage2.setmEmgPhone("0911111111");
//		manage2.setmAddress("屏東縣中正區中正路一段117號之三19樓");
//		manage2.setmHiredate(java.sql.Date.valueOf("2016-01-30"));
//		manage2.setmID("Q198019682");
//		manage2.setmEmail("clementine1476@gmail.com");
//		manage2.setmProfilePic(null);
//		manage2.setmStatus(0);
//		manage2.setManageID(13000010);
//		dao.update(manage2);
		
		// 刪除
//		dao.delete(13000012);
//		dao.delete(13000013);
//		dao.delete(13000014);

		// 查詢單筆by manageID
//		Manage manage3 = dao.getManageByManageID(13000001);
//		System.out.print(manage3.getManageID() + ",");
//		System.out.print(manage3.getmName() + ",");
//		System.out.print(manage3.getmUserName() + ",");
//		System.out.print(manage3.getmPassword() + ",");
//		System.out.print(manage3.getmBirth() + ",");
//		System.out.print(manage3.getmGender() + ",");
//		System.out.print(manage3.getmTelephone() + ",");
//		System.out.print(manage3.getmEmgContact() + ",");
//		System.out.print(manage3.getmEmgPhone() + ",");
//		System.out.print(manage3.getmAddress() + ",");
//		System.out.print(manage3.getmHiredate() + ",");
//		System.out.print(manage3.getmID() + ",");
//		System.out.print(manage3.getmEmail() + ",");
//		System.out.print(manage3.getmProfilePic() + ",");
//		System.out.print(manage3.getmStatus() + ",");
//
//		System.out.println("---------------------");

		// 查詢單筆by mName
//		Manage manage4 = dao.getManageBymName("劉基鴻");
//		
//		System.out.print(manage4.getManageID() + ",");
//		System.out.print(manage4.getmName() + ",");
//		System.out.print(manage4.getmUserName() + ",");
//		System.out.print(manage4.getmPassword() + ",");
//		System.out.print(manage4.getmBirth() + ",");
//		System.out.print(manage4.getmGender() + ",");
//		System.out.print(manage4.getmTelephone() + ",");
//		System.out.print(manage4.getmEmgContact() + ",");
//		System.out.print(manage4.getmEmgPhone() + ",");
//		System.out.print(manage4.getmAddress() + ",");
//		System.out.print(manage4.getmHiredate() + ",");
//		System.out.print(manage4.getmID() + ",");
//		System.out.print(manage4.getmEmail() + ",");
//		System.out.print(manage4.getmProfilePic() + ",");
//		System.out.print(manage4.getmStatus() + ",");
//		

//		System.out.println("---------------------");

		// 查詢單筆by mEmail");
//		Manage manage5 = dao.getManageBymEmail("evie3641@gmail.com");
//		System.out.print(manage5.getManageID() + ",");
//		System.out.print(manage5.getmName() + ",");
//		System.out.print(manage5.getmUserName() + ",");
//		System.out.print(manage5.getmPassword() + ",");
//		System.out.print(manage5.getmBirth() + ",");
//		System.out.print(manage5.getmGender() + ",");
//		System.out.print(manage5.getmTelephone() + ",");
//		System.out.print(manage5.getmEmgContact() + ",");
//		System.out.print(manage5.getmEmgPhone() + ",");
//		System.out.print(manage5.getmAddress() + ",");
//		System.out.print(manage5.getmHiredate() + ",");
//		System.out.print(manage5.getmLastLogTime() + ",");
//		System.out.print(manage5.getmID() + ",");
//		System.out.print(manage5.getmEmail() + ",");
//		System.out.print(manage5.getmProfilePic() + ",");
//		System.out.print(manage5.getmStatus() + ",");
//
//		System.out.println("---------------------");

		// 查詢多筆
//		List<Manage> list = dao.getAll();
//		for (Manage manage : list) {
//		System.out.print(manage.getManageID() + ",");
//			System.out.print(manage.getmName() + ",");
//			System.out.print(manage.getmUserName() + ",");
//			System.out.print(manage.getmPassword() + ",");
//			System.out.print(manage.getmBirth() + ",");
//			System.out.print(manage.getmGender() + ",");
//			System.out.print(manage.getmTelephone() + ",");
//			System.out.print(manage.getmEmgContact() + ",");
//			System.out.print(manage.getmEmgPhone() + ",");
//			System.out.print(manage.getmAddress() + ",");
//			System.out.print(manage.getmHiredate() + ",");
//			System.out.print(manage.getmID() + ",");
//			System.out.print(manage.getmEmail() + ",");
//			System.out.print(manage.getmProfilePic() + ",");
//			System.out.print(manage.getmStatus() + ",");
//			System.out.println();
//		}
		File file = new File("payment_conf.xml");
		String absolutePath = file.getAbsolutePath();
		System.out.println(absolutePath);
	}
}
