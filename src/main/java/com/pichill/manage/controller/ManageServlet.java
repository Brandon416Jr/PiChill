package com.pichill.manage.controller;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.pichill.manage.entity.Manage;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.manage.service.ManageService;
import com.pichill.util.testUtil;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 1000 * 1024 * 1024)
@WebServlet(name = "ManageHServlet", value = "/manage/manage.do")
public class ManageServlet extends HttpServlet {
	private ManageService manageService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		manageService = new ManageService();
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
		if(action != null){
			  action.hashCode(); 
			} else {
				System.out.println("action為空值");
			}
		switch (action) {
		case "getOne_For_Update":
			// 來自all_manage.jsp的請求
			forwardPath = getOne_For_Update(req, res);
			break;
		case "update":
			// 來自set_manage.jsp的請求
			forwardPath = update(req, res);
			break;
		case "insert":
			// 來自new_manage.jsp的請求
			forwardPath = insert(req, res);
			break;
		case "logout":
			forwardPath = logout(req, res);
			break;
		default:
			forwardPath = "/backstage/manage/all_manage.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
		
//		String manageID = req.getParameter("manageID");
		
//		if(manageID == null){
//			doInsert
//			 Object obj = new Object();
//			 obj.setParam1(req.getParameter("param1));
//			 obj.setParam2(req.getParameter("param2));
//			 obj.setParam3(req.getParameter("param3));
//			 insert(obj); call service do Insert
//			return "success";
//		}else{
			//修改有id用id拿DB的data
//			Object obj = findOneById(id);
			//假設param3是你不想被修改的資料 那我就只set新的param1, param2到物件裡面 讓物件裡面的param3的資料不變動
//			 obj.setParam1(req.getParameter("param1));
//			 obj.setParam2(req.getParameter("param2));
//			 update(obj); call service do update
//			return "success";
//		}
	}

