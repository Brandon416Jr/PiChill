package com.pichill.report;

import java.util.List;

public interface ReportDAO {
	void add(Report report);
	void update(Report report);
	void delete(int reportID);
	Report findByPK(Integer ReportID);
	List<Report> getAll();
}
