package com.pichill.backstage.postb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pichill.backstage.postb.service.PostServiceBack;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.service.ManageService;
import com.pichill.post.entity.Post;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

@WebServlet("/exportexcelpost")
public class PostExcelExportServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 這裡调用Service獲取資料清單
		PostServiceBack postSvcB = new PostServiceBack();
		List<Post> list = postSvcB.getAll();

		// 使用Apache POI產生Excel檔案
		HSSFWorkbook workbook = new HSSFWorkbook();
//		HSSFDataFormat format = workbook.createDataFormat();
//		short dateFormat = format.getFormat("yyyy年m月d日");
//		HSSFCellStyle dateStyle = workbook.createCellStyle();
//        dateStyle.setDataFormat(dateFormat);
		HSSFSheet sheet = workbook.createSheet("post");

		 // 欄位清單
        String[] headers = {"貼文編號","一般會員編號","企業會員編號","標題","內文","貼文類別","發布時間","按讚數","留言數"}; 
        
        // 寫入標題列
        HSSFRow row = sheet.createRow(0);    
        for(int i=0; i<headers.length; i++){
            row.createCell(i).setCellValue(headers[i]);
        }
        
        
        
        // 寫入資料內容
        for(int i=0; i<list.size(); i++){
            Post m = list.get(i); 

            HSSFRow dataRow = sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(m.getPostID());
            dataRow.createCell(1).setCellValue(m.getGeneralUser().getgUserID());
            dataRow.createCell(2).setCellValue(m.getOwnerUser().getoUserID());
            dataRow.createCell(3).setCellValue(m.getPostTitle());
            dataRow.createCell(4).setCellValue(m.getPostContent());
            dataRow.createCell(5).setCellValue(m.getPostType());
            dataRow.createCell(6).setCellValue(m.getPostTime());
            dataRow.createCell(7).setCellValue(m.getLikeCnt());
            dataRow.createCell(8).setCellValue(m.getCommentCnt());
        }
		// 設定response header, 讓瀏覽器下載該檔案
        res.setContentType("application/vnd.ms-excel"); 
		res.setHeader("Content-Disposition", "attachment;filename=post.xls");

		// 寫出
		workbook.write(res.getOutputStream());

	}
}
