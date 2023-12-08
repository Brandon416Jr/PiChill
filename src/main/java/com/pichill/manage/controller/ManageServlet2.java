//package com.pichill.manage.controller;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Date;
//import java.util.*;
//import com.pichill.manage.service.ManageService;
//import com.pichill.manage.entity.Manage;
//
//@WebServlet("/manage/manage.do")
//@MultipartConfig
//public class ManageServlet2 extends HttpServlet{
//	
//	public void doGet(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//        doPost(req, res);
//    }
//	
//	public void doPost(HttpServletRequest req, HttpServletResponse res)
//            throws ServletException, IOException {
//
//        req.setCharacterEncoding("UTF-8");
//        String action = req.getParameter("action");
//
//
//        if ("getOne_For_Update".equals(action)) { // 來自listAllAdmin.jsp的請求
//        	System.out.println("成功getOne_For_Update");
//            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
//            req.setAttribute("errorMsgs", errorMsgs);
//
//            /***************************1.接收請求參數****************************************/
//            Integer manageID = Integer.valueOf(req.getParameter("manageID"));
//
//            /***************************2.開始查詢資料****************************************/
//            ManageService manageService = new ManageService();
//            Manage manage = manageService.getOneManage(manageID);
//
//            /***************************3.查詢完成,準備轉交(Send the Success view)************/
//            String param = "?manageID="  +manage.getManageID()+
// 			       "&mName="  +manage.getmName()+
// 			       "&mUserName="    +manage.getmUserName()+
// 			       "&mPassword="+manage.getmPassword()+
// 			       "&mBirth="    +manage.getmBirth()+
// 			       "&mGender="   +manage.getmGender()+
// 			       "&mTelephone="  +manage.getmTelephone()+
// 			       "&mEmgContact="    +manage.getmEmgContact()+
// 			       "&mEmgPhone="+manage.getmEmgPhone()+
// 			       "&mAddress="    +manage.getmAddress()+
// 			       "&mHiredate="   +manage.getmHiredate()+
// 			       "&mID="    +manage.getmID()+
// 			       "&mEmail="+manage.getmEmail()+
// 			       "&mProfilePic="    +manage.getmProfilePic()+
// 			       "&mStatus="   +manage.getmStatus();
//
//            String url = "/backstage/manage/set_manage.jsp" + param;
//            RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交set_manage.jsp
//            successView.forward(req, res);
//        }
//
//
//        if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
//        	System.out.println("成功進update");
//            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
//            req.setAttribute("errorMsgs", errorMsgs);
//
//            /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
//            Integer manageID = Integer.valueOf(req.getParameter("manageID"));
//         
//    		String mName = req.getParameter("mName");
//    		String mNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
//    		if (mName == null || mName.trim().length() == 0) {
//    			errorMsgs.put("mName", "管理員姓名: 請勿空白");
//    		} else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mName", "管理員姓名: 只能是中文, 且長度必需大於2個字");
//    		}
//
//    		String mUserName = req.getParameter("mUserName");
//    		String mUserNameReg = "^[a-zA-Z0-9]{8,12}$";
//    		if (mUserName == null || mUserName.trim().length() == 0) {
//    			errorMsgs.put("mUserName", "管理員帳號: 請勿空白");
//    		} else if (!mUserName.trim().matches(mUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mUserName", "管理員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
//    		}
//
//    		String mPassword = req.getParameter("mPassword");
//    		String mPasswordReg = "^[a-zA-Z0-9]{8,12}$";
//    		if (mPassword == null || mPassword.trim().length() == 0) {
//    			errorMsgs.put("mPassword", "管理員密碼: 請勿空白");
//    		} else if (!mPassword.trim().matches(mPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mPassword", "管理員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
//    		}
//
//    		Date mBirth;
//    		try {
//    			mBirth = java.sql.Date.valueOf(req.getParameter("mBirth"));
//    		} catch (IllegalArgumentException e) {
//    			mBirth = new java.sql.Date(System.currentTimeMillis());
//    			errorMsgs.put("mBirth", "請輸入生日!");
//    		}
////    		Enumeration<String> enumeration = req.getParameterNames();
////    		while(enumeration.hasMoreElements()) {
////    			System.out.println(enumeration.nextElement());
////    		}
//    		Integer mGender = Integer.valueOf(req.getParameter("mGender"));
//
//    		String mTelephone = req.getParameter("mTelephone");
//    		String mTelephoneReg = "^09[0-9]{8}$";
//    		if (mTelephone == null || mTelephone.trim().isEmpty()) {
//    			errorMsgs.put("mTelephone", "手機: 請勿空白");
//    		} else if (!mTelephone.trim().matches(mTelephoneReg)) {
//    			errorMsgs.put("mTelephone", "請輸入正確的手機格式");
//    		}
//
//    		String mEmgContact = req.getParameter("mEmgContact");
//    		String mEmgContactReg = "^[\\u4e00-\\u9fa5]{2,}$";
//    		if (mEmgContact == null || mEmgContact.trim().length() == 0) {
//    			errorMsgs.put("mEmgContact", "管理員姓名: 請勿空白");
//    		} else if (!mEmgContact.trim().matches(mEmgContactReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mEmgContact", "管理員姓名: 只能是中文, 且長度必需大於2個字");
//    		}
//
//    		String mEmgPhone = req.getParameter("mEmgPhone");
//    		String mEmgPhoneReg = "^09[0-9]{8}$";
//    		if (mEmgPhone == null || mEmgPhone.trim().isEmpty()) {
//    			errorMsgs.put("mEmgPhone", "手機: 請勿空白");
//    		} else if (!mTelephone.trim().matches(mEmgPhoneReg)) {
//    			errorMsgs.put("mEmgPhone", "請輸入正確的手機格式");
//    		}
//
//    		String address = req.getParameter("mAddress");
//    		if (address == null || address.trim().isEmpty())
//    			errorMsgs.put("mAddress", "請輸入地址");
//
//    		String city = req.getParameter("city");
//
//    		String area = req.getParameter("area");
//
//    		String mAddress = city + area + address;
//
//    		Date mHiredate = null;
//    					try {
//    						mHiredate = java.sql.Date.valueOf(req.getParameter("mHiredate").trim());
//    					} catch (IllegalArgumentException e) {
//    						mHiredate = new java.sql.Date(System.currentTimeMillis());
//    						errorMsgs.put("mHiredate", "請輸入日期!");
//    					}
//
//
//
//    		String mID = req.getParameter("mID");
//    		String idnoRegex = "^[A-Z][12][0-9]{8}$";
//    		if (mID == null || mID.trim().isEmpty()) {
//    			errorMsgs.put("mID",  "身份證: 請勿空白");
//    		} else if (!mID.trim().matches(idnoRegex)) {
//    			errorMsgs.put("mID", "請輸入正確的身份證格式");
//    		}
//
//    		String mEmail = req.getParameter("mEmail");
//    		String mEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//    		if (mEmail == null || mEmail.trim().isEmpty()) {
//    			errorMsgs.put("mEmail", "Email: 請勿空白");
//    		} else if (!mEmail.trim().matches(mEmailReg)) {
//    			errorMsgs.put("mEmail", "請輸入正確的Email格式");
//    		}
//
//    		// 取得圖片
////    		Byte[] mProfilePic = null;
//    		InputStream in = req.getPart("mProfilePic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
//    		byte[] mProfilePic = null;
//    		if(in.available()!=0){
//    			mProfilePic = new byte[in.available()];
//    			in.read(mProfilePic);
//    			in.close();
//    		}  else {
//    			ManageService manageService = new ManageService();
//    			mProfilePic = manageService.getOneManage(manageID).getmProfilePic();
//    		}
//
//    		Integer mStatus = Integer.valueOf(req.getParameter("mStatus"));
//
//            // Send the use back to the form, if there were errors
//            if (!errorMsgs.isEmpty()) {
//                RequestDispatcher failureView = req
//                        .getRequestDispatcher("/backstage/manage/set_manage.jsp");
//                failureView.forward(req, res);
//                return; //程式中斷
//            }
//
//            /***************************2.開始修改資料*****************************************/
//            ManageService manageService = new ManageService();
//            Manage manage =  manageService.updateManage(manageID, mName, mUserName, mPassword, mBirth, mGender,
//        			mTelephone, mEmgContact, mEmgPhone, mAddress, mHiredate,
//        			mID, mEmail,mProfilePic, mStatus);
//
//            /***************************3.修改完成,準備轉交(Send the Success view)*************/
//            req.setAttribute("manage", manage); // 資料庫update成功後,正確的的AdminVO物件,存入req
//            String url = "/admin/listOneAdminNew.jsp";
//            RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneAdmin.jsp
//            successView.forward(req, res);
//        }
//
//        if ("insert".equals(action)) { // 來自addAdmin.jsp的請求
//        	System.out.println("成功進insert");
//            Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
//            req.setAttribute("errorMsgs", errorMsgs);
//
//            /***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/      
//    		String mName = req.getParameter("mName");
//    		String mNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
//    		if (mName == null || mName.trim().length() == 0) {
//    			errorMsgs.put("mName", "管理員姓名: 請勿空白");
//    		} else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mName", "管理員姓名: 只能是中文, 且長度必需大於2個字");
//    		}
//
//    		String mUserName = req.getParameter("mUserName");
//    		String mUserNameReg = "^[a-zA-Z0-9]{8,12}$";
//    		if (mUserName == null || mUserName.trim().length() == 0) {
//    			errorMsgs.put("mUserName", "管理員帳號: 請勿空白");
//    		} else if (!mUserName.trim().matches(mUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mUserName", "管理員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
//    		}
//
//    		String mPassword = req.getParameter("mPassword");
//    		String mPasswordReg = "^[a-zA-Z0-9]{8,12}$";
//    		if (mPassword == null || mPassword.trim().length() == 0) {
//    			errorMsgs.put("mPassword", "管理員密碼: 請勿空白");
//    		} else if (!mPassword.trim().matches(mPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mPassword", "管理員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
//    		}
//
//    		Date mBirth;
//    		try {
//    			mBirth = java.sql.Date.valueOf(req.getParameter("mBirth"));
//    		} catch (IllegalArgumentException e) {
//    			mBirth = new java.sql.Date(System.currentTimeMillis());
//    			errorMsgs.put("mBirth", "請輸入生日!");
//    		}
////    		Enumeration<String> enumeration = req.getParameterNames();
////    		while(enumeration.hasMoreElements()) {
////    			System.out.println(enumeration.nextElement());
////    		}
//    		Integer mGender = Integer.valueOf(req.getParameter("mGender"));
//
//    		String mTelephone = req.getParameter("mTelephone");
//    		String mTelephoneReg = "^09[0-9]{8}$";
//    		if (mTelephone == null || mTelephone.trim().isEmpty()) {
//    			errorMsgs.put("mTelephone", "手機: 請勿空白");
//    		} else if (!mTelephone.trim().matches(mTelephoneReg)) {
//    			errorMsgs.put("mTelephone", "請輸入正確的手機格式");
//    		}
//
//    		String mEmgContact = req.getParameter("mEmgContact");
//    		String mEmgContactReg = "^[\\u4e00-\\u9fa5]{2,}$";
//    		if (mEmgContact == null || mEmgContact.trim().length() == 0) {
//    			errorMsgs.put("mEmgContact", "管理員姓名: 請勿空白");
//    		} else if (!mEmgContact.trim().matches(mEmgContactReg)) { // 以下練習正則(規)表示式(regular-expression)
//    			errorMsgs.put("mEmgContact", "管理員姓名: 只能是中文, 且長度必需大於2個字");
//    		}
//
//    		String mEmgPhone = req.getParameter("mEmgPhone");
//    		String mEmgPhoneReg = "^09[0-9]{8}$";
//    		if (mEmgPhone == null || mEmgPhone.trim().isEmpty()) {
//    			errorMsgs.put("mEmgPhone", "手機: 請勿空白");
//    		} else if (!mTelephone.trim().matches(mEmgPhoneReg)) {
//    			errorMsgs.put("mEmgPhone", "請輸入正確的手機格式");
//    		}
//
//    		String address = req.getParameter("mAddress");
//    		if (address == null || address.trim().isEmpty())
//    			errorMsgs.put("mAddress", "請輸入地址");
//
//    		String city = req.getParameter("city");
//
//    		String area = req.getParameter("area");
//
//    		String mAddress = city + area + address;
//
//    		Date mHiredate = null;
//    					try {
//    						mHiredate = java.sql.Date.valueOf(req.getParameter("mHiredate").trim());
//    					} catch (IllegalArgumentException e) {
//    						mHiredate = new java.sql.Date(System.currentTimeMillis());
//    						errorMsgs.put("mHiredate", "請輸入日期!");
//    					}
//
//
//
//    		String mID = req.getParameter("mID");
//    		String idnoRegex = "^[A-Z][12][0-9]{8}$";
//    		if (mID == null || mID.trim().isEmpty()) {
//    			errorMsgs.put("mID",  "身份證: 請勿空白");
//    		} else if (!mID.trim().matches(idnoRegex)) {
//    			errorMsgs.put("mID", "請輸入正確的身份證格式");
//    		}
//
//    		String mEmail = req.getParameter("mEmail");
//    		String mEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
//    		if (mEmail == null || mEmail.trim().isEmpty()) {
//    			errorMsgs.put("mEmail", "Email: 請勿空白");
//    		} else if (!mEmail.trim().matches(mEmailReg)) {
//    			errorMsgs.put("mEmail", "請輸入正確的Email格式");
//    		}
//
//    		// 取得圖片
////    		Byte[] mProfilePic = null;
//    		InputStream in = req.getPart("mProfilePic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
//    		byte[] mProfilePic = null;
//    		if(in.available()!=0){
//    			mProfilePic = new byte[in.available()];
//    			in.read(mProfilePic);
//    			in.close();
//    		}  else {
//    			errorMsgs.put("mProfilePic", "請上傳大頭貼照");
//    		}
//
//    		Integer mStatus = Integer.valueOf(req.getParameter("mStatus"));
//
//            // Send the use back to the form, if there were errors
//            if (!errorMsgs.isEmpty()) {
//                RequestDispatcher failureView = req
//                        .getRequestDispatcher("/admin/addadminNew.jsp");
//                failureView.forward(req, res);
//                return;
//            }
//
//            /***************************2.開始新增資料***************************************/
//            ManageService manageService = new ManageService();
//            Manage manage= manageService.insertManage(mName, mUserName, mPassword, mBirth, mGender,
//        			mTelephone, mEmgContact, mEmgPhone, mAddress, mHiredate,
//        			mID, mEmail,mProfilePic, mStatus);
//
//            /***************************3.新增完成,準備轉交(Send the Success view)***********/
//            String url = "/admin/adminSystem.jsp";
//            RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllAdmin.jsp
//            successView.forward(req, res);
//        }
//    }
//}
