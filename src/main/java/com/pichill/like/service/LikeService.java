package com.pichill.like.service;

import java.util.List;

import com.pichill.like.entity.Like;

public interface LikeService {
	Like addLike(Like like);
	Like updateLike(Like like);
//	void delete(Integer likeID);
	Like getByLikeID(Integer likeID);
	Like getLikeByPostIDAndUserID(Integer postID,Integer gUserID);
//	List<Like> getAll();
}
