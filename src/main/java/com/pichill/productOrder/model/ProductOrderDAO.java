package com.pichill.productOrder.model;

import java.util.List;

import com.pichill.product.entity.Product;
import com.pichill.productOrder.entity.ProductOrder;

public interface ProductOrderDAO {
	public abstract int insert(ProductOrder productOrder);

	int update(ProductOrder productOrder);
	int delete(Integer productOrderID); 

	ProductOrder getProductOrderByProductOrderID(Integer productOrderID);

	List<ProductOrder> getAll();

}
