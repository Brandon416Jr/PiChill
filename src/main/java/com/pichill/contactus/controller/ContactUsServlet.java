package com.pichill.contactus.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.service.ContactUsService;
import com.pichill.contactus.service.ContactUsServiceImpl;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ContactUsServlet", value = "/contactus/contactus.do")
public class ContactUsServlet extends HttpServlet {
	private ContactUsService contactUsService;
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		contactUsService = new ContactUsServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
		case "getOne_For_Display":
			// // 來自select_page.jsp的請求
			forwardPath = getOneDisplay(req, res);
			break;
//		case "getOne_For_Update":
//			// 來自listAllContactUs.jsp的請求
//			forwardPath = getOneUpdate(req, res);
//			break;
//		case "update":
//			// 來自setContactUs.jsp的請求
//			forwardPath = update(req, res);
//			break;
		case "insert":
			// 來自addContactUs.jsp的請求
			forwardPath = insert(req, res);
			break;
		default:
			forwardPath = "/contactusForGUser/listAllContactUsForGUser.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getOneDisplay(HttpServletRequest req, HttpServletResponse res) {
		Integer formID = Integer.valueOf(req.getParameter("formID"));

		ContactUs contactUs = contactUsService.getOneContactUs(formID);

		req.setAttribute("contactUs", contactUs);
		return "/contactUs/contactus.jsp";
	}

//	private String update(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		// 錯誤處理
//		List<String> errorMsgs = new ArrayList<>();
//		req.setAttribute("errorMsgs", errorMsgs);
//
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//		Integer formID = Integer.valueOf(req.getParameter("formID"));
//		Integer oUserID = Integer.valueOf(req.getParameter("oUserID"));
//		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));
//
//
//		String formPurpose = req.getParameter("formPurpose");
//		if (formPurpose == null || formPurpose.trim().isEmpty())
//			errorMsgs.add("請輸入主旨");
//		
//		String formContent = req.getParameter("formContent");
//		if (formContent == null || formContent.trim().isEmpty())
//			errorMsgs.add("請輸入內容");
//		
//
//		// 取得圖片
//		byte[] formPic = null;
//		InputStream in = req.getPart("formPic").getInputStream(); 
//		// 從javax.servlet.http.Part物件取得上傳檔案的InputStream		
//		if (in.available() != 0) {
//			formPic = new byte[in.available()];
//			in.read(formPic);
//			in.close();
//		} else {
//			ContactUsService ContactUsService = new ContactUsService();
//			formPic = contactUsService.getContactUsByFormID(formID).getformPic();
//		}
//
//		// 取得當前系統時間
//		java.sql.Timestamp formTime =new Timestamp(System.currentTimeMillis());
//		//定義格式，不顯示毫秒
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//將當前系統時間轉換為不顯示毫秒情況，保存為String類型在dateNow中
//		String dateNow= df.format(formTime);
//		//控制台顯示dateNow的值
//		System.out.print("系統時間" +dateNow);
//				
////		頁面不顯示，所以直接給0，之後用程式碼去計算
//		Integer formStatus = 0;
//
//		Integer formType = Integer.valueOf(req.getParameter("formType"));
//
//
//		// 假如輸入格式錯誤的，備份選原使用者輸入過的資料
//		ContactUs contactUs = new ContactUs();
//		contactUs.setformID(formID);
//		contactUs.setoUserID(oUserID);
//		contactUs.setgUserID(gUserID);
//		contactUs.setformPurpose(formPurpose);
//		contactUs.setformContent(formContent);
//		contactUs.setformPic(formPic);
//		contactUs.setformTime(formTime);
//		contactUs.setformStatus(formStatus);
//		contactUs.setformType(formType);
//
//		contactUs.toString();
//
//		// ========================================================================改到這===============
//
//		if (!errorMsgs.isEmpty()) {
//			req.setAttribute("contactUs", contactUs); // 含有輸入格式錯誤的ownerUser物件,也存入req
//			return "/contactUs/set_contactus.jsp"; // 程式中斷
//		}
//		/*************************** 2.開始修改資料 *****************************************/
//
//		contactUsService.updateOwnerUser(contactUs);
//		req.setAttribute("contactUs", contactUsService.getContactUsByFormID(formID));
//
//		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
//		req.setAttribute("ownerUser", ownerUser); // 資料庫update成功後,正確的的empVO物件,存入req
//		return "/contactUs/set_contactUs.jsp";
//	}

	// insert 資料
	private String insert(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	// 錯誤處理
	List<String> errorMsgs = new ArrayList<>();
	req.setAttribute("errorMsgs", errorMsgs);

	/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
	Integer formID = Integer.valueOf(req.getParameter("formID"));
//	Integer oUserID = OwnerUser.valueOf(req.getParameter("oUserID"));
//	Integer gUserID = GeneralUser.valueOf(req.getParameter("gUserID"));


	String formPurpose = req.getParameter("formPurpose");
	if (formPurpose == null || formPurpose.trim().isEmpty())
		errorMsgs.add("請輸入主旨");
	
	String formContent = req.getParameter("formContent");
	if (formContent == null || formContent.trim().isEmpty())
		errorMsgs.add("請輸入內容");

	// 取得圖片
	byte[] formPic = null;
	InputStream in = req.getPart("formPic").getInputStream(); 
	// 從javax.servlet.http.Part物件取得上傳檔案的InputStream		
	if (in.available() != 0) {
		formPic = new byte[in.available()];
		in.read(formPic);
		in.close();
	} else {
		contactUsService = new ContactUsServiceImpl();
		formPic = contactUsService.getOneContactUs(formID).getformPic();
	}

	// 取得當前系統時間
	Timestamp formTime = Timestamp.valueOf(req.getParameter("formTime"));
			
//	頁面不顯示，所以直接給0，之後用程式碼去計算
	Integer formStatus = 0;

	Integer formType = Integer.valueOf(req.getParameter("formType"));


	 //假如輸入格式錯誤的，備份選原使用者輸入過的資料
	ContactUs contactUs = new ContactUs();
	contactUs.setformID(formID);
//	contactUs.setOwnerUser(oUserID);
//	contactUs.setGeneralUser();
	contactUs.setformPurpose(formPurpose);
	contactUs.setformContent(formContent);
	contactUs.setformPic(formPic);
	contactUs.setformTime(formTime);
	contactUs.setformStatus(formStatus);
	contactUs.setformType(formType);

	contactUs.toString();

// Send the use back to the form, if there were errors
	if (!errorMsgs.isEmpty()) {
		req.setAttribute("contactUs", contactUs); // 含有輸入格式錯誤的empVO物件,也存入req
		return "/contactUs/addContactUs.jsp";
	}
//========================================================================改到這===============

	/*************************** 2.開始新增資料 ***************************************/
 	contactUsService.addContactUs(contactUs);

	/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
	return "/contactUs/listAllContactUs.jsp";

}

}
