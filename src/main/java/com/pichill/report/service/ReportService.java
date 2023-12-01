package com.pichill.report.service;

import java.util.List;

import com.pichill.report.entity.Report;

public interface ReportService {
	Report add(Report report);
	Report updateReport(Report report);
//	void delete(Integer reportID);
	Report getByReportID(Integer reportID);
//	List<Report> getAll();
}
