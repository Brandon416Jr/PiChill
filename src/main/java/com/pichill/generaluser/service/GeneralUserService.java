package com.pichill.generaluser.service;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.model.GeneralUserDAO;
import com.pichill.generaluser.model.GeneralUserDAOImpl;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;

public class GeneralUserService {
	private final GeneralUserDAO dao;

	public GeneralUserService() {
		dao = new GeneralUserDAOImpl();
	}

	public void addGeneralUser(GeneralUser generalUser) {
		dao.add(generalUser);	
	}

	public void updateGeneralUser(GeneralUser generalUser) {
		dao.update(generalUser);
	}
	
	public GeneralUser getOneGeneralUser(Integer gUserID) {
		return dao.findByPK(gUserID);
	}
	public List<GeneralUser> getOrderBygUserID(Integer gUserID) {
		return dao.findBygUserID(gUserID);
	}
	
	//用一般會員ID查預約訂單
//	public GeneralUser getOrderBygUserID(Integer reserveOrderID) {
//		GeneralUser generalUser = dao.findBygUserID(reserveOrderID);
//		ReserveOrderService reserveOrderService = new ReserveOrderService();
//		ReserveOrder reserveOrder = reserveOrderService.getOneReserveOrder(reserveOrderID);
//		return generalUser;
//	}


	public List<GeneralUser> getAll() {
		return dao.getAll();
	}
}
