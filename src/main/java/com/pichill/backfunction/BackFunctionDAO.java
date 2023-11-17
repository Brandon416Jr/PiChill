package com.pichill.backfunction;

import java.util.List;

public interface BackFunctionDAO {
	BackFunction getBackFunctionBybackFunctionID(Integer backFunctionID); 
	List<BackFunction> getAll();

}
