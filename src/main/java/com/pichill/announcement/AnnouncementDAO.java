package com.pichill.announcement;

import java.util.List;

public interface AnnouncementDAO {
	public abstract void add(Announcement announcement); // public abstract可不加，預設就會有
	void update(Announcement announcement);
	void delete(Integer manageID); // 刪除需要篩選條件
	Announcement getAnnouncementByAnnounceID(Integer announceID); 
	List<Announcement> getAll();

}
