package com.pichill.backstage.court.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.court.service.CourtServiceBack;
import com.pichill.court.Court;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelcourt")
public class CourtExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		CourtServiceBack courtSvc = new CourtServiceBack();
		List<Court> list = courtSvc.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("court");

		 // 欄位清單
        String[] headers = {"球館編號","企業會員編號","管理員編號","上架時間","申請上架時間","球館名稱","球館電話","球館地址","球館須知","地區","申請狀態","開館時間","閉館時間"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Court m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getCourtID());
            dataRow.createCell(1).setCellValue(m.getOwnerUser().getoUserID());
            dataRow.createCell(2).setCellValue(m.getManage().getManageID());
            dataRow.createCell(3).setCellValue(m.getCourtOnTime());
            dataRow.createCell(4).setCellValue(m.getCourtApplyTime());
            dataRow.createCell(5).setCellValue(m.getCourtName());
            dataRow.createCell(6).setCellValue(m.getCourtTelephone());
            dataRow.createCell(7).setCellValue(m.getCourtAddress());
            dataRow.createCell(8).setCellValue(m.getCourtRule());
            dataRow.createCell(9).setCellValue(m.getLoc());
            dataRow.createCell(10).setCellValue(m.getCourtApplyStatus());
            dataRow.createCell(11).setCellValue(m.getCourtOpenTime());
            dataRow.createCell(12).setCellValue(m.getCourtCloseTime());
          
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=court.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
