package com.pichill.backstage.reportb.model;

import java.util.List;

import com.pichill.report.entity.Report;

public interface ReportDAOBack {
	int add(Report report);
	int update(Report report);
	int delete(int reportID);
	Report getByReportID(Integer reportID);
	List<Report> getAll();
}
