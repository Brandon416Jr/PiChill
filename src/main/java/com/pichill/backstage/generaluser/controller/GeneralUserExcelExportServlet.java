package com.pichill.backstage.generaluser.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.generaluser.service.GeneralUserServiceBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelguser")
public class GeneralUserExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		GeneralUserServiceBack gUserSvcB = new GeneralUserServiceBack();
		List<GeneralUser> list = gUserSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("generalUser");

		 // 欄位清單
        String[] headers = {"一般會員編號","姓名","連絡電話","電子信箱","聯絡地址","帳號狀態","性別","帳號","密碼","身分證","暱稱ID","貼文數","留言數","被檢舉數","註冊日期","生日","預約次數"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
        	GeneralUser m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getgUserID());
            dataRow.createCell(1).setCellValue(m.getgName());
            dataRow.createCell(2).setCellValue(m.getgTelephone());
            dataRow.createCell(3).setCellValue(m.getgEmail());
            dataRow.createCell(4).setCellValue(m.getgAddress());
            dataRow.createCell(5).setCellValue(m.getStatus());
            dataRow.createCell(6).setCellValue(m.getgGender());
            dataRow.createCell(7).setCellValue(m.getgUsername());
            dataRow.createCell(8).setCellValue(m.getgPassword());
            dataRow.createCell(9).setCellValue(m.getgIDNum());
            dataRow.createCell(10).setCellValue(m.getNicknameID());
            dataRow.createCell(11).setCellValue(m.getgPostAmount());
            dataRow.createCell(12).setCellValue(m.getCommentAmount());
            dataRow.createCell(13).setCellValue(m.getgReportCnt());
            dataRow.createCell(14).setCellValue(m.getgRegistDate());
            dataRow.createCell(15).setCellValue(m.getgBirth());
            dataRow.createCell(16).setCellValue(m.getYoyakuCnt());
            
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=generalUser.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
