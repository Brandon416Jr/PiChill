package com.pichill.frontstage.owneruser.controller;

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

import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;
import com.pichill.manage.entity.Manage;
import com.pichill.owneruser.entity.OwnerUser;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "OwnerUserFServlet", value = "/owneruser/owneruserf.do")
public class OwnerUserServletFront extends HttpServlet {
	private OwnerUserServiceFront oUserSvcF;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		oUserSvcF = new OwnerUserServiceFront();
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
		if (action != null) {
			action.hashCode();
		} else {
			System.out.println("action為空值");
		}
		switch (action) {
		case "insert":
			// 來自set_manage.jsp的請求
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/login/oLogin/oUserLogin.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("成功insert");
		// 錯誤處理
//		Map<String, String[]> parameterMap = req.getParameterMap();
//		Manage manage = testUtil.paramMappingFunction(parameterMap, new Manage());
//		
//		System.out.println("manage:"+manage);
		
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);
		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String oUserName = req.getParameter("oUserName");
		String oUserNameReg = "^[a-zA-Z0-9]{8,12}$";
		if (oUserName == null || oUserName.trim().length() == 0) {
			errorMsgs.put("oUserName", "會員帳號: 請勿空白");
		} else if (!oUserName.trim().matches(oUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("oUserName", "會員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}
		
		Boolean oUserUN = oUserSvcF.existsUsername(oUserName);
		System.out.println(oUserUN);
		if (oUserUN) {
			errorMsgs.put("oUserName", "此帳號已存在");	
		} 
		
		String oPassword = req.getParameter("oPassword");
		String oPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (oPassword == null || oPassword.trim().length() == 0) {
			errorMsgs.put("oPassword", "會員密碼: 請勿空白");
		} else if (!oPassword.trim().matches(oPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("oPassword", "會員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}
		
		String oPassword2 = req.getParameter("oPassword2");
		if (!oPassword2.equals(oPassword)) {
			errorMsgs.put("oPassword2", "請輸入相同的密碼");
		} else if (oPassword2 == null || oPassword2.trim().length() == 0) {
			errorMsgs.put("oPassword", "請勿空白");
		}
		
		String oIDNum = req.getParameter("oIDNum");
		String oIDReg = "^[A-Z][12][0-9]{8}$";
		if (oIDNum == null || oIDNum.trim().isEmpty()) {
			errorMsgs.put("oIDNum", "身份證: 請勿空白");
		} else if (!oIDNum.trim().matches(oIDReg)) {
			errorMsgs.put("oIDNum", "請輸入正確的身份證格式");
		}
		
		Boolean oUserI = oUserSvcF.existsIDNum(oIDNum);
		System.out.println(oUserI);
		if (oUserI) {
			errorMsgs.put("oIDNum", "一個人只能註冊一次!");	
		} 
		
		String compiled = req.getParameter("compiled");
		String compiledReg = "^[0-9]{8}$";
		if (compiled == null || oIDNum.trim().isEmpty()) {
			errorMsgs.put("compiled", "統編: 請勿空白");
		} else if (!compiled.trim().matches(compiledReg)) {
			errorMsgs.put("compiled", "請輸入正確的統編格式");
		}
		
		Boolean oUserC = oUserSvcF.existsCompiled(compiled);
		System.out.println(oUserC);
		if (oUserC) {
			errorMsgs.put("compiled", "此統編已被註冊過");	
		} 
		
		String oName = req.getParameter("oName");
		String oNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (oName == null || oName.trim().length() == 0) {
			errorMsgs.put("oName", "會員姓名: 請勿空白");
		} else if (!oName.trim().matches(oNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("oName", "會員姓名: 只能是中文, 且長度必需大於2個字");
		}
		
		Integer oGender = Integer.valueOf(req.getParameter("oGender"));

		Date oBirth = null;
		try {
			oBirth = java.sql.Date.valueOf(req.getParameter("oBirth").trim());
		} catch (IllegalArgumentException e) {
			errorMsgs.put("oBirth", "請輸入生日!");
		}
		
		String oTelephone = req.getParameter("oTelephone");
		String oTelephoneReg = "^09[0-9]{8}$";
		if (oTelephone == null || oTelephone.trim().isEmpty()) {
			errorMsgs.put("oTelephone", "手機: 請勿空白");
		} else if (!oTelephone.trim().matches(oTelephoneReg)) {
			errorMsgs.put("oTelephone", "請輸入正確的手機格式");
		}
		
		String address = req.getParameter("oAddress");
		if (address == null || address.trim().isEmpty())
			errorMsgs.put("oAddress", "請輸入地址");

		String city = req.getParameter("city");

		String area = req.getParameter("area");

		String oAddress = city + area + address;
		
		String oBankCode = req.getParameter("oBankCode");
		String oBankCodeReg = "^\\d{3}$";
		if (oBankCode == null || oIDNum.trim().isEmpty()) {
			errorMsgs.put("oBankCode", "銀行代碼: 請勿空白");
		} else if (!oBankCode.trim().matches(oBankCodeReg)) {
			errorMsgs.put("oBankCode", "請輸入正確的銀行代碼格式");
		}
		
		String oBankAccount = req.getParameter("oBankAccount");
		String oBankAccountReg = "^[1-9](\\d{9,13})$";
		if (oBankAccount == null || oIDNum.trim().isEmpty()) {
			errorMsgs.put("oBankAccount", "銀行帳號: 請勿空白");
		} else if (!oBankAccount.trim().matches(oBankAccountReg)) {
			errorMsgs.put("oBankAccount", "請輸入正確的銀行帳號格式");
		}
		
//		 取得圖片
		InputStream in = req.getPart("oProfilePic").getInputStream(); // 從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] oProfilePic = null;
		if (in.available() != 0) {
			oProfilePic = new byte[in.available()];
			in.read(oProfilePic);
			in.close();
		} else
			errorMsgs.put("oProfilePic", "照片: 請上傳照片");
		
		Date oRegistDate = new java.sql.Date(System.currentTimeMillis());
//		try {
//			oRegistDate = java.sql.Date.valueOf(req.getParameter("oRegistDate").trim());
//		} catch (IllegalArgumentException e) {
//			oRegistDate = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請輸入日期!");
//		}
		
		Integer oPostAmount = 0;

		Integer oReportCnt = 0;

		Integer courtArriveCnt = 0;

		Integer rsvdCnts = 0;

		String oEmail = req.getParameter("oEmail");
		String oEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (oEmail == null || oEmail.trim().isEmpty()) {
			errorMsgs.put("oEmail", "Email: 請勿空白");
		} else if (!oEmail.trim().matches(oEmailReg)) {
			errorMsgs.put("oEmail", "請輸入正確的Email格式");
		}
		
		Boolean oUserE = oUserSvcF.existsEmail(oEmail);
		System.out.println(oUserE);
		if (oUserE) {
			errorMsgs.put("oEmail", "此信箱已被註冊過");	
		} 
		
		String agree = req.getParameter("agree");
		 if (agree == null) {
			 errorMsgs.put("agree", "請勾選同意使用者條款!");
		 }
		
		OwnerUser ownerUser = new OwnerUser();
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
		ownerUser.setoRegisterDate(oRegistDate);
		ownerUser.setoPostAmount(oPostAmount);
		ownerUser.setoReportCnt(oReportCnt);
		ownerUser.setCourtArriveCnt(courtArriveCnt);
		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoEmail(oEmail);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("ownerUser", ownerUser); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/login/oLogin/oUserRegist.jsp";
		}

		/*************************** 2.開始新增資料 ***************************************/

		oUserSvcF.insertOwnerUser(ownerUser);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		
		return "/login/oLogin/oUserLogin.jsp";
	}
}
