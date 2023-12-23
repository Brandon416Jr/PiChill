package com.pichill.announcementgetone.entity;

import java.util.List;

import com.pichill.announcementgetone.model.AnnouncementGetOneDAO;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAOImpl;

public class AnnouncementGetOneTest {
	public static void main(String[] args) {
		AnnouncementGetOneDAO dao = new AnnouncementGetOneDAOImpl();

		// 單筆查詢
		AnnouncementGetOne announcementGetOne = dao.getAnnouncementByAnnounceID(21000007);
		System.out.print(announcementGetOne.getManage() + ",");
		System.out.print(announcementGetOne.getAnnoTitle() + ",");
		System.out.print(announcementGetOne.getAnnoContent() + ",");
		System.out.print(announcementGetOne.getAnnoPic() + ",");
		System.out.println(announcementGetOne.getAnnoTime() + ",");

		System.out.println("---------------------");

		// 查多筆
		List<AnnouncementGetOne> list = dao.getAll();
		if (list!=null) {
			for (AnnouncementGetOne announcementGetAll : list) {
				System.out.print(announcementGetAll.getManage() + ",");
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

