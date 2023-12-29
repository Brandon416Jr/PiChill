package com.pichill.frontstage.owneruser.controller;

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
import javax.servlet.http.Part;

import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;

import com.pichill.owneruser.entity.OwnerUser;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 1000 * 1024 * 1024)
@WebServlet("/ownerasso/owneruserassof.do")
public class oUserAssoController extends HttpServlet {
	private OwnerUserServiceFront oUserSvcF = new OwnerUserServiceFront();
	
	@Override
	public void init() throws ServletException {
		oUserSvcF = new OwnerUserServiceFront();
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
			forwardPath = getOneDisplay(req, res);
			break;
		case "getOneUpdate":
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			forwardPath = update(req, res);
			break;
		default:
			forwardPath = "/homepage/owneruserhome.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
		
		String str = req.getParameter("oUserID");

		if (str == null || (str.trim()).length() == 0) {
			errorMsgs.add("請輸入會員編號");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/homepage/owneruserhome.jsp";// 程式中斷
		}

		Integer oUserID = null;
		try {
			oUserID = Integer.valueOf(str);
		} catch (Exception e) {
			errorMsgs.add("會員編號格式不正確");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/homepage/owneruserhome.jsp";// 程式中斷
		}
		
	/*=========================================== 2.開始查詢資料 ===========================================*/
		
		OwnerUser ownerUser = oUserSvcF.getOneOwnerUser(oUserID);

		if (ownerUser == null) {
			errorMsgs.add("查無資料");
		}
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			return "/homepage/main.jsp";// 程式中斷
		}

	/*================================= 3.查詢完成,準備轉交(Send the Success view) ==========================*/
		
		req.setAttribute("ownerUser", ownerUser); // 資料庫取出的generalUser物件,存入req
		return "/testoUser/ouserlistOne.jsp";
	}

	/*===================================================================================================*/
	/*                                                修改                                                */
	/*===================================================================================================*/
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));

		OwnerUser ownerUser = oUserSvcF.getOneOwnerUser(oUserID);
		
		req.setAttribute("ownerUser", ownerUser);
		return "/testoUser/owneruser.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

	/*==================================== 1.接收請求參數 - 輸入格式的錯誤處理 ==================================*/
		
		String oUserIDstr = req.getParameter("oUserID");
		System.out.println("從JSP拿來的字串: " + oUserIDstr);
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
		System.out.println("oUserID =" + oUserID);
		if (oUserID == null) {
			System.out.println("oUserID是空值");
			oUserID =0;
		}

		String oName = req.getParameter("oName");
		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (oName == null || oName.trim().length() == 0) {
			errorMsgs.add("會員姓名: 請勿空白");
		} else if (!oName.trim().matches(oNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String oUserName = req.getParameter("oUserName");
		String oUserNameReg = "^[a-zA-Z0-9]{8,12}$";
		if (oUserName == null || oUserName.trim().length() == 0) {
			errorMsgs.add("會員帳號: 請勿空白");
		} else if (!oUserName.trim().matches(oUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的會員帳號");
		}

		String oPassword = req.getParameter("oPassword");
		String oPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (oPassword == null || oPassword.trim().length() == 0) {
			errorMsgs.add("會員密碼: 請勿空白");
		} else if (!oPassword.trim().matches(oPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}
		

		String oEmail = req.getParameter("oEmail");
		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oEmail == null || oEmail.trim().length() == 0) {
			errorMsgs.add("電子信箱: 請勿空白");
		} else if (!oEmail.trim().matches(oEmailReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("請輸入正確的電子信箱格式");
		}
		
		String oIDNum = req.getParameter("oIDNum");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (oIDNum == null || idnoRegex.trim().isEmpty()) {
			errorMsgs.add("身分證字號: 請勿空白");
		} else if (!oIDNum.trim().matches(idnoRegex)) {
			errorMsgs.add("請輸入正確的身分證格式");
		}

//		Integer oGender = Integer.valueOf(req.getParameter("oGender"));

//		Date oBirth = null;
//		try {
//			oBirth = java.sql.Date.valueOf(req.getParameter("oBirth").trim());
//		} catch (IllegalArgumentException e) {
//			oBirth = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請輸入生日!");
//		}

		String oTelephone = req.getParameter("oTelephone");
		String oTelephoneReg = "^09[0-9]{8}$";
		if (oTelephone == null || oTelephone.trim().isEmpty()) {
			errorMsgs.add("手機號碼: 請勿空白");
		} else if (!oTelephone.trim().matches(oTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機號碼格式");
		}

		
		String oAddress = req.getParameter("oAddress");
		if (oAddress == null || oAddress.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		
		

//		Integer oStatus = 1;

		// 取得圖片
		Part part = req.getPart("oProfilePic");
		System.out.println(part);
		InputStream in = res.getPart("oProfilePic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] oProfilePic = null;
		if(in.available()!=0){
			oProfilePic = new byte[in.available()];
			in.read(oProfilePic);
			in.close();
		}  else {
			OwnerUserServiceFront oUserSvcF = new OwnerUserServiceFront();
			oProfilePic = oUserSvcF.getOneOwnerUser(oUserID).getoProfilePic();
		}
		
		

//		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer oPostAmount = 0;

//		Integer courtArriveCnt = 0;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer oReportCnt = 0;

//		頁面不顯示直接先給空值
//		Date oRegistDate = null;

//		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer rsvdCnts = 0;

		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		
		String compiled = req.getParameter("compiled");
		
		String oBankAccount = req.getParameter("oBankAccount");
		
		String oBankCode = req.getParameter("oBankCode");
		
		OwnerUser ownerUser = new OwnerUser();
		ownerUser.setcompiled(compiled);
//		ownerUser.setCourtArriveCnt(courtArriveCnt);
		ownerUser.setoAddress(oAddress);
//		ownerUser.setoBirth(oBirth);
		ownerUser.setoBankAccount(oBankAccount);
		ownerUser.setoBankCode(oBankCode);
//		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoPassword(oPassword);
//		ownerUser.setoPostAmount(oPostAmount);
//		ownerUser.setoReportCnt(oReportCnt);
//		ownerUser.setoGender(oGender);
		ownerUser.setoUserName(oUserName);
//		ownerUser.setoIDNum(oIDNum);
		ownerUser.setoUserName(oUserName);
//		ownerUser.setoUserID(oUserID);
//		ownerUser.setoStatus(oStatus);
		ownerUser.setoProfilePic(oProfilePic);
		ownerUser.setoTelephone(oTelephone);
		ownerUser.setoEmail(oEmail);
		
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的generalUser物件,也存入req
			return "/testoUser/owneruser.jsp"; // 程式中斷
		}
		
	/*=========================================== 2.開始修改資料 ===========================================*/

		oUserSvcF.updateOwnerUserByAll( oUserID,  oUserName,  oName,  oPassword,
				oTelephone,  oAddress, oEmail,  oProfilePic,  compiled,  oBankCode, oBankAccount);

	/*================================= 3.修改完成,準備轉交(Send the Success view) ==========================*/
		
		req.setAttribute("ownerUser", ownerUser); // 資料庫update成功後,正確的的generalUser物件,存入req
		return "/testoUser/ouserlistOne.jsp";
	}
}
