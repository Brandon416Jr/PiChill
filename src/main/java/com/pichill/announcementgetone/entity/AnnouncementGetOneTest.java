package com.pichill.announcementgetone.entity;

import java.util.List;

import com.pichill.announcementgetone.model.AnnouncementGetOneDAO;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAOImpl;
import com.pichill.backstage.announcement.entity.Announcement;

public class AnnouncementGetOneTest {
	public static void main(String[] args) {
		AnnouncementGetOneDAO dao = new AnnouncementGetOneDAOImpl();

		// 單筆查詢
		Announcement announcement = dao.getAnnouncementByAnnounceID(21000007);
		System.out.print(announcement.getManage() + ",");
		System.out.print(announcement.getAnnoTitle() + ",");
		System.out.print(announcement.getAnnoContent() + ",");
		System.out.print(announcement.getAnnoPic() + ",");
		System.out.println(announcement.getAnnoTime() + ",");

		System.out.println("---------------------");

		// 查多筆
		List<Announcement> list = dao.getAll();
		if (list!=null) {
			for (Announcement announcementGetAll : list) {
				System.out.print(announcementGetAll.getManage().getmName() + ",");
				System.out.print(announcementGetAll.getAnnoTitle() + ",");
				System.out.print(announcementGetAll.getAnnoContent() + ",");
				System.out.print(announcementGetAll.getAnnoPic() + ",");
				System.out.println(announcementGetAll.getAnnoTime() + ",");
				System.out.println();
			} 
			}else {
				System.out.println("list is null, check plz");
			}
		}
	}

