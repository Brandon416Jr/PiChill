package com.pichill.backstage.reserveorder.service;

import java.util.List;

import com.pichill.backstage.reserveorder.model.ReserveOrderDAOBack;
import com.pichill.backstage.reserveorder.model.ReserveOrderDAOImplBack;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.model.ReserveOrderDAO;

public class ReserveOrderServiceBack {
	private final ReserveOrderDAOBack dao;
	
	public ReserveOrderServiceBack() {
		dao = new ReserveOrderDAOImplBack();
	}
	
	public void updateReserveOrder(ReserveOrder reserveOrder) {
		dao.update(reserveOrder);
	}

	public ReserveOrder getOneReserveOrder(Integer reserveOrderID) {
		return dao.findByPK(reserveOrderID);
	}

	public List<ReserveOrder> getAll() {
		return dao.getAll();
	}
}
