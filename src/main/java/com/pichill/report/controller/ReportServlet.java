package com.pichill.report.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pichill.report.entity.Report;
import com.pichill.report.service.ReportService;
import com.pichill.report.service.ReportServiceImpl;

@WebServlet("/report/report.do")
public class ReportServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("insert".equals(action)) {
			Integer postID = Integer.valueOf(req.getParameter("postID"));
			System.out.println(postID);
			Integer reportType = Integer.valueOf(req.getParameter("reportType"));
			Report report = new Report();
			report.setPostID(postID);
			report.setReportType(reportType);
			report.setReportStatus(0);
			ReportService reportSvc = new ReportServiceImpl();
			Report addedReport = reportSvc.add(report);
			String json = new Gson().toJson(addedReport);
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}
	}
}
