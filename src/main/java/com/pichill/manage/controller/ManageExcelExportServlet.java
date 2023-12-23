package com.pichill.manage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcel")
public class ManageExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		ManageService manageSvc = new ManageService();
		List<Manage> list = manageSvc.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("manage");

		 // 欄位清單
        String[] headers = {"管理員編號","員工姓名","帳號","密碼","生日","性別","手機","緊急聯絡人","緊急連絡人電話","聯絡地址","入職日期","身分證","電子信箱","員工狀態" }; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Manage m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getManageID());
            dataRow.createCell(1).setCellValue(m.getmName());
            dataRow.createCell(2).setCellValue(m.getmUserName());
            dataRow.createCell(3).setCellValue(m.getmPassword());
            dataRow.createCell(4).setCellValue(m.getmBirth());
//            HSSFCell cell = dataRow.createCell(4);
//            cell.setCellValue(m.getmBirth()); 
//            cell.setCellStyle(dateStyle);
            dataRow.createCell(5).setCellValue(m.getmGender());
            dataRow.createCell(6).setCellValue(m.getmTelephone());
            dataRow.createCell(7).setCellValue(m.getmEmgContact());
            dataRow.createCell(8).setCellValue(m.getmEmgPhone());
            dataRow.createCell(9).setCellValue(m.getmAddress());
            dataRow.createCell(10).setCellValue(m.getmHiredate());
            dataRow.createCell(11).setCellValue(m.getmID());
            dataRow.createCell(12).setCellValue(m.getmEmail());
            dataRow.createCell(13).setCellValue(m.getmStatus());
            
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=manage.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
