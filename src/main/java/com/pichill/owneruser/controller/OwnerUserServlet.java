package com.pichill.owneruser.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
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

import com.pichill.manage.entity.Manage;
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
		System.out.println(action);
		String forwardPath = "";
		if(action != null){
			  action.hashCode(); 
			} else {
				System.out.println("action為空值");
			}
		switch (action) {
		case "getOne_For_Display":
			// // 來自select_page.jsp的請求
			forwardPath = getOneDisplay(req, res);
			break;
		case "getOne_For_Update":
			// 來自all_owneruser.jsp的請求
			forwardPath = getOne_For_Update(req, res);
			break;
		case "update":
			// 來自owneruser.jsp的請求
			forwardPath = update(req, res);
			break;
		case "update_myData":
			//來自owneruser.jsp
			forwardPath = update_myData(req, res);
			break;
		case "logout":
			forwardPath = logout(req, res);
			break;			
//		case "insert":
//			// 來自new_OwnerUser.jsp的請求
//			forwardPath = insert(req, res);
//			break;
		default:
			forwardPath = "owneruser/select_page.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	/*===================================================================================================*/
	/*                                                查詢One                                                */
	/*===================================================================================================*/
	
	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		String str = req.getParameter("oUserID");

		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入會員編號");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/owneruser/owneruser/select_page.jsp";// 程式中斷
		}

		Integer oUserID = null;
		try {
			oUserID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("會員編號格式不正確");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/owneruser/select_page.jsp";// 程式中斷
		}

		/*************************** 2.開始查詢資料 *****************************************/
		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);

		if (ownerUser == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/owneruser/select_page.jsp";// 程式中斷
		}

		/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
		req.setAttribute("ownerUser", ownerUser); // 資料庫取出的ownerUser物件,存入req
		return "/owneruser/set_owneruser.jsp";
	}

	
	
	//=================修改===================================================
	
	
	private String getOne_For_Update(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("成功getOneUpdate");
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);

		req.setAttribute("ownerUser", ownerUser);
		return "/owneruser/owneruser.jsp";
	}

	
	
	//=================修改=============================
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		System.out.println("成功update");
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);
		
		String oName = req.getParameter("oName");
		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (oName == null || oName.trim().length() == 0) {
			errorMsgs.add("企業會員姓名: 請勿空白");
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
		String oTelephoneReg = "^09[0-9]{8}$";
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
		String oBkARegex = "^[1-9]{13}$";
		if (oBankAccount == null || oBkARegex.trim().isEmpty()) {
			errorMsgs.add("銀行帳號: 請勿空白");
		} else if (!oBankAccount.trim().matches(oBkARegex)) {
			errorMsgs.add("請輸入正確的銀行帳號格式");
		}
		

		// 取得圖片
		
		InputStream in = req.getPart("oProfilePic").getInputStream(); 
		// 從javax.servlet.http.Part物件取得上傳檔案的InputStream	
		byte[] oProfilePic = null;
		if (in.available() != 0) {
			oProfilePic = new byte[in.available()];
			in.read(oProfilePic);
			in.close();
		} else {
			OwnerUserService ownerUserService = new OwnerUserService();
			oProfilePic = ownerUserService.getOneOwnerUser(oUserID).getoProfilePic();
		}

		// 頁面不顯示直接先給空值
//		Date oRegisterDate = Date.valueOf(req.getParameter("oRegisterDate"));
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer oPostAmount = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer oReportCnt = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer rsvdCnts = 0;
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer courtArriveCnt = 0;
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer oStatus = 0;	
		
		
		
		String oEmail = req.getParameter("oEmail");
		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oEmail == null || oEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!oEmail.trim().matches(oEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}


		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		OwnerUser owneruser = new OwnerUser();
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
//		ownerUser.setoRegisterDate(oRegisterDate);
		ownerUser.setoPostAmount(oPostAmount);
		ownerUser.setoReportCnt(oReportCnt);
		ownerUser.setCourtArriveCnt(courtArriveCnt);
		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoEmail(oEmail);
		ownerUser.setoStatus(oStatus);	
		ownerUser.toString();


		

		if (!errorMsgs.isEmpty()) {
			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的ownerUser物件,也存入req
			return "/owneruser/owneruser.jsp"; // 程式中斷
		}
		/*************************** 2.開始修改資料 *****************************************/

		ownerUserService.updateOwnerUser(ownerUser);
		req.setAttribute("ownerUser", ownerUserService.getOneOwnerUser(oUserID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("ownerUser", ownerUser); // 資料庫update成功後,正確的的empVO物件,存入req
		return "/owneruser/ouserListOne.jsp";
	}
	
	
	//=================update_myData=============================
	
	private String update_myData(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("成功update");
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		
		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		OwnerUser ownerUser = ownerUserService.getOneOwnerUser(oUserID);
		
		String oName = req.getParameter("oName");
		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (oName == null || oName.trim().length() == 0) {
			errorMsgs.add("企業會員姓名: 請勿空白");
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
		String oTelephoneReg = "^09[0-9]{8}$";
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
		
		InputStream in = req.getPart("oProfilePic").getInputStream(); 
		// 從javax.servlet.http.Part物件取得上傳檔案的InputStream	
		byte[] oProfilePic = null;
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
		
//		頁面不顯示，所以直接給0，之後用程式碼去計算
		Integer oStatus = 0;	
		
		
		
		String oEmail = req.getParameter("oEmail");
		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oEmail == null || oEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!oEmail.trim().matches(oEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}


		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
//		OwnerUser ownerUser = new OwnerUser();
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
		ownerUser.setoStatus(oStatus);	
		ownerUser.toString();


		

		if (!errorMsgs.isEmpty()) {
			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的ownerUser物件,也存入req
			return "/owneruser/owneruser.jsp"; // 程式中斷
		}
		/*************************** 2.開始修改資料 *****************************************/

		ownerUserService.updateOwnerUser(ownerUser);
		req.setAttribute("ownerUser", ownerUserService.getOneOwnerUser(oUserID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("ownerUser", ownerUser); // 資料庫update成功後,正確的的empVO物件,存入req
		return "/owneruser/owneruser.jsp";
		
		
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
	
	
	
	
	
	
	
	

		//=========== insert 資料==============//
//		private String insert(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		System.out.println("成功insert");
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
//		String oName = req.getParameter("oName");
//		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
//		if (oName == null || oName.trim().length() == 0) {
//			errorMsgs.add("企業會員姓名: 請勿空白");
//		} else if (!oName.trim().matches(oNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於等於2個字");
//		}
//
//		String oUserName = req.getParameter("oUserName");
//		String oUserNameReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//		if (oUserName == null || oUserName.trim().length() == 0) {
//			errorMsgs.add("會員帳號: 請勿空白");
//		} else if (!oUserName.trim().matches(oUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("請輸入正確的Email格式");
//		}
//
//		String oPassword = req.getParameter("oPassword");
//		String oPasswordReg = "^[a-zA-Z0-9]{8,12}$";
//		if (oPassword == null || oPassword.trim().length() == 0) {
//			errorMsgs.add("會員密碼: 請勿空白");
//		} else if (!oPassword.trim().matches(oPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
//			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
//		}
//
//		String oIDNum = req.getParameter("oIDNum");
//		String idnoRegex = "^[A-Z][12][0-9]{8}$";
//		if (oIDNum == null || idnoRegex.trim().isEmpty()) {
//			errorMsgs.add("身份證: 請勿空白");
//		} else if (!oIDNum.trim().matches(idnoRegex)) {
//			errorMsgs.add("請輸入正確的身份證格式");
//		}
//
//		String compiled = req.getParameter("compiled");
//		String compRegex = "^[0-9]{8}$";
//		if (compiled == null || compRegex.trim().isEmpty()) {
//			errorMsgs.add("統編: 請勿空白");
//		} else if (!compiled.trim().matches(compRegex)) {
//			errorMsgs.add("請輸入正確的統一編號格式");
//		}
//
//		Integer oGender = Integer.valueOf(req.getParameter("oGender"));
//
//		Date oBirth = null;
//		try {
//			oBirth = java.sql.Date.valueOf(req.getParameter("oBirth").trim());
//		} catch (IllegalArgumentException e) {
//			oBirth = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請輸入生日!");
//		}
//
//		String oTelephone = req.getParameter("oTelephone");
//		String oTelephoneReg = "^09[0-9]{8}$";
//		if (oTelephone == null || oTelephone.trim().isEmpty()) {
//			errorMsgs.add("聯絡電話: 請勿空白");
//		} else if (!oTelephone.trim().matches(oTelephoneReg)) {
//			errorMsgs.add("請輸入正確的電話格式");
//		}
//
//		String oAddress = req.getParameter("oAddress");
//		if (oAddress == null || oAddress.trim().isEmpty())
//			errorMsgs.add("請輸入地址");
//		
//		String oBankCode = req.getParameter("oBankCode");
//		String oBcRegex = "^[0-9]{3}$";
//		if (oBankCode == null || oBcRegex.trim().isEmpty()) {
//			errorMsgs.add("銀行代碼: 請勿空白");
//		} else if (!oBankCode.trim().matches(oBcRegex)) {
//			errorMsgs.add("請輸入正確的銀行代碼格式");
//		}
//		
//		String oBankAccount = req.getParameter("oBankAccount");
//		String oBkARegex = "^[0-9]{3}$";
//		if (oBankAccount == null || oBkARegex.trim().isEmpty()) {
//			errorMsgs.add("銀行帳號: 請勿空白");
//		} else if (!oBankAccount.trim().matches(oBkARegex)) {
//			errorMsgs.add("請輸入正確的銀行帳號格式");
//		}
//		
//		// 圖片，need to ask question!
//		InputStream in = req.getPart("oProfilePic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
//		byte[] oProfilePic = null;
//		if(in.available()!=0){
//			oProfilePic = new byte[in.available()];
//			in.read(oProfilePic);
//			in.close();
//		}  else errorMsgs.add("員工照片: 請上傳照片");
//	
//
//		// 頁面不顯示直接先給空值
//		Date oRegisterDate = Date.valueOf(req.getParameter("oRegisterDate"));
//		
////		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer oPostAmount = 0;
//
////		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer oReportCnt = 0;
//
////		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer rsvdCnts = 0;
//		
////		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer courtArriveCnt = 0;
//		
//		
//		String oEmail = req.getParameter("oEmail");
//		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//		if (oEmail == null || oEmail.trim().isEmpty()) {
//			errorMsgs.add("Email: 請勿空白");
//		} else if (!oEmail.trim().matches(oEmailReg)) {
//			errorMsgs.add("請輸入正確的Email格式");
//		}
//
//
//		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
//		OwnerUser ownerUser = new OwnerUser();
//		ownerUser.setoUserName(oUserName);
//		ownerUser.setoPassword(oPassword);
//		ownerUser.setoIDNum(oIDNum);
//		ownerUser.setcompiled(compiled);
//		ownerUser.setoName(oName);
//		ownerUser.setoGender(oGender);
//		ownerUser.setoBirth(oBirth);
//		ownerUser.setoTelephone(oTelephone);
//		ownerUser.setoAddress(oAddress);
//		ownerUser.setoBankCode(oBankCode);
//		ownerUser.setoBankAccount(oBankAccount);
//		ownerUser.setoProfilePic(oProfilePic);
//		ownerUser.setoRegisterDate(oRegisterDate);
//		ownerUser.setoPostAmount(oPostAmount);
//		ownerUser.setoReportCnt(oReportCnt);
//		ownerUser.setCourtArriveCnt(courtArriveCnt);
//		ownerUser.setRsvdCnts(rsvdCnts);
//		ownerUser.setoEmail(oEmail);
//
//	// Send the use back to the form, if there were errors
//		if (!errorMsgs.isEmpty()) {
//			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的empVO物件,也存入req
//			return "/owneruser/add_OwnerUser.jsp";
//		}
//
//		/*************************** 2.開始新增資料 ***************************************/
//		ownerUserService.addOwnerUser(ownerUser);
//
//		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
//		return "/owneruser/all_OwnerUser.jsp";
//
//	}

}
