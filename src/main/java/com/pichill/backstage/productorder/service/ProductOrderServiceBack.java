package com.pichill.backstage.productorder.service;

import java.util.List;

import com.pichill.backstage.productorder.model.ProductOrderDAOImplBack;
import com.pichill.productOrder.entity.ProductOrder;
import com.pichill.productOrder.model.ProductOrderDAO;

public class ProductOrderServiceBack {
	private final ProductOrderDAO dao;
	
	public ProductOrderServiceBack() {
		dao = new ProductOrderDAOImplBack();
	}
	
	public void updateProductOrder(ProductOrder productorder) {
		dao.update(productorder);
	}

	public ProductOrder getOneProductOrder(Integer productorderID) {
		return dao.getProductOrderByProductOrderID(productorderID);
	}

	public List<ProductOrder> getAll() {
		return dao.getAll();
	}

}
