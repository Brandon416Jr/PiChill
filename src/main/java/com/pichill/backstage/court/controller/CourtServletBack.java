package com.pichill.backstage.court.controller;

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

import com.pichill.backstage.contactus.service.ContactUsServiceBack;
import com.pichill.backstage.court.service.CourtServiceBack;
import com.pichill.contactus.entity.ContactUs;
import com.pichill.court.Court;
import com.pichill.manage.entity.Manage;

/**
 * Servlet implementation class CourtServletBack
 */
@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "CourtBServlet", value = "/court/courtb.do")
public class CourtServletBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourtServiceBack courtSvcB;
       
    public CourtServletBack() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
    	courtSvcB = new CourtServiceBack();
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

		case "getOne_For_Update":
			// 來自all_manage.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自set_manage.jsp的請求
			forwardPath = update(req, res);
			break;
		default:
			forwardPath = "/backstage/courtBack/all_court.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
    
    private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));

		Court court = courtSvcB.getOneCourt(courtID);

		req.setAttribute("court", court);
		return "/backstage/courtBack/set_court.jsp";
	}
    
    private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		Court court = courtSvcB.getOneCourt(courtID);
		
//		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
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
//		
//		Timestamp courtApplyTime;
//		if (req.getParameter("courtApplyTime") != null && !req.getParameter("courtApplyTime").trim().equals("")) {
//			// 如果請求中有傳時間參數,使用該時間
//			courtApplyTime = java.sql.Timestamp.valueOf(req.getParameter("courtApplyTime").trim());
//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			courtApplyTime = court2.getCourtApplyTime();
//		}
//		
//		String courtName;
//		if (req.getParameter("courtName") != null) {
//			courtName = req.getParameter("courtName");
//		} else {
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			courtName = court2.getCourtName();
//		}
		
//		byte[] courtPic = null;
//		
//		String courtTelephone = req.getParameter("courtTelephone");
//		if (req.getParameter("courtName") != null) {
//			courtTelephone = req.getParameter("courtTelephone");
//		} else {
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			courtTelephone = court2.getCourtTelephone();
//		}
		
//		String courtAddress = req.getParameter("courtAddress");
//		if (req.getParameter("courtAddress") != null) {
//			courtAddress = req.getParameter("courtAddress");
//		} else {
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			courtAddress = court2.getCourtAddress();
//		}
//		
//		String courtRule = req.getParameter("courtRule");
//		if (req.getParameter("courtRule") != null) {
//			courtTelephone = req.getParameter("courtRule");
//		} else {
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			courtRule = court2.getCourtRule();
//		}
//		
//		String loc = req.getParameter("loc");
//		if (req.getParameter("loc") != null) {
//			courtTelephone = req.getParameter("loc");
//		} else {
//			CourtServiceBack service = new CourtServiceBack();
//			Court court2 = service.getOneCourt(courtID);
//			loc = court2.getLoc();
//		}

		Integer courtApplyStatus;
		if(req.getParameter("courtApplyStatus") != null) {
			courtApplyStatus = Integer.valueOf(req.getParameter("courtApplyStatus"));
		} else {
			CourtServiceBack service = new CourtServiceBack();
			Court court2 = service.getOneCourt(courtID);
			courtApplyStatus = court2.getcourtApplyStatus();
		}
		
//		Court court = new Court();
		court.setCourtID(courtID);
//		court.setoUserID(oUserID);
//		court.setManageID(manageID);
//		court.setCourtOnTime(courtOnTime);
//		court.setCourtApplyTime(courtApplyTime);
//		court.setCourtName(courtName);
//		court.setCourtPic(courtPic);
//		court.setCourtTelephone(courtTelephone);
//		court.setCourtAddress(courtAddress);
//		court.setCourtRule(courtRule);
//		court.setLoc(loc);
		court.setcourtApplyStatus (courtApplyStatus );

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("court", court); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/courtBack/set_court.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		courtSvcB.updateCourt(court);
		req.setAttribute("court", courtSvcB.getOneCourt(courtID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("court", court); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/courtBack/all_court.jsp";
	}

}
