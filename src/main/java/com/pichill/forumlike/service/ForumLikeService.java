package com.pichill.forumlike.service;

import java.util.List;

import com.pichill.forumlike.entity.ForumLike;

public interface ForumLikeService {
	ForumLike addLike(ForumLike like);
	ForumLike updateLike(ForumLike like);
//	void delete(Integer likeID);
	ForumLike getByLikeID(Integer likeID);
	Integer getLikeByPostIDAndUserID(Integer postID,Integer gUserID);
//	List<Like> getAll();
}

