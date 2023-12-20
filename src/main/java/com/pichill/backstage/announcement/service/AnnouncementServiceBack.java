package com.pichill.backstage.announcement.service;

import java.util.List;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;
import com.pichill.backstage.announcement.model.AnnouncementDAOBack;
import com.pichill.backstage.announcement.model.AnnouncementDAOImplBack;


public class AnnouncementServiceBack {
	private final AnnouncementDAOBack dao;
	
	public AnnouncementServiceBack() {
		dao = new AnnouncementDAOImplBack();
	}
	
	public void insertAnnouncement(AnnouncementGetOne announcement) {
		dao.insert(announcement);	
	}

	public void updateAnnouncement(AnnouncementGetOne announcement) {
		dao.update(announcement);
	}

	public AnnouncementGetOne getOneAnnouncement(Integer announceID) {
		return dao.getAnnouncementByAnnounceID(announceID);
	}

	public List<AnnouncementGetOne> getAll() {
		return dao.getAll();
	}
	
	

}
