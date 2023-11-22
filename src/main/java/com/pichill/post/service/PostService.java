package com.pichill.post.service;

import java.util.List;
import java.util.Map;

import com.pichill.post.entity.Post;

public interface PostService {
	Post addPost(Post post);
	
	Post updatePost(Post post);
	
	void deletePost(Integer post);
	
	Post getPostByPostID(Integer post);;
	
//	List<Post>getAllPosts(int currentPage);
	
//	int getPageTotal();
//	
//	List<Post>getPostsByCompositeQuery(Map<String,String[]>map);
	
}
