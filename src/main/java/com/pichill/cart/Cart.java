package com.pichill.cart;

import java.io.Serializable;

public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer cartID;
	private Integer productID;
	private Integer gUserID;
	
	public Cart() {
		super();
	}

	public Cart(Integer cartID, Integer productID, Integer gUserID) {
		super();
		this.cartID = cartID;
		this.productID = productID;
		this.gUserID = gUserID;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getgUserID() {
		return gUserID;
	}

	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}
	
	
}
