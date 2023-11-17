package com.pichill.time;

import java.util.List;

public interface TimeDAO {
	Time getTimeByTimeID(Integer timeID); 
	List<Time> getAll();
}
