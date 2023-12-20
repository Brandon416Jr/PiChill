package com.pichill.backstage.postb.model;

import java.util.List;

import com.pichill.post.entity.Post;

public interface PostDAOBack {
	int update(Post entity);

	int delete(Integer postID);
	
	Post getByPostID(Integer postID);
	
	List<Post> getAll();
}
