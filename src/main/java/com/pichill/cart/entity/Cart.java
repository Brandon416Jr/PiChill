package com.pichill.cart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cart")
public class Cart{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartID", updatable = false)
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

	@Override
	public String toString() {
		return "Cart [cartID=" + cartID + ", productID=" + productID + ", gUserID=" + gUserID + "]";
	}
	
	
}
