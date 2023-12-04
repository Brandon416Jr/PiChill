package com.pichill.backstage.productorder.controller;

import java.io.IOException;
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

import com.pichill.backstage.announcement.entity.Announcement;
import com.pichill.backstage.productorder.service.ProductOrderServiceBack;
import com.pichill.productOrder.entity.ProductOrder;



@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ProductOrderBServlet", value = "/productorder/productorderb.do")
public class ProductOrderServletBack extends HttpServlet {
	private ProductOrderServiceBack proOdSvcB;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		proOdSvcB = new ProductOrderServiceBack();
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
			forwardPath = "/backstage/productOrderBack/all_productOrder.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res)  {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer productOrderID = Integer.valueOf(req.getParameter("productOrderID"));

		ProductOrder productOrder = proOdSvcB.getOneProductOrder(productOrderID);

		req.setAttribute("productOrder", productOrder);
		return "/backstage/productOrderBack/set_productOrder.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer productOrderID = Integer.valueOf(req.getParameter("productOrderID"));

		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
		if (gUserID != null) {
			gUserID = Integer.valueOf(req.getParameter("gUserID"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		if (courtID != null) {
			courtID = Integer.valueOf(req.getParameter("courtID"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Timestamp productOrderTime = java.sql.Timestamp.valueOf(req.getParameter("productOrderTime").trim());
		if (req.getParameter("productOrderTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productOrderTime = java.sql.Timestamp.valueOf(req.getParameter("productOrderTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Timestamp comsume = java.sql.Timestamp.valueOf(req.getParameter("comsume").trim());
		if (req.getParameter("comsume") != null) {
			// 如果請求中有傳時間參數,使用該時間
			comsume = java.sql.Timestamp.valueOf(req.getParameter("comsume").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Timestamp productShipTime = java.sql.Timestamp.valueOf(req.getParameter("productShipTime").trim());
		if (req.getParameter("productShipTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productShipTime = java.sql.Timestamp.valueOf(req.getParameter("productShipTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Timestamp productArriveTime = java.sql.Timestamp.valueOf(req.getParameter("productArriveTime").trim());
		if (req.getParameter("productArriveTime") != null) {
			// 如果請求中有傳時間參數,使用該時間
			productArriveTime = java.sql.Timestamp.valueOf(req.getParameter("productArriveTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			errorMsgs.add("not null!");
		}
		
		Integer productShipStatus = Integer.valueOf(req.getParameter("productShipStatus"));
		
		String annoTitle = req.getParameter("annoTitle");
		if (annoTitle != null) {
			annoTitle = req.getParameter("annoTitle");
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer gUserPiCnt = Integer.valueOf(req.getParameter("gUserPiCnt"));
		if (gUserPiCnt != null) {
			gUserPiCnt = Integer.valueOf(req.getParameter("gUserPiCnt"));
		} else {
			errorMsgs.add("not null!");
		}
		
		Integer orderTotalPrice = Integer.valueOf(req.getParameter("orderTotalPrice"));
		if (orderTotalPrice != null) {
			orderTotalPrice = Integer.valueOf(req.getParameter("orderTotalPrice"));
		} else {
			errorMsgs.add("not null!");
		}

		ProductOrder productOrder = new ProductOrder();
		productOrder.setProductOrderID(productOrderID);
		productOrder.setgUserID(gUserID);
		productOrder.setCourtID(courtID);
		productOrder.setProductOrderTime(productOrderTime);
		productOrder.setConsume(productArriveTime);
		productOrder.setProductShipTime(productShipTime);
		productOrder.setProductArriveTime(productArriveTime);
		productOrder.setProductShipStatus(productShipStatus);
		productOrder.setgUserPiCnt(gUserPiCnt);
		productOrder.setOrderTotalPrice(orderTotalPrice);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("productOrder", productOrder); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/productOrderBack/set_productOrder.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		proOdSvcB.updateProductOrder(productOrder);
		req.setAttribute("productOrder", proOdSvcB.getOneProductOrder(productOrderID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("productOrder", productOrder); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/productOrderBack/all_productOrder.jsp";
	}
}
