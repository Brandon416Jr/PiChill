package com.pichill.time;

import java.util.List;

public interface TimeDAO {
	Time findByPK(Integer timeID); 
	List<Time> getAll();
}
