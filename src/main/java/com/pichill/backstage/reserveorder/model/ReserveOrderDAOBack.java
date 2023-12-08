package com.pichill.backstage.reserveorder.model;

import java.util.List;

import com.pichill.reserveorder.entity.ReserveOrder;

public interface ReserveOrderDAOBack {
	int add(ReserveOrder reserveOrder);
	int delete(Integer reserveOrderID);
	int update(ReserveOrder reserveOrderID);
	ReserveOrder findByPK(Integer reserveOrderID);
	List<ReserveOrder> getAll();
}
