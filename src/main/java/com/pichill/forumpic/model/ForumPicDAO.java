package com.pichill.forumpic.model;

import java.util.List;

import com.pichill.forumpic.entity.ForumPic;

public interface ForumPicDAO {
	int add(ForumPic forumPic);
	
	int update(ForumPic forumPic);
	
	int delete(int forumPicID);
	
	ForumPic getByForumPicID(Integer forumPicID);
	
	List<ForumPic> getAll();
}
