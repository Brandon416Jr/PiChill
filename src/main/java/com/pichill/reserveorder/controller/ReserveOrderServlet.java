package com.pichill.reserveorder.controller;

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

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.service.GeneralUserService;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.owneruser.service.OwnerUserService;
import com.pichill.place.Place;
import com.pichill.place.PlaceService;
import com.pichill.post.service.PostService;
import com.pichill.post.service.PostServiceImpl;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;
import com.pichill.time.TimeRef;
import com.pichill.time.TimeService;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 1000 * 1024 * 1024)
@WebServlet(name = "ReserveOrderServlet", value = "/reserveorder/reserveorder.do")
public class ReserveOrderServlet extends HttpServlet {
	
	private ReserveOrderService reserveOrderService;
	private Integer gUserID;
	private Integer oUserID;
	private Integer timeID;
	private Integer placeID;
	
	@Override
	public void init() throws ServletException {
		reserveOrderService = new ReserveOrderService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
//		case "getOne_For_Display":
//			// 來自select_page.jsp的請求
//			forwardPath = getOneDisplay(req, res);
//			break;
		case "getOneList_Display":
			// 來自select_page.jsp的請求
			forwardPath = getOneList(req, res);
			break;
		case "getOne_For_Update":
			// 來自listAllGeneralUser.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
//		case "insert":
//			// 來自addGeneralUser.jsp的請求
//			forwardPath = insert(req, res);
//			break;
		default:
			forwardPath = "/generaluser/select_page.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
//	/*===================================================================================================*/
//	/*                                                查詢                                                */
//	/*===================================================================================================*/
//	
//	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
//		
//		String str = req.getParameter("reserveOrderID");
//
//		if (str == null || (str.trim()).length() == 0) {
//			errorMsgs.add("請輸入預約訂單編號");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/generaluser/select_page.jsp";// 程式中斷
//		}
//
//		Integer reserveOrderID = null;
//		try {
//			reserveOrderID = Integer.valueOf(str);
//		} catch (Exception e) {
//			errorMsgs.add("預約訂單編號格式不正確");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/generaluser/select_page.jsp";// 程式中斷
//		}
//		
//	/*=========================================== 2.開始查詢資料 ===========================================*/
//		
//		ReserveOrder reserveOrder = reserveOrderService.getOneReserveOrder(reserveOrderID);
//
//		if (reserveOrder == null) {
//			errorMsgs.add("查無資料");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/generaluser/select_page.jsp";// 程式中斷
//		}
//
//	/*================================= 3.查詢完成,準備轉交(Send the Success view) ==========================*/
//		
//		req.setAttribute("reserveOrder", reserveOrder); // 資料庫取出的generalUser物件,存入req
//		return "/reserveorder/listOneOrder.jsp";
//	}
	/*===================================================================================================*/
	/*                                                會員預約查詢                                                */
	/*===================================================================================================*/
	
	private String getOneList(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
		
//		String str = req.getParameter("gUserID");

//		if (gUserID == null || (gUserID == 0) ){
//			
//			errorMsgs.add("請輸入會員編號");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/generaluser/select_page.jsp";// 程式中斷
//		}
//
//		Integer gUserID = null;
//		try {
//			gUserID = Integer.valueOf(gUserID);
//		} catch (Exception e) {
//			errorMsgs.add("會員編號不正確");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/generaluser/select_page.jsp";// 程式中斷
//		}
		
	/*=========================================== 2.開始查詢資料 ===========================================*/
//		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
		Integer gUserID = 11000001;
		ReserveOrderService reserveOrderService = new ReserveOrderService();
		List<ReserveOrder> reserveOrder = reserveOrderService.getgUserID(gUserID);

		if (reserveOrder == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/generaluser/select_page.jsp";// 程式中斷
		}

	/*================================= 3.查詢完成,準備轉交(Send the Success view) ==========================*/
		
		req.setAttribute("reserveOrder", reserveOrder); // 資料庫取出的reserveOrder物件,存入req
		return "/reserveorder/listOneOrder.jsp";
	}
	/*===================================================================================================*/
	/*                                                新增                                                */
	/*===================================================================================================*/

//	private String insert(HttpServletRequest req, HttpServletResponse res) {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
//		
//		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
//
//		Integer oUserID = Integer.parseInt(req.getParameter("oUserID"));
//		
//		//預約日期
////		Date mHiredate = new java.sql.Date(System.currentTimeMillis());
//		Date reserveDate = null;
//		try {
//			reserveDate = java.sql.Date.valueOf(req.getParameter("reserveDate").trim());
//		} catch (IllegalArgumentException e) {
//			reserveDate = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請選擇預約日期!");
//		}
//		//時段編號: 根據開館閉館時間判斷
//		Integer timeID = Integer.parseInt(req.getParameter("timeID"));
//		
//		
//		//場地編號
//		Integer placeID = Integer.parseInt(req.getParameter("placeID"));
//		
//		//下單時間Timestamp自動產生
////		Timestamp orderTime = Timestamp.valueOf(req.getParameter("orderTime"));
//		
//		
//		//人數: 根據不同場地會有人數限制
//		Integer orderNum = Integer.valueOf(req.getParameter("orderNum"));
////		Integer orderNum = req.getParameter("orderNum");
////		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
////		if (gEmail == null || gEmail.trim().length() == 0) {
////			errorMsgs.add("會員帳號: 請勿空白");
////		} else if (!gEmail.trim().matches(gEmailReg)) { // 以下練習正則(規)表示式(regular-expression)
////			errorMsgs.add("請輸入正確的Email格式");
////		}
//
//		//訂單狀態: 0→訂單取消 1→訂單成立 2→訂單已完成
//		Integer orderStatus = Integer.valueOf(req.getParameter("orderStatus"));
//		
//		
//		//訂單總金額: 根據場地費用判斷
//		Integer totalCost = Integer.valueOf(req.getParameter("totalCost"));
//		
//
//
//
//		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
//		ReserveOrder reserveOrder = new ReserveOrder();
//		
//		reserveOrder.setGeneralUser().setgUserID(gUserID);
//		reserveOrder.setOwnerlUser().setoUserID(oUserID);
//		reserveOrder.setReserveDate(reserveDate);
//		reserveOrder.setTimeRef().setTimeID(timeID);
//		reserveOrder.setPlace().setPlaceID(placeID);
////		reserveOrder.setOrderTime(orderTime);
//		reserveOrder.setOrderNum(orderNum);
//		reserveOrder.setOrderStatus(orderStatus);
//		reserveOrder.setTotalCost(totalCost);
//
//		reserveOrder.toString();
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			req.setAttribute("reserveOrder", reserveOrder); // 含有輸入格式錯誤的reserveOrder物件,也存入req
//			return "/reserveorder/reserveOrder2.jsp";
//		}
//
//	/*=========================================== 2.開始新增資料 ===========================================*/
//		reserveOrderService.addReserveOrder(reserveOrder);
//
//	/*================================= 3.新增完成,準備轉交(Send the Success view) ==========================*/
//		return "/reserveorder/reserveOrderList.jsp";
//
//	}
	
	/*===================================================================================================*/
	/*                                                修改                                                */
	/*===================================================================================================*/
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID"));

		ReserveOrder reserveOrder = reserveOrderService.getOneReserveOrder(reserveOrderID);
		
		req.setAttribute("reserveOrder", reserveOrder);
		return "/reserveorder/updateOrderStatus.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
		
		Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID"));
		
		GeneralUserService generalUserService = new GeneralUserService();
		GeneralUser generalUser = generalUserService.getOneGeneralUser(gUserID);
		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));

		OwnerUserService ownerUserService = new OwnerUserService();
		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		
		//預約日期
		Date reserveDate = java.sql.Date.valueOf(req.getParameter("reserveDate").trim());
