package com.pichill.backstage.reportb.service;

import java.util.List;

import com.pichill.backstage.reportb.model.ReportDAOImplBack;
import com.pichill.report.entity.Report;
import com.pichill.backstage.reportb.model.ReportDAOBack;

public class ReportServiceBack {
	private final ReportDAOBack dao;

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

	public Report updateReport(Integer reportID, Integer reportStatus) {

		Report report = dao.getByReportID(reportID); // 先獲取現有的 MemberVO 物件
		if (report != null) {

			report.setReportStatus(reportStatus);

			dao.update(report);
		}

		return report;
	}
}
