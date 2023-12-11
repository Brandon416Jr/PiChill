package com.pichill.owneruser.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.owneruser.service.OwnerUserService;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "OwnerUserServlet", value = "/owneruser/owneruser.do")
public class OwnerUserServlet extends HttpServlet {
	private OwnerUserService ownerUserService;

	@Override
	public void init() throws ServletException {
		ownerUserService = new OwnerUserService();
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
//			// // 來自select_page.jsp的請求
//			forwardPath = getOneDisplay(req, res);
//			break;
		case "getOne_For_Update":
			// 來自listAllOwnerUser.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自setOwnerUser.jsp的請求
			forwardPath = update(req, res);
			break;
//		case "insert":
//			// 來自addOwnerUser.jsp的請求
//			forwardPath = insert(req, res);
//			break;
		default:
			forwardPath = "/owneruser/select_page.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

//	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//		String str = req.getParameter("gUserID");
//
//		if (str == null || (str.trim()).length() == 0) {
//			errorMsgs.add("請輸入會員編號");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/owneruser/select_page.jsp";// 程式中斷
//		}
//
//		Integer gUserID = null;
//		try {
//			gUserID = Integer.valueOf(str);
//		} catch (Exception e) {
//			errorMsgs.add("會員編號格式不正確");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/owneruser/select_page.jsp";// 程式中斷
//		}
//
//		/*************************** 2.開始查詢資料 *****************************************/
//		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);
//
//		if (ownerUser == null) {
//			errorMsgs.add("查無資料");
//		}
//		// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			return "/generaluser/select_page.jsp";// 程式中斷
//		}
//
//		/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
//		req.setAttribute("ownerUser", ownerUser); // 資料庫取出的ownerUser物件,存入req
//		return "/owneruser/listOneOwnerUser.jsp";
//	}

	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));

		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);

		req.setAttribute("ownerUser", ownerUser);
		return "/owneruser/setowneruser.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));

		String oName = req.getParameter("oName");
		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (oName == null || oName.trim().length() == 0) {
			errorMsgs.add("會員姓名: 請勿空白");
		} else if (!oName.trim().matches(oNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於等於2個字");
		}

		String oUserName = req.getParameter("oUserName");
		String oUserNameReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oUserName == null || oUserName.trim().length() == 0) {
			errorMsgs.add("會員帳號: 請勿空白");
		} else if (!oUserName.trim().matches(oUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的Email格式");
		}

		String oPassword = req.getParameter("oPassword");
		String oPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (oPassword == null || oPassword.trim().length() == 0) {
			errorMsgs.add("會員密碼: 請勿空白");
		} else if (!oPassword.trim().matches(oPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String oIDNum = req.getParameter("oIDNum");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (oIDNum == null || idnoRegex.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!oIDNum.trim().matches(idnoRegex)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}

		String compiled = req.getParameter("compiled");
		String compRegex = "^[0-9]{8}$";
		if (compiled == null || compRegex.trim().isEmpty()) {
			errorMsgs.add("統編: 請勿空白");
		} else if (!compiled.trim().matches(compRegex)) {
			errorMsgs.add("請輸入正確的統一編號格式");
		}

		Integer oGender = Integer.valueOf(req.getParameter("oGender"));

		Date oBirth = null;
		try {
			oBirth = java.sql.Date.valueOf(req.getParameter("oBirth").trim());
		} catch (IllegalArgumentException e) {
			oBirth = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入生日!");
		}

		String oTelephone = req.getParameter("oTelephone");
		String oTelephoneReg = "^0[0-9]{1}-[0-9]{8,}#[0-9]$";
		if (oTelephone == null || oTelephone.trim().isEmpty()) {
			errorMsgs.add("聯絡電話: 請勿空白");
		} else if (!oTelephone.trim().matches(oTelephoneReg)) {
			errorMsgs.add("請輸入正確的電話格式");
		}

		String oAddress = req.getParameter("oAddress");
		if (oAddress == null || oAddress.trim().isEmpty())
			errorMsgs.add("請輸入地址");
		
		String oBankCode = req.getParameter("oBankCode");
		String oBcRegex = "^[0-9]{3}$";
		if (oBankCode == null || oBcRegex.trim().isEmpty()) {
			errorMsgs.add("銀行代碼: 請勿空白");
		} else if (!oBankCode.trim().matches(oBcRegex)) {
			errorMsgs.add("請輸入正確的銀行代碼格式");
		}
		
		String oBankAccount = req.getParameter("oBankAccount");
		String oBkARegex = "^[0-9]{3}$";
		if (oBankAccount == null || oBkARegex.trim().isEmpty()) {
			errorMsgs.add("銀行帳號: 請勿空白");
		} else if (!oBankAccount.trim().matches(oBkARegex)) {
			errorMsgs.add("請輸入正確的銀行帳號格式");
		}
		

		// 取得圖片
		byte[] oProfilePic = null;
		InputStream in = req.getPart("oProfilePic").getInputStream(); 
		// 從javax.servlet.http.Part物件取得上傳檔案的InputStream		
		if (in.available() != 0) {
			oProfilePic = new byte[in.available()];
			in.read(oProfilePic);
			in.close();
		} else {
			OwnerUserService ownerUserService = new OwnerUserService();
			oProfilePic = ownerUserService.getOneOwnerUser(oUserID).getoProfilePic();
		}

		// 頁面不顯示直接先給空值
		Date oRegisterDate = Date.valueOf(req.getParameter("oRegisterDate"));
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer oPostAmount = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer oReportCnt = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer rsvdCnts = 0;
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer courtArriveCnt = 0;
		
		
		String oEmail = req.getParameter("oEmail");
		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oEmail == null || oEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!oEmail.trim().matches(oEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}


		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		OwnerUser ownerUser = new OwnerUser();
		ownerUser.setoUserID(oUserID);
		ownerUser.setoUserName(oUserName);
		ownerUser.setoPassword(oPassword);
		ownerUser.setoIDNum(oIDNum);
		ownerUser.setcompiled(compiled);
		ownerUser.setoName(oName);
		ownerUser.setoGender(oGender);
		ownerUser.setoBirth(oBirth);
		ownerUser.setoTelephone(oTelephone);
		ownerUser.setoAddress(oAddress);
		ownerUser.setoBankCode(oBankCode);
		ownerUser.setoBankAccount(oBankAccount);
		ownerUser.setoProfilePic(oProfilePic);
		ownerUser.setoRegisterDate(oRegisterDate);
		ownerUser.setoPostAmount(oPostAmount);
		ownerUser.setoReportCnt(oReportCnt);
		ownerUser.setCourtArriveCnt(courtArriveCnt);
		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoEmail(oEmail);

//		ownerUser.toString();

		// ========================================================================改到這===============

		if (!errorMsgs.isEmpty()) {
			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的ownerUser物件,也存入req
			return "/owneruser/set_owneruser.jsp"; // 程式中斷
		}
		/*************************** 2.開始修改資料 *****************************************/

		ownerUserService.updateOwnerUser(ownerUser);
		req.setAttribute("ownerUser", ownerUserService.getOneOwnerUser(oUserID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("ownerUser", ownerUser); // 資料庫update成功後,正確的的empVO物件,存入req
		return "/owneruser/set_owneruser.jsp";
	}

		// insert 資料
//		private String insert(HttpServletRequest req, HttpServletResponse res) {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//		String gName = req.getParameter("gName");
//		String gNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
//		if (gName == null || gName.trim().length() == 0) {
//			errorMsgs.add("會員姓名: 請勿空白11111");
//		} else if (!gName.trim().matches(gNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於等於2個字");
//		}
//
//		String gEmail = req.getParameter("gEmail");
//		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//		if (gEmail == null || gEmail.trim().length() == 0) {
//			errorMsgs.add("會員帳號: 請勿空白");
//		} else if (!gEmail.trim().matches(gEmailReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("請輸入正確的Email格式");
//		}
//
//		String gPassword = req.getParameter("gPassword");
//		String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
//		if (gPassword == null || gPassword.trim().length() == 0) {
//			errorMsgs.add("會員密碼: 請勿空白");
//		} else if (!gPassword.trim().matches(gPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
//		}
//
//		String gIDNum = req.getParameter("gIDNum");
//		String idnoRegex = "^[A-Z][12][0-9]{8}$";
//		if (gIDNum == null || gIDNum.trim().isEmpty()) {
//			errorMsgs.add("身份證: 請勿空白");
//		} else if (!gIDNum.trim().matches(idnoRegex)) {
//			errorMsgs.add("請輸入正確的身份證格式");
//		}
//
//		Integer gGender = Integer.valueOf(req.getParameter("gGender"));
//
//		Date gBirth = null;
//		try {
//			gBirth = java.sql.Date.valueOf(req.getParameter("gBirth").trim());
//		} catch (IllegalArgumentException e) {
//			gBirth = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請輸入生日!");
//		}
//
//		String gTelephone = req.getParameter("gTelephone");
//		String gTelephoneReg = "^09[0-9]{8}$";
//		if (gTelephone == null || gTelephone.trim().isEmpty()) {
//			errorMsgs.add("聯絡電話: 請勿空白");
//		} else if (!gTelephone.trim().matches(gTelephoneReg)) {
//			errorMsgs.add("請輸入正確的手機格式");
//		}
//
//		String gAddress = req.getParameter("gAddress");
//		if (gAddress == null || gAddress.trim().isEmpty())
//			errorMsgs.add("請輸入地址");
//
//		Integer status = Integer.valueOf(req.getParameter("status"));
//
//		String nicknameID = null;
//
//		Integer piAmount = 0;
//
//		Integer gPostAmount = 0;
//
//		Integer commentAmount = 0;
//
//		Integer gReportCnt = 0;
//
//		Integer purchaseCnt = 0;
//
//		Integer yoyakuCnt = 0;
//
//		Byte[] gProfilePic = null;
//
//		Date gRegistDate = null;
//
		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
//	OwnerUser ownerUser = new OwnerUser();
//	ownerUser.setoUserID(oUserID);
//	ownerUser.setoUserName(oUserName);
//	ownerUser.setoPassword(oPassword);
//	ownerUser.setoIDNum(oIDNum);
//	ownerUser.setcompiled(compiled);
//	ownerUser.setoName(oName);
//	ownerUser.setoGender(oGender);
//	ownerUser.setoBirth(oBirth);
//	ownerUser.setoTelephone(oTelephone);
//	ownerUser.setoAddress(oAddress);
//	ownerUser.setoBankCode(oBankCode);
//	ownerUser.setoBankAccount(oBankAccount);
//	ownerUser.setoProfilePic(oProfilePic);
//	ownerUser.setoRegisterDate(oRegisterDate);
//	ownerUser.setoPostAmount(oPostAmount);
//	ownerUser.setoReportCnt(oReportCnt);
//	ownerUser.setCourtArriveCnt(courtArriveCnt);
//	ownerUser.setRsvdCnts(rsvdCnts);
//	ownerUser.setoEmail(oEmail);

//	ownerUser.toString();

	// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			req.setAttribute("generalUser", generalUser); // 含有輸入格式錯誤的empVO物件,也存入req
//			return "/generaluser/addGeneralUser.jsp";
//		}
//// ========================================================================改到這===============
//
//		/*************************** 2.開始新增資料 ***************************************/
//		generalUserService.addGeneralUser(generalUser);
//
//		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//		return "/generaluser/listAllGeneralUser.jsp";
//
//	}

}
