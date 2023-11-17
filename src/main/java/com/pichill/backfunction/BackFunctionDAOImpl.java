package com.pichill.backfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BackFunctionDAOImpl implements BackFunctionDAO{
	private static final String FIND_BY_PK = "SELECT * FROM backFunction WHERE backFunctionID = ?";
	private static final String GET_ALL = "SELECT * FROM  backFunction";
	@Override
	public BackFunction getBackFunctionBybackFunctionID(Integer backFunctionID) {
		// TODO Auto-generated method stub
		BackFunction backFunction = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, backFunctionID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				backFunction = new BackFunction();
				backFunction.setBackFunctionID(rs.getInt("backFunctionID"));
				backFunction.setBackFunctionName(rs.getString("BackFunctionName"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return backFunction;
	}

	@Override
	public List<BackFunction> getAll() {
		// TODO Auto-generated method stub
		List<BackFunction> backFunctionList = new ArrayList<>();
		BackFunction backFunction = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				backFunction = new BackFunction();
				backFunction.setBackFunctionID(rs.getInt("backFunctionID"));
				backFunction.setBackFunctionName(rs.getString("backFunctionName"));
				backFunctionList.add(backFunction);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return backFunctionList;
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
