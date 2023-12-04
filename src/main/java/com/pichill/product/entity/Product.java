package com.pichill.product.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productID", updatable = false)
	private Integer productID;
	@Column(name = "oUserID")
	private Integer oUserID;
	@Column(name = "manageID")
	private Integer manageID;
	@Column(name = "courtID")
	private Integer courtID;
	@Column(name = "productTypeID")
	private Integer productTypeID;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productStatus")
	private Integer productStatus;
	@Column(name = "productApplyStatus")
	private Integer productApplyStatus;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "productPic", columnDefinition = "longblob")
	private byte[] productPic;
	@Column(name = "productOnCnt")
	private Integer productOnCnt;
	@Column(name = "productApplyTime")
	private Timestamp productApplyTime;
	@Column(name = "productOnTime")
	private Timestamp productOnTime;
	@Column(name = "productPrice")
	private Integer productPrice;
	@Column(name = "productDescription", columnDefinition = "text")
	private String productDescription;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getoUserID() {
		return oUserID;
	}

	public void setoUserID(Integer oUserID) {
		this.oUserID = oUserID;
	}

	public Integer getManageID() {
		return manageID;
	}

	public void setManageID(Integer manageID) {
		this.manageID = manageID;
	}

	public Integer getCourtID() {
		return courtID;
	}

	public void setCourtID(Integer courtID) {
		this.courtID = courtID;
	}

	public Integer getProductTypeID() {
		return productTypeID;
	}

	public void setProductTypeID(Integer productTypeID) {
		this.productTypeID = productTypeID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}

	public Integer getProductApplyStatus() {
		return productApplyStatus;
	}

	public void setProductApplyStatus(Integer productApplyStatus) {
		this.productApplyStatus = productApplyStatus;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public byte[] getProductPic() {
		return productPic;
	}

	public void setProductPic(byte[] productPic) {
		this.productPic = productPic;
	}

	public Integer getProductOnCnt() {
		return productOnCnt;
	}

	public void setProductOnCnt(Integer productOnCnt) {
		this.productOnCnt = productOnCnt;
	}

	public Timestamp getProductApplyTime() {
		return productApplyTime;
	}

	public void setProductApplyTime(Timestamp productApplyTime) {
		this.productApplyTime = productApplyTime;
	}

	public Timestamp getProductOnTime() {
		return productOnTime;
	}

	public void setProductOnTime(Timestamp productOnTime) {
		this.productOnTime = productOnTime;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Product(Integer productID, Integer oUserID, Integer manageID, Integer courtID, Integer productTypeID,
			String productName, Integer productStatus, Integer productApplyStatus, Integer stock, byte[] productPic,
			Integer productOnCnt, Timestamp productApplyTime, Timestamp productOnTime, Integer productPrice,
			String productDescription) {
		super();
		this.productID = productID;
		this.oUserID = oUserID;
		this.manageID = manageID;
		this.courtID = courtID;
		this.productTypeID = productTypeID;
		this.productName = productName;
		this.productStatus = productStatus;
		this.productApplyStatus = productApplyStatus;
		this.stock = stock;
		this.productPic = productPic;
		this.productOnCnt = productOnCnt;
		this.productApplyTime = productApplyTime;
		this.productOnTime = productOnTime;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", oUserID=" + oUserID + ", manageID=" + manageID + ", courtID="
				+ courtID + ", productTypeID=" + productTypeID + ", productName=" + productName + ", productStatus="
				+ productStatus + ", productApplyStatus=" + productApplyStatus + ", stock=" + stock + ", productPic="
				+ Arrays.toString(productPic) + ", productOnCnt=" + productOnCnt + ", productApplyTime="
				+ productApplyTime + ", productOnTime=" + productOnTime + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + "]";
	}
}