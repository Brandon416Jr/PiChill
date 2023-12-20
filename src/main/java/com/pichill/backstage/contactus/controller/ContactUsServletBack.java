package com.pichill.backstage.contactus.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
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

import com.pichill.backstage.contactus.service.ContactUsServiceBack;
import com.pichill.contactus.entity.ContactUs;


/**
 * Servlet implementation class ContactUsServletBack
 */

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ContactUsBServlet", value = "/contactus/contactusb.do")
public class ContactUsServletBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactUsServiceBack contactUsSvcB;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		contactUsSvcB = new ContactUsServiceBack();
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
		if(action == null) {
			  action = "default"; // 給預設值
			}
		String forwardPath = "";
		switch (action) {

		case "getOne_For_Update":
			// 來自all_manage.jsp的請求
			forwardPath = getOneUpdate(req, res);
			break;
		case "update":
			// 來自set_manage.jsp的請求
			forwardPath = update(req, res);
			break;
		default:
			forwardPath = "/backstage/contactUsBack/all_form.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer formID = Integer.valueOf(req.getParameter("formID"));

		ContactUs contactUs = contactUsSvcB.getOneForm(formID);

		req.setAttribute("contactUs", contactUs);
		return "/backstage/contactUsBack/set_form.jsp";
	}

	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer formID = Integer.valueOf(req.getParameter("formID"));
		ContactUs contactUs = contactUsSvcB.getOneForm(formID);
//		Integer oUserID;
//		if (req.getParameter("oUserID") != null) {
//			oUserID = Integer.valueOf(req.getParameter("oUserID"));
//		} else {
//			oUserID = null;
//		}
//
//		Integer gUserID;
//		if (req.getParameter("gUserID") != null) {
//			gUserID = Integer.valueOf(req.getParameter("gUserID"));
//		} else {
//			gUserID = null;
//		}
//		
		

//		Integer gUserID = Integer.valueOf(req.getParameter("gUserID"));

//		String formPurpose;
//		if (req.getParameter("formPurpose") != null) {
//			formPurpose = req.getParameter("formPurpose");
//		} else {
//			ContactUsServiceBack contact = new ContactUsServiceBack();
//			ContactUs con = contact.getOneForm(formID);
//			formPurpose = con.getFormPurpose();
//		}
//		if (formPurpose == null || formPurpose.trim().isEmpty())
//			errorMsgs.add("請輸入主旨");
//
//		String formContent;
//		if (req.getParameter("formContent") != null) {
//			formContent = req.getParameter("formContent");
//		} else {
//			ContactUsServiceBack contact = new ContactUsServiceBack();
//			ContactUs con = contact.getOneForm(formID);
//			formContent = con.getFormPurpose();
//		}
//		if (formContent == null || formContent.trim().isEmpty())
//			errorMsgs.add("請輸入內容");

//		byte[] formPic = null;
//		InputStream in = req.getPart("formPic").getInputStream(); //從javax.servlet.http.Part物件取得上傳檔案的InputStream
//		byte[] formPic = null;
//		if(in.available()!=0){
//			formPic = new byte[in.available()];
//			in.read(formPic);
//			in.close();
//		}  else {
//			ContactUsServiceBack contactUsSvcB = new ContactUsServiceBack();
//			formPic = contactUsSvcB.getOneForm(formID).getFormPic();
//		}

//		Timestamp formTime;

//		if (req.getParameter("formTime") != null && !req.getParameter("formTime").trim().equals("")) {
//			// 如果請求中有傳時間參數,使用該時間
//			formTime = java.sql.Timestamp.valueOf(req.getParameter("formTime").trim());

//		} else {
//			// 如果請求沒有傳時間參數,查詢資料庫中原有的時間
//			ContactUsServiceBack service = new ContactUsServiceBack();
//			ContactUs contactUs2 = service.getOneForm(formID);
//			formTime = contactUs2.getFormTime();
//		}

//		Timestamp formTime;
//		if (req.getParameter("formTime") != null) {
//			formTime = java.sql.Timestamp.valueOf(req.getParameter("formTime").trim());
//		} else {
//			formTime = contactUs2.getFormTime();
//		}

//		Timestamp formTime = null;
//		try {
//			formTime = java.sql.Timestamp.valueOf(req.getParameter("formTime").trim());
//		} catch (IllegalArgumentException e) {
//			formTime = new java.sql.Timestamp(System.currentTimeMillis());
//			errorMsgs.add("請輸入填單時間!");
//		}

		Integer formStatus = Integer.valueOf(req.getParameter("formStatus"));

//		Integer formType = Integer.valueOf(req.getParameter("formType"));

//		Integer formType;
//		if (req.getParameter("formType") != null) {
//			formType = Integer.valueOf(req.getParameter("formType"));
//		} else {
//			ContactUsServiceBack service = new ContactUsServiceBack();
//			ContactUs contactUs2 = service.getOneForm(formID);
//			formType = contactUs2.getFormType();
//		}

		// 可能需要多一欄會員的信箱

//		ContactUs contactUs = new ContactUs();
		contactUs.setformID(formID);
//		contactUs.setOUserID(oUserID);
//		contactUs.setGUserID(gUserID);
//		contactUs.setFormPurpose(formPurpose);
//		contactUs.setFormContent(formContent);
//		contactUs.setFormPic(formPic);
//		contactUs.setFormTime(formTime);
		contactUs.setformStatus(formStatus);
//		contactUs.setFormType(formType);

		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("contactUs", contactUs); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/contactUsBack/set_form.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		contactUsSvcB.updateContactUs(contactUs);
//		ContactUs updatedContactUs = contactUsSvcB.getOneForm(formID);
//
//		// 比較數據使否更新
//		if(updatedContactUs.getFormStatus().equals(contactUs.getFormStatus())) {
//		  // 更新成功 
//			res.getWriter().print("success");
//		} else {
//		  // 更新失败
//			res.getWriter().print("failed");
//		}
		req.setAttribute("contactUs", contactUsSvcB.getOneForm(formID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("contactUs", contactUs); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/contactUsBack/all_form.jsp";
	}

}
