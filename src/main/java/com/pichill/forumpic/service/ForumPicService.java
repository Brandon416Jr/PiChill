package com.pichill.forumpic.service;

import java.util.List;

import com.pichill.forumpic.entity.ForumPic;

public interface ForumPicService {
	ForumPic add(ForumPic forumPic);

	ForumPic update(ForumPic forumPic);

	void delete(int forumPicID);

	ForumPic getByForumPicID(Integer forumPicID);

	List<ForumPic> getAll();
}
