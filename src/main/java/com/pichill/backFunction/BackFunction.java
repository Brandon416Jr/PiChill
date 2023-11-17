package com.pichill.backFunction;

import java.io.Serializable;

public class BackFunction implements Serializable {
//	private static final long serialVersionUID = 1L; // 可加可不加
	private Integer backFunctionID;
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
