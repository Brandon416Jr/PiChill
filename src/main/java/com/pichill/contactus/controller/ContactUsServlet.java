package com.pichill.contactus.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

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

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ContactUsServlet", value = "/contactUs.do")
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
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String fID = req.getParameter("formID");
			if (fID == null || (fID.length() == 0)) {
				errorMsgs.put("formID", "請輸入表單編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("<%=request.getContextPath()%>/addContactUs.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer formID = null;
			try {
				formID = Integer.valueOf(fID);
			} catch (Exception e) {
				errorMsgs.put("formID", "表單編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("<%=request.getContextPath()%>/addContactUs.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ContactUsService contactUsSvc = new ContactUsServiceImpl();
			ContactUs contactUs = contactUsSvc.getOneContactUs(Integer.valueOf(formID));
			if (contactUs == null) {
				errorMsgs.put("formID", "查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("<%=request.getContextPath()%>/addContactUs.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("ContactUs", contactUs); // 資料庫取出的empVO物件,存入req
			req.setAttribute("getOne_For_Display", "true"); // 旗標getOne_For_Display見select_page.jsp的第155行 -->
//				String url = "/back-end/emp/listOneEmp.jsp";    // 成功轉交 listOneEmp.jsp
			String url = "<%=request.getContextPath()%>/addContactUs.jsp"; // 查詢完成後轉交select_page.jsp由其include
														// file="listOneEmp-div.fragment"
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String formPurpose = req.getParameter("formPurpose");
			String formContent = req.getParameter("formContent");

			java.sql.Date hiredate = null;
			try {
				hiredate = java.sql.Date.valueOf(req.getParameter("hiredate"));
			} catch (IllegalArgumentException e) {
				errorMsgs.put("hiredate", "雇用日期: 請勿空白");
			}

			// 照片
//			InputStream in = req.getPart("upFiles").getInputStream(); // 從javax.servlet.http.Part物件取得上傳檔案的InputStream
//			byte[] upFiles = null;
//			if (in.available() != 0) {
//				upFiles = new byte[in.available()];
//				in.read(upFiles);
//				in.close();
//			} else
//				errorMsgs.put("upFiles", "員工照片: 請上傳照片");
//			}
//			// Send the use back to the form, if there were errors
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/emp/addEmp.jsp");
//				failureView.forward(req, res);
//				return;
//			}

			/*************************** 2.開始新增資料 ***************************************/
			ContactUsServiceImpl contactUsSvc = new ContactUsServiceImpl();
			contactUsSvc.addContactUs();

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("success", "- (新增成功)");
			String url = "/contactus/successView.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

	}
}