//		Date reserveDate = null;
//		try {
//			reserveDate = java.sql.Date.valueOf(req.getParameter("reserveDate").trim());
//		} catch (IllegalArgumentException e) {
//			reserveDate = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請選擇預約日期!");
//		}
		//時段編號: 根據開館閉館時間判斷
		TimeService timeService = new TimeService();
		TimeRef timeRef = timeService.getOneTime(timeID);
		Integer timeID = Integer.valueOf(req.getParameter("timeID"));
		
		
		//場地編號
		PlaceService placeService = new PlaceService();
		Place place = placeService.getOnePlace(placeID);
		Integer placeID = Integer.valueOf(req.getParameter("placeID"));
		
		//下單時間Timestamp自動產生
		Timestamp orderTime = Timestamp.valueOf(req.getParameter("orderTime"));
		
		
		//人數: 根據不同場地會有人數限制
		Integer orderNum = Integer.valueOf(req.getParameter("orderNum"));
//		Integer orderNum = req.getParameter("orderNum");
//		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//		if (gEmail == null || gEmail.trim().length() == 0) {
//			errorMsgs.add("會員帳號: 請勿空白");
//		} else if (!gEmail.trim().matches(gEmailReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("請輸入正確的Email格式");
//		}

		//訂單狀態: 1→訂單成立 2→訂單完成 3→訂單已取消
		Integer orderStatus = Integer.valueOf(req.getParameter("orderStatus"));
//		String inputParameter = req.getParameter("orderStatus");
//		Integer orderStatus = 0;
//        try {
//        	orderStatus = Integer.parseInt(inputParameter);
//        } catch (NumberFormatException e) {
//            // 轉換失敗，使用預設值 0
//        }
//        // 使用自定義方法轉換整數為字串
//        String resultString = convertToString(orderStatus);
//
//        // 將結果輸出到網頁
//        res.getWriter().write(resultString);
//    }
//
//	    private String convertToString(int orderStatus) {
//	        if (orderStatus == 0) {
//	            return "訂單取消";
//	        } else if (orderStatus == 1) {
//	            return "訂單成立";
//	        } else {
//	        	return "訂單已完成";
//	        }
	
		//訂單總金額: 根據場地費用判斷
		Integer totalCost = Integer.valueOf(req.getParameter("totalCost"));
		



		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		ReserveOrder reserveOrder = new ReserveOrder();
		reserveOrder.setReserveOrderID(reserveOrderID);
//		reserveOrder.setgUserID(gUserID);
//		reserveOrder.setoUserID(oUserID);
		reserveOrder.setReserveDate(reserveDate);
//		reserveOrder.setTimeID(timeID);
//		reserveOrder.setPlaceID(placeID);
		reserveOrder.setOrderTime(orderTime);
		reserveOrder.setOrderNum(orderNum);
		reserveOrder.setOrderStatus(orderStatus);
		reserveOrder.setTotalCost(totalCost);
		reserveOrder.toString();
		
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("reserveOrder", reserveOrder); // 含有輸入格式錯誤的reserveOrder物件,也存入req
			return "/reserveorder/allOrder.jsp";
		}
		
	/*=========================================== 2.開始修改資料 ===========================================*/
		reserveOrderService.updateReserveOrder(reserveOrder);
		req.setAttribute("reserveOrder", reserveOrderService.getOneReserveOrder(reserveOrderID));

	/*================================= 3.修改完成,準備轉交(Send the Success view) ==========================*/
		
		req.setAttribute("reserveOrder", reserveOrder); // 資料庫update成功後,正確的的generalUser物件,存入req
		return "/generaluser/allOrder.jsp";
	}
	

}
