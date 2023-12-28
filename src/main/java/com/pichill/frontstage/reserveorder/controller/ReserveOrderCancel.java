package com.pichill.frontstage.reserveorder.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.frontstage.reserveorder.service.ReserveOrderServiceFront;
import com.pichill.reserveorder.entity.ReserveOrder;

@WebServlet("/reserveorder/cancel.do")
public class ReserveOrderCancel extends HttpServlet {
	private ReserveOrderServiceFront rsvdSvc;
	
	@Override
	public void init() throws ServletException {
		rsvdSvc = new ReserveOrderServiceFront();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ReserveOrder reserveOrder = new ReserveOrder();
		Integer reserveOrderID = reserveOrder.getReserveOrderID();
		Integer orderStatus = reserveOrder.getOrderStatus();
		orderStatus = 0;
		reserveOrder.setOrderStatus(orderStatus);
		reserveOrder = rsvdSvc.updateReserveOrderByOrderStatus(reserveOrderID, orderStatus);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	

}
