package com.pichill.report;

import java.util.List;

public class ReportTest {

	public static void main(String[] args) {
		ReportDAO dao = new ReportDAOImpl();
		
		//新增
		Report report1 =new Report();
		report1.setManageID(13000002);
		report1.setPostID(null);
		report1.setCommentID(32000007);
		report1.setReportTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
		report1.setReportStatus(0);
		report1.setReportType(3);
		dao.add(report1);
		
//		//修改
		Report report2 =new Report();
		report2.setReportID(34000011);
		report2.setManageID(13000002);
		report2.setPostID(13000002);
		report2.setCommentID(32000007);
		report2.setReportTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
		report2.setReportStatus(1);
		report2.setReportType(5);
		dao.update(report2);
//		
//		//刪除
//		dao.delete(34000011);
//		
//		//查詢單筆
//		Report report3 = dao.findByPK(34000001);
//		System.out.print(report3.getReportID()+ ",");
//		System.out.print(report3.getManageID()+ ",");
//		System.out.print(report3.getPostID()+ ",");
//		System.out.print(report3.getCommentID()+ ",");
//		System.out.print(report3.getReportTime()+ ",");
//		System.out.print(report3.getReportStatus()+ ",");
//		System.out.print(report3.getReportType());
//		
//		//查詢多筆
//		List<Report>list = dao.getAll();
//		for(Report report:list) {
//			System.out.print(report.getReportID()+ ",");
//			System.out.print(report.getManageID()+ ",");
//			System.out.print(report.getPostID()+ ",");
//			System.out.print(report.getCommentID()+ ",");
//			System.out.print(report.getReportTime()+ ",");
//			System.out.print(report.getReportStatus()+ ",");
//			System.out.print(report.getReportType());
//			System.out.println();
//		}
	}
}
