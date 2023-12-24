package com.pichill.backstage.commentb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.commentb.service.CommentServiceBack;
import com.pichill.comment.entity.Comment;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelcomment")
public class CommentExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		CommentServiceBack commentSvcB = new CommentServiceBack();
		List<Comment> list = commentSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("comment");

		 // 欄位清單
        String[] headers = {"留言編號","一般會員編號","貼文編號","留言內容","留言時間"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Comment m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getCommentID());
            dataRow.createCell(1).setCellValue(m.getGeneralUser().getgUserID());
            dataRow.createCell(2).setCellValue(m.getPostID());
            dataRow.createCell(3).setCellValue(m.getCommentContent());
            dataRow.createCell(4).setCellValue(m.getCommentTime());
           
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=comment.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
