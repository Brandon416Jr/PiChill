package com.pichill.reserveorder.model;

import java.util.List;

import com.pichill.reserveorder.entity.ReserveOrder;

public interface ReserveOrderDAO {
	int add(ReserveOrder reserveOrder);
	ReserveOrder findByPK(Integer reserveOrderID);
	List<ReserveOrder> getAll();
}
