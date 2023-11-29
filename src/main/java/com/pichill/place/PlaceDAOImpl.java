package com.pichill.place;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceDAOImpl implements PlaceDAO {
	private static final String INSERT_STMT = "INSERT INTO place(courtID,placeName,placeFee,ball)VALUES(?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE Place SET courtID=?,placeName=?,placeFee=?,ball=? WHERE placeID = ? ";
	private static final String DELETE_STMT = "DELETE FROM place WHERE placeID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM place WHERE placeID = ?";
	private static final String GET_ALL = "SELECT * FROM place";

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
	public void add(Place place) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			// pstmt.setInt(1, place.getPlaceID());
			pstmt.setInt(1, place.getCourtID());
			pstmt.setString(2, place.getPlaceName());
			pstmt.setInt(3, place.getPlaceFee());
			pstmt.setInt(4, place.getBall());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(Place place) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, place.getPlaceID());
			pstmt.setInt(2, place.getCourtID());
			pstmt.setString(3, place.getPlaceName());
			pstmt.setInt(4, place.getPlaceFee());
			pstmt.setInt(5, place.getBall());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(int placeID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, placeID);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public Place findByPK(Integer placeID) {
		Place place = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, placeID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				place = new Place();
				place.setPlaceID(rs.getInt("placeID"));
				place.setCourtID(rs.getInt("courtID"));
				place.setPlaceName(rs.getString("placeName"));
				place.setPlaceFee(rs.getInt("placeFee"));
				place.setBall(rs.getInt("ball"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return place;
	}

	@Override
	public List<Place> getAll() {
		List<Place> placeList = new ArrayList<>();
		Place place = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				place = new Place();
				place.setPlaceID(rs.getInt("placeID"));
				place.setCourtID(rs.getInt("courtID"));
				place.setPlaceName(rs.getString("placeName"));
				place.setPlaceFee(rs.getInt("placeFee"));
				place.setBall(rs.getInt("ball"));
				placeList.add(place);
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			closeResources(con, pstmt, rs);
		}
		return placeList;
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
