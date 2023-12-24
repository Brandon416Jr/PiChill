package com.pichill.backstage.place.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.place.service.PlaceServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.place.Place;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelplace")
public class PlaceExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		PlaceServiceBack placeSvcB = new PlaceServiceBack();
		List<Place> list = placeSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("place");

		 // 欄位清單
        String[] headers = {"場地編號","球館編號","名稱","費用","球類"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Place m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getPlaceID());
            dataRow.createCell(1).setCellValue(m.getCourt().getCourtID());
            dataRow.createCell(2).setCellValue(m.getPlaceName());
            dataRow.createCell(3).setCellValue(m.getPlaceFee());
            dataRow.createCell(4).setCellValue(m.getBall());
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=place.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
