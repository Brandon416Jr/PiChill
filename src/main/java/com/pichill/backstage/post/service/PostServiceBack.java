package com.pichill.backstage.post.service;

import java.util.List;

import com.pichill.backstage.post.model.PostDAOBack;
import com.pichill.backstage.post.model.PostDAOImplBack;
import com.pichill.post.entity.Post;

public class PostServiceBack {
	private final PostDAOBack dao;

	public PostServiceBack() {
		dao = new PostDAOImplBack();
	}

	public void deletePostBack(Integer postID) {
		dao.delete(postID);
	}
	
	public Post getOnePost(Integer postID) {
		return dao.getByPostID(postID);
	}

	public List<Post> getAll() {
		return dao.getAll();
	}

}