	private String getOne_For_Update(HttpServletRequest req, HttpServletResponse res)  {
		System.out.println("成功getOneUpdate");
		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
		req.setAttribute("errorMsgs", errorMsgs);
		Integer manageID = Integer.valueOf(req.getParameter("manageID"));

		Manage manage = manageService.getOneManage(manageID);
		
//		String param = "?manageID="  +manage.getManageID()+
//			       "&mName="  +manage.getmName()+
//			       "&mUserName="    +manage.getmUserName()+
//			       "&mPassword="+manage.getmPassword()+
//			       "&mBirth="    +manage.getmBirth()+
//			       "&mGender="   +manage.getmGender()+
//			       "&mTelephone="  +manage.getmTelephone()+
//			       "&mEmgContact="    +manage.getmEmgContact()+
//			       "&mEmgPhone="+manage.getmEmgPhone()+
//			       "&mAddress="    +manage.getmAddress()+
//			       "&mHiredate="   +manage.getmHiredate()+
//			       "&mID="    +manage.getmID()+
//			       "&mEmail="+manage.getmEmail()+
//			       "&mProfilePic="    +manage.getmProfilePic()+
//			       "&mStatus="   +manage.getmStatus();
//		return "/backstage/manage/set_manage.jsp"+param;
	
		req.setAttribute("manage", manage);
		return "/backstage/manage/set_manage.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("成功update");
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer manageID = Integer.valueOf(req.getParameter("manageID"));
		Manage manage = manageService.getOneManage(manageID);

		String mName = req.getParameter("mName");
		String mNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (mName == null || mName.trim().length() == 0) {
			errorMsgs.add("管理員姓名: 請勿空白");
		} else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String mUserName = req.getParameter("mUserName");
		String mUserNameReg = "^[a-zA-Z0-9]{8,12}$";
		if (mUserName == null || mUserName.trim().length() == 0) {
			errorMsgs.add("管理員帳號: 請勿空白");
		} else if (!mUserName.trim().matches(mUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String mPassword = req.getParameter("mPassword");
		String mPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (mPassword == null || mPassword.trim().length() == 0) {
			errorMsgs.add("管理員密碼: 請勿空白");
		} else if (!mPassword.trim().matches(mPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

//		Date mBirth;
//		try {
//			mBirth = java.sql.Date.valueOf(req.getParameter("mBirth"));
//		} catch (IllegalArgumentException e) {
//			mBirth = new java.sql.Date(System.currentTimeMillis());
//			errorMsgs.add("請輸入生日!");
//		}
//		Enumeration<String> enumeration = req.getParameterNames();
//		while(enumeration.hasMoreElements()) {
//			System.out.println(enumeration.nextElement());
//		}
//		Integer mGender = Integer.valueOf(req.getParameter("mGender"));

		String mTelephone = req.getParameter("mTelephone");
		String mTelephoneReg = "^09[0-9]{8}$";
		if (mTelephone == null || mTelephone.trim().isEmpty()) {
			errorMsgs.add("手機: 請勿空白");
		} else if (!mTelephone.trim().matches(mTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String mEmgContact = req.getParameter("mEmgContact");
		String mEmgContactReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (mEmgContact == null || mEmgContact.trim().length() == 0) {
			errorMsgs.add("管理員姓名: 請勿空白");
		} else if (!mEmgContact.trim().matches(mEmgContactReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String mEmgPhone = req.getParameter("mEmgPhone");
		String mEmgPhoneReg = "^09[0-9]{8}$";
		if (mEmgPhone == null || mEmgPhone.trim().isEmpty()) {
			errorMsgs.add("手機: 請勿空白");
		} else if (!mTelephone.trim().matches(mEmgPhoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String address = req.getParameter("mAddress");
		if (address == null || address.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		String city = req.getParameter("city");

		String area = req.getParameter("area");

		String mAddress = city + area + address;

//		Date mHiredate = null;
//					try {
//						mHiredate = java.sql.Date.valueOf(req.getParameter("mHiredate").trim());
//					} catch (IllegalArgumentException e) {
//						mHiredate = new java.sql.Date(System.currentTimeMillis());
//						errorMsgs.add("請輸入日期!");
//					}



//		String mID = req.getParameter("mID");
//		String idnoRegex = "^[A-Z][12][0-9]{8}$";
//		if (mID == null || mID.trim().isEmpty()) {
//			errorMsgs.add("身份證: 請勿空白");
//		} else if (!mID.trim().matches(idnoRegex)) {
//			errorMsgs.add("請輸入正確的身份證格式");
//		}

		String mEmail = req.getParameter("mEmail");
		String mEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (mEmail == null || mEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!mEmail.trim().matches(mEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}

		// 取得圖片
//		Byte[] mProfilePic = null;
		InputStream in = req.getPart("mProfilePic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] mProfilePic = null;
		if(in.available()!=0){
			mProfilePic = new byte[in.available()];
			in.read(mProfilePic);
			in.close();
		}  else {
			ManageService manageService = new ManageService();
			mProfilePic = manageService.getOneManage(manageID).getmProfilePic();
		}

		Integer mStatus = Integer.valueOf(req.getParameter("mStatus"));
		if (mStatus == 3) {
			errorMsgs.add("請選擇員工狀態");
		}

//		Manage manage = new Manage();
		manage.setManageID(manageID);
		manage.setmName(mName);
		manage.setmUserName(mUserName);
		manage.setmPassword(mPassword);
//		manage.setmBirth(mBirth);
//		manage.setmGender(mGender);
		manage.setmTelephone(mTelephone);
		manage.setmEmgContact(mEmgContact);
		manage.setmEmgPhone(mEmgPhone);
		manage.setmAddress(mAddress);
//		manage.setmHiredate(mHiredate);
//		manage.setmID(mID);
		manage.setmEmail(mEmail);
		manage.setmProfilePic(mProfilePic);
		manage.setmStatus(mStatus);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("manage", manage); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/manage/set_manage.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		System.out.println("manage:"+manage.toString());
		manageService.updateManage(manage);
		req.setAttribute("manage", manageService.getOneManage(manageID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//		req.setAttribute("manage", manage); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/manage/all_manage.jsp";
	}

	private String insert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("成功insert");
		// 錯誤處理
//		Map<String, String[]> parameterMap = req.getParameterMap();
//		Manage manage = testUtil.paramMappingFunction(parameterMap, new Manage());
//		
//		System.out.println("manage:"+manage);
		
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);
		/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
		String mName = req.getParameter("mName");
		String mNameReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (mName == null || mName.trim().length() == 0) {
			errorMsgs.add("管理員姓名: 請勿空白");
		} else if (!mName.trim().matches(mNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String mUserName = req.getParameter("mUserName");
		String mUserNameReg = "^[a-zA-Z0-9]{8,12}$";
		if (mUserName == null || mUserName.trim().length() == 0) {
			errorMsgs.add("管理員帳號: 請勿空白");
		} else if (!mUserName.trim().matches(mUserNameReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員帳號: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		String mPassword = req.getParameter("mPassword");
		String mPasswordReg = "^[a-zA-Z0-9]{8,12}$";
		if (mPassword == null || mPassword.trim().length() == 0) {
			errorMsgs.add("管理員密碼: 請勿空白");
		} else if (!mPassword.trim().matches(mPasswordReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員密碼: 可以是英文大小寫及數字, 且長度必需介於8到12個字");
		}

		Date mBirth = null;
		try {
			mBirth = java.sql.Date.valueOf(req.getParameter("mBirth").trim());
		} catch (IllegalArgumentException e) {
			mBirth = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入生日!");
		}

		Integer mGender = Integer.valueOf(req.getParameter("mGender"));

		String mTelephone = req.getParameter("mTelephone");
		String mTelephoneReg = "^09[0-9]{8}$";
		if (mTelephone == null || mTelephone.trim().isEmpty()) {
			errorMsgs.add("手機: 請勿空白");
		} else if (!mTelephone.trim().matches(mTelephoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String mEmgContact = req.getParameter("mEmgContact");
		String mEmgContactReg = "^[\\u4e00-\\u9fa5]{2,}$";
		if (mEmgContact == null || mEmgContact.trim().length() == 0) {
			errorMsgs.add("管理員姓名: 請勿空白");
		} else if (!mEmgContact.trim().matches(mEmgContactReg)) { // 以下練習正則(規)表示式(regular-expression)
			errorMsgs.add("管理員姓名: 只能是中文, 且長度必需大於2個字");
		}

		String mEmgPhone = req.getParameter("mEmgPhone");
		String mEmgPhoneReg = "^09[0-9]{8}$";
		if (mEmgPhone == null || mEmgPhone.trim().isEmpty()) {
			errorMsgs.add("手機: 請勿空白");
		} else if (!mTelephone.trim().matches(mEmgPhoneReg)) {
			errorMsgs.add("請輸入正確的手機格式");
		}

		String address = req.getParameter("mAddress");
		if (address == null || address.trim().isEmpty())
			errorMsgs.add("請輸入地址");

		String city = req.getParameter("city");

		String area = req.getParameter("area");

		String mAddress = city + area + address;

		Date mHiredate = new java.sql.Date(System.currentTimeMillis());
		try {
			mHiredate = java.sql.Date.valueOf(req.getParameter("mHiredate").trim());
		} catch (IllegalArgumentException e) {
			mHiredate = new java.sql.Date(System.currentTimeMillis());
			errorMsgs.add("請輸入日期!");
		}

		String mID = req.getParameter("mID");
		String idnoRegex = "^[A-Z][12][0-9]{8}$";
		if (mID == null || mID.trim().isEmpty()) {
			errorMsgs.add("身份證: 請勿空白");
		} else if (!mID.trim().matches(idnoRegex)) {
			errorMsgs.add("請輸入正確的身份證格式");
		}

		String mEmail = req.getParameter("mEmail");
		String mEmailReg = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
		if (mEmail == null || mEmail.trim().isEmpty()) {
			errorMsgs.add("Email: 請勿空白");
		} else if (!mEmail.trim().matches(mEmailReg)) {
			errorMsgs.add("請輸入正確的Email格式");
		}

		// 圖片，need to ask question!
		InputStream in = req.getPart("mProfilePic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
		byte[] mProfilePic = null;
		if(in.available()!=0){
			mProfilePic = new byte[in.available()];
			in.read(mProfilePic);
			in.close();
		}  else errorMsgs.add("員工照片: 請上傳照片");

		Integer mStatus = Integer.valueOf(req.getParameter("mStatus"));
		if (mStatus == 3) {
			errorMsgs.add("請選擇員工狀態");
		}
//				Integer mStatus = null;
		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
		Manage manage = new Manage();
		manage.setmName(mName);
		manage.setmUserName(mUserName);
		manage.setmPassword(mPassword);
		manage.setmBirth(mBirth);
		manage.setmGender(mGender);
		manage.setmTelephone(mTelephone);
		manage.setmEmgContact(mEmgContact);
		manage.setmEmgPhone(mEmgPhone);
		manage.setmAddress(mAddress);
		manage.setmHiredate(mHiredate);
		manage.setmID(mID);
		manage.setmEmail(mEmail);
		manage.setmProfilePic(mProfilePic);
		manage.setmStatus(mStatus);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("manage", manage); // 含有輸入格式錯誤的empVO物件,也存入req
			return "/backstage/manage/new_manage.jsp";
		}

		/*************************** 2.開始新增資料 ***************************************/

		manageService.insertManage(manage);

		/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
		
		return "/backstage/manage/all_manage.jsp";
	}
	
	private String logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // 登出，终止session
            System.out.println("成功登出");
        }

        res.setHeader("Cache-Control","no-cache"); 
        res.setHeader("Pragma","no-cache");
        res.setDateHeader ("Expires", 0);
        
        return "/login/mLogin/manageLogin.jsp";
	}

}
