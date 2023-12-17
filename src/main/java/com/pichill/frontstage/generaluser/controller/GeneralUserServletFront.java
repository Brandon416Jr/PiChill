package com.pichill.frontstage.generaluser.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.generaluser.entity.GeneralUser;

@MultipartConfig(fileSizeThreshold = 1 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 1000 * 1024
		* 1024)
@WebServlet(name = "GeneralUserFServlet", value = "/generaluser/generaluserf.do")
public class GeneralUserServletFront extends HttpServlet {
	private GeneralUserServiceFront gUserSvcF;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		gUserSvcF = new GeneralUserServiceFront();
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
			// 來自new_manage.jsp的請求
			forwardPath = insert(req, res);
			break;
//		case "checkAccount":
//			// 來自new_manage.jsp的請求
//			forwardPath = checkAccount(req, res);
//			break;
		default:
			forwardPath = "/login/gLogin/gUserLogin.jsp";
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

		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);
		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String gName = req.getParameter("gName");
		String gNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (gName == null || gName.trim().length() == 0) {
			errorMsgs.put("gName", "會員姓名: 請勿空白");
		} else if (!gName.trim().matches(gNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("gName", "會員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String gTelephone = req.getParameter("gTelephone");
		String gTelephoneReg = "^09[0-9]{8}$";
		if (gTelephone == null || gTelephone.trim().isEmpty()) {
			errorMsgs.put("gTelephone", "手機: 請勿空白");
		} else if (!gTelephone.trim().matches(gTelephoneReg)) {
			errorMsgs.put("gTelephone", "請輸入正確的手機格式");
		}

		String gEmail = req.getParameter("gEmail");
		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (gEmail == null || gEmail.trim().isEmpty()) {
			errorMsgs.put("gEmail", "Email: 請勿空白");
		} else if (!gEmail.trim().matches(gEmailReg)) {
			errorMsgs.put("gEmail", "請輸入正確的Email格式");
		}
		
		Boolean gUserE = gUserSvcF.existsEmail(gEmail);
		System.out.println(gUserE);
		if (gUserE) {
			errorMsgs.put("gEmail", "此信箱已被註冊過");	
		} 

		String address = req.getParameter("gAddress");
		if (address == null || address.trim().isEmpty())
			errorMsgs.put("gAddress", "請輸入地址");

		String city = req.getParameter("city");

		String area = req.getParameter("area");

		String gAddress = city + area + address;

		Integer status = 0;

		Integer gGender = Integer.valueOf(req.getParameter("gGender"));
		if (gGender == 3) {
			errorMsgs.put("gGender", "請選擇性別");
		}

		String gUsername = req.getParameter("gUsername");
		String gUsernameReg = "^[a-zA-Z0-9]{8,12}$";
		if (gUsername == null || gUsername.trim().length() == 0) {
			errorMsgs.put("gUsername", "會員帳號: 請勿空白");
		} else if (!gUsername.trim().matches(gUsernameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("gUsername", "會員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		Boolean gUserUN = gUserSvcF.existsUsername(gUsername);
		System.out.println(gUserUN);
		if (gUserUN) {
			errorMsgs.put("gUsername", "此帳號已存在");	
		} 
		

		String gPassword = req.getParameter("gPassword");
		String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (gPassword == null || gPassword.trim().length() == 0) {
			errorMsgs.put("gPassword", "密碼: 請勿空白");
		} else if (!gPassword.trim().matches(gPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("gPassword", "密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String gPassword2 = req.getParameter("gPassword2");
		if (!gPassword2.equals(gPassword)) {
			errorMsgs.put("gPassword2", "請輸入相同的密碼");
		} else if (gPassword2 == null || gPassword2.trim().length() == 0) {
			errorMsgs.put("gPassword2", "請勿空白");
		}

		String gIDNum = req.getParameter("gIDNum");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (gIDNum == null || gIDNum.trim().isEmpty()) {
			errorMsgs.put("gIDNum", "身份證: 請勿空白");
		} else if (!gIDNum.trim().matches(idnoRegex)) {
			errorMsgs.put("gIDNum", "請輸入正確的身份證格式");
		}
		
		Boolean gUserI = gUserSvcF.existsIDNum(gIDNum);
		System.out.println(gUserI);
		if (gUserI) {
			errorMsgs.put("gIDNum", "一個人只能註冊一個帳號!");	
		} 

		String nicknameID = req.getParameter("nicknameID");
		String nickReg = "^[a-zA-Z0-9_@$%^]{10}$";
		if (nicknameID == null || nicknameID.trim().isEmpty()) {
			nicknameID = "";
		} else if (!nicknameID.trim().matches(nickReg)) {
			errorMsgs.put("nicknameID", "請輸入正確的匿名ID格式:字數10個，可以有符號、大小寫英文及數字，請勿填寫中文");
		}
		
		Boolean gUserNN = gUserSvcF.existsNicknameID(nicknameID);
		System.out.println(gUserNN);
		if (gUserNN) {
			errorMsgs.put("nicknameID", "此暱稱ID已存在!");	
		} 


		Integer gPostAmount = 0;

		Integer commentAmount = 0;

		Integer gReportCnt = 0;

		Date gRegistDate = new java.sql.Date(System.currentTimeMillis());
//		try {
//			gRegistDate = java.sql.Date.valueOf(req.getParameter("gRegistDate").trim());
//		} catch (IllegalArgumentException e) {
//			gRegistDate = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請輸入日期!");
//		}

		Date gBirth = null;
		try {
			gBirth = java.sql.Date.valueOf(req.getParameter("gBirth").trim());
		} catch (IllegalArgumentException e) {
			errorMsgs.put("gBirth", "請輸入生日!");
		}

		Integer yoyakuCnt = 0;

		InputStream in = req.getPart("gProfilePic").getInputStream(); // 從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] gProfilePic = null;
		if (in.available() != 0) {
			gProfilePic = new byte[in.available()];
			in.read(gProfilePic);
			in.close();
		} else
			errorMsgs.put("gProfilePic", "員工照片: 請上傳照片");

		String agree = req.getParameter("agree");
		if (agree == null) {
			errorMsgs.put("agree", "請勾選同意使用者條款!");
		}

		GeneralUser generalUser = new GeneralUser();
		generalUser.setgName(gName);
		generalUser.setgTelephone(gTelephone);
		generalUser.setgEmail(gEmail);
		generalUser.setgAddress(gAddress);
		generalUser.setStatus(status);
		generalUser.setgGender(gGender);
		generalUser.setgUsername(gUsername);
		generalUser.setgPassword(gPassword);
		generalUser.setgIDNum(gIDNum);
		generalUser.setNicknameID(nicknameID);
		generalUser.setgPostAmount(gPostAmount);
		generalUser.setCommentAmount(commentAmount);
		generalUser.setgReportCnt(gReportCnt);
		generalUser.setgRegistDate(gRegistDate);
		generalUser.setgBirth(gBirth);
		generalUser.setYoyakuCnt(yoyakuCnt);
		generalUser.setgProfilePic(gProfilePic);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("generalUser", generalUser); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/login/gLogin/gUserRegist.jsp";
		}
		
//		Boolean gUser = gUserSvcF.existsUsername(generalUser.getgUsername());
//		if (gUser) {
//			errorMsgs.put("gUsername", "此帳號已存在");
//		} 
//		Boolean gUser = gUserSvcF.existsUsername(gUsername);
//		if (gUser == true) {
//			errorMsgs.put("gUsername", "此帳號已存在");
//			req.setAttribute("generalUser", generalUser); 
//			return "/frontstage/generalUserFront/gUserRegist.jsp";
//		} 


		/*************************** 2.開始新增資料 ***************************************/

		gUserSvcF.insertGeneralUser(gName,  gTelephone,  gEmail,  gAddress,  status,
				 gGender,  gUsername,  gPassword,  gIDNum,  nicknameID,  gPostAmount,
				 commentAmount,  gReportCnt,  gRegistDate,  gBirth,  yoyakuCnt,
				 gProfilePic);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/

		return "/login/gLogin/gUserLogin.jsp";
	}

//	private String checkAccount(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		String gUsername = req.getParameter("gUsername");
//		System.out.println("進來比對了");
//		boolean isAccountExists = checkAccountInDatabase(gUsername);
//		
//
//	    res.setContentType("application/json");
//	    res.setCharacterEncoding("UTF-8");
//	    res.getWriter().write("{\"exists\":" + isAccountExists + "}");
////		if(isAccountExists) {
////			  req.setAttribute("errorMsgs", "帳號已被註冊");
////			  return "/frontstage/generalUserFront/gUserRegist.jsp"; 
////			}
////		req.setAttribute("exists", isAccountExists); 
//		return "/frontstage/generalUserFront/gUserRegist.jsp";
//	}

//	private boolean checkAccountInDatabase(String gUsername) {
//		GeneralUserServiceFront gUserSvcF = new GeneralUserServiceFront();
//		GeneralUser generalUser = gUserSvcF.getGeneralUserBygUsername(gUsername);
//		System.out.println("Checking account in database: " + gUsername);
//
//		if (generalUser != null) {
//			System.out.println("Retrieved member email from database: " + generalUser.getgUsername());
//			return true;
//		} else {
//			return false;
//		}
////		if(generalUser.size() > 0) {
////			  // 用戶名存在
////			  return true;
////			} else {
////			  // 未找到用戶名
////				for(GeneralUser generalUsers : generalUser) {
////					  System.out.println(generalUsers.getgUsername()); 
////					}
////			  return false; 
////			}
//		
//	}
}
