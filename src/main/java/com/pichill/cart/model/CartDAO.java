package com.pichill.cart.model;

import java.util.List;

import com.pichill.cart.entity.Cart;

public interface CartDAO {
	int add(Cart cart);
	int update(Cart cart);
	int delete(Integer cartID);
	Cart findByPK(Integer cartID);
	List<Cart> getAll();
	
}
