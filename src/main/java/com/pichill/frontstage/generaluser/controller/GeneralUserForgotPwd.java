package com.pichill.frontstage.generaluser.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.security.SecureRandom;
//import org.hibernate.internal.build.AllowSysOut;
import org.mindrot.jbcrypt.BCrypt;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pichill.util.SendMailService;
import com.pichill.frontstage.generaluser.service.GeneralUserServiceFront;
import com.pichill.generaluser.entity.GeneralUser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import redis.clients.jedis.Jedis;

@WebServlet("/guser/forgotpwd")
public class GeneralUserForgotPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	private static final Random random = new SecureRandom();

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		String origin = req.getHeader("Origin");
//		if ("https://mail.google.com".equals(origin)) {
//			// 允許Google的郵件服務訪問
//			res.setHeader("Access-Control-Allow-Origin", origin);
//			res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
//			res.setHeader("Access-Control-Allow-Headers",
//					"Origin, X-Requested-With, Content-Type, Accept, Authorization");
//		}

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		System.out.println("action================" + action);

		/********************** 寄信(忘記密碼) **********************/
		/********************** 寄信(忘記密碼) **********************/
		/********************** 寄信(忘記密碼) **********************/
		if ("forgot".equals(action)) {

			System.out.println("寄信(忘記密碼)");
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String gEmail = req.getParameter("gEmail");
			String gEmailReg = "[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
			if (gEmail == null || gEmail.trim().length() == 0) {
				errorMsgs.put("gEmail", "信箱請勿空白");
			} else if (!gEmail.trim().matches(gEmailReg)) {
				errorMsgs.put("gEmail", "信箱格式不符");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserForgotPwd.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 2.開始查詢資料 *****************************************/
			GeneralUserServiceFront gUserSvcF = new GeneralUserServiceFront();
			GeneralUser generalUser = gUserSvcF.getGeneralUserBygEmail(gEmail);

			if (generalUser == null) {
				errorMsgs.put("forgotpassword", "此信箱未註冊過");

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserForgotPwd.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
			}

//			req.setAttribute("isForgotStepOneCompleted", true);

			String subject = " PiChill_密碼重置驗證信";

			String activeCode = generateRandomString(6);

			String messageText = "你好, 你的驗證碼為:" + activeCode + "\n請於十分鐘內完成驗證，請勿轉發或告知他人訊息，以維護你的帳號使用安全，謝謝";
			SendMailService sendMailService = new SendMailService();
			sendMailService.sendMail(gEmail, subject, messageText);

			RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserForgotPwd.jsp");
			failureView.forward(req, res);

			// 將驗證碼存進redis
			Map<String, String> verification = new HashMap<>();
			verification.put("activeCode", activeCode);

			Jedis jedis = new Jedis("localhost", 6379);
			jedis.select(2);
			Gson gson = new Gson();
			String verificationValue = gson.toJson(verification);
			String email = String.valueOf(gEmail);

			jedis.expire(email, 600);// 設定生命週期(以秒為單位)

			jedis.set(email, verificationValue);
			jedis.close();
		}

		/********************** 驗證(忘記密碼) **********************/
		/********************** 驗證(忘記密碼) **********************/
		/********************** 驗證(忘記密碼) **********************/
		if ("verificationforgot".equals(action)) {
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			System.out.println("驗證(忘記密碼)");

			String verification = req.getParameter("verification");

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			if (verification == null || verification.trim().length() == 0) {
				errorMsgs.put("verification", "驗證碼請勿空白");
			}

//			req.setAttribute("isForgotStepOneCompleted", true);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserForgotPwd.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 2.開始查詢資料 *****************************************/
			Jedis jedis = new Jedis("localhost", 6379);
			jedis.select(2);
			String gEmail = req.getParameter("gEmail");
			System.out.println(gEmail);

			String verificationValue = jedis.get(gEmail);
			if (verificationValue != null) {
				Gson gson = new Gson();
				Map<String, String> verification2 = gson.fromJson(verificationValue,
						new TypeToken<Map<String, String>>() {
						}.getType());
				System.out.println(verificationValue);

				String activeCode = verification2.get("activeCode");
				System.out.println(activeCode);

				jedis.close();

				if (verificationValue != null && verification.equals(activeCode)) {
					System.out.println("驗證通過");

//					req.setAttribute("isForgotStepTwoCompleted", true);
//					req.setAttribute("isForgotStepOneCompleted", false);

					RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserChangePwd.jsp");
					failureView.forward(req, res);

				} else {
					System.out.println("驗證失敗");
					errorMsgs.put("verification", "驗證碼不正確");

					RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserForgotPwd.jsp");
					failureView.forward(req, res);
				}
			} else {

				System.out.println("抓不到redis，驗證失敗");
				errorMsgs.put("verification", "驗證碼不正確");

				RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserForgotPwd.jsp");
				failureView.forward(req, res);
			}

		}
		/********************** 修改(忘記密碼) **********************/
		/********************** 修改(忘記密碼) **********************/
		/********************** 修改(忘記密碼) *********************/
		if ("changePassword".equals(action)) {

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String gPassword = req.getParameter("gPassword");
			String gPasswordReg = "^[a-zA-Z0-9]{8,12}$";
			if (gPassword == null || gPassword.trim().length() == 0) {
				errorMsgs.put("gPassword", "密碼請勿空白");
			} else if (!gPassword.trim().matches(gPasswordReg)) {
				errorMsgs.put("gPassword", "密碼格式錯誤: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
			}

			String confirmPass = req.getParameter("confirmPassword");
			if (confirmPass == null || confirmPass.trim().length() == 0) {
				errorMsgs.put("confirmPassword", "確認密碼請勿空白");
			} else if (!confirmPass.equals(gPassword)) {
				errorMsgs.put("confirmPassword", "密碼不一致");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
//				req.setAttribute("isForgotStepTwoCompleted", true);
//				req.setAttribute("isForgotStepOneCompleted", false);
				RequestDispatcher failureView = req.getRequestDispatcher("/login/gLogin/gUserChangePwd.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始修改密碼 ***************************************/
			String gEmail = req.getParameter("gEmail");
			String hashedPassword = BCrypt.hashpw(gPassword, BCrypt.gensalt());

			System.out.println("email=" + gEmail);
			System.out.println(gPassword);

			GeneralUserServiceFront gUserSvcF = new GeneralUserServiceFront();
			GeneralUser generalUser = gUserSvcF.getGeneralUserBygEmail(gEmail);

			generalUser.setgPassword(gPassword);
			gUserSvcF.updateGeneralUsers(generalUser);

			req.setAttribute("generalUser", generalUser); // 資料庫update成功後,正確的的memberVO物件,存入req
			String url = "/login/gLogin/gUserLogin.jsp";

			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交gUserLogin.jsp

			// 禁用快取
			res.setHeader("Cache-Control", "no-cache");
			res.setHeader("Cache-Control", "no-store");
			res.setDateHeader("Expires", 0);

			successView.forward(req, res);

		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	private String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(randomIndex));
		}
		return sb.toString();
	}
}
