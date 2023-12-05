package com.pichill.backstage.announcement.model;

import java.util.List;

import com.pichill.backstage.announcement.entity.Announcement;



public interface AnnouncementDAOBack {
	int insert(Announcement announcement); // public abstract可不加，預設就會有
	int update(Announcement announcement);
	Announcement getAnnouncementByAnnounceID(Integer announceID); 
	List<Announcement> getAll();
}
