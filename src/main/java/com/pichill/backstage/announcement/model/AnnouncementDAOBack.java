package com.pichill.backstage.announcement.model;

import java.util.List;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;



public interface AnnouncementDAOBack {
	int insert(AnnouncementGetOne announcement); // public abstract可不加，預設就會有
	int update(AnnouncementGetOne announcement);
	AnnouncementGetOne getAnnouncementByAnnounceID(Integer announceID); 
	List<AnnouncementGetOne> getAll();
}
