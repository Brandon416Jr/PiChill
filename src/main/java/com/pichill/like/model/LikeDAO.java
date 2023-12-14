package com.pichill.like.model;

import java.util.List;

import com.pichill.like.entity.Like;

public interface LikeDAO {
	int add(Like like);
	int update(Like like);
	int delete(int likeID);
	Like getByLikeID(Integer likeID);
	Like getLikeByPostIDAndUserID(Integer postID,Integer gUserID);
	List<Like> getAll();
}
