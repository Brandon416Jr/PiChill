package com.pichill.post.service;

import java.util.List;
import java.util.Map;

import com.pichill.post.entity.Post;
public interface PostService {
//dao的save方法還回主鍵值 再透過主鍵值用get方法找到資料庫的物件
	Post addPost(Post post);
	
	Post updatePost(Post post);
	
	void deletePost(Integer postID);
	
	Post getByPostID(Integer postID);
	
	List<Post> getPostByPostTitle(String postTitle);
	
	List<Post> getPostByPostType(Integer postType);
	
	List<Post> getBygUserID(Integer gUserID);
	
	List<Post> getByoUserID(Integer oUserID);
	
	List<Post> getByCommentCnt();
		
	List<Post>getAllPosts(int currentPage);
	
	List<Post> getTypeTwo();
	
	int getPageTotal();
	
	int updateLike(Integer postID, Integer likeCnt);
	
	 int updateComment(Integer postID, Integer commentCnt);
//	List<Post>getPostsByCompositeQuery(Map<String,String[]>map);
	
}
