package com.pichill.backstage.owneruser.controller;

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

import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.owneruser.OwnerUser;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "OwnerUserBServlet", value = "/owneruser/owneruserb.do")
public class OwnerUserServletBack extends HttpServlet {
	private OwnerUserServiceBack oUserSvcB;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		oUserSvcB = new OwnerUserServiceBack();
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
//		case "getOne_For_Display":
//			// // 來自index.jsp的請求
//			forwardPath = getOneDisplay(req, res);
//			break;
		case "getOne_For_Update":
			// 來自all_manage.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自set_manage.jsp的請求
			forwardPath = update(req, res);
			break;
		default:
			forwardPath = "/backstage/ownerUserBack/all_oUser.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res)  {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));

		OwnerUser ownerUser = oUserSvcB.getOneOwnerUser(oUserID);
	
		req.setAttribute("ownerUser", ownerUser);
		return "/backstage/ownerUserBack/set_oUser.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));

		String oUserName = req.getParameter("oUserName");
		String oUserNameReg = "^[a-zA-Z0-9]{8,12}$";
		if (oUserName == null || oUserName.trim().length() == 0) {
			errorMsgs.add("會員帳號: 請勿空白");
		} else if (!oUserName.trim().matches(oUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}
		
		String oPassword = req.getParameter("oPassword");
		String oPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (oPassword == null || oPassword.trim().length() == 0) {
			errorMsgs.add("會員密碼: 請勿空白");
		} else if (!oPassword.trim().matches(oPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}
		
		String oIDNum = req.getParameter("oIDNum");
		String oIDReg = "^[A-Z][12][0-9]{8}$";
		if (oIDNum == null || oIDNum.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!oIDNum.trim().matches(oIDReg)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}
		
		String compiled = req.getParameter("compiled");
		String compiledReg = "^[0-9]{8}$";
		if (compiled == null || oIDNum.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!compiled.trim().matches(compiledReg)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}
		
		String oName = req.getParameter("oName");
		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (oName == null || oName.trim().length() == 0) {
			errorMsgs.add("會員姓名: 請勿空白");
		} else if (!oName.trim().matches(oNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員姓名: 只能是中文, 且長度必需大於2個字");
		}
		
		Integer oGender = Integer.valueOf(req.getParameter("oGender"));

		Date oBirth = null;
		try {
			oBirth = java.sql.Date.valueOf(req.getParameter("oBirth").trim());
		} catch (IllegalArgumentException e) {
			errorMsgs.add("請輸入生日!");
		}
		
		String oTelephone = req.getParameter("oTelephone");
		String oTelephoneReg = "^09[0-9]{8}$";
		if (oTelephone == null || oTelephone.trim().isEmpty()) {
			errorMsgs.add("手機: 請勿空白");
		} else if (!oTelephone.trim().matches(oTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}
		
		String address = req.getParameter("oAddress");
		if (address == null || address.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		String city = req.getParameter("city");

		String area = req.getParameter("area");

		String oAddress = city + area + address;
		
		String oBankCode = req.getParameter("oBankCode");
		String oBankCodeReg = "^\\d{3}$";
		if (oBankCode == null || oIDNum.trim().isEmpty()) {
			errorMsgs.add("銀行代碼: 請勿空白");
		} else if (!oBankCode.trim().matches(oBankCodeReg)) {
			errorMsgs.add("請輸入正確的銀行代碼格式");
		}
		
		String oBankAccount = req.getParameter("oBankAccount");
		String oBankAccountReg = "^[1-9](\\d{9,13})$";
		if (oBankAccount == null || oIDNum.trim().isEmpty()) {
			errorMsgs.add("銀行帳號: 請勿空白");
		} else if (!oBankAccount.trim().matches(oBankAccountReg)) {
			errorMsgs.add("請輸入正確的銀行帳號格式");
		}
		
		// 取得圖片
		byte[] oProfilePic = null;
		
		Date oRegistDate = null;
		try {
			oRegistDate = java.sql.Date.valueOf(req.getParameter("oRegistDate").trim());
		} catch (IllegalArgumentException e) {
			oRegistDate = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入日期!");
		}
		
		Integer oPostAmount = Integer.valueOf(req.getParameter("oPostAmount"));

		Integer oReportCnt = Integer.valueOf(req.getParameter("oReportCnt"));

		Integer courtArriveCnt = Integer.valueOf(req.getParameter("courtArriveCnt"));

		Integer rsvdCnts = Integer.valueOf(req.getParameter("rsvdCnts"));

		String oEmail = req.getParameter("oEmail");
		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oEmail == null || oEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!oEmail.trim().matches(oEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}
		
		OwnerUser ownerUser = new OwnerUser();
		ownerUser.setoUserID(oUserID);
		ownerUser.setoUserName(oUserName);
		ownerUser.setoPassword(oPassword);
		ownerUser.setoIDNum(oIDNum);
		ownerUser.setCompiled(compiled);
		ownerUser.setoName(oName);
		ownerUser.setoGender(oGender);
		ownerUser.setoBirth(oBirth);
		ownerUser.setoTelephone(oTelephone);
		ownerUser.setoAddress(oAddress);
		ownerUser.setoBankCode(oBankCode);
		ownerUser.setoBankAccount(oBankAccount);
		ownerUser.setoProfilePic(oProfilePic);
		ownerUser.setoRegisterDate(oRegistDate);
		ownerUser.setoPostAmount(oPostAmount);
		ownerUser.setoReportCnt(oReportCnt);
		ownerUser.setCourtArriveCnt(courtArriveCnt);
		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoEmail(oEmail);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/ownerUserBack/set_oUser.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		oUserSvcB.updateOwnerUser(ownerUser);
		req.setAttribute("ownerUser", oUserSvcB.getOneOwnerUser(oUserID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("ownerUser", ownerUser); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/ownerUserBack/all_oUser.jsp";
	}
}
