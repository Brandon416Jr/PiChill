package com.pichill.productOrder.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.productOrder.service.ProductOrderService;

@WebServlet(name = "ProductOrderHServlet", value = "/productOrder/productOrder.do")
public class ProductOrderServelet extends HttpServlet {
private static final long serialVersionUID = 1L;
	//private static final long sericalVersionUID = 1L;
	private ProductOrderService productOrderService;

	public ProductOrderServelet() {
		// TODO Auto-generated constructor stub
	super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.getWriter().append("Served at: ").append(request.getContextPath());	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
