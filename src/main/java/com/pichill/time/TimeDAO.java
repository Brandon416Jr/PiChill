package com.pichill.time;

import java.util.List;

public interface TimeDAO {
	TimeRef findByPK(Integer timeID); 
	List<TimeRef> getAll();
}
