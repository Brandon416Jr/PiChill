package com.pichill.reserveorder.model;

import java.util.List;

import com.pichill.reserveorder.entity.ReserveOrder;

public interface ReserveOrderDAO {
	int add(ReserveOrder reserveOrder);
	int update(ReserveOrder reserveOrder);
	ReserveOrder findByPK(Integer reserveOrderID);
//	ReserveOrder findByFK1(Integer gUserID);
	List<ReserveOrder> getAll();
	
}


