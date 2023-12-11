package com.pichill.announcementgetone.model;

import java.util.List;

import com.pichill.backstage.announcement.entity.Announcement;



public interface AnnouncementGetOneDAO {
	int insert(Announcement announcement); // public abstract可不加，預設就會有
	int update(Announcement announcement);
	Announcement getAnnouncementByAnnounceID(Integer announceID); 
	Announcement getAnnouncementByAnnoTitle(String annoTitle); 
	List<Announcement> getAll();
}
