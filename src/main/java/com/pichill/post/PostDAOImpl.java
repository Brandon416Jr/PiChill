package com.pichill.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PostDAOImpl implements PostDAO{
	private static final String INSERT_STMT = "INSERT INTO post(gUserID,oUserID, postTitle, postContent, postType,postTime, likeCnt) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE post SET gUserID = ?, oUserID = ?, postTitle = ?, postContent = ?, postType = ?, postTime = ?,likeCnt = ? WHERE postID = ?";
	private static final String DELETE_STMT = "DELETE FROM post WHERE postID = ?";
	private static final String FIND_BY_PK = "SELECT * FROM post WHERE postID = ?";
	private static final String GET_ALL = "SELECT * FROM post";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	
	@Override
	public void add(Post post) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, post.getgUserID());
			pstmt.setInt(2, post.getoUserID());
			pstmt.setString(3, post.getPostTitle());
			pstmt.setString(4, post.getPostContent());
			pstmt.setInt(5, post.getPostType());
			pstmt.setTimestamp(6, post.getPostTime());
			pstmt.setInt(7, post.getLikeCnt());

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
	public void update(Post post) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
	
			pstmt.setInt(1, post.getgUserID());
			pstmt.setInt(2, post.getoUserID());
			pstmt.setString(3, post.getPostTitle());
			pstmt.setString(4, post.getPostContent());
			pstmt.setInt(5, post.getPostType());
			pstmt.setTimestamp(6, post.getPostTime());
			pstmt.setInt(7, post.getLikeCnt());
			pstmt.setInt(8, post.getPostID());

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
	public void delete(int postID) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, postID);
			
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
	public Post findByPK(Integer PostID) {
		Post post = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1,PostID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				post = new Post();
				post.setPostID(rs.getInt("postID"));	
				post.setgUserID(rs.getInt("gUserID"));		
				post.setoUserID(rs.getInt("oUserID"));		
				post.setPostTitle(rs.getString("postTitle"));		
				post.setPostContent(rs.getString("postContent"));		
				post.setPostType(rs.getInt("postType"));		
				post.setPostTime(rs.getTimestamp("postTime"));		
				post.setLikeCnt(rs.getInt("likeCnt"));		
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, rs);
		}
		return post;
	}
	@Override
	public List<Post> getAll() {
		List<Post>postList = new ArrayList<>();
		Post post = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				post = new Post();
				post.setPostID(rs.getInt("postID"));	
				post.setgUserID(rs.getInt("gUserID"));		
				post.setoUserID(rs.getInt("oUserID"));		
				post.setPostTitle(rs.getString("postTitle"));		
				post.setPostContent(rs.getString("postContent"));		
				post.setPostType(rs.getInt("postType"));		
				post.setPostTime(rs.getTimestamp("postTime"));		
				post.setLikeCnt(rs.getInt("likeCnt"));
				postList.add(post);
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			Util.closeResources(con, pstmt, rs);
		}
		return postList;
	}
	
}


