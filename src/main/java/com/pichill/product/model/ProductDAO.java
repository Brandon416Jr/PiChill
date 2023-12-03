package com.pichill.product.model;

import java.util.List;

import com.pichill.product.entity.Product;

public interface ProductDAO {
	public abstract int insert(Product product);

	int update(Product product);
	int delete(Integer productID); 

	Product getProductByProductID(Integer productID);

	List<Product> getAll();

}
