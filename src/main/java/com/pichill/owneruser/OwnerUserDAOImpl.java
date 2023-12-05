package com.pichill.owneruser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class OwnerUserDAOImpl implements OwnerUserDAO {
	private static final String INSERT_STMT = "INSERT INTO owneruser(oUserID,oUserName,oPassword,oIDNum,compiled,oName,oGender,oBirth,oTelephone,oAddress,oBankCode,oBankAccount,oProfilePic,oRegisterDate,oPostAmount,oReportCnt,courtArriveCnt,couponArriveCnt,rsvdCnts,oEmail)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE Owneruser SET oUserName=?,oPassword=?,oIDNum=?,compiled=?,oName=?,oGender=?,oBirth=?,oTelephone=?,oAddress=?,oBankCode=?,oBankAccount=?,oProfilePic = ?,oRegisterDate=?,oPostAmount = ?,oReportCnt = ?,courtArriveCnt,couponArriveCnt = ?,rsvdCnts = ?,oEmail = ?WHERE oUserID = ? ";
	private static final String DELETE_STMT = "DELETE FROM owneruser WHERE oUserID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM owneruser WHERE oUserID = ?";
	private static final String GET_ALL = "SELECT * FROM owneruser";

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
	public void add(OwnerUser ownerUser) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

//			pstmt.setInt(1, ownerUser.getoUserID());
			pstmt.setString(1, ownerUser.getoName());
			pstmt.setString(2, ownerUser.getoPassword());
			pstmt.setString(3, ownerUser.getoIDNum());
			pstmt.setString(4, ownerUser.getCompiled());
			pstmt.setString(5, ownerUser.getoName());
			pstmt.setInt(6, ownerUser.getoGender());
			pstmt.setDate(7, ownerUser.getoBirth());
			pstmt.setString(8, ownerUser.getoTelephone());
			pstmt.setString(9, ownerUser.getoAddress());
			pstmt.setString(10, ownerUser.getoBankCode());
			pstmt.setString(11, ownerUser.getoBankAccount());
			pstmt.setBytes(12, ownerUser.getoProfilePic());
			pstmt.setDate(13, ownerUser.getoRegisterDate());
			pstmt.setInt(14, ownerUser.getoPostAmount());
			pstmt.setInt(15, ownerUser.getoReportCnt());
			pstmt.setInt(16, ownerUser.getCourtArriveCnt());
			pstmt.setInt(17, ownerUser.getCouponArriveCnt());
			pstmt.setInt(18, ownerUser.getRsvdCnts());
			pstmt.setString(19, ownerUser.getoEmail());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public void update(OwnerUser owneruser) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, owneruser.getoUserID());
			pstmt.setString(2, owneruser.getoUserName());
			pstmt.setString(3, owneruser.getoPassword());
			pstmt.setString(4, owneruser.getoIDNum());
			pstmt.setString(5, owneruser.getCompiled());
			pstmt.setString(6, owneruser.getoName());
			pstmt.setInt(7, owneruser.getoGender());
			pstmt.setDate(8, owneruser.getoBirth());
			pstmt.setString(9, owneruser.getoTelephone());
			pstmt.setString(10, owneruser.getoAddress());
			pstmt.setString(11, owneruser.getoBankCode());
			pstmt.setString(12, owneruser.getoBankAccount());
			pstmt.setBytes(13, owneruser.getoProfilePic());
			pstmt.setDate(14, owneruser.getoRegisterDate());
			pstmt.setInt(15, owneruser.getoPostAmount());
			pstmt.setInt(16, owneruser.getoReportCnt());
			pstmt.setInt(17, owneruser.getCourtArriveCnt());
			pstmt.setInt(18, owneruser.getCouponArriveCnt());
			pstmt.setInt(19, owneruser.getRsvdCnts());
			pstmt.setString(20, owneruser.getoEmail());

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
	public void delete(Integer oUserID) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, oUserID);

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
	public OwnerUser findByPK(Integer oUserID) {
		// TODO Auto-generated method stub
		OwnerUser ownerUser = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, oUserID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ownerUser = new OwnerUser();
				ownerUser.setoUserID(rs.getInt("oUserID"));
				ownerUser.setoUserName(rs.getString("oUserName"));
				ownerUser.setoPassword(rs.getString("oPassword"));
				ownerUser.setoIDNum(rs.getString("oIDNum"));
				ownerUser.setCompiled(rs.getString("compiled"));
				ownerUser.setoName(rs.getString("oName"));
				ownerUser.setoGender(rs.getInt("oGender"));
				ownerUser.setoBirth(rs.getDate("oBirth"));
				ownerUser.setoTelephone(rs.getString("oTelephone"));
				ownerUser.setoAddress(rs.getString("oAddress"));
				ownerUser.setoBankCode(rs.getString("oBankCode"));
				ownerUser.setoBankAccount(rs.getString("oBankAccount"));
				ownerUser.setoProfilePic(rs.getBytes("oProfilePic"));
				ownerUser.setoRegisterDate(rs.getDate("oRegisterDate"));
				ownerUser.setoPostAmount(rs.getInt("oPostAmount"));
				ownerUser.setoReportCnt(rs.getInt("oReportCnt"));
				ownerUser.setCourtArriveCnt(rs.getInt("courtArriveCnt"));
				ownerUser.setCouponArriveCnt(rs.getInt("couponArriveCnt"));
				ownerUser.setRsvdCnts(rs.getInt("rsvdCnts"));
				ownerUser.setoEmail(rs.getString("oEmail"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return ownerUser;
	}

	@Override
	public List<OwnerUser> getAll() {
		List<OwnerUser> ownerUserList = new ArrayList<OwnerUser>();
		OwnerUser owneuser = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OwnerUser ownerUser = new OwnerUser();
				ownerUser.setoUserID(rs.getInt("oUserID"));
				ownerUser.setoUserName(rs.getString("oUserName"));
				ownerUser.setoPassword(rs.getString("oPassword"));
				ownerUser.setoIDNum(rs.getString("oIDNum"));
				ownerUser.setCompiled(rs.getString("compiled"));
				ownerUser.setoName(rs.getString("oName"));
				ownerUser.setoGender(rs.getInt("oGender"));
				ownerUser.setoBirth(rs.getDate("oBirth"));
				ownerUser.setoTelephone(rs.getString("oTelephone"));
				ownerUser.setoAddress(rs.getString("oAddress"));
				ownerUser.setoBankCode(rs.getString("oBankCode"));
				ownerUser.setoBankAccount(rs.getString("oBankAccount"));
				ownerUser.setoProfilePic(rs.getBytes("oProfilePic"));
				ownerUser.setoRegisterDate(rs.getDate("oRegisterDate"));
				ownerUser.setoPostAmount(rs.getInt("oPostAmount"));
				ownerUser.setoReportCnt(rs.getInt("oReportCnt"));
				ownerUser.setCourtArriveCnt(rs.getInt("courtArriveCnt"));
				ownerUser.setCouponArriveCnt(rs.getInt("couponArriveCnt"));
				ownerUser.setRsvdCnts(rs.getInt("rsvdCnts"));
				ownerUser.setoEmail(rs.getString("oEmail"));
				
				ownerUserList.add(ownerUser);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return ownerUserList;
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
