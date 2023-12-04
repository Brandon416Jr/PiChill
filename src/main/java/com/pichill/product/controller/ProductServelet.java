package com.pichill.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.wls.shaded.java_cup.runtime.lr_parser;
import com.pichill.product.service.ProductService;

@WebServlet(name = "ProductHServlet", value = "/product/product.do")
public class ProductServelet extends HttpServlet {
private static final long serialVersionUID = 1L;
	//private static final long sericalVersionUID = 1L;
	private ProductService productService;

	public ProductServelet() {
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
