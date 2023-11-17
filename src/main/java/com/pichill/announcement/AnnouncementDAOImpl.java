package com.pichill.announcement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class AnnouncementDAOImpl implements AnnouncementDAO {
	private static final String INSERT_STMT = "INSERT INTO announcement(manageID, annoTitle,annoContent, annoPic, annoTime) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE announcement SET manageID = ?, annoTitle = ?, annoContent = ?, annoPic = ?, annoTime = ? WHERE announceID = ?";
	private static final String DELETE_STMT = "DELETE FROM announcement WHERE announceID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM announcement WHERE announceID = ?";
	private static final String GET_ALL = "SELECT * FROM announcement";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void add(Announcement announcement) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, announcement.getManageID());
			pstmt.setString(2, announcement.getAnnoTitle());
			pstmt.setString(3, announcement.getAnnoContent());
			pstmt.setBytes(4, announcement.getAnnoPic());
			pstmt.setTimestamp(5, announcement.getAnnoTime());

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
	public void update(Announcement announcement) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			
			pstmt.setInt(1, announcement.getManageID());
			pstmt.setString(2, announcement.getAnnoTitle());
			pstmt.setString(3, announcement.getAnnoContent());
			pstmt.setBytes(4, announcement.getAnnoPic());
			pstmt.setTimestamp(5, announcement.getAnnoTime());
			pstmt.setInt(6, announcement.getAnnounceID());

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
	public void delete(Integer announceID) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, announceID);
			
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
	public Announcement getAnnouncementByAnnounceID(Integer announceID) {
		// TODO Auto-generated method stub
		Announcement announcement = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, announceID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				announcement = new Announcement();
				announcement.setAnnounceID(rs.getInt("announceID"));
				announcement.setManageID(rs.getInt("manageID"));
				announcement.setAnnoTitle(rs.getString("annoTitle"));
				announcement.setAnnoContent(rs.getString("annoContent"));
				announcement.setAnnoPic(rs.getBytes("annoPic"));
				announcement.setAnnoTime(rs.getTimestamp("annoTime"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return announcement;
	}
	
	@Override
	public List<Announcement > getAll() {
		// TODO Auto-generated method stub
		List<Announcement > announcementList = new ArrayList<>();
		Announcement announcement = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				announcement  = new Announcement ();
				announcement.setAnnounceID(rs.getInt("announceID"));
				announcement.setManageID(rs.getInt("manageID"));
				announcement.setAnnoTitle(rs.getString("annoTitle"));
				announcement.setAnnoContent(rs.getString("annoContent"));
				announcement.setAnnoPic(rs.getBytes("annoPic"));
				announcement.setAnnoTime(rs.getTimestamp("annoTime"));
				announcementList.add(announcement);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return announcementList;
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
