package com.pichill.frontstage.owneruser.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pichill.frontstage.owneruser.service.OwnerUserServiceFront;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.owneruser.entity.OwnerUser;

@WebServlet("/ologinhandler")
public class OwnerUserLoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int loginAttempts = 0;  // 登入嘗試次數
	private static long lockoutTime = 0;   // 鎖定時間
	private static final int MAX_LOGIN_ATTEMPTS = 5;  // 最大嘗試次數
	private static final long LOCKOUT_DURATION = 1 * 60 * 1000;
	// 【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
		// 【實際上應至資料庫搜尋比對】
		protected boolean allowOUser(String oUserName, String oPassword) {

			OwnerUserServiceFront oUserSvcF = new OwnerUserServiceFront();
			OwnerUser ownerUser = oUserSvcF.userAuth(oUserName, oPassword);

			if (ownerUser != null) {
				return true; // 找到匹配的管理员紀錄
			} else {
				return false; // 未找到匹配的管理员紀錄
			}
		}
		
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = res.getWriter();

			// 【取得使用者 帳號(account) 密碼(password)】
			String oUserName = req.getParameter("oUserName");
			String oPassword = req.getParameter("oPassword");

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String oUserNameReg = "^[a-zA-Z0-9]{8,12}$";
			if (oUserName == null || oUserName.trim().length() == 0) {
				errorMsgs.put("oUserName", "帳號: 請勿空白");
			} else if (!oUserName.trim().matches(oUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("oUserName", "帳號格式錯誤!可以是英文大小寫及數字, 且長度必需介於8到12個字");
			}

			String oPasswordReg = "^[a-zA-Z0-9]{8,12}$";
			if (oPassword == null || oPassword.trim().length() == 0) {
				errorMsgs.put("oPassword", "密碼: 請勿空白");
			} else if (!oPassword.trim().matches(oPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("oPassword", "密碼格式錯誤!可以是英文大小寫及數字, 且長度必需介於8到12個字");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/login/oLogin/oUserLogin.jsp");
				failureView.forward(req, res);
				return;
			}

			// 【檢查該帳號 , 密碼是否有效】
			if (!allowOUser(oUserName, oPassword)) { // 【帳號 , 密碼無效時】
				System.out.println("有進帳號密碼無效");
				errorMsgs.put("oUserName", "查無資料");
				errorMsgs.put("oPassword", "密碼錯誤");
			}
			
			 // 增加登入嘗試次數
		    loginAttempts++;
		    
		    // 檢查是否達到最大嘗試次數
		    if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
		        System.out.println("密碼輸入錯誤次數過多，請稍候再試");

		        // 設定鎖定時間
		        lockoutTime = System.currentTimeMillis() + LOCKOUT_DURATION;
		    	req.setAttribute("lockoutTime", lockoutTime);
				if (System.currentTimeMillis() < lockoutTime) {
				    System.out.println("帳號已被鎖定，請稍候再試");
				    loginAttempts = 0;
				    res.sendRedirect(req.getContextPath() +"/login/oLogin/oUserFailToLogin.jsp");
				    return;
				} else {
					 loginAttempts = 0;
					res.sendRedirect(req.getContextPath() +"/login/oLogin/oUserLogin.jsp");
					return;
				}
		    }

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("有近error提示區域");
				RequestDispatcher failureView = req.getRequestDispatcher("/login/oLogin/oUserLogin.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			if (allowOUser(oUserName, oPassword)) { // 帳號密碼有效
				// 從資料庫獲取 adminStat 的值
				OwnerUserServiceFront oUserSvcF = new OwnerUserServiceFront();
				OwnerUser ownerUserStatus = oUserSvcF.userAuth(oUserName, oPassword);
				if (ownerUserStatus != null) {
					Integer oStatus = ownerUserStatus.getoStatus();
					// 設置mStatus 属性的值到 HttpSession
					HttpSession session = req.getSession();
					session.setAttribute("oStatus", oStatus);
					// mStatus 為2（停權）的情況
					if (oStatus == 0) {
						errorMsgs.put("oStatus", "此帳號尚未被激活");
					}
				}

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					System.out.println("有近第二個error提示區域");
					RequestDispatcher failureView = req.getRequestDispatcher("/login/oLogin/oUserLogin.jsp");
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
					RequestDispatcher failureView = req.getRequestDispatcher("/login/oLogin/oUserLogin.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				session = req.getSession(); // 【帳號 , 密碼有效時, 才做以下工作】
//				session.setAttribute("oUserName", oUserName); // *工作1: 才在session內做已經登入過的標識
				OwnerUser ownerUser = oUserSvcF.getOneOwnerUser(oUserName);
				session.setAttribute("ownerUser", ownerUser);
				System.out.println(session.getId());//印出session確認
				try {
					String location = (String) session.getAttribute("location");
					if (location != null) {
						session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
						res.sendRedirect(location);
						return;
					}
				} catch (Exception ignored) {
				}
//				
				
//				
				res.sendRedirect(req.getContextPath() + "/homepage/owneruserhome.jsp"); // *工作3: // 要換成企業會員的首頁
																						// (-->如無來源網頁:則重導至login_success.jsp)

			}
		}

}
