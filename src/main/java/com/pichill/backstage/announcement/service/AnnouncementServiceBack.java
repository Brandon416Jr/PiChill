package com.pichill.backstage.announcement.service;

import java.util.List;

import com.pichill.backstage.announcement.entity.Announcement;
import com.pichill.backstage.announcement.model.AnnouncementDAOBack;
import com.pichill.backstage.announcement.model.AnnouncementDAOImplBack;
import com.pichill.manage.entity.Manage;

public class AnnouncementServiceBack {
	private final AnnouncementDAOBack dao;
	
	public AnnouncementServiceBack() {
		dao = new AnnouncementDAOImplBack();
	}
	
	public void insertAnnouncement(Announcement announcement) {
		dao.insert(announcement);	
	}

	public void updateAnnouncement(Announcement announcement) {
		dao.update(announcement);
	}

	public Announcement getOneAnnouncement(Integer announceID) {
		return dao.getAnnouncementByAnnounceID(announceID);
	}

	public List<Announcement> getAll() {
		return dao.getAll();
	}
	
	

}
