package com.pichill.comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CommentDAOImpl implements CommentDAO {
	private static final String INSERT_STMT = "INSERT INTO `comment`(gUserID,postID,commentContent,commentTime)VALUES(?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE `comment` SET gUserID=?,postID=?,commentContent=?,commentTime=? WHERE commentID = ?";
	private static final String DELETE_STMT = "DELETE FROM `comment` WHERE commentID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM `comment` WHERE commentID = ?";
	private static final String GET_ALL = "SELECT * FROM `comment`";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(Comment comment) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, comment.getgUserID());
			pstmt.setInt(2, comment.getPostID());
			pstmt.setString(3, comment.getCommentContent());
			pstmt.setTimestamp(4, comment.getCommentTime());

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
	public void update(Comment comment) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, comment.getgUserID());
			pstmt.setInt(2, comment.getPostID());
			pstmt.setString(3, comment.getCommentContent());
			pstmt.setTimestamp(4, comment.getCommentTime());
			pstmt.setInt(5, comment.getCommentID());

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
	public void delete(int commentID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, commentID);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, null);
		}
	}

	@Override
	public Comment findByPK(Integer commentID) {
		Comment comment = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, commentID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setgUserID(rs.getInt("gUserID"));
				comment.setPostID(rs.getInt("postID"));
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
			}
		} catch (SQLException se) {
			se.printStackTrace();

		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return comment;
	}

	@Override
	public List<Comment> getAll() {
		List<Comment> commentList = new ArrayList<Comment>();
		Comment comment = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				comment = new Comment();
				comment.setCommentID(rs.getInt("commentID"));
				comment.setgUserID(rs.getInt("gUserID"));
				comment.setPostID(rs.getInt("postID"));
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentTime(rs.getTimestamp("commentTime"));
				commentList.add(comment);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			Util.closeResources(con, pstmt, rs);
		}
		return commentList;
	}

}
