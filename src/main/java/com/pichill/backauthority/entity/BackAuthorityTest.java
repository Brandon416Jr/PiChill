package com.pichill.backauthority.entity;

import java.util.List;

import com.pichill.backauthority.model.BackAuthorityDAO;
import com.pichill.backauthority.model.BackAuthorityDAOImpl;



public class BackAuthorityTest {
	public static void main(String[] args) {
		BackAuthorityDAO dao = new BackAuthorityDAOImpl();

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
		
		// 刪除
//		dao.delete(41000011);

		// 查詢單筆
//		BackAuthority backAuthority3 = dao.getBackAuthorityByBackAuthorityID(41000008);
//		System.out.print(backAuthority3.getManageID() + ",");
//		System.out.println(backAuthority3.getBackFunctionID() + ",");
//		System.out.println("---------------------");
		
		// 查詢多筆
		List<BackAuthority> list = dao.getAll();
		for (BackAuthority backAuthority : list) {
			System.out.print(backAuthority.getManageID() + ",");
			System.out.print(backAuthority.getBackFunctionID() + ",");
			System.out.println();
		}
	}
}
