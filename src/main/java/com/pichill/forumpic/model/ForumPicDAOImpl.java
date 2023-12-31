package com.pichill.forumpic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.forumpic.Util;
import com.pichill.forumpic.entity.ForumPic;

public class ForumPicDAOImpl implements ForumPicDAO {
	private SessionFactory factory;

	public ForumPicDAOImpl() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(ForumPic forumPic) {
		return (Integer) getSession().save(forumPic);

	}

	@Override
	public int update(ForumPic forumPic) {
		try {
			getSession().update(forumPic);
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(int forumPicID) {
		ForumPic forumPic = getSession().get(ForumPic.class, forumPicID);
		if (forumPic != null) {
			getSession().delete(forumPic);
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public ForumPic getByForumPicID(Integer forumPicID) {
		getSession().clear();
		return getSession().get(ForumPic.class,forumPicID);
	}

	@Override
	public List<ForumPic> getAll() {
	return getSession().createQuery("from ForumPic",ForumPic.class).list();
	}

}
//	private static final String INSERT_STMT = "INSERT INTO forumPic(postID,postPic, picTime) VALUES (?, ?, ?)";
//	private static final String UPDATE_STMT = "UPDATE forumPic SET postID = ?, postPic = ?, picTime = ?WHERE forumPicID = ?";
//	private static final String DELETE_STMT = "DELETE FROM forumPic WHERE forumPicID = ?";
//	private static final String FIND_BY_PK = "SELECT * FROM forumPic WHERE forumPicID = ?";
//	private static final String GET_ALL = "SELECT * FROM forumPic";
//
//	static {
//		try {
//			Class.forName(Util.DRIVER);
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
//	}
//
//	@Override
//	public void add(ForumPic forumPic) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setBytes(1, forumPic.getPostPic());
//			pstmt.setTimestamp(2, forumPic.getPicTime());
//			pstmt.setInt(3, forumPic.getForumPicID());
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public void update(ForumPic forumPic) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//
//			pstmt.setInt(1, forumPic.getPostID());
//			pstmt.setBytes(2, forumPic.getPostPic());
//			pstmt.setTimestamp(3, forumPic.getPicTime());
//			pstmt.setInt(4, forumPic.getForumPicID());
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public void delete(int forumPicID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, forumPicID);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public ForumPic findByPK(Integer forumPicID) {
//		ForumPic forumPic = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, forumPicID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				forumPic = new ForumPic();
//				forumPic.setForumPicID(rs.getInt("forumPicID"));
//				forumPic.setPostID(rs.getInt("postID"));
//				forumPic.setPostPic(rs.getBytes("postPic"));
//				forumPic.setPicTime(rs.getTimestamp("picTime"));
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return forumPic;
//	}
//
//	@Override
//	public List<ForumPic> getAll() {
//		List<ForumPic> forumPicList = new ArrayList<ForumPic>();
//		ForumPic forumPic = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(GET_ALL);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				forumPic = new ForumPic();
//				forumPic.setForumPicID(rs.getInt("forumPicID"));
//				forumPic.setPostID(rs.getInt("postID"));
//				forumPic.setPostPic(rs.getBytes("postPic"));
//				forumPic.setPicTime(rs.getTimestamp("picTime"));
//				forumPicList.add(forumPic);
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return forumPicList;
//	}
//
//}
