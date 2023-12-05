package com.pichill.product.service;

import java.util.List;

import com.pichill.product.entity.Product;
import com.pichill.product.model.ProductDAO;
import com.pichill.product.model.ProductDAOImpl;

public class ProductService {
	private final ProductDAO dao;

	public ProductService() {
		dao = new ProductDAOImpl();
	}

	public void insertProduct(Product product) {
		dao.insert(product);	
	}

	public void updateProduct(Product product) {
		dao.update(product);
	}

//	public void deleteProduct(Integer productID) {
//		dao.delete(productID);
//	}

	public Product getOneProduct(Integer productID) {
		return dao.getProductByProductID(productID);
	}

	public List<Product> getAll() {
		return dao.getAll();
	}
}
