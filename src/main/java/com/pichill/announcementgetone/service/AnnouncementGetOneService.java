package com.pichill.announcementgetone.service;

import java.util.List;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAO;
import com.pichill.announcementgetone.model.AnnouncementGetOneDAOImpl;
import com.pichill.backstage.announcement.entity.Announcement;

public class AnnouncementGetOneService {
	private final AnnouncementGetOneDAO dao;
	
	public AnnouncementGetOneService() {
		dao = new AnnouncementGetOneDAOImpl();
	}
//	public AnnouncementGetOneService() {
//		dao = new AnnouncementGetOneDAOImpl();
//	}

	public Announcement getOneAnnouncementID(Integer announceID) {
		return dao.getAnnouncementByAnnounceID(announceID);
	}
//	public AnnouncementGetOne getAnnouncementByAnnoTitle(String annoTitle) {
//		return dao.getAnnouncementByAnnoTitle(annoTitle);
//	}

	public List<Announcement> getAll() {
		return dao.getAll();
	}

}
