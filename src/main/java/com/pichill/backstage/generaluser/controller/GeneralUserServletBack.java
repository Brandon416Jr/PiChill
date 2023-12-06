package com.pichill.backstage.generaluser.controller;

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

import com.pichill.backstage.generaluser.service.GeneralUserServiceBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "GeneralUserBServlet", value = "/generaluser/generaluserb.do")
public class GeneralUserServletBack extends HttpServlet {
	private GeneralUserServiceBack gUserSvcB;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		gUserSvcB = new GeneralUserServiceBack();
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
			forwardPath = "/backstage/gUserBack/all_generalUser.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));

		GeneralUser generalUser = gUserSvcB.getOneGeneralUser(gUserID);

		req.setAttribute("generalUser", generalUser);
		return "/backstage/generalUserBack/set_gUser.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

		String gTelephone = req.getParameter("gTelephone");
		String gTelephoneReg = "^09[0-9]{8}$";
		if (gTelephone == null || gTelephone.trim().isEmpty()) {
			errorMsgs.add("手機: 請勿空白");
		} else if (!gTelephone.trim().matches(gTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String gEmail = req.getParameter("gEmail");
		String gEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (gEmail == null || gEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!gEmail.trim().matches(gEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}

		String address = req.getParameter("gAddress");
		if (address == null || address.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		String city = req.getParameter("city");

		String area = req.getParameter("area");

		String gAddress = city + area + address;

		Integer status = Integer.valueOf(req.getParameter("status"));

		Integer gGender = Integer.valueOf(req.getParameter("gGender"));

		String gUsername = req.getParameter("gUsername");
		String gUsernameReg = "^[a-zA-Z0-9]{8,12}$";
		if (gUsername == null || gUsername.trim().length() == 0) {
			errorMsgs.add("會員帳號: 請勿空白");
		} else if (!gUsername.trim().matches(gUsernameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("會員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}
		
		String gPassword = req.getParameter("gPassword");
		String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (gPassword == null || gPassword.trim().length() == 0) {
			errorMsgs.add("管理員密碼: 請勿空白");
		} else if (!gPassword.trim().matches(gPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String gIDNum = req.getParameter("gIDNum");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (gIDNum == null || gIDNum.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!gIDNum.trim().matches(idnoRegex)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}
		
		// 再問問格式驗證!
				String nicknameID = req.getParameter("nicknameID");
				String nickReg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{10}$";
				if (nicknameID == null || nicknameID.trim().isEmpty()) {
					nicknameID = null;
				} else if (!nicknameID.trim().matches(nickReg)) {
					errorMsgs.add("請輸入正確的匿名ID格式");
				}

		Integer gPostAmount = Integer.valueOf(req.getParameter("gPostAmount"));

		Integer commentAmount = Integer.valueOf(req.getParameter("commentAmount"));

		Integer gReportCnt = Integer.valueOf(req.getParameter("gReportCnt"));

		Date gRegistDate = null;
		try {
			gRegistDate = java.sql.Date.valueOf(req.getParameter("gRegistDate").trim());
		} catch (IllegalArgumentException e) {
			gRegistDate = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入日期!");
		}
		
		Date gBirth = null;
		try {
			gBirth = java.sql.Date.valueOf(req.getParameter("gBirth").trim());
		} catch (IllegalArgumentException e) {
			errorMsgs.add("請輸入生日!");
		}

		Integer yoyakuCnt = Integer.valueOf(req.getParameter("yoyakuCnt"));

		byte[] gProfilePic = null;

		GeneralUser generalUser = new GeneralUser();
		generalUser.setgUserID(gUserID);
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
			req.setAttribute("generalUser", generalUser); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/generalUserBack/set_gUser.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		gUserSvcB.updateGeneralUser(generalUser);
		req.setAttribute("manage", gUserSvcB.getOneGeneralUser(gUserID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("generalUser", generalUser); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/generalUserBack/all_gUser.jsp";
	}
}
