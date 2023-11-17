package com.pichill.cart;

import java.util.List;

public interface CartDAO {
	void add(Cart cart);
	void update(Cart cart);
	void delete(int cartID);
	Cart findByPK(Integer cartID);
	List<Cart> getAll();
}
