package com.pichill.time;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAOimpl implements TimeDAO {
	private static final String FIND_BY_PK = "SELECT * FROM time WHERE timeID = ?";
	private static final String GET_ALL = "SELECT * FROM time";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public Time getTimeByTimeID(Integer timeID) {
		// TODO Auto-generated method stub
		Time time = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, timeID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				time = new Time();
				time.setTimeID(rs.getInt("timeID"));
				time.setReserveTime(rs.getString("reserveTime"));
				time.setCourtID(rs.getInt("courtID"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return time;
	}
	
	@Override
	public List<Time > getAll() {
		// TODO Auto-generated method stub
		List<Time > timeList = new ArrayList<>();
		Time time = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				time = new Time();
				time.setTimeID(rs.getInt("timeID"));
				time.setReserveTime(rs.getString("reserveTime"));
				time.setCourtID(rs.getInt("courtID"));
				timeList.add(time);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return timeList;
	}
	
	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
}
