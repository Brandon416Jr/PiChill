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

	private static final long PAGE_MAX_RESULT = 4;
	private PostDAO dao;

	public PostServiceImpl() {
		dao = new PostDAOImpl();
	}

//	public Post addPost(Post post) {
//		Integer id = dao.insert(post);
//		post = dao.getByPostID(id);
//		return post;
////		return dao.insert(post);//返回給controller
//	}
	@Override
	public Post addPost(Post post) {
		Integer id = dao.insert(post);
//	    System.out.println("=================");
//	    System.out.println(id);
		post = dao.getByPostID(id);

//	    if (post != null) {
//	        System.out.println("Post Time: " + post.getPostTime());
//	    } else {
//	        System.out.println("Failed to retrieve post.");
//	    }
//
		return post;
	}

	@Override
	public Post updatePost(Post post) {
		try {
			int result = dao.update(post);
			if (result == 1) {
				return post;
			} else {
				System.out.println("Failed to update post with ID: " + post.getPostID());
				return null;
			}
		} catch (Exception e) {
			System.out.printf("Error updating post", e);
			return null;
		}
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
	public List<Post> getBygUserID(Integer gUserID) {
		return dao.getBygUserID(gUserID);
	}

	@Override
	public List<Post> getByoUserID(Integer oUserID) {
		return dao.getByoUserID(oUserID);
	}

	@Override
	public List<Post> getByCommentCnt() {
		return dao.getByCommentCnt();
	}

//	@Override
//	public List<Post> getAllPosts() {
//		return dao.getAll();
//	}

	@Override
	public List<Post> getAllPosts(int currentPage) {
		return dao.getAll(currentPage);
	}

	@Override
	public List<Post> getTypeTwo() {
		return dao.getTypeTwo();
	}
	
	@Override
	public int getPageTotal() {
		long total = dao.getTotal();
		int pageQty = (int) (total % PAGE_MAX_RESULT == 0 ? (total / PAGE_MAX_RESULT) : (total / PAGE_MAX_RESULT + 1));
		return pageQty;
	}

	@Override
	public int updateLike(Integer postID, Integer likeCnt) {
		int result = dao.updateLike(postID, likeCnt);

		if (result == 1) {
			// 更新成功
			return result;
		} else {
			// 更新失败
			return 0;
		}
	}

	@Override
	public int updateComment(Integer postID, Integer commentCnt) {
		int result = dao.updateComment(postID, commentCnt);

		if (result == 1) {
			// 更新成功
			return result;
		} else {
			// 更新失败
			return 0;
		}
	}

	
}

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
