package com.pichill.backauthority;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	// MySQL 8.0.13以後只需保留serverTimezone設定即可
	public static final String URL = "jdbc:mysql://localhost:3306/PiChill?"
//			+ "useSSL=false&"                   // 不使用加密連線 (需有憑證才行)
			+ "rewriteBatchedStatements=true&" // 批次更新需要此資訊
			+ "serverTimezone=Asia/Taipei"; // 設定時區資訊
//			+ "allowPublicKeyRetrieval=true&"   // 配合MySQL 8以後版本對密碼儲存機制的設定
//			+ "useUnicode=true&"                // 使用Unicode編碼 (中文才不會亂碼)
//			+ "characterEncoding=utf-8";        // 字元採用UTF-8設定

	public static final String USER = "root";

	public static final String PASSWORD = "Vv4161911";

	public static void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		if (con != null) {
			try {
				con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
}
