package com.pichill.report.service;

import java.util.List;

import com.pichill.report.entity.Report;
import com.pichill.report.model.ReportDAO;
import com.pichill.report.model.ReportDAOImpl;

public class ReportServiceImpl implements ReportService{
private ReportDAO dao;

public ReportServiceImpl() {
	dao = new ReportDAOImpl();
}

@Override
public Report add(Report report) {
	Integer id = dao.add(report);
	report = dao.getByReportID(id);
	return report;
}

@Override
public Report updateReport(Report report) {
	if (dao.update(report) == 1) {
		return report;
	} else
		return null;
}

//@Override
//public void delete(Integer reportID) {
//	// TODO Auto-generated method stub
//	
//}

@Override
public Report getByReportID(Integer reportID) {
	return dao.getByReportID(reportID);
}

//@Override
//public List<Report> getAll() {
//	return dao.getAll();
//}


}
