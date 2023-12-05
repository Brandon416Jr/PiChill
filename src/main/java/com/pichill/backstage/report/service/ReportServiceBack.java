package com.pichill.backstage.report.service;

import java.util.List;

import com.pichill.backstage.report.model.ReportDAOImplBack;
import com.pichill.report.entity.Report;
import com.pichill.report.model.ReportDAO;

public class ReportServiceBack {
	private final ReportDAO dao;

	public ReportServiceBack() {
		dao = new ReportDAOImplBack();
	}
	
	public Report getOneReport(Integer reportID) {
		return dao.getByReportID(reportID);
	}

	public List<Report> getAll() {
		return dao.getAll();
	}
	
	public void deleteReport(Integer reportID) {
	dao.delete(reportID);
}
}
