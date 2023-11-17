package com.pichill.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CartDAOImpl implements CartDAO{
	private static final String INSERT_STMT = "INSERT INTO cart(productID, gUserID) VALUES (?, ?)";
	private static final String UPDATE_STMT = "UPDATE cart SET productID = ?, gUserID = ? WHERE cartID = ?";
	private static final String DELETE_STMT = "DELETE FROM cart WHERE cartID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM cart WHERE cartID = ?";
	private static final String GET_ALL = "SELECT * FROM cart";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void add(Cart cart) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, cart.getProductID());
			pstmt.setInt(2, cart.getgUserID());
			

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
	public void update(Cart cart) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, cart.getProductID());
			pstmt.setInt(2, cart.getgUserID());
			pstmt.setInt(3, cart.getCartID());
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(int cartID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, cartID);
			
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public Cart findByPK(Integer cartID) {
		Cart cart = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, cartID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cart = new Cart();
				cart.setCartID(rs.getInt("cartID"));
				cart.setProductID(rs.getInt("ProductID"));
				cart.setgUserID(rs.getInt("gUserID"));
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return cart;
	}

	@Override
	public List<Cart> getAll() {
		List<Cart> cartList = new ArrayList<>();
		Cart cart = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cart = new Cart();
				cart.setCartID(rs.getInt("cartID"));
				cart.setProductID(rs.getInt("productID"));
				cart.setgUserID(rs.getInt("gUserID"));
				cartList.add(cart);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return cartList;
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
