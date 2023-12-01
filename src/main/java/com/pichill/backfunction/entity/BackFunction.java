package com.pichill.backfunction.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "backFunction")
public class BackFunction implements Serializable {
//	private static final long serialVersionUID = 1L; // 可加可不加
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "backFunctionID", updatable = false, insertable = false)
	private Integer backFunctionID;
	
	@Column(name = "backFunctionName")
	private String backFunctionName;
	
	public BackFunction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BackFunction(Integer backFunctionID, String backFunctionName) {
		super();
		this.backFunctionID = backFunctionID;
		this.backFunctionName = backFunctionName;
	}

	public Integer getBackFunctionID() {
		return backFunctionID;
	}

	public void setBackFunctionID(Integer backFunctionID) {
		this.backFunctionID = backFunctionID;
	}

	public String getBackFunctionName() {
		return backFunctionName;
	}

	public void setBackFunctionName(String backFunctionName) {
		this.backFunctionName = backFunctionName;
	}

	@Override
	public String toString() {
		return "BackFunction [backFunctionID=" + backFunctionID + ", backFunctionName=" + backFunctionName + "]";
	}
}
