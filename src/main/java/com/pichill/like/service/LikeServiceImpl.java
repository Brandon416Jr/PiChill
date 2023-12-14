package com.pichill.like.service;

import java.util.List;

import com.pichill.like.entity.Like;
import com.pichill.like.model.LikeDAO;
import com.pichill.like.model.LikeDAOImpl;

public class LikeServiceImpl implements LikeService {

	private LikeDAO dao;

	public LikeServiceImpl() {
		dao = new LikeDAOImpl();
	}

	@Override
	public Like addLike(Like like) {
		Integer id = dao.add(like);
		like = dao.getByLikeID(id);
		return like;
	}

	@Override
	public Like updateLike(Like like) {
		if (dao.update(like) == 1) {
			return like;
		} else
			return null;
	}
//
//	@Override
//	public void delete(Integer likeID) {
//		dao.delete(likeID);
//	}

	@Override
	public Like getByLikeID(Integer likeID) {
		return dao.getByLikeID(likeID);

	}

	@Override
	public Like getLikeByPostIDAndUserID(Integer postID, Integer gUserID) {
		return dao.getLikeByPostIDAndUserID(postID, gUserID);
	}

//	@Override
//	public List<Like> getAll() {
//		return dao.getAll();
//	}
}
