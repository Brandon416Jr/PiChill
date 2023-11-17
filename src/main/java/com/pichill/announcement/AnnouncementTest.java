package com.pichill.announcement;

import java.util.*;
import java.sql.*;

public class AnnouncementTest {
	public static void main(String[] args) {
		AnnouncementDAO dao = new AnnouncementDAOImpl();

		// 新增
//		Announcement announcement= new Announcement();
//		announcement.setManageID(13000002);
//		announcement.setAnnoTitle("我想回家");
//		announcement.setAnnoContent("我想回家我想回家我想回家我想回家我想回家我想回家我想回家我想回家");
//		announcement.setAnnoPic(null);
//		announcement.setAnnoTime(java.sql.Timestamp.valueOf("2022-12-31 23:59:59"));
//		
//		dao.add(announcement);
		
		// 修改
//		Announcement announcement1= new Announcement();
//		announcement1.setManageID(13000008);
//		announcement1.setAnnoTitle("我不想回家");
//		announcement1.setAnnoContent("我不想回家我不想回家我不想回家我不想回家我不想回家我不想回家我不想回家我想回家");
//		announcement1.setAnnoPic(null);
//		announcement1.setAnnoTime(java.sql.Timestamp.valueOf("2020-12-31 23:59:59"));
//		announcement1.setAnnounceID(21000011);
//		
//		dao.update(announcement1);
		
		// 刪除
//		dao.delete(21000011);
//		dao.delete(21000012);

		
		// 單筆查詢
//		Announcement announcement2 = dao.getAnnouncementByAnnounceID(21000001);
//		System.out.print(announcement2.getManageID() + ",");
//		System.out.print(announcement2.getAnnoTitle() + ",");
//		System.out.print(announcement2.getAnnoContent() + ",");
//		System.out.print(announcement2.getAnnoPic() + ",");
//		System.out.println(announcement2.getAnnoTime() + ",");
//		
//		System.out.println("---------------------");
		
		// 查多筆
		List<Announcement> list = dao.getAll();
		for (Announcement announcement3 : list) {
			System.out.print(announcement3.getManageID() + ",");
			System.out.print(announcement3.getAnnoTitle() + ",");
			System.out.print(announcement3.getAnnoContent() + ",");
			System.out.print(announcement3.getAnnoPic() + ",");
			System.out.println(announcement3.getAnnoTime() + ",");
			System.out.println();
		}
	}
}
