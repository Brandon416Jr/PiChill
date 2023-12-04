package com.pichill.productOrder.service;

import java.util.List;

import com.pichill.productOrder.entity.ProductOrder;
import com.pichill.productOrder.entity.ProductOrder;
import com.pichill.productOrder.model.ProductOrderDAO;
import com.pichill.productOrder.model.ProductOrderDAOImpl;

public class ProductOrderService {
	private final ProductOrderDAO dao;

	public ProductOrderService() {
		dao = new ProductOrderDAOImpl();
	}

	public void insertProductOrder(ProductOrder productOrder){
		dao.insert(productOrder);	
	}

	public void updateProductOrder(ProductOrder productOrder){
		dao.update(productOrder);
	}

//	public void deleteProductOrder(Integer productID) {
//		dao.delete(productID);
//	}

	public ProductOrder getOneProductOrder(Integer productOrderID) {
		return dao.getProductOrderByProductOrderID(productOrderID);
	}

	public List<ProductOrder> getAll() {
		return dao.getAll();
	}
}
