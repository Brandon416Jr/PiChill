package com.pichill.manage.entity;

import java.util.List;

import com.pichill.manage.model.ManageDAO;
import com.pichill.manage.model.ManageDAOImpl;
import com.pichill.manage.entity.Manage;

public class ManageTest {
	public static void main(String[] args) {
		ManageDAO dao = new ManageDAOImpl();

		// 新增
//		Manage manage1 = new Manage();
//		manage1.setmName("蔡煒宜");
//		manage1.setmUserName("liugogo");
//		manage1.setmPassword("144kd4l4");
//		manage1.setmBirth(java.sql.Date.valueOf("1997-12-12"));
//		manage1.setmGender(1);
//		manage1.setmTelephone("0933773992");
//		manage1.setmEmgContact("劉致融");
//		manage1.setmEmgPhone("0933848504");
//		manage1.setmAddress("台北市中正區中正路一段117號之三19樓");
//		manage1.setmHiredate(java.sql.Date.valueOf("2016-11-30"));
//		manage1.setmLastLogTime(java.sql.Timestamp.valueOf("2022-12-31 23:59:59"));
//		manage1.setmID("A736125622");
//		manage1.setmEmail("fikoslfk444@gmail.com");
//		manage1.setmProfilePic(null);
//		manage1.setmStatus(1);
//		dao.insert(manage1);
//		
		// 修改
		Manage manage2 = new Manage();
		
		manage2.setmName("羅煒宜");
		manage2.setmUserName("chengogo");
		manage2.setmPassword("144kd4l4");
		manage2.setmBirth(java.sql.Date.valueOf("1997-12-12"));
		manage2.setmGender(0);
		manage2.setmTelephone("0922222222");
		manage2.setmEmgContact("陳致融");
		manage2.setmEmgPhone("0911111111");
		manage2.setmAddress("屏東縣中正區中正路一段117號之三19樓");
		manage2.setmHiredate(java.sql.Date.valueOf("2016-01-30"));
		manage2.setmLastLogTime(java.sql.Timestamp.valueOf("2012-12-31 23:59:59"));
		manage2.setmID("K736125622");
		manage2.setmEmail("fikoslfk555@gmail.com");
		manage2.setmProfilePic(null);
		manage2.setmStatus(1);
		manage2.setManageID(13000014);
//		
//		
//		
		dao.update(manage2);
//		
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
//		System.out.print(manage3.getmLastLogTime() + ",");
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
//		System.out.print(manage4.getmLastLogTime() + ",");
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
//			System.out.print(manage.getmLastLogTime() + ",");
//			System.out.print(manage.getmID() + ",");
//			System.out.print(manage.getmEmail() + ",");
//			System.out.print(manage.getmProfilePic() + ",");
//			System.out.print(manage.getmStatus() + ",");
//			System.out.println();
//		}
	}
}
