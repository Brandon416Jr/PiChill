package com.pichill.productOrder.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productOrder")
public class ProductOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productOrderID", updatable = false)
	private Integer productOrderID;
	@Column(name = "gUserID")
	private Integer gUserID;
	@Column(name = "courtID")
	private Integer courtID;
	@Column(name = "productOrderTime")
	private Timestamp productOrderTime;
	@Column(name = "consume")
	private Timestamp consume;
	@Column(name = "productShipTime")
	private Timestamp productShipTime;
	@Column(name = "productArriveTime")
	private Timestamp productArriveTime;
	@Column(name = "productShipStatus")
	private Integer productShipStatus;
	@Column(name = "gUserPiCnt")
	private Integer gUserPiCnt;
	@Column(name = "orderTotalPrice")
	private Integer orderTotalPrice;

	public Integer getProductOrderID() {
		return productOrderID;
	}

	public void setProductOrderID(Integer productOrderID) {
		this.productOrderID = productOrderID;
	}

	public Integer getgUserID() {
		return gUserID;
	}

	public void setgUserID(Integer gUserID) {
		this.gUserID = gUserID;
	}

	public Integer getCourtID() {
		return courtID;
	}

	public void setCourtID(Integer courtID) {
		this.courtID = courtID;
	}

	public Timestamp getProductOrderTime() {
		return productOrderTime;
	}

	public void setProductOrderTime(Timestamp productOrderTime) {
		this.productOrderTime = productOrderTime;
	}

	public Timestamp getConsume() {
		return consume;
	}

	public void setConsume(Timestamp consume) {
		this.consume = consume;
	}

	public Timestamp getProductShipTime() {
		return productShipTime;
	}

	public void setProductShipTime(Timestamp productShipTime) {
		this.productShipTime = productShipTime;
	}

	public Timestamp getProductArriveTime() {
		return productArriveTime;
	}

	public void setProductArriveTime(Timestamp productArriveTime) {
		this.productArriveTime = productArriveTime;
	}

	public Integer getProductShipStatus() {
		return productShipStatus;
	}

	public void setProductShipStatus(Integer productShipStatus) {
		this.productShipStatus = productShipStatus;
	}

	public Integer getgUserPiCnt() {
		return gUserPiCnt;
	}

	public void setgUserPiCnt(Integer gUserPiCnt) {
		this.gUserPiCnt = gUserPiCnt;
	}

	public Integer getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Integer orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	@Override
	public String toString() {
		return "ProductOrder [productOrderID=" + productOrderID + ", gUserID=" + gUserID + ", courtID=" + courtID
				+ ", productOrderTime=" + productOrderTime + ", consume=" + consume + ", productShipTime="
				+ productShipTime + ", productArriveTime=" + productArriveTime + ", productShipStatus="
				+ productShipStatus + ", gUserPiCnt=" + gUserPiCnt + ", orderTotalPrice=" + orderTotalPrice + "]";
	}

	public ProductOrder() {
		// TODO Auto-generated constructor stub
	}
}