package com.pichill.cart.entity;

import java.util.List;

import com.pichill.cart.model.CartDAO;
import com.pichill.cart.model.CartDAOImpl;

import com.pichill.cart.entity.Cart;


public class TestCart {
	public static void main(String[] args) throws Exception {
		CartDAO dao = new CartDAOImpl();

		// 新增
//		Cart cart = new Cart();
//		cart.setProductID(51000010);
//		cart.setgUserID(11000010);
//		dao.add(cart);

		// 修改
//		Cart cart1 = new Cart();
//		cart1.setCartID(56000001);
//		cart1.setProductID(51000010);
//		cart1.setgUserID(11000010);
//		dao.update(cart1);
//
//		// 刪除
//		dao.delete(56000011);
//
//		// 查詢單筆
//		Cart cart2 = dao.findByPK(56000002);
//		System.out.print(cart2.getCartID() + ",");
//		System.out.print(cart2.getProductID() + ",");		
//		System.out.println(cart2.getgUserID());
//		System.out.println();

		// 查詢多筆
		List<Cart> list = dao.getAll();
		for (Cart cart3 : list) {
			System.out.print(cart3.getCartID() + ",");
			System.out.print(cart3.getProductID() + ",");
			System.out.print(cart3.getgUserID());
			
			System.out.println();
		}
	}
}
