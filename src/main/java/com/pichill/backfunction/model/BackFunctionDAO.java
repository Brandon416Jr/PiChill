package com.pichill.backfunction.model;

import java.util.List;

import com.pichill.backfunction.entity.BackFunction;

public interface BackFunctionDAO {
	BackFunction getBackFunctionBybackFunctionID(Integer backFunctionID); 
	List<BackFunction> getAll();

}
