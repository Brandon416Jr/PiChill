package com.pichill.post;

import java.util.List;

public class PostTest {

	public static void main(String[] args) {
		PostDAO dao = new PostDAOImpl();
		
		//新增
		Post post1 = new Post();
		post1.setgUserID(11000001);		
		post1.setoUserID(12000001);		
		post1.setPostTitle("我是標題");		
		post1.setPostContent("我是內容");		
		post1.setPostType(0);		
		post1.setPostTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));		
		post1.setLikeCnt(9999);	
		dao.add(post1);
//		
		//修改
		Post post2 = new Post();
		post2.setPostID(31000001);	
		post2.setgUserID(22);		
		post2.setoUserID(12000001);		
		post2.setPostTitle("我是標題");		
		post2.setPostContent("我是內容");		
		post2.setPostType(0);		
		post2.setPostTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));		
		post2.setLikeCnt(9999);	
		dao.update(post2);
		
		//刪除
//		dao.delete(31000011);
		
		//查詢單筆
//		Post post3 = dao.findByPK(31000001);
//		System.out.print(post3.getPostID() + ",");
//		System.out.print(post3.getgUserID() + ",");
//		System.out.print(post3.getoUserID() + ",");
//		System.out.print(post3.getPostTitle() + ",");
//		System.out.print(post3.getPostContent() + ",");
//		System.out.print(post3.getPostType() + ",");
//		System.out.print(post3.getPostTime() + ",");
//		System.out.print(post3.getLikeCnt());
		
		//查詢多筆
//		List<Post>list = dao.getAll();
//		for(Post post:list) {
//			System.out.print(post.getPostID() + ",");
//			System.out.print(post.getgUserID() + ",");
//			System.out.print(post.getoUserID() + ",");
//			System.out.print(post.getPostTitle() + ",");
//			System.out.print(post.getPostContent() + ",");
//			System.out.print(post.getPostType() + ",");
//			System.out.print(post.getPostTime() + ",");
//			System.out.print(post.getLikeCnt());
//			System.out.println();
//		}
	}
}
