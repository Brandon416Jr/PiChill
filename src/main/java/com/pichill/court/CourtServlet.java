package com.pichill.court;

import java.io.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pichill.manage.entity.Manage;
import com.pichill.place.*;



@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "CourtHServlet", value = "/court/court.do")
public class CourtServlet extends HttpServlet{
	private CourtService courtService;
	private Integer placeID;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		courtService = new CourtService();
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
		case "getOne_For_Display":
			 // 來自select_page.jsp的請求
			forwardPath = getOne_For_Display(req, res);
			break;
		case "getOne_For_Update":
			// 來自all_court.jsp的請求
			forwardPath = getOne_For_Update(req, res);
			break;
		case "update":
			// 來自set_court.jsp的請求
			forwardPath = update(req, res);
			break;
		case "insert":
			// 來自new_court.jsp的請求
			forwardPath = insert(req, res);
			break;
		case "logout":
			forwardPath = logout(req, res);
			break;			
		default:
			forwardPath = "/court/select_page.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	
	
	
	
	
	private String getOne_For_Display(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		String str = req.getParameter("gUserID");

		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入球館編號");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/court/select_page.jsp";// 程式中斷
		}

		Integer courtID = null;
		try {
			courtID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("球館編號格式不正確");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/court/select_page.jsp";// 程式中斷
		}

		/*************************** 2.開始查詢資料 *****************************************/
		Court court = courtService.getOneCourt(courtID);

		if (court == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/court/select_page.jsp";// 程式中斷
		}

		/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
		req.setAttribute("court", court); // 資料庫取出的court物件,存入req
		return "/court/listOnecourt.jsp";
	}

	//=================修改===================
	
	private String getOne_For_Update(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("成功getOneUpdate");
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);

		
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));

		Court updateCourt = courtService.getOneCourt(courtID);

		HttpSession session = req.getSession();
		try {
			if(session != null) {
				  // get session attributes
				}
		} catch (NullPointerException ne ) {
			ne.printStackTrace();
		}
		Court court = (Court) session.getAttribute("court");
		System.out.println("court: " + court);
		Enumeration<String> attrs = session.getAttributeNames();

		while (attrs.hasMoreElements()) {
		  String name = attrs.nextElement();
		  
		  Object value = session.getAttribute(name);
		  System.out.println(name + ": " + value);
		}
		Integer courtApplyStatus = court.getCourtApplyStatus();
		if (courtApplyStatus != 2 && Integer.valueOf(updateCourt.getCourtID()) != Integer.valueOf(court.getCourtID())) {	

			  req.setAttribute("noAuth", true);
				return "/court/all_court.jsp";
			}
		
		
		req.setAttribute("court", court);
		return "/court/court.jsp";
	}

	
	
	
//===========================更新==============================================	
	
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer courtID = Integer.valueOf(req.getParameter("courtID"));
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer  manageID = 0;
		
		Timestamp courtOnTime = Timestamp.valueOf(req.getParameter("courtOnTime"));
		
		Timestamp courtApplyTime = Timestamp.valueOf(req.getParameter("courtApplyTime"));
		

		String courtName = req.getParameter("courtName");
		if (courtName == null || courtName.trim().isEmpty())
			errorMsgs.add("請輸入球館名稱");

		Integer status = Integer.valueOf(req.getParameter("status"));

		// 取得圖片
		byte[] courtPic = null;
		InputStream in = req.getPart("courtPic").getInputStream(); 
		// 從javax.servlet.http.Part物件取得上傳檔案的InputStream		
		if (in.available() != 0) {
			courtPic = new byte[in.available()];
			in.read(courtPic);
			in.close();
		} else {
			CourtService courtService = new CourtService();
			courtPic = courtService.getOneCourt(courtID).getCourtPic();
		}

		String courtTelephone = req.getParameter("courtTelephone");
		String courtTelephoneReg = "^(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{7,14}$";
		if (courtTelephone == null || courtTelephone.trim().isEmpty()) {
			errorMsgs.add("球館電話: 請勿空白");
		} else if (!courtTelephone.trim().matches(courtTelephoneReg)) {
			errorMsgs.add("請輸入正確的球館電話格式");
		}
		
		String courtAddress = req.getParameter("courtAddress");
		if (courtAddress == null || courtAddress.trim().isEmpty())
			errorMsgs.add("請輸入球館地址");
		
		String courtRule = req.getParameter("courtRule");
		if (courtRule == null || courtRule.trim().isEmpty())
			errorMsgs.add("請輸入球館須知");
		
		String loc = req.getParameter("loc");
		if (loc == null || loc.trim().isEmpty())
			errorMsgs.add("請輸入球館地區");
		
		Integer courtApplyStatus = Integer.valueOf(req.getParameter("courtApplyStatus"));
		
		Time courtOpenTime = Time.valueOf(req.getParameter("courtOpenTime"));
		
		Time courtCloseTime = Time.valueOf(req.getParameter("courtCloseTime"));
		
		String placeName = String.valueOf(req.getParameter("placeName").trim());
		
		Integer placeFee = Integer.valueOf(req.getParameter("placeFee").trim());
		
		Integer ball = Integer.valueOf(req.getParameter("ball").trim());
		

		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		Court court = new Court();
		court.setCourtID(courtID);
