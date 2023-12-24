package com.pichill.backstage.reserveorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.reserveorder.service.ReserveOrderServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.reserveorder.entity.ReserveOrder;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelreserve")
public class ReserveOrderExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		ReserveOrderServiceBack reserveOrderSvcB = new ReserveOrderServiceBack();
		List<ReserveOrder> list = reserveOrderSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("reserveOrder");

		 // 欄位清單
        String[] headers = {"預約訂單編號","一般會員編號","企業會員邊號","預約日期","時段編號","場地編號","球館編號","下單時間","人數","預約訂單狀態","訂單總金額"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            ReserveOrder m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getReserveOrderID());
            dataRow.createCell(1).setCellValue(m.getGeneralUser().getgUserID());
            dataRow.createCell(2).setCellValue(m.getOwnerUser().getoUserID());
            dataRow.createCell(3).setCellValue(m.getReserveDate());
            dataRow.createCell(4).setCellValue(m.getTimeRef().getTimeID());
            dataRow.createCell(5).setCellValue(m.getPlace().getPlaceID());
            dataRow.createCell(6).setCellValue(m.getCourt().getCourtID());
            dataRow.createCell(7).setCellValue(m.getOrderTime());
            dataRow.createCell(8).setCellValue(m.getOrderNum());
            dataRow.createCell(9).setCellValue(m.getOrderStatus());
            dataRow.createCell(10).setCellValue(m.getTotalCost());
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=reserveOrder.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
