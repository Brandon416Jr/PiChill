package com.pichill.backstage.contactus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pichill.backstage.contactus.service.ContactUsServiceBack;
import com.pichill.contactus.entity.ContactUs;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelform")
public class ContactUsExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		ContactUsServiceBack formSvc = new ContactUsServiceBack();
		List<ContactUs> list = formSvc.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("contactUs");

		 // 欄位清單
        String[] headers = {"表單編號","企業會員編號","一般會員編號","主旨","內容","時間","狀態","表單類型"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            ContactUs m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getformID());
            dataRow.createCell(1).setCellValue(m.getOwnerUser().getoUserID());
            dataRow.createCell(2).setCellValue(m.getGeneralUser().getgUserID());
            dataRow.createCell(3).setCellValue(m.getformPurpose());
            dataRow.createCell(4).setCellValue(m.getformContent());
            dataRow.createCell(5).setCellValue(m.getformTime());
            dataRow.createCell(6).setCellValue(m.getformStatus());
            dataRow.createCell(7).setCellValue(m.getformType());            
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=contactUs.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
