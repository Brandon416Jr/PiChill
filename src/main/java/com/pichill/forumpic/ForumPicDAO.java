package com.pichill.forumpic;

import java.util.List;

public interface ForumPicDAO {
	void add(ForumPic forumPic);
	void update(ForumPic forumPic);
	void delete(int forumPicID);
	ForumPic findByPK(Integer forumPicID);
	List<ForumPic> getAll();
}
