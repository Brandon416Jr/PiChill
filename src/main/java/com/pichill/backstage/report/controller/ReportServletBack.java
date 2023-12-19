package com.pichill.backstage.report.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.comment.service.CommentServiceBack;
import com.pichill.backstage.report.service.ReportServiceBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.report.entity.Report;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
@WebServlet(name = "ReportBServlet", value = "/report/reportb.do")
public class ReportServletBack extends HttpServlet {
	private ReportServiceBack reportSvcB;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		reportSvcB = new ReportServiceBack();
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
//		case "insert":
//			// 來自new_manage.jsp的請求
//			forwardPath = insert(req, res);
//			break;
		case "delete":
			// 來自new_manage.jsp的請求
			forwardPath = delete(req, res);
			break;
		default:
			forwardPath = "/backstage/reportBack/all_report.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}
	
	private String getOneUpdate(HttpServletRequest req, HttpServletResponse res) {
//		Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
//		req.setAttribute("errorMsgs", errorMsgs);
		Integer reportID = Integer.valueOf(req.getParameter("reportID"));
		ReportServiceBack reportSvcB = new ReportServiceBack();
		Report report = reportSvcB.getOneReport(reportID);

		req.setAttribute("report", report);
		return "/backstage/reportBack/set_report.jsp";
	}
	
	private String update(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 錯誤處理
		List<String> errorMsgs = new ArrayList<>();
		req.setAttribute("errorMsgs", errorMsgs);

		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
		Integer reportID = Integer.valueOf(req.getParameter("reportID"));
		Report report = reportSvcB.getOneReport(reportID);


		Integer reportStatus = Integer.valueOf(req.getParameter("reportStatus"));


		report.setReportID(reportID);

		report.setReportStatus(reportStatus);

		
		
		// Send the use back to the form, if there were errors
		if (!errorMsgs.isEmpty()) {
			req.setAttribute("report", report); // 含有輸入格式錯誤的manage物件,也存入req
			return "/backstage/reportBack/set_report.jsp"; // 程式中斷
		}

		/*************************** 2.開始修改資料 *****************************************/
		report = reportSvcB.updateReport( reportID, reportStatus);
		req.setAttribute("report",reportSvcB.getOneReport(reportID));

		/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
		req.setAttribute("report", report); // 資料庫update成功後,正確的的manage物件,存入req
		return "/backstage/reportBack/all_report.jsp";
	}
	
	private String delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<String> errorMsgs = new LinkedList<String>();
		// Store this set in the request scope, in case we need to
		// send the ErrorPage view.
		req.setAttribute("errorMsgs", errorMsgs);
		/*************************** 1.接收請求參數 ***************************************/
		Integer reportID = Integer.valueOf(req.getParameter("reportID"));

		/*************************** 2.開始刪除資料 ***************************************/
		ReportServiceBack reportSvcB = new ReportServiceBack();
		reportSvcB.deleteReport(reportID);

		/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
		return "/backstage/reportBack/all_report.jsp";
		
	}
}
