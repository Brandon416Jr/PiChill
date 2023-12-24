package com.pichill.backstage.owneruser.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.owneruser.service.OwnerUserServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.owneruser.entity.OwnerUser;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelouser")
public class OwnerUserExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		OwnerUserServiceBack oUserSvcB = new OwnerUserServiceBack();
		List<OwnerUser> list = oUserSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("ownerUser");

		 // 欄位清單
        String[] headers = {"企業會員編號","帳號","密碼","身分證","統編","姓名","性別","生日","聯絡電話","聯絡地址","銀行代號","銀行帳號","註冊日期","文章數","被檢舉數","球館上架次數","被預約次數","電子信箱","狀態"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            OwnerUser m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getoUserID());
            dataRow.createCell(1).setCellValue(m.getoUserName());
            dataRow.createCell(2).setCellValue(m.getoPassword());
            dataRow.createCell(3).setCellValue(m.getoIDNum());
            dataRow.createCell(4).setCellValue(m.getcompiled());
            dataRow.createCell(5).setCellValue(m.getoName());
            dataRow.createCell(6).setCellValue(m.getoGender());
            dataRow.createCell(7).setCellValue(m.getoBirth());
            dataRow.createCell(8).setCellValue(m.getoTelephone());
            dataRow.createCell(9).setCellValue(m.getoAddress());
            dataRow.createCell(10).setCellValue(m.getoBankCode());
            dataRow.createCell(11).setCellValue(m.getoBankAccount());
            dataRow.createCell(12).setCellValue(m.getoRegisterDate());
            dataRow.createCell(13).setCellValue(m.getoPostAmount());
            dataRow.createCell(13).setCellValue(m.getoReportCnt());
            dataRow.createCell(13).setCellValue(m.getCourtArriveCnt());
            dataRow.createCell(13).setCellValue(m.getRsvdCnts());
            dataRow.createCell(13).setCellValue(m.getoEmail());
            dataRow.createCell(13).setCellValue(m.getoStatus());            
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=ownerUser.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
