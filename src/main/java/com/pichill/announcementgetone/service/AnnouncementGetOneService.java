package com.pichill.announcementgetone.service;

import java.util.List;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAO;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAOImpl;
import com.pichill.backstage.announcement.entity.Announcement;
//前台公告查一筆與查多筆的service

public class AnnouncementGetOneService {
	private final AnnouncementGetOneDAO dao;
	
	public AnnouncementGetOneService() {
		dao = new AnnouncementGetOneDAOImpl();
	}

	public AnnouncementGetOne getOneAnnouncementID(Integer announceID) {
		return dao.getAnnouncementByAnnounceID(announceID);
	}
//	public AnnouncementGetOne getAnnouncementByAnnoTitle(String annoTitle) {
//		return dao.getAnnouncementByAnnoTitle(annoTitle);
//	}

	public List<AnnouncementGetOne> getAll() {
		return dao.getAll();
	}

}
