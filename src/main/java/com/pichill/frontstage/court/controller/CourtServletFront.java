package com.pichill.frontstage.court.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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


@WebServlet("/courtf.do")
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
				action = "default";
			}
		
		switch (action) {
		case "getOne_For_Update":
			forwardPath = getOne_For_Update(req, res);
			break;
		case "update":
			forwardPath = update(req, res);
			break;
		default:
			forwardPath = "/court/all_court.jsp";
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
		return "/court/set_court.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		System.out.println("進來update了");

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		Court court = courtSvcF.getOneCourt(courtID);
		
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
//		
//		Integer manageID;
//		if(req.getParameter("manageID") != null) {
//			manageID = Integer.valueOf(req.getParameter("manageID"));
//		} else {
//			manageID = null;
//		}
//		
//		Timestamp courtOnTime;
//		if (req.getParameter("courtOnTime") != null && !req.getParameter("courtOnTime").trim().equals("")) {
//			// 如果請求中有傳時間參數,使用該時間
//			courtOnTime = java.sql.Timestamp.valueOf(req.getParameter("courtOnTime").trim());
//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			courtOnTime = court2.getCourtOnTime();
//		}
		
		Time courtOpenTime;
		if (req.getParameter("courtOpenTime") != null && !req.getParameter("courtOpenTime").trim().equals("")) {
			// 如果請求中有傳時間參數,使用該時間
			courtOpenTime = java.sql.Time.valueOf(req.getParameter("courtOpenTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtOpenTime = court2.getCourtOpenTime();
		}
		
		Time courtCloseTime;
		if (req.getParameter("courtCloseTime") != null && !req.getParameter("courtCloseTime").trim().equals("")) {
			// 如果請求中有傳時間參數,使用該時間
			courtCloseTime = java.sql.Time.valueOf(req.getParameter("courtCloseTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtCloseTime = court2.getCourtCloseTime();
		}
//		
		Timestamp courtApplyTime;
		if (req.getParameter("courtApplyTime") != null && !req.getParameter("courtApplyTime").trim().equals("")) {
			// 如果請求中有傳時間參數,使用該時間
			courtApplyTime = java.sql.Timestamp.valueOf(req.getParameter("courtApplyTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtApplyTime = court2.getCourtApplyTime();
		}
		
		Timestamp courtOnTime;
		if (req.getParameter("courtOnTime") != null && !req.getParameter("courtOnTime").trim().equals("")) {
			// 如果請求中有傳時間參數,使用該時間
			courtOnTime = java.sql.Timestamp.valueOf(req.getParameter("courtOnTime").trim());
		} else {
			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtOnTime = court2.getCourtOnTime();
		}
//		
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

		Integer courtApplyStatus;
		if(req.getParameter("courtApplyStatus") != null) {
			courtApplyStatus = Integer.valueOf(req.getParameter("courtApplyStatus"));
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtApplyStatus = court2.getCourtApplyStatus();
		}
		
		Integer manageID;
		if(req.getParameter("manageID") != null) {
			manageID = Integer.valueOf(req.getParameter("manageID"));
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			Manage manage = court2.getManage();
			manageID = manage.getManageID();
		}

		
//		Court court = new Court();
		court.setCourtID(courtID);
		OwnerUser ownerUser = court.getOwnerUser();
		ownerUser.setoUserID(oUserID);
		court.setOwnerUser(ownerUser);
		Manage manage = court.getManage();
		manage.setManageID(manageID);
		court.setManage(manage);
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
		courtSvcF.updateCourt( courtID,  courtOpenTime,courtCloseTime,  courtName, courtPic, courtTelephone, courtAddress,  loc, courtRule);
		req.setAttribute("court", courtSvcF.getOneCourt(courtID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("court", court); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/courtBack/all_court.jsp";
	}
}
