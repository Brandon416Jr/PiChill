package com.pichill.forumlike.service;

import com.pichill.forumlike.entity.ForumLike;
import com.pichill.forumlike.model.ForumLikeDAO;
import com.pichill.forumlike.model.ForumLikeDAOImpl;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.service.GeneralUserService;
import com.pichill.post.entity.Post;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;

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
		ForumLike like = dao.getLikeByPostIDAndUserID(postID, gUserID);
		if (like == null) {
			GeneralUserService generalUserService = new GeneralUserService();
			GeneralUser generalUser = generalUserService.getOneGeneralUser(gUserID);
			
			PostService postService = new PostServiceImpl();
			Post post = postService.getByPostID(postID);
			ForumLike likepost = new ForumLike();
			likepost.setPost(post);
			likepost.setGeneralUser(generalUser);
			likepost.setLikeStatus(true);
			dao.add(likepost);
			return 1;
		} else if (like.isLikeStatus()) {
			like.setLikeStatus(false);
			dao.update(like);
			return 0;
		} else {
			like.setLikeStatus(true);
			dao.update(like);
			return 1;
		}
	}

	@Override
	public long getLikeCnt(Integer postID) {
		return dao.getLikeCnt(postID);
	}

	@Override // 判斷狀態來顯示顏色
	public boolean getLikeByPostIDAndUserID2(Integer postID, Integer gUserID) {
		ForumLike like = dao.getLikeByPostIDAndUserID(postID, gUserID);
		if (like != null) {
			return like.isLikeStatus();
		}
		return false;
	}

//	@Override
//	public List<Like> getAll() {
//		return dao.getAll();
//	}
}
