package com.pichill.announcementgetone.model;

import java.util.List;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;



public interface AnnouncementGetOneDAO {
//	int insert(Announcement announcement); // public abstract可不加，預設就會有
//	int update(Announcement announcement);
	AnnouncementGetOne getAnnouncementByAnnounceID(Integer announceID); 
//	AnnouncementGetOne getAnnouncementByAnnoTitle(String annoTitle); 
	List<AnnouncementGetOne> getAll();
}
