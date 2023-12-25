package com.pichill.backstage.reportb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.reportb.service.ReportServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.report.entity.Report;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelreport")
public class ReportExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		ReportServiceBack reportSvcB = new ReportServiceBack();
		List<Report> list = reportSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("report");

		 // 欄位清單
        String[] headers = {"檢舉編號","管理員編號","貼文編號","留言編號","檢舉時間","檢舉狀態","檢舉類別"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Report m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getReportID());
            dataRow.createCell(1).setCellValue(m.getManageID());
            dataRow.createCell(2).setCellValue(m.getPost().getPostID());
            dataRow.createCell(3).setCellValue(m.getComment().getCommentID());
            dataRow.createCell(4).setCellValue(m.getReportTime());
            dataRow.createCell(5).setCellValue(m.getReportStatus());
            dataRow.createCell(6).setCellValue(m.getReportType());
            
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=report.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
