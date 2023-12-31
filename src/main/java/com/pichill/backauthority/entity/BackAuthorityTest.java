package com.pichill.backauthority.entity;

import java.util.List;

import com.pichill.backauthority.model.BackAuthorityDAO;
import com.pichill.backauthority.model.BackAuthorityHibernateDAOImpl;



public class BackAuthorityTest {
	public static void main(String[] args) {
		BackAuthorityDAO dao = new BackAuthorityHibernateDAOImpl();

		// 新增
//		BackAuthority backAuthority1 = new BackAuthority();
//		backAuthority1.setManageID(13000011);
//		backAuthority1.setBackFunctionID(3);
//		dao.add(backAuthority1);

		// 修改
//		BackAuthority backAuthority2 = new BackAuthority();
//		backAuthority2.setManageID(13000019);
//		backAuthority2.setBackFunctionID(7);
//		backAuthority2.setBackAuthorityID(41000011);
//		dao.update(backAuthority2);
		

		
		// 查詢多筆
		List<BackAuthority> list = dao.getAll();
		for (BackAuthority backAuthority : list) {
			System.out.print(backAuthority.getManageID() + ",");
			System.out.print(backAuthority.getBackFunctionID() + ",");
			System.out.println();
		}
	}
}
