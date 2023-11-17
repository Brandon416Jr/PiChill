package com.pichill.reserveorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReserveOrderDAOImpl implements ReserveOrderDAO {
	private static final String INSERT_STMT = "INSERT INTO reserveOrder(reserveOrderID, gUserID, oUserID, timeID, placeID, couponID, orderTime,orderNum,orderStatus,totalCost) VALUES (?, ?, ?, ?, ?, ?, ?, ?,? ,?)";
	private static final String UPDATE_STMT = "UPDATE reserveOrder SET gUserID = ?, oUserID = ?, timeID = ?, placeID = ?, couponID = ?, orderTime = ?, orderNum = ?, orderStatus = ?, totalCost = ? WHERE reserveOrderID = ?";
	private static final String DELETE_STMT = "DELETE FROM reserveOrder WHERE reserveOrderID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM reserveOrder WHERE reserveOrderID = ?";
	private static final String GET_ALL = "SELECT * FROM reserveOrder";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(ReserveOrder reserveOrder) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, reserveOrder.getReserveOrderID());
			pstmt.setInt(2, reserveOrder.getgUserID());
			pstmt.setInt(3, reserveOrder.getoUserID());
			pstmt.setInt(4, reserveOrder.getTimeID());
			pstmt.setInt(5, reserveOrder.getPlaceID());
			pstmt.setInt(6, reserveOrder.getCouponID());
			pstmt.setTimestamp(7, reserveOrder.getOrderTime());
			pstmt.setInt(8, reserveOrder.getOrderNum());
			pstmt.setInt(9, reserveOrder.getOrderStatus());
			pstmt.setInt(10, reserveOrder.getTotalCost());

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
	public void update(ReserveOrder reserveOrder) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, reserveOrder.getgUserID());
			pstmt.setInt(2, reserveOrder.getoUserID());
			pstmt.setInt(3, reserveOrder.getTimeID());
			pstmt.setInt(4, reserveOrder.getPlaceID());
			pstmt.setInt(5, reserveOrder.getCouponID());
			pstmt.setTimestamp(6, reserveOrder.getOrderTime());
			pstmt.setInt(7, reserveOrder.getOrderNum());
			pstmt.setInt(8, reserveOrder.getOrderStatus());
			pstmt.setInt(9, reserveOrder.getTotalCost());
			pstmt.setInt(10, reserveOrder.getReserveOrderID());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(int reserveOrderID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, reserveOrderID);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public ReserveOrder findByPK(Integer reserveOrderID) {
		ReserveOrder res = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, reserveOrderID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				res = new ReserveOrder();
				res.setReserveOrderID(rs.getInt("reserveOrderID"));
				res.setgUserID(rs.getInt("gUserID"));
				res.setoUserID(rs.getInt("oUserID"));
				res.setTimeID(rs.getInt("timeID"));
				res.setPlaceID(rs.getInt("placeID"));
				res.setCouponID(rs.getInt("couponID"));
				res.setOrderTime(rs.getTimestamp("orderTime"));
				res.setOrderNum(rs.getInt("orderNum"));
				res.setOrderStatus(rs.getInt("orderStatus"));
				res.setTotalCost(rs.getInt("totalCost"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return res;
	}

	@Override
	public List<ReserveOrder> getAll() {
		List<ReserveOrder> resList = new ArrayList<>();
		ReserveOrder res = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				res = new ReserveOrder();
				res.setReserveOrderID(rs.getInt("reserveOrderID"));
				res.setgUserID(rs.getInt("gUserID"));
				res.setoUserID(rs.getInt("oUserID"));
				res.setTimeID(rs.getInt("timeID"));
				res.setPlaceID(rs.getInt("placeID"));
				res.setCouponID(rs.getInt("couponID"));
				res.setOrderTime(rs.getTimestamp("orderTime"));
				res.setOrderNum(rs.getInt("orderNum"));
				res.setOrderStatus(rs.getInt("orderStatus"));
				res.setTotalCost(rs.getInt("totalCost"));
				resList.add(res);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return resList;
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
