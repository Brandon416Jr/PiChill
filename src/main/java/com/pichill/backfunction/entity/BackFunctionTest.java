package com.pichill.backfunction.entity;

import java.util.List;

import com.pichill.backfunction.model.BackFunctionDAO;
import com.pichill.backfunction.model.BackFunctionHibernateDAOImpl;

public class BackFunctionTest {
	public static void main(String[] args) {
		BackFunctionDAO dao = new BackFunctionHibernateDAOImpl();


		// 查詢多筆
		List<BackFunction> list = dao.getAll();
		for (BackFunction  backFunction  : list) {
			System.out.print(backFunction.getBackFunctionID() + ",");
			System.out.print(backFunction.getBackFunctionName() + ",");
			System.out.println();
		}
	}
}
