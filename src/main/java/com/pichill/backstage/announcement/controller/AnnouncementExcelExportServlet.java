package com.pichill.backstage.announcement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.announcement.service.AnnouncementServiceBack;
import com.pichill.backstage.announcement.entity.Announcement;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelannouncement")
public class AnnouncementExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		AnnouncementServiceBack annoSvc = new AnnouncementServiceBack();
		List<Announcement> list = annoSvc.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("announcement");

		 // 欄位清單
        String[] headers = {"公告編號","管理員編號","表單編號","標題","內文","時間","公告狀態"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Announcement m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getAnnounceID());
            dataRow.createCell(1).setCellValue(m.getManage().getManageID());
            dataRow.createCell(2).setCellValue(m.getFormID());
            dataRow.createCell(3).setCellValue(m.getAnnoTitle());
            dataRow.createCell(4).setCellValue(m.getAnnoContent());
            dataRow.createCell(5).setCellValue(m.getAnnoTime());
            dataRow.createCell(6).setCellValue(m.getAnnoStatus());
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=announcement.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
