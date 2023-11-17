package com.pichill.comment;

import java.util.List;

public class CommentTest {

	public static void main(String[] args) {
		CommentDAO dao = new CommentDAOImpl();
		
		//新增
//		Comment comment1 = new Comment();
//		comment1.setgUserID(11000003);
//		comment1.setPostID(31000010);
//		comment1.setCommentContent("HI");
//		comment1.setCommentTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
//		dao.add(comment1);
//		
		//修改
//		Comment comment2 = new Comment();
//		comment2.setCommentID(32000001);
//		comment2.setgUserID(11000003);
//		comment2.setPostID(31000010);
//		comment2.setCommentContent("HELLO");
//		comment2.setCommentTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
//		dao.update(comment2);
//		
//		//刪除
//		dao.delete(32000011);
//		
		//查詢單筆
		Comment comment3 = dao.findByPK(32000001);
		System.out.print(comment3.getCommentID()+ ",");
		System.out.print(comment3.getgUserID()+ ",");
		System.out.print(comment3.getPostID()+ ",");
		System.out.print(comment3.getCommentContent()+ ",");
		System.out.print(comment3.getCommentTime());
		
		//查詢多筆
		List<Comment>list = dao.getAll();
		for(Comment comment:list) {
			System.out.print(comment.getCommentID()+ ",");
			System.out.print(comment.getgUserID()+ ",");
			System.out.print(comment.getPostID()+ ",");
			System.out.print(comment.getCommentContent()+ ",");
			System.out.print(comment.getCommentTime());
			System.out.println();
		}
	}
}