//		court.setoUserID(oUserID);
//		court.setmanageID(manageID);
		court.setCourtOnTime(courtOnTime);
		court.setCourtApplyTime(courtApplyTime);
		court.setCourtName(courtName);
		court.setCourtPic(courtPic);
		court.setCourtTelephone(courtTelephone);
		court.setCourtAddress(courtAddress);
		court.setCourtRule(courtRule);
		court.setLoc(loc);
		court.setCourtApplyStatus(courtApplyStatus);
		court.setCourtOpenTime(courtOpenTime);
		court.setCourtCloseTime(courtCloseTime);
		((Place) court.getPlace()).setPlaceName(placeName);
		((Place) court.getPlace()).setPlaceFee(placeFee);
		((Place) court.getPlace()).setBall(ball);
		court.toString();
		

		// ========================================================================改到這===============

		if (!errorMsgs.isEmpty()) {
			req.setAttribute("court", court); // 含有輸入格式錯誤的manage物件,也存入req
			return "/owneruser/court/set_court.jsp"; // 程式中斷
		}
		/*************************** 2.開始修改資料 *****************************************/

		courtService.updateCourt(court);
		req.setAttribute("court", courtService.getOneCourt(courtID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("court", court); // 資料庫update成功後,正確的的empVO物件,存入req
		return "/owneruser/court/all_court.jsp";
	}

	
// ==============insert 資料========================
	private String insert(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		Court newCourt = new Court();
		req.setAttribute("newCourt", newCourt);
		Integer courtID = Integer.parseInt(req.getParameter("courtID"));
		Integer oUserID = Integer.parseInt(req.getParameter("oUserID"));

		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer  manageID = 0;
		
		Timestamp courtOnTime = Timestamp.valueOf(req.getParameter("courtOnTime"));
		
		Timestamp courtApplyTime = Timestamp.valueOf(req.getParameter("courtApplyTime"));
		

		String courtName = req.getParameter("courtName");
		if (courtName == null || courtName.trim().isEmpty())
			errorMsgs.add("請輸入球館名稱");

		Integer status = Integer.valueOf(req.getParameter("status"));

		// 取得圖片
		byte[] courtPic = null;
		InputStream in = req.getPart("courtPic").getInputStream(); 
		// 從javax.servlet.http.Part物件取得上傳檔案的InputStream		
		if (in.available() != 0) {
			courtPic = new byte[in.available()];
			in.read(courtPic);
			in.close();
		} else {
			CourtService courtService = new CourtService();
			courtPic = courtService.getOneCourt(courtID).getCourtPic();
		}

		String courtTelephone = req.getParameter("courtTelephone");
		String courtTelephoneReg = "^(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{7,14}$";
		if (courtTelephone == null || courtTelephone.trim().isEmpty()) {
			errorMsgs.add("球館電話: 請勿空白");
		} else if (!courtTelephone.trim().matches(courtTelephoneReg)) {
			errorMsgs.add("請輸入正確的球館電話格式");
		}
		
		String courtAddress = req.getParameter("courtAddress");
		if (courtAddress == null || courtAddress.trim().isEmpty())
			errorMsgs.add("請輸入球館地址");
		
		String courtRule = req.getParameter("courtRule");
		if (courtRule == null || courtRule.trim().isEmpty())
			errorMsgs.add("請輸入球館須知");
		
		String loc = req.getParameter("loc");
		if (loc == null || loc.trim().isEmpty())
			errorMsgs.add("請輸入球館地區");
		
		Integer courtApplyStatus = Integer.valueOf(req.getParameter("courtApplyStatus"));
		
		Time courtOpenTime = Time.valueOf(req.getParameter("courtOpenTime"));
		
		Time courtCloseTime = Time.valueOf(req.getParameter("courtCloseTime"));
		
//		String placeName = String.valueOf(req.getParameter("placeName").trim());
//		
//		Integer placeFee = Integer.valueOf(req.getParameter("placeFee").trim());
//		
//		Integer ball = Integer.valueOf(req.getParameter("ball").trim());
		


		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		Court court = new Court();
//		Place place = new Place();
		
		court.setCourtID(courtID);
		court.getOwnerUser().setoUserID(oUserID);
		court.getManage().setManageID(manageID);
		court.setCourtOnTime(courtOnTime);
		court.setCourtApplyTime(courtApplyTime);
		court.setCourtName(courtName);
		court.setCourtPic(courtPic);
		court.setCourtTelephone(courtTelephone);
		court.setCourtAddress(courtAddress);
		court.setCourtRule(courtRule);
		court.setLoc(loc);
		court.setCourtApplyStatus(courtApplyStatus);
		court.setCourtOpenTime(courtOpenTime);
		court.setCourtCloseTime(courtCloseTime);
//		((Place) court.getPlace()).setPlaceName(placeName);
//		((Place) court.getPlace()).setPlaceFee(placeFee);
//		((Place) court.getPlace()).setBall(ball);

		court.toString();
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("court", court); // 含有輸入格式錯誤的empVO物件,也存入req
			return "owneruser/court/new_court.jsp";
		}
// ========================================================================改到這===============

		/*************************** 2.開始新增資料 ***************************************/
		courtService.insertCourt(courtOnTime, courtApplyTime, courtName,  courtPic, courtTelephone
				,courtAddress, courtRule, loc,  courtApplyStatus
				, courtOpenTime, courtCloseTime);
		System.out.println(newCourt);
		req.setAttribute("newCourt", newCourt); 

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		return "owneruser/court/all_court.jsp";

	}
	//========================================================//
	//                          登出                           //
	//========================================================//
	
	private String logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // 登出，终止session
            System.out.println("成功登出");
        }

        res.setHeader("Cache-Control","no-cache"); 
        res.setHeader("Pragma","no-cache");
        res.setDateHeader ("Expires", 0);
        
        return "/login/oLogin/oUserLogin.jsp";
	}	

}