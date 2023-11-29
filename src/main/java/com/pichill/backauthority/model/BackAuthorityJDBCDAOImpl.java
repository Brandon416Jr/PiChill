package com.pichill.backauthority.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pichill.backauthority.Util;
import com.pichill.backauthority.entity.BackAuthority;


public class BackAuthorityJDBCDAOImpl implements BackAuthorityDAO {
	private static final String INSERT_STMT = "INSERT INTO backAuthority(manageID, backFunctionID) VALUES (?, ?)";
	private static final String UPDATE_STMT = "UPDATE backAuthority SET manageID = ?, backFunctionID = ? WHERE backAuthorityID = ?";
	private static final String DELETE_STMT = "DELETE FROM backAuthority WHERE backAuthorityID  = ?";
	private static final String FIND_BY_PK = "SELECT * FROM backAuthority WHERE backAuthorityID = ?";
	private static final String GET_ALL = "SELECT * FROM backAuthority";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public int add(BackAuthority backAutority) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, backAutority.getManageID());
			pstmt.setInt(2, backAutority.getBackFunctionID());

			pstmt.executeUpdate();
			return 1;

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		return 0;
	}

	@Override
	public int update(BackAuthority backAutority) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, backAutority.getManageID());
			pstmt.setInt(2, backAutority.getBackFunctionID());
			pstmt.setInt(3, backAutority.getBackAuthorityID());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		return 0;
	}

//	@Override
//	public void delete(Integer backAuthorityID) {
//		// TODO Auto-generated method stub
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, backAuthorityID);
//			
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			closeResources(con, pstmt, null);
//		}
//	}

//	@Override
//	public BackAuthority getBackAuthorityByBackAuthorityID(Integer backAuthorityID) {
//		// TODO Auto-generated method stub
//		BackAuthority backAuthority = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, backAuthorityID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				backAuthority = new BackAuthority();
//				backAuthority.setBackAuthorityID(rs.getInt("backAuthorityID"));
//				backAuthority.setManageID(rs.getInt("manageID"));
//				backAuthority.setBackFunctionID(rs.getInt("backFunctionID"));
//				
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			closeResources(con, pstmt, rs);
//		}
//		return backAuthority;
//	}

	@Override
	public List<BackAuthority> getAll() {
		// TODO Auto-generated method stub
		List<BackAuthority> backAuthorityList = new ArrayList<>();
		BackAuthority backAuthority = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				backAuthority = new BackAuthority();
				backAuthority.setBackAuthorityID(rs.getInt("backAuthorityID"));
				backAuthority.setManageID(rs.getInt("manageID"));
				backAuthority.setBackFunctionID(rs.getInt("backFunctionID"));
				
				backAuthorityList.add(backAuthority);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return backAuthorityList;
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
