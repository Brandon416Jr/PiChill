package com.pichill.backstage.reserveorder.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.generaluser.service.GeneralUserServiceBack;
import com.pichill.backstage.reserveorder.service.ReserveOrderServiceBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ReserveOrderBServlet", value = "/reserveorder/reserveorderb.do")
public class ReserveOrderServletBack extends HttpServlet {
	private ReserveOrderServiceBack reserveOrderSvcB;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		reserveOrderSvcB = new ReserveOrderServiceBack();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
//		case "getOne_For_Display":
//			// // 來自index.jsp的請求
//			forwardPath = getOneDisplay(req, res);
//			break;
		case "getOne_For_Update":
			// 來自all_manage.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自set_manage.jsp的請求
			forwardPath = update(req, res);
			break;
		default:
			forwardPath = "/backstage/reserveOrderBack/all_reserveOrder.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID"));

		ReserveOrder reserveOrder = reserveOrderSvcB.getOneReserveOrder(reserveOrderID);

		req.setAttribute("generalUreserveOrderser", reserveOrder);
		return "/backstage/reserveOrderBack/set_reserveOrder.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID"));

		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
		
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));

		Date reserveDate = null;
		try {
			reserveDate = java.sql.Date.valueOf(req.getParameter("reserveDate").trim());
		} catch (IllegalArgumentException e) {
			errorMsgs.add("請輸入日期!");
		}
		
		Integer timeID = Integer.valueOf(req.getParameter("timeID"));

		Integer placeID = Integer.valueOf(req.getParameter("placeID"));

		Timestamp orderTime = java.sql.Timestamp.valueOf(req.getParameter("orderTime").trim());
		if (req.getParameter("orderTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			orderTime = java.sql.Timestamp.valueOf(req.getParameter("orderTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}

		Integer orderNum = Integer.valueOf(req.getParameter("orderNum"));

		Integer orderStatus = Integer.valueOf(req.getParameter("orderStatus"));
		
		Integer totalCost = Integer.valueOf(req.getParameter("totalCost"));

		ReserveOrder reserveOrder = new ReserveOrder();
		reserveOrder.setReserveOrderID(reserveOrderID);
		reserveOrder.setgUserID(gUserID);
		reserveOrder.setoUserID(oUserID);
		reserveOrder.setReserveDate(reserveDate);
		reserveOrder.setTimeID(timeID);
		reserveOrder.setPlaceID(placeID);
		reserveOrder.setOrderTime(orderTime);
		reserveOrder.setOrderNum(orderNum);
		reserveOrder.setOrderStatus(orderStatus);
		reserveOrder.setTotalCost(totalCost);



		
		
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("reserveOrder", reserveOrder); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/reserveOrderBack/set_reserveOrder.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		reserveOrderSvcB.updateReserveOrder(reserveOrder);
		req.setAttribute("reserveOrder", reserveOrderSvcB.getOneReserveOrder(reserveOrderID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("reserveOrder", reserveOrder); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/reserveOrderBack/all_reserveOrder.jsp";
	}
}
