package com.pichill.forumpic;

import java.util.List;

import com.pichill.forumpic.model.ForumPicDAO;
import com.pichill.forumpic.model.ForumPicDAOImpl;

public class ForumTest {

	public static void main(String[] args) {
		ForumPicDAO dao = new ForumPicDAOImpl();
		
		//新增
//		ForumPic forumPic1 = new ForumPic();
//		forumPic1.setPostID(31000001);
//		forumPic1.setPostPic(null);
//		forumPic1.setPicTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
//		dao.add(forumPic1);
		
//		//修改
//		ForumPic forumPic2 = new ForumPic();
//		forumPic2.setForumPicID(35000011);
//		forumPic2.setPostID(31000011);
//		forumPic2.setPostPic(null);
//		forumPic2.setPicTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
//		dao.update(forumPic2);
//		
//		//刪除
//		dao.delete(35000011);
//		
//		//查詢單筆
//		ForumPic forumPic3 = dao.findByPK(35000001);
//		System.out.print(forumPic3.getForumPicID()+ ",");
//		System.out.print(forumPic3.getPostID()+ ",");
//		System.out.print(forumPic3.getPostPic()+ ",");
//		System.out.print(forumPic3.getPicTime());
//		
//		//查詢多筆
//		List<ForumPic>list = dao.getAll();
//		for(ForumPic forumPic:list) {
//			System.out.print(forumPic.getForumPicID()+ ",");
//			System.out.print(forumPic.getPostID()+ ",");
//			System.out.print(forumPic.getPostPic()+ ",");
//			System.out.print(forumPic.getPicTime());
//			System.out.println();
//		}		
	}
}
