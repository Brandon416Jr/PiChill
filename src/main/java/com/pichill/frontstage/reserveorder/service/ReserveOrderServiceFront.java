package com.pichill.frontstage.reserveorder.service;


import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.model.ReserveOrderDAO;
import com.pichill.reserveorder.model.ReserveOrderDAOImpl;

public class ReserveOrderServiceFront {
private final ReserveOrderDAO dao;
	
	public ReserveOrderServiceFront() {
		dao = new ReserveOrderDAOImpl();
	}

	public ReserveOrder updateReserveOrderByOrderStatus(Integer reserveOrderID, Integer orderStatus) {

		ReserveOrder reserveOrder = dao.findByPK(reserveOrderID); // 先獲取現有的 MemberVO 物件
		if (reserveOrder != null) {

			reserveOrder.setOrderStatus(orderStatus);

			dao.update(reserveOrder);
		}

		return reserveOrder;
	}
}
