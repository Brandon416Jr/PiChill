//package com.pichill.managejdbc.entity;
//
//import java.util.List;
//
//import com.pichill.managejdbc.model.ManageDAO;
//import com.pichill.managejdbc.model.ManageDAOImpl;
//
//
//public class ManageTest {
//	public static void main(String[] args) {
//		ManageDAO dao = new ManageDAOImpl();
//
//		// 新增
////		Manage manage1 = new Manage();
////		manage1.setmName("六煒宜");
////		manage1.setmUserName("liugogo");
////		manage1.setmPassword("144kd4l4");
////		manage1.setmBirth(java.sql.Date.valueOf("1997-12-12"));
////		manage1.setmGender(1);
////		manage1.setmTelephone("0933773992");
////		manage1.setmEmgContact("劉致融");
////		manage1.setmEmgPhone("0933848504");
////		manage1.setmAddress("台北市中正區中正路一段117號之三19樓");
////		manage1.setmHiredate(java.sql.Date.valueOf("2016-11-30"));
////		manage1.setmLastLogTime(java.sql.Timestamp.valueOf("2022-12-31 23:59:59"));
////		manage1.setmID("A736125622");
////		manage1.setmEmail("fikoslfk444@gmail.com");
////		manage1.setmProfilePic(null);
////		manage1.setmStatus(1);
////		dao.insert(manage1);
////		
//		// 修改 
////		Manage manage2 = new Manage();
////		manage2.setmName("陳煒宜");
////		manage2.setmUserName("chengogo");
////		manage2.setmPassword("144kd4l4");
////		manage2.setmBirth(java.sql.Date.valueOf("1997-12-12"));
////		manage2.setmGender(0);
////		manage2.setmTelephone("0922222222");
////		manage2.setmEmgContact("陳致融");
////		manage2.setmEmgPhone("0911111111");
////		manage2.setmAddress("屏東縣中正區中正路一段117號之三19樓");
////		manage2.setmHiredate(java.sql.Date.valueOf("2016-01-30"));
////		manage2.setmLastLogTime(java.sql.Timestamp.valueOf("2012-12-31 23:59:59"));
////		manage2.setmID("K736125622");
////		manage2.setmEmail("fikoslfk555@gmail.com");
////		manage2.setmProfilePic(null);
////		manage2.setmStatus(1);
////		manage2.setManageID(13000015);
////		
////		dao.update(manage2);
////		
//		// 刪除 先不要這個功能
////		dao.delete(13000011);
////		dao.delete(13000013);
////		dao.delete(13000014);
//		
//		// 查詢單筆
//		Manage manage3 = dao.findByPrimaryKey(13000001);
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
//		System.out.print(manage3.getmLastLogTime() + ",");
//		System.out.print(manage3.getmID() + ",");
//		System.out.print(manage3.getmEmail() + ",");
//		System.out.print(manage3.getmProfilePic() + ",");
//		System.out.print(manage3.getmStatus() + ",");
//		
//		System.out.println("---------------------");
//
//		// 查詢多筆
//////		List<Manage> list = dao.getAll();
//////		for (Manage manage : list) {
//////			System.out.print(manage.getmName() + ",");
//////			System.out.print(manage.getmUserName() + ",");
//////			System.out.print(manage.getmPassword() + ",");
//////			System.out.print(manage.getmBirth() + ",");
//////			System.out.print(manage.getmGender() + ",");
//////			System.out.print(manage.getmTelephone() + ",");
//////			System.out.print(manage.getmEmgContact() + ",");
//////			System.out.print(manage.getmEmgPhone() + ",");
//////			System.out.print(manage.getmAddress() + ",");
//////			System.out.print(manage.getmHiredate() + ",");
//////			System.out.print(manage.getmLastLogTime() + ",");
//////			System.out.print(manage.getmID() + ",");
//////			System.out.print(manage.getmEmail() + ",");
//////			System.out.print(manage.getmProfilePic() + ",");
//////         System.out.print(manage.getmStatus() + ",");
//////			System.out.println();
////		}
//	}
//}
