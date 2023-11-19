package com.pichill.coupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pichill.time.Util;

public class CouponDAOImpl implments CouponDAO{
	private static final String INSERT_STMT= "INSERT INTO coupon(couponID, productID) VALUES(?, ?)"
	private static final String UPDATE_STMT = "UPDATE coupon SET couponID= ?, productID = ?";
	private static final String DELETE_STMT = "DELETE FROM coupon WHERE couponID =? ";
	private static final String FIND_BY_COUPONID = "SELECT * FROM coupon where couponID= ? ";
	private static final String GET_ALL = "SELECT * FROM coupon";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public void add(Coupon Coupon) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, coupon.);
			pstmt.setInt(2, coupon.());
			
			}
	}

	@Override
	public Coupon getCouponByCouponID(Integer couponID) {
		Coupon coupon = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_COUPONID);
			pstmt.setInt(1, couponID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				coupon = new Coupon();
				coupon.setCouponID(rs.getInt("couponID"));
				coupon.setProductID(rs.getInt("productID"));

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return coupon;
	}

public List<Coupon>getAll(){
	List<Coupon> couponList = new ArrayList<>();
	Coupon coupon = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
	con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
	pstmt = con.prepareStatement(GET_ALL);
	rs = pstmt.executeQuery();
	
	}catch(SQLException se) {
		se.printStackTrace();
	}finally {
		closeResources(con,pstmt,rs)};
	}return couponList;

}

	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// TODO Auto-generated method stub
		if (rs != null) {
			try {
				rs.close();
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
