package com.pichill.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.pichill.post.entity.Post;
import com.pichill.post.model.PostDAO;
import com.pichill.post.model.PostDAOImpl;

public class PostServiceImpl implements PostService {

	private static final long PAGE_MAX_RESULT = 3;
	private PostDAO dao;

	public PostServiceImpl() {
		dao = new PostDAOImpl();
	}

	@Override
	public Post addPost(Post post) {
		Integer id = dao.insert(post);
		post = dao.getByPostID(id);
		return post;
//		return dao.insert(post);//返回給controller
	}

//	public Post addPost(String postTitle,String postContent,Integer postType) {
//		Post post = new Post();
//		post.setPostTitle(postTitle);
//		post.setPostContent(postContent);
//		post.setPostType(postType);
//		dao.insert(post);
//	return post;
////		return dao.insert(post);//返回給controller
//	}
	@Override
	public Post updatePost(Post post) {
		if (dao.update(post) == 1) {
			return post;
		} else
			return null;
	}

	@Override
	public void deletePost(Integer postID) {
		dao.delete(postID);
	}
	
	@Override
	public Post getByPostID(Integer postID) {
		return dao.getByPostID(postID);
	}

	@Override
	public List<Post> getPostByPostTitle(String postTitle) {
		return dao.getByTitle(postTitle);
	}

	@Override
	public List<Post> getPostByPostType(Integer postType) {
		return dao.getByType(postType);
	}

	@Override
	public List<Post> getAllPosts() {
		return dao.getAll();
	}


//	@Override
//	public List<Post> getAllPosts(int currentPage) {
//		return dao.getAll(currentPage);
//	}
//
	@Override
	public int getPageTotal() {
		long total =dao.getTotal();
		int pageQty = (int)(total%PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}
//
//	@Override
//	public List<Post> getPostsByCompositeQuery(Map<String, String[]> map) {
//		Map<String, String> query = new HashMap<>();
//		// Map.Entry即代表一組key-value
//		Set<Map.Entry<String, String[]>> entry = map.entrySet();
//		
//		for (Map.Entry<String, String[]> row : entry) {
//			String key = row.getKey();
//			// 因為請求參數裡包含了action，做個去除動作
//			if ("action".equals(key)) {
//				continue;
//			}
//			// 若是value為空即代表沒有查詢條件，做個去除動作
//			String value = row.getValue()[0]; // getValue拿到一個String陣列, 接著[0]取得第一個元素檢查
//			if (value == null || value.isEmpty()) {
//				continue;
//			}
//			query.put(key, value);
//		}
//		
//		System.out.println(query);
//		
//		return dao.getByCompositeQuery(query);
//	}
}
