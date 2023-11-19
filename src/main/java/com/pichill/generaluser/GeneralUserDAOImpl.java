package com.pichill.generaluser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GeneralUserDAOImpl implements GeneralUserDAO{

	private static final String INSERT_STMT = "INSERT INTO generalUser (gName,gTelephone,gEmail,gAddress,`status`,gGender,gPassword,gIDNum,nicknameID,piAmount,couponAmount,gPostAmount,commentAmount,gReportCnt,gRegistDate,gLastLogTime,gBirth,purchaseCnt,yoyakuCnt,gProfilePic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE generalUser SET gName = ?, gTelephone = ?, gEmail = ?, gAddress = ?, `status` = ?, gGender = ?, gPassword = ?, gIDNum = ? nicknameID = ?, piAmount = ?, couponAmount = ?, gPostAmount = ?, commentAmount = ?, gReportCnt = ?, gRegistDate = ?, gLastLogTime = ?, gBirth = ?, purchaseCnt = ?, yoyakuCnt = ?, gProfilePic = ? WHERE gUserID = ?";
	private static final String DELETE_STMT = "DELETE FROM generalUser WHERE gUserID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM generalUser WHERE gUserID = ?";
	private static final String GET_ALL = "SELECT * FROM generalUser";
			
	static {
		try {
			Class.forName(Util.DRIVER);

		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void add(GeneralUser generalUser) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, generalUser.getgName());
			pstmt.setString(2, generalUser.getgTelephone());
			pstmt.setString(3, generalUser.getgEmail());
			pstmt.setString(4, generalUser.getgAddress());
			pstmt.setInt(5, generalUser.getStatus());
			pstmt.setInt(6, generalUser.getgGender());
			pstmt.setString(7, generalUser.getgPassword());
			pstmt.setString(8, generalUser.getgIDNum());
			pstmt.setObject(9, generalUser.getNicknameID());
			pstmt.setObject(10, generalUser.getPiAmount());
			pstmt.setObject(11, generalUser.getCouponAmount());
			pstmt.setInt(12, generalUser.getgPostAmount());
			pstmt.setInt(13, generalUser.getCommentAmount());
			pstmt.setInt(14, generalUser.getgReportCnt());
			pstmt.setDate(15, generalUser.getgRegistDate());
			pstmt.setTimestamp(16, generalUser.getgLastLogTime());
			pstmt.setDate(17, generalUser.getgBirth());
			pstmt.setInt(18, generalUser.getPurchaseCnt());
			pstmt.setInt(19, generalUser.getYoyakuCnt());
			pstmt.setBytes(20, generalUser.getgProfilePic());
			
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(GeneralUser generalUser) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setString(1, generalUser.getgName());
			pstmt.setString(2, generalUser.getgTelephone());
			pstmt.setString(3, generalUser.getgEmail());
			pstmt.setString(4, generalUser.getgAddress());
			pstmt.setInt(5, generalUser.getStatus());
			pstmt.setInt(6, generalUser.getgGender());
			pstmt.setString(7, generalUser.getgPassword());
			pstmt.setString(8, generalUser.getgIDNum());
			pstmt.setObject(9, generalUser.getNicknameID());
			pstmt.setObject(10, generalUser.getPiAmount());
			pstmt.setObject(11, generalUser.getCouponAmount());
			pstmt.setObject(12, generalUser.getgPostAmount());
			pstmt.setInt(13, generalUser.getCommentAmount());
			pstmt.setInt(14, generalUser.getgReportCnt());
			pstmt.setDate(15, generalUser.getgRegistDate());
			pstmt.setTimestamp(16, generalUser.getgLastLogTime());
			pstmt.setDate(17, generalUser.getgBirth());
			pstmt.setInt(18, generalUser.getPurchaseCnt());
			pstmt.setInt(19, generalUser.getYoyakuCnt());
			pstmt.setBytes(20, generalUser.getgProfilePic());
			pstmt.setInt(21, generalUser.getgUserID());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(int gUserID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, gUserID);
			
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
	public GeneralUser findByPK(Integer gUserID) {
		GeneralUser gen = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, gUserID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				gen = new GeneralUser();
				gen.setgUserID(rs.getInt("gUserID"));
				gen.setgName(rs.getString("gName"));
				gen.setgTelephone(rs.getString("gTelephone"));
				gen.setgEmail(rs.getString("gEmail"));
				gen.setgAddress(rs.getString("gAddress"));
				gen.setStatus(rs.getInt("status"));
				gen.setgGender(rs.getInt("gGender"));
				gen.setgPassword(rs.getString("gPassword"));
				gen.setgIDNum(rs.getString("gIDNum"));
				gen.setNicknameID(rs.getString("nicknameID"));
				gen.setPiAmount(rs.getInt("piAmount"));
				gen.setCouponAmount(rs.getInt("couponAmount"));
				gen.setgPostAmount(rs.getInt("gPostAmount"));
				gen.setCommentAmount(rs.getInt("commentAmount"));
				gen.setgReportCnt(rs.getInt("gReportCnt"));
				gen.setgRegistDate(rs.getDate("gRegistDate"));
				gen.setgLastLogTime(rs.getTimestamp("gLastLogTime"));
				gen.setgBirth(rs.getDate("gBirth"));
				gen.setPurchaseCnt(rs.getInt("purchaseCnt"));
				gen.setYoyakuCnt(rs.getInt("yoyakuCnt"));
				gen.setgProfilePic(rs.getBytes("gProfilePic"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return gen;
	}

	@Override
	public List<GeneralUser> getAll() {
		List<GeneralUser> genList = new ArrayList<>();
		GeneralUser gen = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				gen = new GeneralUser();
				gen.setgUserID(rs.getInt("gUserID"));
				gen.setgName(rs.getString("gName"));
				gen.setgTelephone(rs.getString("gTelephone"));
				gen.setgEmail(rs.getString("gEmail"));
				gen.setgAddress(rs.getString("gAddress"));
				gen.setStatus(rs.getInt("status"));
				gen.setgGender(rs.getInt("gGender"));
				gen.setgPassword(rs.getString("gPassword"));
				gen.setgIDNum(rs.getString("gIDNum"));
				gen.setNicknameID(rs.getString("nicknameID"));
				gen.setPiAmount(rs.getInt("piAmount"));
				gen.setCouponAmount(rs.getInt("couponAmount"));
				gen.setgPostAmount(rs.getInt("gPostAmount"));
				gen.setCommentAmount(rs.getInt("commentAmount"));
				gen.setgReportCnt(rs.getInt("gReportCnt"));
				gen.setgRegistDate(rs.getDate("gRegistDate"));
				gen.setgLastLogTime(rs.getTimestamp("gLastLogTime"));
				gen.setgBirth(rs.getDate("gBirth"));
				gen.setPurchaseCnt(rs.getInt("purchaseCnt"));
				gen.setYoyakuCnt(rs.getInt("yoyakuCnt"));
				gen.setgProfilePic(rs.getBytes("gProfilePic"));
				genList.add(gen);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return genList;
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
