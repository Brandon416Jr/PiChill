package com.pichill.court;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pichill.comment.entity.Comment;
import com.pichill.court.Util;


public class CourtDAOImpl implements CourtDAO{
	private static final String INSERT_STMT= "INSERT INTO court(oUserID,manageID,courtOnTime,courtApplyTime,courtName,courtPic,courtTelephone,courtAddress,courtRule,loc,courtApplyStatus,courtOpenTime,courtCloseTime)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT= "UPDATE Court SET oUserID=?,manageID=?,courtOnTime=?,courtApplyTime=?,courtName=?,courtPic=?,courtTelephone=?,courtAddress=?,courtRule=?,loc=?,courtApplyStatus=?,courtOpenTime=?,courtCloseTime=? WHERE courtID = ? ";
	private static final String DELETE_STMT= "DELETE FROM court WHERE courtID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM court WHERE courtID = ?";
	private static final String GET_ALL= "SELECT * FROM court";  
	       
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassCastException ce) {
			ce.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

		@Override
		public void add(Court court) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, court.getoUserID());
				pstmt.setInt(2, court.getManageID());
				pstmt.setTimestamp(3, court.getCourtOnTime());
				pstmt.setTimestamp(4, court.getCourtApplyTime());
				pstmt.setString(5, court.getCourtName());
				pstmt.setBytes(6, court.getCourtPic());
				pstmt.setString(7, court.getCourtTelephone());
				pstmt.setString(8, court.getCourtAddress());
				pstmt.setString(9, court.getCourtRule());
				pstmt.setString(10, court.getLoc());
				pstmt.setInt(11, court.getCourtApplyStatus());
				pstmt.setTime(12, court.getCourtOpenTime());
				pstmt.setTime(13, court.getCourtCloseTime());
				pstmt.executeUpdate();

			} catch (SQLException se) {
				se.printStackTrace();
				// Clean up JDBC resources
			} finally {
				Util.closeResources(con, pstmt, null);
			}
		}

		//更改
		@Override
		public void update(Court court) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(UPDATE_STMT);
				pstmt.setInt(1, court.getoUserID());
				pstmt.setTimestamp(2, court.getCourtOnTime());
				pstmt.setTimestamp(3, court.getCourtApplyTime());
				pstmt.setString(4, court.getCourtName());
				pstmt.setBytes(5, court.getCourtPic());
				pstmt.setString(6, court.getCourtTelephone());
				pstmt.setString(7, court.getCourtAddress());
				pstmt.setString(8, court.getCourtRule());
				pstmt.setString(9, court.getLoc());
				pstmt.setInt(10, court.getCourtApplyStatus());
				pstmt.setInt(11, court.getCourtID());
							
				pstmt.executeUpdate();
				

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				Util.closeResources(con, pstmt, null);
			}
		}

		@Override
		public void delete(int courtID) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(DELETE_STMT);

				pstmt.setInt(1, courtID);
				
				pstmt.executeUpdate();

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				Util.closeResources(con, pstmt, null);
			}
		}

		@Override
		public Court findByPK(Integer courtID) {
			Court court = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(FIND_BY_PK);
				pstmt.setInt(1, courtID);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					court = new Court();
					court.setCourtID(rs.getInt("courtID"));
					court.setoUserID(rs.getInt("oUserID"));
					court.setManageID(rs.getInt("manageID"));
					court.setCourtOnTime(rs.getTimestamp("courtOnTime"));
					court.setCourtApplyTime(rs.getTimestamp("courtApplyTime"));
					court.setCourtName(rs.getString("courtName"));
					court.setCourtPic(rs.getBytes("courtPic"));
					court.setCourtTelephone(rs.getString("courtTelephone"));
					court.setCourtAddress(rs.getString("courtAddress"));
					court.setCourtRule(rs.getString("courtRule"));
					court.setLoc(rs.getString("loc"));
					court.setCourtApplyStatus(rs.getInt("courtApplyStatus"));
				}

			} catch (SQLException se) {
				se.printStackTrace();
				// Clean up JDBC resources
			} finally {
				Util.closeResources(con, pstmt, rs);
			}
			return court;
		}

		@Override
		public List<Court> getAll() {
			List<Court> courtList = new ArrayList<Court>();
			Court court = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
				pstmt = con.prepareStatement(GET_ALL);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					court = new Court();
					court.setCourtID(rs.getInt("courtID"));
					court.setoUserID(rs.getInt("oUserID"));
					court.setManageID(rs.getInt("manageID"));
					court.setCourtOnTime(rs.getTimestamp("courtOnTime"));
					court.setCourtApplyTime(rs.getTimestamp("courtApplyTime"));
					court.setCourtName(rs.getString("courtName"));
					court.setCourtPic(rs.getBytes("courtPic"));
					court.setCourtTelephone(rs.getString("courtTelephone"));
					court.setCourtAddress(rs.getString("courtAddress"));
					court.setCourtRule(rs.getString("courtRule"));
					court.setLoc(rs.getString("loc"));
					court.setCourtApplyStatus(rs.getInt("courtApplyStatus"));
					courtList.add(court);
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				Util.closeResources(con, pstmt, rs);
			}
			return courtList;
		}

}

