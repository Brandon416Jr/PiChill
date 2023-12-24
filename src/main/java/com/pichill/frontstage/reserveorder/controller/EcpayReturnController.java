package com.pichill.frontstage.reserveorder.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Hashtable;
import com.pichill.court.Court;
import com.pichill.court.CourtService;
import com.pichill.ecpay.payment.integration.AllInOne;
import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;
import com.pichill.frontstage.reserveorder.service.ReserveOrderServiceFront;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.service.GeneralUserService;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;

@WebServlet("/ecpayreturn.do")
public class EcpayReturnController extends HttpServlet {
	public static AllInOne all;
	private ReserveOrderServiceFront rsvdSvc; // 修改訂單狀態
	private OwnerUserServiceFront oUserSvc; // 修改企業會員被預約次數
	private GeneralUserServiceFront gUserSvc; // 一般會員預約次數

	public void init() throws ServletException {
		all = new AllInOne("");
		rsvdSvc = new ReserveOrderServiceFront();
		oUserSvc = new OwnerUserServiceFront();
		gUserSvc = new GeneralUserServiceFront();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("進到EcpayReturn控制器");
		String merchantID = req.getParameter("MerchantID");
		String merchantTradeNo = req.getParameter("MerchantTradeNo");
		String RtnMsg = req.getParameter("RtnMsg");
		String checkMacValue = req.getParameter("CheckMacValue");
		String rtnCode = req.getParameter("RtnCode");
		Integer courtID = Integer.valueOf(req.getParameter("CustomField1"));
		Integer reserveOrderID = Integer.valueOf(req.getParameter("CustomField2"));
//		String courtOrdTimeAndEnd = req.getParameter("CustomField3");
		Integer gUserID = Integer.valueOf(req.getParameter("CustomField4"));
		
		CourtService courtSvc = new CourtService();
		Court court = courtSvc.getOneCourt(courtID);
		GeneralUserService gUserSvc = new GeneralUserService();
		GeneralUser generalUser = gUserSvc.getOneGeneralUser(gUserID);

		System.out.println(merchantTradeNo + " " + RtnMsg + " RtnCode=" + rtnCode 
				+ " courtID=" + courtID
				+"courtOrdDateAndTimeAndEnd="
				+"gUserID="+gUserID);
		
		if ("1".equals(rtnCode)) {
			// 付款成功
						// 檢查 checkMacValue，正確的話回傳 1|OK
						Hashtable<String, String> dict = new Hashtable<String, String>();
						dict.put("MerchantID", merchantID);
						dict.put("CheckMacValue", checkMacValue);
						res.setCharacterEncoding("UTF-8");
						res.setContentType("text/html");
						if(all.compareCheckMacValue(dict)) {
							res.getWriter().write("1|OK");
						}
						
						// 更新訂單狀態
						ReserveOrder reserveOrder = new ReserveOrder();
						Integer orderStatus = reserveOrder.getOrderStatus();
						orderStatus = 2;
						reserveOrder.setOrderStatus(orderStatus);
						reserveOrder = rsvdSvc.updateReserveOrderByOrderStatus(reserveOrderID, orderStatus);
						
						// 更新一般會員預約次數
						
						
						// 更新企業會員被預約次數
						
						
						// 寄預約成功信件
						
						
		} else {
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
