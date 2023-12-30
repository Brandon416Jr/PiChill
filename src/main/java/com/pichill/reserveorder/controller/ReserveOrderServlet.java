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
import javax.servlet.http.HttpSession;

import com.pichill.court.Court;
import com.pichill.court.CourtService;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.owneruser.service.OwnerUserService;
import com.pichill.place.Place;
import com.pichill.place.PlaceService;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;
import com.pichill.time.TimeRef;
import com.pichill.time.TimeService;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 1000 * 1024 * 1024)
@WebServlet(name = "ReserveOrderServlet", value = "/reserveorder/reserveorder.do")
public class ReserveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReserveOrderService reserveOrderService;
	private Integer gUserID;

	private Integer reserveOrderID;

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
		case "getAllList_Display":
			forwardPath = getAllList(req, res);
			break;
		case "getOne_For_Update":
			forwardPath = getOneUpdate(req, res);
			break;
		case "insert":
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/homepage/main.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	/*===================================================================================================*/
	/*                                            查詢球館預約紀錄                                           */
	/*===================================================================================================*/
	
	private String getAllList(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

	/*=========================================== 1.開始查詢資料 ===========================================*/
		HttpSession session = req.getSession();
		GeneralUser generalUser = (GeneralUser)session.getAttribute("generalUser");
		gUserID = generalUser.getgUserID();
		
		ReserveOrderService reserveOrderService = new ReserveOrderService();
		List<ReserveOrder> reserveOrder = reserveOrderService.getgUserID(gUserID);

		if (reserveOrder == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/homepage/main.jsp";// 程式中斷
		}

	/*================================= 2.查詢完成,準備轉交(Send the Success view) ==========================*/
		
		req.setAttribute("reserveOrder", reserveOrder); // 資料庫取出的reserveOrder物件,存入req
		return "/reserveorder/listOneOrder.jsp";
	}
	
	/*===================================================================================================*/
	/*                                             新增預約訂單                                             */
	/*===================================================================================================*/

	private String insert(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
		
		HttpSession session = req.getSession();
		GeneralUser generalUser = (GeneralUser)session.getAttribute("generalUser");
		gUserID = generalUser.getgUserID();
		
		Integer courtID = Integer.valueOf(req.getParameter("courtID")!=null ? req.getParameter("courtID") : "");
		CourtService courtSVC = new CourtService();
		Court court = courtSVC.getOneCourt(courtID);
		
		Integer placeID = Integer.valueOf(req.getParameter("placeID")!=null ? req.getParameter("placeID") : "");
		PlaceService placeSVC = new PlaceService();
		Place place = placeSVC.getOnePlace(placeID);
		
		Date reserveDate = java.sql.Date.valueOf(req.getParameter("reserveDate")!=null ? req.getParameter("reserveDate") : "");
		Integer timeID = Integer.valueOf(req.getParameter("timeID")!=null ? req.getParameter("timeID") : "");
		TimeService timeSVC = new TimeService();
		TimeRef timeRef = timeSVC.getOneTime(timeID);
		Integer orderNum = Integer.valueOf(req.getParameter("orderNum")!=null ? req.getParameter("orderNum") : "");
		
		//頁面不顯示
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID")!=null ? req.getParameter("oUserID") : "");
		OwnerUserService ownerUserSVC = new OwnerUserService();
		OwnerUser ownerUser = ownerUserSVC.getOneOwnerUser(oUserID);
		
		
		Integer totalCost = Integer.valueOf(req.getParameter("totalCost")!=null ? req.getParameter("totalCost") : "");
		totalCost = totalCost * orderNum;
		
		//訂單狀態: 0→訂單已取消 1→訂單成立 2→訂單完成
		Integer orderStatus = Integer.valueOf(req.getParameter("orderStatus")!=null ? "1" : "");

		//下單時間Timestamp自動產生
		Timestamp orderTime = null;

		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		ReserveOrder reserveOrder = new ReserveOrder();
		
		reserveOrder.setGeneralUser(generalUser);
		reserveOrder.setOwnerUser(ownerUser);
		reserveOrder.setReserveDate(reserveDate);
		reserveOrder.setTimeRef(timeRef);
		reserveOrder.setPlace(place);
		reserveOrder.setCourt(court);
		reserveOrder.setOrderTime(orderTime);
		reserveOrder.setOrderNum(orderNum);
		reserveOrder.setOrderStatus(orderStatus);
		reserveOrder.setTotalCost(totalCost);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("reserveOrder", reserveOrder); // 含有輸入格式錯誤的reserveOrder物件,也存入req
			return "/reserveorder/reserveOrder.jsp";
		}
		
	/*=========================================== 2.開始新增資料 ===========================================*/
		reserveOrderService.addReserveOrder(reserveOrder);
	/*================================= 3.新增完成,準備轉交(Send the Success view) ==========================*/
		HttpSession session1 = req.getSession();
		session1.setAttribute("newReserveOrder", reserveOrder);
		return "/reserveorder/reserveOrderList.jsp";
		
	}

	/*===================================================================================================*/
	/*                                          修改訂單狀態                                                */
	/*===================================================================================================*/
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer reserveOrderID = Integer.valueOf(req.getParameter("reserveOrderID"));

        // 取得預約訂單
        ReserveOrder reserveOrder = reserveOrderService.getOneReserveOrder(reserveOrderID);

        // 將訂單狀態設置為「0 → 訂單取消」
        reserveOrder.setOrderStatus(0);
		
	/*=========================================== 1.開始修改資料 ===========================================*/
        
		reserveOrderService.updateReserveOrder(reserveOrder);
		req.setAttribute("reserveOrder", reserveOrderService.getOneReserveOrder(reserveOrderID));

	/*================================= 2.修改完成,準備轉交(Send the Success view) ==========================*/
		
		req.setAttribute("reserveOrder", reserveOrder); // 資料庫update成功後,正確的的generalUser物件,存入req
		return "/reserveorder/listOneOrder.jsp";
	}
	

}
