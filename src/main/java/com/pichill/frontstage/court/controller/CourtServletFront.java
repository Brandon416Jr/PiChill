package com.pichill.frontstage.court.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pichill.backstage.court.service.CourtServiceBack;
import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
import com.pichill.court.Court;
import com.pichill.frontstage.court.service.CourtServiceFront;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.util.SendMailService;


@WebServlet("/court/courtf.do")
@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 10 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class CourtServletFront extends HttpServlet {
	private CourtServiceFront courtSvcF;
	
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		courtSvcF = new CourtServiceFront();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter CourtServletFront doGet");
		doPost(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String action = req.getParameter("action");
		System.out.println(action);
//		System.out.println(req.getParameterMap().toString());	
		String forwardPath = "";
		if(action != null){
			  action.hashCode(); 
			} else {
				System.out.println("action為空值");
//				action = "default";
			}
		
		switch (action) {
		case "getOne_For_Update":
			forwardPath = getOne_For_Update(req, res);
			break;
		case "update":
			forwardPath = update(req, res);
			break;
		case "insert":
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/testCourt/all_court.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOne_For_Update(HttpServletRequest req, HttpServletResponse res)  {
		System.out.println("成功getOneUpdate");
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));

		Court court = courtSvcF.getOneCourt(courtID);
		
		
		req.setAttribute("court", court);
		return "/testCourt/set_court.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		System.out.println("進來update了");

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		Court court = courtSvcF.getOneCourt(courtID);
		
//		HttpSession session = req.getSession();
//		OwnerUser ownerUser =(OwnerUser)session.getAttribute("ownerUser");
//		Integer oUserID = ownerUser.getoUserID();

		Time courtOpenTime = null;
		if (req.getParameter("courtOpenTime") != null && !req.getParameter("courtOpenTime").trim().equals("")) {

			String courtOpenTimeStr = req.getParameter("courtOpenTime"); 
			if(courtOpenTimeStr.length() == 5){  
			  courtOpenTimeStr += ":00"; 
			}
			courtOpenTime = Time.valueOf(courtOpenTimeStr);
			
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtOpenTime = court2.getCourtOpenTime();
		}

		Time courtCloseTime = null;
		if (req.getParameter("courtCloseTime") != null && !req.getParameter("courtCloseTime").trim().equals("")) {
			// 如果請求中有傳時間參數,使用該時間
			String courtCloseTimeStr = req.getParameter("courtCloseTime"); 
			if(courtCloseTimeStr.length() == 5){
			  courtCloseTimeStr += ":00"; 
			}
			courtCloseTime = Time.valueOf(courtCloseTimeStr);
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtCloseTime = court2.getCourtCloseTime();
		}
		
		String courtName;
		if (req.getParameter("courtName") != null) {
			courtName = req.getParameter("courtName");
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtName = court2.getCourtName();
		}
		
		InputStream in = req.getPart("courtPic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] courtPic = null;
		if(in.available()!=0){
			courtPic = new byte[in.available()];
			in.read(courtPic);
			in.close();
		}  else {
			CourtServiceFront courtSvcF = new CourtServiceFront();
			courtPic = courtSvcF.getOneCourt(courtID).getCourtPic();
		}
		
		String courtTelephone = req.getParameter("courtTelephone");
		if (req.getParameter("courtName") != null) {
			courtTelephone = req.getParameter("courtTelephone");
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtTelephone = court2.getCourtTelephone();
		}
		
		String courtAddress = req.getParameter("courtAddress");
		if (req.getParameter("courtAddress") != null) {
			courtAddress = req.getParameter("courtAddress");
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtAddress = court2.getCourtAddress();
		}
		
		String courtRule = req.getParameter("courtRule");
		if (req.getParameter("courtRule") != null) {
			courtTelephone = req.getParameter("courtRule");
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtRule = court2.getCourtRule();
		}
		
		String loc = req.getParameter("loc");
		if (req.getParameter("loc") != null) {
			courtTelephone = req.getParameter("loc");
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			loc = court2.getLoc();
		}




		
//		Court court = new Court();
		court.setCourtID(courtID);

//		ownerUser.setoUserID(oUserID);
//		court.setOwnerUser(ownerUser);
//		Manage manage = court.getManage();
//		manage.setManageID(manageID);
//		court.setManage(manage);
//		court.setCourtOnTime(courtOnTime);
//		court.setCourtApplyTime(courtApplyTime);
		court.setCourtOpenTime(courtOpenTime);
		court.setCourtCloseTime(courtCloseTime);
		court.setCourtName(courtName);
		court.setCourtPic(courtPic);
		court.setCourtTelephone(courtTelephone);
		court.setCourtAddress(courtAddress);
		court.setCourtRule(courtRule);
		court.setLoc(loc);
//		court.setCourtApplyStatus (courtApplyStatus );
		

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("court", court); // 含有輸入格式錯誤的manage物件,也存入req
			return "/testCourt/set_court.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
//		System.out.println("court:"+court.toString());
		courtSvcF.updateCourtAll(court);
//		req.setAttribute("court", courtSvcF.getOneCourt(courtID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("court", court); // 資料庫update成功後,正確的的manage物件,存入req
		return "/testCourt/all_court.jsp";
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		System.out.println("進來insert了");

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		// oUserID
		HttpSession session = req.getSession();
		OwnerUser ownerUser =(OwnerUser)session.getAttribute("ownerUser");
		Integer oUserID = ownerUser.getoUserID();

		// manageID
		Integer manageID = 13000009;
		
		// courtOnTime
		Timestamp courtOnTime = null;
		
		// courtApplyTime
		Timestamp courtApplyTime = new java.sql.Timestamp(System.currentTimeMillis());
		
		// courtName
		String courtName = req.getParameter("courtName");
		
		// courtPic
		InputStream in = req.getPart("courtPic").getInputStream(); // 從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] courtPic = null;
		if (in.available() != 0) {
			courtPic = new byte[in.available()];
			in.read(courtPic);
			in.close();
		} 
		
		// courtTelephone
		String courtTelephone = req.getParameter("courtTelephone");
		
		// courtAddress
		String courtAddress = req.getParameter("courtAddress");
		
		// courtRule
		String courtRule = req.getParameter("courtRule");
		
		// loc
		String loc = req.getParameter("loc");
		
		// courtApplyStatus
		Integer courtApplyStatus = 0;
		
		// courtOpenTime
		String courtOpenTimeStr = req.getParameter("courtOpenTime"); 
		if(courtOpenTimeStr.length() == 5){  
		  courtOpenTimeStr += ":00"; 
		}
		Time courtOpenTime = Time.valueOf(courtOpenTimeStr);
		
		// courtCloseTime
		String courtCloseTimeStr = req.getParameter("courtCloseTime"); 
		if(courtCloseTimeStr.length() == 5){
		  courtCloseTimeStr += ":00"; 
		}
		Time courtCloseTime = Time.valueOf(courtCloseTimeStr);
				
		Court court = new Court();
		ownerUser.setoUserID(oUserID);
		court.setOwnerUser(ownerUser);
//		Manage manage = court.getManage();
		
//		court.setManage(manage);
		
		court.setCourtOnTime(courtOnTime);
		court.setCourtApplyTime(courtApplyTime);
		court.setCourtOpenTime(courtOpenTime);
		court.setCourtCloseTime(courtCloseTime);
		court.setCourtName(courtName);
		court.setCourtPic(courtPic);
		court.setCourtTelephone(courtTelephone);
		court.setCourtAddress(courtAddress);
		court.setCourtRule(courtRule);
		court.setLoc(loc);
		court.setCourtApplyStatus (courtApplyStatus );
		

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("court", court); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/courtBack/set_court.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		System.out.println("court:"+court.toString());
		courtSvcF.insertCourtAll(court);

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("court", court); // 資料庫update成功後,正確的的manage物件,存入req
		return "/testCourt/all_court.jsp";
	}
}
