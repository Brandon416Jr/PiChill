package com.pichill.manage.controller;

import javax.servlet.annotation.WebServlet;

import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.util.VerifyCode;

import javax.servlet.*;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/mloginhandler")
//@WebServlet(name = "ManageLoginServlet", value = "/manage/manage.do")
public class ManageLoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int loginAttempts = 0;  // 登入嘗試次數
	private static long lockoutTime = 0;   // 鎖定時間
	private static final int MAX_LOGIN_ATTEMPTS = 5;  // 最大嘗試次數
	private static final long LOCKOUT_DURATION = 1 * 10 * 1000;
	// 【檢查使用者輸入的帳號(account) 密碼(password)是否有效】
	// 【實際上應至資料庫搜尋比對】
	protected boolean allowAdmin(String mUserName, String mPassword) {

		ManageService manageSvc = new ManageService();
		Manage manage = manageSvc.userAuth(mUserName, mPassword);

		if (manage != null) {
			return true; // 找到匹配的管理员紀錄
		} else {
			return false; // 未找到匹配的管理员紀錄
		}
//	    if ("tomcat".equals(account) && "tomcat".equals(password))
//	      return true;
//	    else
//	      return false;
	}
	
	

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = res.getWriter();

		// 【取得使用者 帳號(account) 密碼(password)】
		String mUserName = req.getParameter("mUserName");
		String mPassword = req.getParameter("mPassword");

		Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String mUserNameReg = "^[a-zA-Z0-9]{8,12}$";
		if (mUserName == null || mUserName.trim().length() == 0) {
			errorMsgs.put("mUserName", "帳號: 請勿空白");
		} else if (!mUserName.trim().matches(mUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("mUserName", "帳號格式錯誤!可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String mPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (mPassword == null || mPassword.trim().length() == 0) {
			errorMsgs.put("mPassword", "密碼: 請勿空白");
		} else if (!mPassword.trim().matches(mPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.put("mPassword", "密碼格式錯誤!可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("/login/mLogin/manageLogin.jsp");
			failureView.forward(req, res);
			return;
		}
		
		
		// 【檢查該帳號 , 密碼是否有效】

		if (!allowAdmin(mUserName, mPassword)) { // 【帳號 , 密碼無效時】

			System.out.println("有進帳號密碼無效");
			errorMsgs.put("mUserName", "查無資料");
			errorMsgs.put("mPassword", "密碼錯誤");
			
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
//				    loginAttempts = 0;
				    req.getRequestDispatcher("/login/mLogin/manageFailToLogin.jsp").forward(req, res);
				    return;
				} else {
					 loginAttempts = 0;
					 req.getRequestDispatcher("/login/mLogin/manageLogin.jsp").forward(req, res);
					return;
				} 
		    }
		    
		}
	

	

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			System.out.println("有近error提示區域");
			RequestDispatcher failureView = req.getRequestDispatcher("/login/mLogin/manageLogin.jsp");
			failureView.forward(req, res);
			return;// 程式中斷
		}

		if (allowAdmin(mUserName, mPassword)) { // 帳號密碼有效
			// 從資料庫獲取 adminStat 的值
			ManageService manageSvc = new ManageService();
			Manage manageStatus = manageSvc.userAuth(mUserName, mPassword);
			if (manageStatus != null) {
				Integer mStatus = manageStatus.getmStatus();
				// 設置mStatus 属性的值到 HttpSession
				HttpSession session = req.getSession();
				session.setAttribute("mStatus", mStatus);
				// mStatus 為2（停權）的情況
				if (mStatus == 0) {
					errorMsgs.put("mStatus", "此員工已離職，帳號已停權");
				}
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("有進第二個error提示區域");
				RequestDispatcher failureView = req.getRequestDispatcher("/login/mLogin/manageLogin.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			
//			res.setContentType("image/jpeg");
//			// 禁止瀏覽器快取驗證碼
//			res.setDateHeader("Expires", -1);
//			res.setHeader("Cache-Control", "no-cache");
//			res.setHeader("Pragma", "no-cache");
//			// 生成驗證碼
//			VerifyCode vc = new VerifyCode();
//			// 輸出驗證碼
//			vc.drawImage(res.getOutputStream());
//			// 獲取驗證碼的值，儲存到session中
//			String valistr = vc.getCode();
//			HttpSession sessionCode = req.getSession();
//			sessionCode.setAttribute("valistr", valistr);
//			// 列印到控制檯
//			System.out.println(valistr);
//	
			HttpSession session = req.getSession();
			String inputCode = req.getParameter("checkCode");
			String valistr = (String) session.getAttribute("valistr");
			if (!valistr.equalsIgnoreCase(inputCode)) {
				errorMsgs.put("checkCode", "輸入的驗證碼錯誤!");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("有進第三個error提示區域");
				RequestDispatcher failureView = req.getRequestDispatcher("/login/mLogin/manageLogin.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			 session = req.getSession(); // 【帳號 , 密碼有效時, 才做以下工作】

//			session.setAttribute("mUserName", mUserName); // *工作1: 才在session內做已經登入過的標識
			
			// 測試
			Manage manage = manageSvc.getOneManage(mUserName);
			session.setAttribute("manage", manage);
//			Integer manageID =  manage.getManageID();
//			session.setAttribute("manageID", manageID);
			
			System.out.println(session.getId());
			try {
				String location = (String) session.getAttribute("location");
				if (location != null) {
					System.out.println("無來源網頁");
					session.removeAttribute("location"); // *工作2: 看看有無來源網頁 (-->如有來源網頁:則重導至來源網頁)
					res.sendRedirect(location);
					return;
				}
			} catch (Exception ignored) {
			}
			
			res.sendRedirect(req.getContextPath() + "/backstage/login/index.jsp"); // *工作3:
																					// (-->如無來源網頁:則重導至login_success.jsp)

		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}