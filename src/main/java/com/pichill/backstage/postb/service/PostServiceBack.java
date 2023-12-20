package com.pichill.backstage.postb.service;

import java.util.List;

import com.pichill.backstage.postb.model.PostDAOBack;
import com.pichill.backstage.postb.model.PostDAOImplBack;
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
