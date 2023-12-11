package com.pichill.post.model;

import java.util.List;
import java.util.Map;

import com.pichill.post.entity.Post;

public interface PostDAO {
	int insert(Post entity);

	int update(Post entity);

	int delete(Integer postID);
	
	Post getByPostID(Integer postID);
	
	List<Post> getByTitle(String postTitle);
	
	List<Post> getByType(Integer postType);
	
	List<Post> getBygUserID(Integer gUserID);
	
	List<Post> getByoUserID(Integer oUserID);
	
	List<Post> getByCommentCnt();

	List<Post> getAll();

//	List<Post> getByCompositeQuery(Map<String, String> map);

	List<Post> getAll(int currentPage);

	long getTotal();
}
