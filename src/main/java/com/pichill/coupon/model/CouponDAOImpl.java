package com.pichill.coupon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pichill.coupon.Util;
import com.pichill.coupon.entity.Coupon;

public class CouponDAOImpl implements CouponDAO {
	private static final String INSERT_STMT= "INSERT INTO coupon(productID) VALUES(?)";
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
	
	@Override
	public void add(Coupon coupon) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, coupon.getProductID());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

//改
	public void update(Coupon coupon) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, coupon.getCouponID());
			pstmt.setInt(2, coupon.getProductID());
			pstmt.executeUpdate();
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
		
	}
	//刪
	@Override
	public void delete(int couponID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, couponID);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, null);
		}
	}


	// 查
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
	
	@Override
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
	
	while(rs.next()) {
		coupon = new Coupon();
		coupon.setCouponID(rs.getInt("couponID"));
		coupon.setCouponID(rs.getInt("productID"));
//		coupon.setProductID(rs.getInt("productID"));
//		coupon.setProductID(rs.getInt("couponID"));
		couponList.add(coupon);
	}
	}catch(SQLException se) {
		se.printStackTrace();
	}finally {
		closeResources(con,pstmt,rs);
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
