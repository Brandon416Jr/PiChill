package com.pichill.frontstage.reserveorder.service;


import java.util.List;

import com.pichill.frontstage.reserveorder.model.ReserveOrderDAOFront;
import com.pichill.frontstage.reserveorder.model.ReserveOrderDAOImplFront;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.model.ReserveOrderDAO;
import com.pichill.reserveorder.model.ReserveOrderDAOImpl;

public class ReserveOrderServiceFront {
private final ReserveOrderDAO dao;
private final ReserveOrderDAOFront dao2;

	public ReserveOrderServiceFront() {
		dao = new ReserveOrderDAOImpl();
		dao2 = new ReserveOrderDAOImplFront();
	}

	
	

	public ReserveOrder updateReserveOrderByOrderStatus(Integer reserveOrderID, Integer orderStatus) {

		ReserveOrder reserveOrder = dao.findByPK(reserveOrderID); // 先獲取現有的 MemberVO 物件
		if (reserveOrder != null) {

			reserveOrder.setOrderStatus(orderStatus);

			dao.update(reserveOrder);
		}

		return reserveOrder;
	}
	
	public List<ReserveOrder> getoUserID(Integer oUserID) {
		return dao2.findReserveOrderByoUserID(oUserID);
	}
}
