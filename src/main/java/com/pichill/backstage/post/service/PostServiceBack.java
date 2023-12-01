package com.pichill.backstage.post.service;

import java.util.List;

import com.pichill.post.model.PostDAO;
import com.pichill.backstage.post.model.PostDAOImplBack;
import com.pichill.post.entity.Post;

public class PostServiceBack {
	private final PostDAO dao;

	public PostServiceBack() {
		dao = new PostDAOImplBack();
	}

	public void deletePostBack(Integer postID) {
		dao.delete(postID);
	}

	public List<Post> getAll() {
		return dao.getAll();
	}

}
