package com.pichill.like;

import java.util.List;

public class LikeTest {

	public static void main(String[] args) {
		LikeDAO dao = new LikeDAOImpl();

		// 新增
//		Like like1 = new Like();
//		like1.setgUserID(11000001);
//		like1.setPostID(31000001);
//		dao.add(like1);

//		//修改
//		Like like2 = new Like();
//		like2.setLikeID(33000001);
//		like2.setgUserID(11000001);
//		like2.setPostID(31000002);
//		dao.update(like2);
//		
//		// 刪除
//		dao.delete(33000001);
//		
//		//查詢單筆
//		Like like3 = dao.findByPK(33000002);
//		System.out.print(like3.getLikeID()+ ",");
//		System.out.print(like3.getgUserID()+ ",");
//		System.out.print(like3.getPostID()+ ",");
//		
//		//查詢多筆
		List<Like>list = dao.getAll();
		for(Like like:list) {
			System.out.print(like.getLikeID()+ ",");
			System.out.print(like.getgUserID()+ ",");
			System.out.print(like.getPostID());
		System.out.println();
		}
	}
}
