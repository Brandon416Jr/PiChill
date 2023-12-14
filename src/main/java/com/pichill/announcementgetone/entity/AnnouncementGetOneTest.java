package com.pichill.announcementgetone.entity;

import java.util.List;

import com.pichill.announcementgetone.controller.AnnouncementGetOneServlet;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAO;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAOImpl;
import com.pichill.announcementgetone.service.AnnouncementGetOneService;

public class AnnouncementGetOneTest {
	public static void main(String[] args) {
		AnnouncementGetOneDAO dao = new AnnouncementGetOneDAOImpl();

		// 單筆查詢
		AnnouncementGetOne announcementGetOne = dao.getAnnouncementByAnnounceID(21000001);
		System.out.print(announcementGetOne.getManageID() + ",");
		System.out.print(announcementGetOne.getAnnoTitle() + ",");
		System.out.print(announcementGetOne.getAnnoContent() + ",");
		System.out.print(announcementGetOne.getAnnoPic() + ",");
		System.out.println(announcementGetOne.getAnnoTime() + ",");

		System.out.println("---------------------");

		// 查多筆
		List<AnnouncementGetOne> list = dao.getAll();
		for (AnnouncementGetOne announcementGetAll : list) {
			System.out.print(announcementGetAll.getManageID() + ",");
			System.out.print(announcementGetAll.getAnnoTitle() + ",");
			System.out.print(announcementGetAll.getAnnoContent() + ",");
			System.out.print(announcementGetAll.getAnnoPic() + ",");
			System.out.println(announcementGetAll.getAnnoTime() + ",");
			System.out.println();
		}
	}
}
