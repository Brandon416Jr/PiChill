package com.pichill.frontstage.generaluser.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.generaluser.entity.GeneralUser;

@WebServlet("/gloginhandler")
public class GeneralUserLoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int loginAttempts = 0; // 登入嘗試次數
	private long lockoutTime = 0; // 鎖定時間
	private static final int MAX_LOGIN_ATTEMPTS = 5; // 最大嘗試次數
	private static final long LOCKOUT_DURATION = 1 * 10 * 1000;

	// 【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
	// 【實際上應至資料庫搜尋比對】
	protected boolean allowgUser(String gUsername, String gPassword) {

		GeneralUserServiceFront gUserSvcF = new GeneralUserServiceFront();
		GeneralUser generalUser = gUserSvcF.userAuth(gUsername, gPassword);

		if (generalUser != null) {
			return true; // 找到匹配的一般理员紀錄
		} else {
			return false; // 未找到匹配的一般员紀錄
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = res.getWriter();

		// 【取得使用者 帳號(account) 密碼(password)】
		String gUsername = req.getParameter("gUsername");
		String gPassword = req.getParameter("gPassword");

		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String gUsernameReg = "^[a-zA-Z0-9]{8,12}$";
		if (gUsername == null || gUsername.trim().length() == 0) {
			errorMsgs.put("gUsername", "帳號: 請勿空白");
		} else if (!gUsername.trim().matches(gUsernameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("gUsername", "帳號格式錯誤!可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (gPassword == null || gPassword.trim().length() == 0) {
			errorMsgs.put("gPassword", "密碼: 請勿空白");
		} else if (!gPassword.trim().matches(gPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("gPassword", "密碼格式錯誤!可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserLogin.jsp");
			failureView.forward(req, res);
			return;
		}

		// 【檢查該帳號 , 密碼是否有效】
		if (!allowgUser(gUsername, gPassword)) { // 【帳號 , 密碼無效時】
			System.out.println("有進帳號密碼無效");
			errorMsgs.put("gUsername", "查無資料");
			errorMsgs.put("gPassword", "密碼錯誤");

			// 增加登入嘗試次數
			loginAttempts++;
			System.out.println(loginAttempts);
			// 檢查是否達到最大嘗試次數
			if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
				System.out.println("密碼輸入錯誤次數過多，請稍候再試");

				// 設定鎖定時間
				lockoutTime = System.currentTimeMillis() + LOCKOUT_DURATION;
				
				if (System.currentTimeMillis() < lockoutTime) {
					req.setAttribute("lockoutTime", lockoutTime);
					loginAttempts = 0;
					System.out.println("帳號已被鎖定，請稍候再試");
					res.sendRedirect(req.getContextPath() + "/login/gLogin/gUserFailToLogin.jsp");
					return;
				} else {
					loginAttempts = 0;
					res.sendRedirect(req.getContextPath() + "/login/gLogin/gUserLogin.jsp");
					return;
				} 
			}
		}

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			System.out.println("有近error提示區域");
			RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserLogin.jsp");
			failureView.forward(req, res);
			return;// 程式中斷
		}

		if (allowgUser(gUsername, gPassword)) { // 帳號密碼有效
			// 從資料庫獲取 adminStat 的值
			GeneralUserServiceFront gUserSvcF = new GeneralUserServiceFront();
			GeneralUser gStatus = gUserSvcF.userAuth(gUsername, gPassword);
			if (gStatus != null) {
				Integer status = gStatus.getStatus();
				// 設置mStatus 属性的值到 HttpSession
				HttpSession session = req.getSession();
				session.setAttribute("status", status);
				// mStatus 為2（停權）的情況
				if (status == 0) {
					errorMsgs.put("status", "此帳號尚未被驗證!");
				}
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("有近第二個error提示區域");
				RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserLogin.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			HttpSession session = req.getSession();
			String inputCode = req.getParameter("checkCode");
			String valistr = (String) session.getAttribute("valistr");
			if (!valistr.equalsIgnoreCase(inputCode)) {
				errorMsgs.put("checkCode", "輸入的驗證碼錯誤!");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("有進第三個error提示區域");
				RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserLogin.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			session = req.getSession(); // 【帳號 , 密碼有效時, 才做以下工作】
			GeneralUser generalUser = gUserSvcF.getGeneralUserBygUsername(gUsername);
			session.setAttribute("generalUser", generalUser);

//				session.setAttribute("gUsername", gUsername); // *工作1: 才在session內做已經登入過的標識
			try {
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
					res.sendRedirect(location);
					return;
				}
			} catch (Exception ignored) {
			}

			System.out.println(session.getId());// 印出session確認

//				GeneralUser gUser = gUserSvcF.getOneGeneralUser(null);
//				session = req.getSession();
//				session.setAttribute("loginGUser", gUser);
			res.sendRedirect(req.getContextPath() + "/homepage/main.jsp"); // *工作3: // 要改成一般會員首頁
																			// (-->如無來源網頁:則重導至login_success.jsp)

		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
