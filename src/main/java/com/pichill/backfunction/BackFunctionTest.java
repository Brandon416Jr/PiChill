package com.pichill.backfunction;

import java.util.List;

public class BackFunctionTest {
	public static void main(String[] args) {
		BackFunctionDAO dao = new BackFunctionDAOImpl();

		// 查詢單筆
//		BackFunction backFunction3 = dao.getBackFunctionBybackFunctionID(4);
//		System.out.print(backFunction3.getBackFunctionID() + ",");
//		System.out.println(backFunction3.getBackFunctionName() + ",");
//		System.out.println("---------------------");

		// 查詢多筆
		List<BackFunction> list = dao.getAll();
		for (BackFunction  backFunction  : list) {
			System.out.print(backFunction.getBackFunctionID() + ",");
			System.out.print(backFunction.getBackFunctionName() + ",");
			System.out.println();
		}
	}
}
