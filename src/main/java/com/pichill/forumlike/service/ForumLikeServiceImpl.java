package com.pichill.forumlike.service;

import java.util.List;

import com.pichill.forumlike.entity.ForumLike;
import com.pichill.forumlike.model.ForumLikeDAO;
import com.pichill.forumlike.model.ForumLikeDAOImpl;

public class ForumLikeServiceImpl implements ForumLikeService {

	private ForumLikeDAO dao;

	public ForumLikeServiceImpl() {
		dao = new ForumLikeDAOImpl();
	}

	@Override
	public ForumLike addLike(ForumLike like) {
		Integer id = dao.add(like);
		like = dao.getByLikeID(id);
		return like;
	}

	@Override
	public ForumLike updateLike(ForumLike like) {
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
	public ForumLike getByLikeID(Integer likeID) {
		return dao.getByLikeID(likeID);

	}

	@Override
	public Integer getLikeByPostIDAndUserID(Integer postID, Integer gUserID) {
//		System.out.println("進來了~~~~~~~~~~");
//		System.out.println(postID);
//		System.out.println("+++++++++"+gUserID);
		ForumLike like = dao.getLikeByPostIDAndUserID(postID, gUserID);
//		System.out.println(like);
		if(like == null) {
//			System.out.println("========"+like);
			ForumLike likepost = new ForumLike();
			likepost.setPostID(postID);
			likepost.setgUserID(gUserID);
			likepost.setLikeStatus(true);
			System.out.println(postID);
			dao.add(likepost);
			return 1;
		}else if(like.isLikeStatus()) {
			like.setLikeStatus(false);
			dao.update(like);
			return 0;
		}else {
			like.setLikeStatus(true);
			dao.update(like);
			return 1;
		}
	}

//	@Override
//	public List<Like> getAll() {
//		return dao.getAll();
//	}
}
