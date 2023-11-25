package com.pichill.contactus.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pichill.contactus.Util;
import com.pichill.contactus.entity.ContactUs;


public class ContactUsDAOImpl implements ContactUsDAO{
	private static final String INSERT_STMT= "INSERT INTO contactUs(oUserID,gUserID,formPurpose,formContent,formPic,formTime,formStatus,formType)VALUES(?,?,?,?,?,?,?,?)";
    private static final String UPDATE_STMT= "UPDATE contactUs SET oUserID=?,gUserID=?,formPurpose=?,formContent=?,formPic=?,formTime=?,formStatus=?,formType=? WHERE formID = ? ";
    private static final String DELETE_STMT= "DELETE FROM contactUs WHERE formID = ?";
    private static final String FIND_BY_PK = "SELECT * FROM contactUs WHERE formID = ?";
    private static final String GET_ALL= "SELECT * FROM contactUs";  
    
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(ContactUs contactUs) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, contactUs.getOUserID());
			pstmt.setInt(2, contactUs.getGUserID());
			pstmt.setString(3, contactUs.getFormPurpose());
			pstmt.setString(4, contactUs.getFormContent());
			pstmt.setBytes(5, contactUs.getFormPic());
			pstmt.setString(6, contactUs.getFormContent());
			pstmt.setInt(7, contactUs.getFormStatus());
			pstmt.setInt(8, contactUs.getFormType());
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}


	@Override
	public void update(ContactUs contactUs) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, contactUs.getFormID());
			pstmt.setInt(2, contactUs.getOUserID());
			pstmt.setInt(3, contactUs.getGUserID());
			pstmt.setString(4, contactUs.getFormPurpose());
			pstmt.setString(5, contactUs.getFormContent());
			pstmt.setBytes(6, contactUs.getFormPic());
			pstmt.setString(7, contactUs.getFormContent());
			pstmt.setInt(8, contactUs.getFormStatus());
			pstmt.setInt(9, contactUs.getFormType());
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(Integer formID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, formID);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public ContactUs getContactUsByFormID(Integer formID) { 
		ContactUs contactUs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, formID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				contactUs = new ContactUs();
				contactUs.setFormID(rs.getInt("formID"));
				contactUs.setOUserID(rs.getInt("oUserID"));
				contactUs.setGUserID(rs.getInt("gUserID"));
				contactUs.setFormPurpose(rs.getString("formPurpose"));
				contactUs.setFormContent(rs.getString("formContent"));
				contactUs.setFormPic(rs.getBytes("formPic"));
				contactUs.setFormTime(rs.getTimestamp("formTime"));
				contactUs.setFormStatus(rs.getInt("formStatus"));
				contactUs.setFormStatus(rs.getInt("formType"));
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return contactUs;
	}

	@Override
	public List<ContactUs> getAll() {
		List<ContactUs> contactUsList = new ArrayList<>();
		ContactUs contactUs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				contactUs = new ContactUs();
				contactUs.setFormID(rs.getInt("formID"));
				contactUs.setOUserID(rs.getInt("oUserID"));
				contactUs.setGUserID(rs.getInt("gUserID"));
				contactUs.setFormPurpose(rs.getString("formPurpose"));
				contactUs.setFormContent(rs.getString("formContent"));
				contactUs.setFormPic(rs.getBytes("formPic"));
				contactUs.setFormTime(rs.getTimestamp("formTime"));
				contactUs.setFormStatus(rs.getInt("formStatus"));
				contactUs.setFormType(rs.getInt("formType"));
				
				contactUsList.add(contactUs);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return contactUsList;
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
    