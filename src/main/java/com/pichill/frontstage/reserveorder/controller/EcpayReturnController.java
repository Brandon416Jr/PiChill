package com.pichill.frontstage.reserveorder.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Hashtable;
import com.pichill.court.Court;
import com.pichill.court.CourtService;
import ecpay.payment.integration.AllInOne;
import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;
import com.pichill.frontstage.reserveorder.service.ReserveOrderServiceFront;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.time.TimeRef;
import com.pichill.util.SendMailService;

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
		GeneralUserServiceFront gUserSvc = new GeneralUserServiceFront();
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
						Integer yoyakuCnt = generalUser.getYoyakuCnt();
						yoyakuCnt += 1;
						generalUser.setYoyakuCnt(yoyakuCnt);
						generalUser = gUserSvc.updateGeneralUserByYoyakuCnt(gUserID, yoyakuCnt);
						
						// 更新企業會員被預約次數
						OwnerUser ownerUser = new OwnerUser();
						Integer rsvdCnts = ownerUser.getRsvdCnts();
						rsvdCnts += 1;
						ownerUser.setRsvdCnts(rsvdCnts);
						
						// 寄預約成功信件 (一般會員)
						String gEmail = generalUser.getgEmail();
						Date reserveDate = reserveOrder.getReserveDate();
						String reserveTime = reserveOrder.getTimeRef().getReserveTime();
						String gName = reserveOrder.getGeneralUser().getgName();
						Timestamp orderTime = reserveOrder.getOrderTime();
						String courtName = reserveOrder.getCourt().getCourtName();
						Integer orderNum = reserveOrder.getOrderNum();
						String subject = " PiChill_預約成功通知";
						String messageText = gName + "您好,您已於" + orderTime + "預約" + courtName + "預約時間為" + reserveDate + " " + reserveTime + "，預約人數為" + orderNum + "人，請於當日準時抵達，有任何疑問可以使用聯絡我們與我們聯絡，謝謝!";
						SendMailService sendMailService = new SendMailService();
						sendMailService.sendMail(gEmail, subject, messageText);
						
						// 寄預約成功信件 (企業會員)
						String oEmail = reserveOrder.getOwnerUser().getoEmail();
						String oName = reserveOrder.getOwnerUser().getoName();
						String subjectO = "PiChill_場館有新的預約";
						String messageTextO = oName + "您好," + courtName + "有一筆新的訂單，可於預約通知中查看預約明細!";
						SendMailService sendMailServiceO = new SendMailService();
						sendMailServiceO.sendMail(oEmail, subjectO, messageTextO);
						
		} else {
			
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
