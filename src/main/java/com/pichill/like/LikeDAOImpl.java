package com.pichill.like;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LikeDAOImpl implements LikeDAO {
	private static final String INSERT_STMT = "INSERT INTO `like`(gUserID,postID)VALUES(?,?)";
	private static final String UPDATE_STMT = "UPDATE `like` SET gUserID=?,postID=? WHERE likeID = ?";
	private static final String DELETE_STMT = "DELETE FROM `like` WHERE likeID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM `like` WHERE likeID = ?";
	private static final String GET_ALL = "SELECT * FROM `like`";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(Like like) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, like.getgUserID());
			pstmt.setInt(2, like.getPostID());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public void update(Like like) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, like.getgUserID());
			pstmt.setInt(2, like.getPostID());
			pstmt.setInt(3, like.getLikeID());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public void delete(int likeID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, likeID);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public Like findByPK(Integer likeID) {
		Like like = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, likeID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				like = new Like();
				like.setLikeID(rs.getInt("likeID"));
				like.setgUserID(rs.getInt("gUserID"));
				like.setPostID(rs.getInt("postID"));
			}
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return like;
	}

	@Override
	public List<Like> getAll() {
		List<Like> likeList = new ArrayList<Like>();
		Like like = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				like = new Like();
				like.setLikeID(rs.getInt("likeID"));
				like.setgUserID(rs.getInt("gUserID"));
				like.setPostID(rs.getInt("postID"));
				likeList.add(like);
			}
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return likeList;
	}
}
