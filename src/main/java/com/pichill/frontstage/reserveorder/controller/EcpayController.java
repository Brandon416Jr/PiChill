package com.pichill.frontstage.reserveorder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import ecpay.payment.integration.domain.AioCheckOutApplePay;
import ecpay.payment.integration.domain.AioCheckOutATM;
import ecpay.payment.integration.domain.AioCheckOutBARCODE;
import ecpay.payment.integration.domain.AioCheckOutCVS;
import ecpay.payment.integration.domain.AioCheckOutDevide;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import ecpay.payment.integration.domain.AioCheckOutPeriod;
import ecpay.payment.integration.domain.AioCheckOutWebATM;
import ecpay.payment.integration.domain.CreateServerOrderObj;
import ecpay.payment.integration.domain.DoActionObj;
import ecpay.payment.integration.domain.FundingReconDetailObj;
import ecpay.payment.integration.domain.InvoiceObj;
import ecpay.payment.integration.domain.QueryCreditCardPeriodInfoObj;
import ecpay.payment.integration.domain.QueryTradeInfoObj;
import ecpay.payment.integration.domain.QueryTradeObj;
import ecpay.payment.integration.domain.TradeNoAioObj;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;

@WebServlet("/ecpay.do")
public class EcpayController extends HttpServlet {
	public static AllInOne all;
	public static ReserveOrderService rsvdSvc;
	
	@Override
	public void init() throws ServletException {
		all = new AllInOne("");
		rsvdSvc = new ReserveOrderService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// 寫死，直接呼叫綠界
//		AioCheckOutALL obj = new AioCheckOutALL();
//		int currentYear = getCurrentYear();
//		int merchantTradeNoSet = 1245675789;
//		obj.setMerchantTradeNo("CCO" + currentYear + merchantTradeNoSet);	
//		obj.setMerchantTradeDate("2023/12/28 11:11:33");
//		obj.setTradeDesc("緯育球館");
//		obj.setItemName("緯育球館" + "  " + "2023/12/15" + " " + "15:00-16:00");
//		obj.setTotalAmount("1000");
//		obj.setCustomField1("61000001"); // 訂單成立接收到CourtNo
//		obj.setCustomField2("52000001"); // 預約單編號（資料庫的）
//		obj.setCustomField4("11000001"); // 會員編號
//		obj.setReturnURL("https://da60-114-24-167-99.ngrok-free.app/PiChill/frontstage/reserveorder/ecpayreturn.do");	// 使用時要記得換成外網
//		obj.setOrderResultURL("http://localhost:8081/PiChill/test/paymentSuccess.jsp");  // 使用者付款完成跳轉頁面
//		obj.setNeedExtraPaidInfo("N");
//		String form = all.aioCheckOut(obj, null);
//		System.out.println(form);
		
		
		// 不寫死
		
		Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID")) ;
		
		
		ReserveOrder reserveOrder = rsvdSvc.getOneReserveOrder(reserveOrderID);
		
		Integer gUserID = reserveOrder.getGeneralUser().getgUserID();
		Timestamp tradeDate = reserveOrder.getOrderTime();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String formattedTradeDate = dateFormat.format(tradeDate);
		
//		 呼叫綠界
		AioCheckOutALL obj = new AioCheckOutALL();
		int currentYear = getCurrentYear();
		int merchantTradeNoSet = 10000 + reserveOrderID;
		obj.setMerchantTradeNo("PC" + currentYear + merchantTradeNoSet);	
		obj.setMerchantTradeDate(formattedTradeDate);
		obj.setTradeDesc(reserveOrder.getCourt().getCourtName());
		obj.setItemName(reserveOrder.getCourt().getCourtName() + "  " + reserveOrder.getReserveDate() 
						+ "  " + reserveOrder.getTimeRef().getReserveTime());
		obj.setTotalAmount(String.valueOf(reserveOrder.getTotalCost()));
		obj.setCustomField1(String.valueOf(reserveOrder.getCourt().getCourtID())); // 訂單成立接收到CourtNo
		obj.setCustomField2(String.valueOf(reserveOrderID)); // 預約單編號（資料庫的）
		obj.setCustomField4(Integer.toString(gUserID)); // 會員編號
		obj.setReturnURL("https://8cda-2001-b011-6-36f6-808c-a1d0-434c-858c.ngrok-free.app/PiChill/reserveorder/ecpayreturn.do");	// 使用時要記得換成外網
		obj.setOrderResultURL("http://localhost:8081/PiChill/reserveorder/listOneOrder.jsp");  // 使用者付款完成跳轉頁面
//		obj.setOrderResultURL("http://localhost:8081/PiChill/reserveorder/listOneOrder.jsp?ecpay=1");  // 使用者付款完成跳轉頁面
//		obj.setOrderResultURL("http://localhost:8081/PiChill/reserveorder/reserveOrder.jsp"); 
		obj.setNeedExtraPaidInfo("N");
		String form = all.aioCheckOut(obj, null);
		System.out.println(form);
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		try(PrintWriter out = res.getWriter()){
			out.print(form);
		}
	}

	private int getCurrentYear() {
        return LocalDate.now().getYear();
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

}
