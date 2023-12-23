package com.pichill.comment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pichill.comment.Util;
import com.pichill.comment.entity.Comment;
import com.pichill.post.entity.Post;
import com.pichill.post.model.PostDAOImpl;


public class CommentDAOImpl implements CommentDAO {

	private SessionFactory factory;
	
	public CommentDAOImpl() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public int add(Comment comment) {
		 Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        Integer id = (Integer) session.save(comment);
System.out.println("?????????????"+id);
		        tx.commit();
		        return id;
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); 
		        return -1;
		    } finally {
		        getSession().close();
		    }
	}

	@Override
	public int update(Comment comment) {
		Transaction tx = null;
	    try {
	        Session session = getSession();
	        tx = session.beginTransaction();

	        session.update(comment);

	        tx.commit();
	        return 1;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace(); 
	        return -1;
	    } finally {
	        getSession().close();
	    }
	}

	@Override
	public int delete(Integer commentID) {
		 Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        Comment comment = session.get(Comment.class, commentID);
		        if (comment != null) {
		            session.delete(comment);

		            tx.commit();
		            return 1;
		        } else {
		            tx.rollback(); // 回滚事务，因为未找到评论
		            return -1;
		        }
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); 
		        return -1;
		    } finally {
		        getSession().close();
		    }
	}

	@Override
	public Comment getByCommentID(Integer commentID) {
		Transaction tx = null;
	    try {
	        Session session = getSession();
	        tx = session.beginTransaction();

	        Comment comment = session.get(Comment.class, commentID);

	        tx.commit();
	        return comment;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace(); 
	        return null;
	    } finally {
	        getSession().close();
	    }
	}

	@Override
	public List<Comment> getAll(Integer postID) {
		Transaction tx = null;
	    try {
	        Session session = getSession();
	        tx = session.beginTransaction();

	        List<Comment> comments = session.createQuery(
	            "from Comment where postID = :postID",
	            Comment.class
	        )
	        .setParameter("postID", postID)
	        .list();

	        tx.commit();
	        return comments;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace(); 
	        return Collections.emptyList();
	    } finally {
	        getSession().close();
	    }
	}
	@Override
	public long getCommentCnt(Integer postID) {
		 Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        Long commentCount = session.createQuery(
		            "select count(*) from Comment WHERE postID = :postID",
		            Long.class
		        )
		        .setParameter("postID", postID)
		        .uniqueResult();

		        tx.commit();
		        return commentCount != null ? commentCount : 0; 
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); 
		        return 0;
		    } finally {
		        getSession().close();
		    }
	}
	
	
}
//	private static final String INSERT_STMT = "INSERT INTO `comment`(gUserID,postID,commentContent,commentTime)VALUES(?,?,?,?)";
//	private static final String UPDATE_STMT = "UPDATE `comment` SET gUserID=?,postID=?,commentContent=?,commentTime=? WHERE commentID = ?";
//	private static final String DELETE_STMT = "DELETE FROM `comment` WHERE commentID = ?";
//	private static final String FIND_BY_PK = "SELECT * FROM `comment` WHERE commentID = ?";
//	private static final String GET_ALL = "SELECT * FROM `comment`";
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
//	public void add(Comment comment) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setInt(1, comment.getgUserID());
//			pstmt.setInt(2, comment.getPostID());
//			pstmt.setString(3, comment.getCommentContent());
//			pstmt.setTimestamp(4, comment.getCommentTime());
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
//	}
//
//	@Override
//	public void update(Comment comment) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//
//			pstmt.setInt(1, comment.getgUserID());
//			pstmt.setInt(2, comment.getPostID());
//			pstmt.setString(3, comment.getCommentContent());
//			pstmt.setTimestamp(4, comment.getCommentTime());
//			pstmt.setInt(5, comment.getCommentID());
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
//	}
//
//	@Override
//	public void delete(int commentID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, commentID);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//	}
//
//	@Override
//	public Comment findByPK(Integer commentID) {
//		Comment comment = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, commentID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				comment = new Comment();
//				comment.setCommentID(rs.getInt("commentID"));
//				comment.setgUserID(rs.getInt("gUserID"));
//				comment.setPostID(rs.getInt("postID"));
//				comment.setCommentContent(rs.getString("commentContent"));
//				comment.setCommentTime(rs.getTimestamp("commentTime"));
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return comment;
//	}
//
//	@Override
//	public List<Comment> getAll() {
//		List<Comment> commentList = new ArrayList<Comment>();
//		Comment comment = null;
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
//				comment = new Comment();
//				comment.setCommentID(rs.getInt("commentID"));
//				comment.setgUserID(rs.getInt("gUserID"));
//				comment.setPostID(rs.getInt("postID"));
//				comment.setCommentContent(rs.getString("commentContent"));
//				comment.setCommentTime(rs.getTimestamp("commentTime"));
//				commentList.add(comment);
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return commentList;
//	}
//
//}
