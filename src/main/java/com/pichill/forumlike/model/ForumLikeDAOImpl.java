package com.pichill.forumlike.model;

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

import com.pichill.comment.entity.Comment;
import com.pichill.forumlike.Util;
import com.pichill.forumlike.entity.ForumLike;
import com.pichill.post.entity.Post;
import com.pichill.util.HibernateUtil;

public class ForumLikeDAOImpl implements ForumLikeDAO {
	private SessionFactory factory;

	public ForumLikeDAOImpl() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(ForumLike like) {
		  Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        Integer id = (Integer) session.save(like);

		        tx.commit();
		        return id;
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); // 记录异常或使用日志库
		        return -1;
		    } finally {
		        getSession().close();
		    }
	}

	@Override
	public int update(ForumLike like) {
		Transaction tx = null;
	    try {
	        Session session = getSession();
	        tx = session.beginTransaction();

	        session.update(like);

	        tx.commit();
	        return 1;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace(); // 记录异常或使用日志库
	        return -1;
	    } finally {
	        getSession().close();
	    }
	}

	@Override
	public int delete(int likeID) {
		 Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        ForumLike like = session.get(ForumLike.class, likeID);
		        if (like != null) {
		            session.delete(like);

		            tx.commit();
		            return 1;
		        } else {
		            tx.rollback(); // 回滚事务，因为未找到点赞信息
		            return -1;
		        }
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); // 记录异常或使用日志库
		        return -1;
		    } finally {
		        getSession().close();
		    }
	}

	@Override
	public ForumLike getByLikeID(Integer likeID) {
		Transaction tx = null;
	    try {
	        Session session = getSession();
	        tx = session.beginTransaction();

	        ForumLike like = session.get(ForumLike.class, likeID);

	        tx.commit();
	        return like;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace(); // 记录异常或使用日志库
	        return null;
	    } finally {
	        getSession().close();
	    }
	}

	@Override
	public List<ForumLike> getAll() {
		 Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        List<ForumLike> likes = session.createQuery("from ForumLike", ForumLike.class).list();

		        tx.commit();
		        return likes;
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); // 记录异常或使用日志库
		        return Collections.emptyList();
		    } finally {
		        getSession().close();
		    }
	}

	@Override
	public ForumLike getLikeByPostIDAndUserID(Integer postID, Integer gUserID) {
		 Transaction tx = null;
		    try {
		        Session session = getSession();
		        tx = session.beginTransaction();

		        ForumLike like = session.createQuery(
		            "from ForumLike WHERE postID = :postID AND gUserID = :gUserID",
		            ForumLike.class
		        )
		        .setParameter("postID", postID)
		        .setParameter("gUserID", gUserID)
		        .uniqueResult();

		        tx.commit();
		        return like;
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        e.printStackTrace(); // 记录异常或使用日志库
		        return null;
		    } finally {
		        getSession().close();
		    }
	}

	@Override
	public long getLikeCnt(Integer postID) {
		Transaction tx = null;
	    try {
	        Session session = getSession();
	        tx = session.beginTransaction();

	        Long like = session.createQuery(
	            "select count(*) from ForumLike WHERE postID = :postID AND likeStatus = 1",
	            Long.class
	        )
	        .setParameter("postID", postID)
	        .uniqueResult();

	        tx.commit();
	        return like != null ? like : 0; // 处理结果为 null 的情况，返回 0
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace(); // 记录异常或使用日志库
	        return 0; // 处理异常情况，返回 0
	    } finally {
	        getSession().close();
	    }
	}
}
//	private static final String INSERT_STMT = "INSERT INTO `like`(gUserID,postID)VALUES(?,?)";
//	private static final String UPDATE_STMT = "UPDATE `like` SET gUserID=?,postID=? WHERE likeID = ?";
//	private static final String DELETE_STMT = "DELETE FROM `like` WHERE likeID = ?";
//	private static final String FIND_BY_PK = "SELECT * FROM `like` WHERE likeID = ?";
//	private static final String GET_ALL = "SELECT * FROM `like`";
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
//	public void add(Like like) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setInt(1, like.getgUserID());
//			pstmt.setInt(2, like.getPostID());
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
//	public void update(Like like) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//
//			pstmt.setInt(1, like.getgUserID());
//			pstmt.setInt(2, like.getPostID());
//			pstmt.setInt(3, like.getLikeID());
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
//	public void delete(int likeID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, likeID);
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
//	public Like findByPK(Integer likeID) {
//		Like like = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, likeID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				like = new Like();
//				like.setLikeID(rs.getInt("likeID"));
//				like.setgUserID(rs.getInt("gUserID"));
//				like.setPostID(rs.getInt("postID"));
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return like;
//	}
//
//	@Override
//	public List<Like> getAll() {
//		List<Like> likeList = new ArrayList<Like>();
//		Like like = null;
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
//				like = new Like();
//				like.setLikeID(rs.getInt("likeID"));
//				like.setgUserID(rs.getInt("gUserID"));
//				like.setPostID(rs.getInt("postID"));
//				likeList.add(like);
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return likeList;
//	}
//}
