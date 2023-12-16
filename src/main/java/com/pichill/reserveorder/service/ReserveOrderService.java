package com.pichill.reserveorder.service;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.model.GeneralUserDAOImpl;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.model.ReserveOrderDAO;
import com.pichill.reserveorder.model.ReserveOrderDAOImpl;

public class ReserveOrderService {
	private final ReserveOrderDAO dao;
	
	public ReserveOrderService() {
		dao = new ReserveOrderDAOImpl();
	}

	public void addReserveOrder(ReserveOrder reserveOrder) {
		dao.add(reserveOrder);	
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
