package com.pichill.util;


import java.io.File;
import java.io.FileOutputStream;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {
	 public static void main(String[] args) throws Exception {

	        // Create blank workbook
	        XSSFWorkbook workbook = new XSSFWorkbook();

	        // Create a blank sheet
	        XSSFSheet spreadsheet = workbook.createSheet(" Employee Info ");

	        // Create row object
	        XSSFRow row;

	        // This data needs to be written (Object[])
	        Map<String, Object[]> empinfo = new TreeMap<String, Object[]>();
	        empinfo.put("1", new Object[] { "編號", "姓名", "描述" });

	        empinfo.put("2", new Object[] { "10010", "李立", "技術經理" });

	        empinfo.put("3", new Object[] { "10011", "張曉龍", "微信它爹" });

	        empinfo.put("4", new Object[] { "10012", "王小飛", "技術作家" });

	        empinfo.put("5", new Object[] { "10013", "庫里", "NBA球員" });

	        empinfo.put("6", new Object[] { "10014", "李雙雙", "體操運動員" });

	        // Iterate over data and write to sheet
	        Set<String> keyid = empinfo.keySet();
	        int rowid = 0;

	        for (String key : keyid) {
	            row = spreadsheet.createRow(rowid++);
	            Object[] objectArr = empinfo.get(key);
	            int cellid = 0;

	            for (Object obj : objectArr) {
	                Cell cell = row.createCell(cellid++);
	                cell.setCellValue((String) obj);
	            }
	        }
	        // Write the workbook in file system
	        FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));

	        workbook.write(out);
	        out.close();
	        System.out.println("Writesheet.xlsx written successfully");
	        System.out.println(new File(".").getAbsolutePath());
	    }
}
