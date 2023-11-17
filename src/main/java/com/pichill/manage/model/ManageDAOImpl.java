package com.pichill.manage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pichill.manage.Util;
import com.pichill.manage.entity.Manage;



public class ManageDAOImpl implements ManageDAO {
	private static final String INSERT_STMT = "INSERT INTO manage(mName, mUserName, mPassword, mBirth, mGender, mTelephone, mEmgContact, mEmgPhone, mAddress, mHiredate, mLastLogTime, mID, mEmail, mProfilePic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE manage SET mName = ?, mUserName = ?, mPassword = ?, mBirth = ?, mGender = ?, mTelephone = ?, mEmgContact = ?,  mEmgPhone = ?, mAddress = ?, mHiredate = ?, mLastLogTime = ?, mID = ?,  mEmail = ?, mProfilePic = ?  WHERE manageID = ?";
	private static final String DELETE_STMT = "DELETE FROM manage WHERE manageID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM manage WHERE manageID = ?";
	private static final String GET_ALL = "SELECT * FROM manage";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void add(Manage manage) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, manage.getmName());
			pstmt.setString(2, manage.getmUserName());
			pstmt.setString(3, manage.getmPassword());
			pstmt.setDate(4, manage.getmBirth());
			pstmt.setInt(5, manage.getmGender());
			pstmt.setString(6, manage.getmTelephone());
			pstmt.setString(7, manage.getmEmgContact());
			pstmt.setString(8, manage.getmEmgPhone());
			pstmt.setString(9, manage.getmAddress());
			pstmt.setDate(10, manage.getmHiredate());
			pstmt.setTimestamp(11, manage.getmLastLogTime());
			pstmt.setString(12, manage.getmID());
			pstmt.setString(13, manage.getmEmail());
			pstmt.setBytes(14, manage.getmProfilePic());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
		
	}


	@Override
	public void update(Manage manage) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			
			pstmt.setString(1, manage.getmName());
			pstmt.setString(2, manage.getmUserName());
			pstmt.setString(3, manage.getmPassword());
			pstmt.setDate(4, manage.getmBirth());
			pstmt.setInt(5, manage.getmGender());
			pstmt.setString(6, manage.getmTelephone());
			pstmt.setString(7, manage.getmEmgContact());
			pstmt.setString(8, manage.getmEmgPhone());
			pstmt.setString(9, manage.getmAddress());
			pstmt.setDate(10, manage.getmHiredate());
			pstmt.setTimestamp(11, manage.getmLastLogTime());
			pstmt.setString(12, manage.getmID());
			pstmt.setString(13, manage.getmEmail());
			pstmt.setBytes(14, manage.getmProfilePic());
			pstmt.setInt(15, manage.getManageID());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(Integer manageID) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, manageID);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public Manage getManageByManageID(Integer manageID) {
		// TODO Auto-generated method stub
		Manage manage = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, manageID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				manage = new Manage();
				manage.setManageID(rs.getInt("manageID"));
				manage.setmName(rs.getString("mName"));
				manage.setmUserName(rs.getString("mUserName"));
				manage.setmPassword(rs.getString("mPassword"));
				manage.setmBirth(rs.getDate("mBirth"));
				manage.setmGender(rs.getInt("mGender"));
				manage.setmTelephone(rs.getString("mTelephone"));
				manage.setmEmgContact(rs.getString("mEmgContact"));
				manage.setmEmgPhone(rs.getString("mEmgPhone"));
				manage.setmAddress(rs.getString("mAddress"));
				manage.setmHiredate(rs.getDate("mHiredate"));
				manage.setmLastLogTime(rs.getTimestamp("mLastLogTime"));
				manage.setmID(rs.getString("mID"));
				manage.setmEmail(rs.getString("mEmail"));
				manage.setmProfilePic(rs.getBytes("mProfilePic"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return manage;
	}

	@Override
	public List<Manage> getAll() {
		// TODO Auto-generated method stub
		List<Manage> manageList = new ArrayList<>();
		Manage manage = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				manage = new Manage();
				manage.setManageID(rs.getInt("manageID"));
				manage.setmName(rs.getString("mName"));
				manage.setmUserName(rs.getString("mUserName"));
				manage.setmPassword(rs.getString("mPassword"));
				manage.setmBirth(rs.getDate("mBirth"));
				manage.setmGender(rs.getInt("mGender"));
				manage.setmTelephone(rs.getString("mTelephone"));
				manage.setmEmgContact(rs.getString("mEmgContact"));
				manage.setmEmgPhone(rs.getString("mEmgPhone"));
				manage.setmAddress(rs.getString("mAddress"));
				manage.setmHiredate(rs.getDate("mHiredate"));
				manage.setmLastLogTime(rs.getTimestamp("mLastLogTime"));
				manage.setmID(rs.getString("mID"));
				manage.setmEmail(rs.getString("mEmail"));
				manage.setmProfilePic(rs.getBytes("mProfilePic"));
				manageList.add(manage);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return manageList;
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
