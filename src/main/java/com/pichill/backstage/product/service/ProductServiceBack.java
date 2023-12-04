package com.pichill.backstage.product.service;

import java.util.List;

import com.pichill.backstage.product.model.ProductDAOImplBack;
import com.pichill.manage.entity.Manage;
import com.pichill.product.entity.Product;
import com.pichill.product.model.ProductDAO;

public class ProductServiceBack {
	private final ProductDAO dao;
	
	public ProductServiceBack() {
		dao = new ProductDAOImplBack();
	}
	
	public void insertProduct(Product product) {
		dao.insert(product);	
	}
	
	public void updateProduct(Product product) {
		dao.update(product);
	}

	public Product getOneProduct(Integer productID) {
		return dao.getProductByProductID(productID);
	}

	public List<Product> getAll() {
		return dao.getAll();
	}
	
}
