package com.pichill.generaluser.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.service.GeneralUserService;

@WebServlet(name = "GeneralUserServlet", value = "/generaluser/generaluser.do")
public class GeneralUserServlet extends HttpServlet {
	private GeneralUserService generalUserService;

	@Override
	public void init() throws ServletException {
		generalUserService = new GeneralUserService();
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
		case "getOne_For_Display":
			// // 來自select_page.jsp的請求
			forwardPath = getOneDisplay(req, res);
			break;
		case "getOne_For_Update":
			// 來自listAllGeneralUser.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自update_GeneralUser_input.jsp的請求
			forwardPath = update(req, res);
			break;
		case "insert":
			// 來自addGeneralUser.jsp的請求
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/generaluser/select_page.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		String str = req.getParameter("gUserID");

		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入會員編號");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/generaluser/select_page.jsp";// 程式中斷
		}

		Integer gUserID = null;
		try {
			gUserID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("會員編號格式不正確");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/generaluser/select_page.jsp";// 程式中斷
		}

		/*************************** 2.開始查詢資料 *****************************************/
		GeneralUser generalUser = generalUserService.getOneGeneralUser(gUserID);

		if (generalUser == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/generaluser/select_page.jsp";// 程式中斷
		}

		/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
		req.setAttribute("generalUser", generalUser); // 資料庫取出的generalUser物件,存入req
		return "/generaluser/listOneGeneralUser.jsp";
	}

	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));

		GeneralUser generalUser = generalUserService.getOneGeneralUser(gUserID);

		req.setAttribute("generalUser", generalUser);
		return "/generaluser/update_GeneralUser_input.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));

		String gName = req.getParameter("gName");
		String gNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (gName == null || gName.trim().length() == 0) {
			errorMsgs.add("會員姓名: 請勿空白");
		} else if (!gName.trim().matches(gNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String gEmail = req.getParameter("gEmail");
		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (gEmail == null || gEmail.trim().length() == 0) {
			errorMsgs.add("會員帳號: 請勿空白");
		} else if (!gEmail.trim().matches(gEmailReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的Email格式");
		}

		String gPassword = req.getParameter("gPassword");
		String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (gPassword == null || gPassword.trim().length() == 0) {
			errorMsgs.add("會員密碼: 請勿空白");
		} else if (!gPassword.trim().matches(gPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String gIDNum = req.getParameter("gIDNum");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (gIDNum == null || idnoRegex.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!gIDNum.trim().matches(idnoRegex)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}

		Integer gGender = Integer.valueOf(req.getParameter("gGender"));

		Date gBirth = null;
		try {
			gBirth = java.sql.Date.valueOf(req.getParameter("gBirth").trim());
		} catch (IllegalArgumentException e) {
			gBirth = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入生日!");
		}

		String gTelephone = req.getParameter("gTelephone");
		String gTelephoneReg = "^09[0-9]{8}$";
		if (gTelephone == null || gTelephone.trim().isEmpty()) {
			errorMsgs.add("聯絡電話: 請勿空白");
		} else if (!gTelephone.trim().matches(gTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String gAddress = req.getParameter("gAddress");
		if (gAddress == null || gAddress.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		Integer status = Integer.valueOf(req.getParameter("status"));

		// 取得圖片，need to ask question!
//		Byte[] gProfilePic = null;

		// default null，頁面不顯示直接先給空值
		String nicknameID = null;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer gPostAmount = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer commentAmount = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer gReportCnt = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer purchaseCnt = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer yoyakuCnt = 0;

		// 頁面不顯示直接先給空值
		Date gRegistDate = null;

		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		GeneralUser generalUser = new GeneralUser();
		generalUser.setgUserID(gUserID);
		generalUser.setgName(gName);
		generalUser.setgTelephone(gTelephone);
		generalUser.setgEmail(gEmail);
		generalUser.setgAddress(gAddress);
		generalUser.setStatus(status);
		generalUser.setgGender(gGender);
		generalUser.setgPassword(gPassword);
		generalUser.setgIDNum(gIDNum);
		generalUser.setNicknameID(nicknameID);
		generalUser.setgPostAmount(gPostAmount);
		generalUser.setCommentAmount(commentAmount);
		generalUser.setgReportCnt(gReportCnt);
		generalUser.setgRegistDate(gRegistDate);
		generalUser.setgBirth(gBirth);
		generalUser.setYoyakuCnt(yoyakuCnt);
		
		generalUser.toString();
//generalUser.setgProfilePic(gProfilePic);

		// ========================================================================改到這===============

		if (!errorMsgs.isEmpty()) {
			req.setAttribute("generalUser", generalUser); // 含有輸入格式錯誤的manage物件,也存入req
			return "/generaluser/update_GeneralUser_input.jsp"; // 程式中斷
		}
		/*************************** 2.開始修改資料 *****************************************/

		generalUserService.updateGeneralUser(generalUser);
		req.setAttribute("generalUser", generalUserService.getOneGeneralUser(gUserID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("generalUser", generalUser); // 資料庫update成功後,正確的的empVO物件,存入req
		return "/generaluser/listOneGeneralUser.jsp";
	}

	
	// insert 資料
	private String insert(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String gName = req.getParameter("gName");
		String gNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (gName == null || gName.trim().length() == 0) {
			errorMsgs.add("會員姓名: 請勿空白11111");
		} else if (!gName.trim().matches(gNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於等於2個字");
		}

		String gEmail = req.getParameter("gEmail");
		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (gEmail == null || gEmail.trim().length() == 0) {
			errorMsgs.add("會員帳號: 請勿空白");
		} else if (!gEmail.trim().matches(gEmailReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的Email格式");
		}

		String gPassword = req.getParameter("gPassword");
		String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (gPassword == null || gPassword.trim().length() == 0) {
			errorMsgs.add("會員密碼: 請勿空白");
		} else if (!gPassword.trim().matches(gPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String gIDNum = req.getParameter("gIDNum");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (gIDNum == null || gIDNum.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!gIDNum.trim().matches(idnoRegex)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}

		Integer gGender = Integer.valueOf(req.getParameter("gGender"));

		Date gBirth = null;
		try {
			gBirth = java.sql.Date.valueOf(req.getParameter("gBirth").trim());
		} catch (IllegalArgumentException e) {
			gBirth = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入生日!");
		}

		String gTelephone = req.getParameter("gTelephone");
		String gTelephoneReg = "^09[0-9]{8}$";
		if (gTelephone == null || gTelephone.trim().isEmpty()) {
			errorMsgs.add("聯絡電話: 請勿空白");
		} else if (!gTelephone.trim().matches(gTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String gAddress = req.getParameter("gAddress");
		if (gAddress == null || gAddress.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		Integer status = Integer.valueOf(req.getParameter("status"));

		String nicknameID = null;

		Integer gPostAmount = 0;

		Integer commentAmount = 0;

		Integer gReportCnt = 0;

		Integer yoyakuCnt = 0;

		Byte[] gProfilePic = null;

		Date gRegistDate = null;


		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		GeneralUser generalUser = new GeneralUser();
		generalUser.setgName(gName);
		generalUser.setgTelephone(gTelephone);
		generalUser.setgEmail(gEmail);
		generalUser.setgAddress(gAddress);
		generalUser.setStatus(status);
		generalUser.setgGender(gGender);
		generalUser.setgPassword(gPassword);
		generalUser.setgIDNum(gIDNum);
		generalUser.setNicknameID(nicknameID);
		generalUser.setgPostAmount(gPostAmount);
		generalUser.setCommentAmount(commentAmount);
		generalUser.setgReportCnt(gReportCnt);
		generalUser.setgRegistDate(gRegistDate);
		generalUser.setgBirth(gBirth);
		generalUser.setYoyakuCnt(yoyakuCnt);
//		generalUser.setgProfilePic(gProfilePic);

		generalUser.toString();
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("generalUser", generalUser); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/generaluser/addGeneralUser.jsp";
		}
// ========================================================================改到這===============

		/*************************** 2.開始新增資料 ***************************************/
		generalUserService.addGeneralUser(generalUser);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		return "/generaluser/listAllGeneralUser.jsp";

	}

}
