package com.pichill.forumlike.model;

import java.util.List;

import com.pichill.forumlike.entity.ForumLike;

public interface ForumLikeDAO {
	int add(ForumLike like);
	int update(ForumLike like);
	int delete(int likeID);
	ForumLike getByLikeID(Integer likeID);
	ForumLike getLikeByPostIDAndUserID(Integer postID,Integer gUserID);
	List<ForumLike> getAll();
	long getLikeCnt(Integer postID);
}

