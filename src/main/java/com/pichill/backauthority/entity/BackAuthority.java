package com.pichill.backauthority.entity;

import java.io.Serializable;

public class BackAuthority implements Serializable {
//	private static final long serialVersionUID = 1L; // 可加可不加
	private Integer backAuthorityID;
	private Integer manageID;
	private Integer backFunctionID;
	
	public BackAuthority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BackAuthority(Integer backAuthorityID, Integer manageID, Integer backFunctionID) {
		super();
		this.backAuthorityID = backAuthorityID;
		this.manageID = manageID;
		this.backFunctionID = backFunctionID;
	}

	public Integer getBackAuthorityID() {
		return backAuthorityID;
	}

	public void setBackAuthorityID(Integer backAuthorityID) {
		this.backAuthorityID = backAuthorityID;
	}

	public Integer getManageID() {
		return manageID;
	}

	public void setManageID(Integer manageID) {
		this.manageID = manageID;
	}

	public Integer getBackFunctionID() {
		return backFunctionID;
	}

	public void setBackFunctionID(Integer backFunctionID) {
		this.backFunctionID = backFunctionID;
	}

	@Override
	public String toString() {
		return "BackAuthority [backAuthorityID=" + backAuthorityID + ", manageID=" + manageID + ", backFunctionID="
				+ backFunctionID + "]";
	}
	
	
	
	
}
