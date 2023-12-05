package com.pichill.post.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pichill.post.entity.Post;
import com.pichill.util.HibernateUtil;

public class PostDAOImpl implements PostDAO{

	private static final int PAGE_MAX_RESULT = 4;
	private SessionFactory factory;

	public PostDAOImpl() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(Post entity) {
		SessionFactory factory2 = HibernateUtil.getSessionFactory();
		Session session = factory2.openSession();
		Transaction tx = session.beginTransaction();
//		 回傳給 service 剛新增成功的自增主鍵值
//		entity.setPostTime(new java.sql.Timestamp(System.currentTimeMillis()));
		session.save(entity);
		tx.commit();
		return 1;
//		return(Integer)getSession().save(entity);
	}

	@Override
	public int update(Post entity) {
		try {
//			SessionFactory factory2 = HibernateUtil.getSessionFactory();
//			Session session = factory2.openSession();
//			Transaction tx = session.beginTransaction();
			getSession().update(entity);
//			tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer postID) {
		Post post = getSession().get(Post.class, postID);
		if (post != null) {
			getSession().delete(post);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}
	@Override
	public Post getByPostID(Integer postID) {
		getSession().clear();
		return getSession().get(Post.class,postID);
	}
	
	@Override
	public List<Post> getByTitle(String postTitle) {
		return getSession().createQuery("from Post WHERE postTitle like :postTitle", Post.class)
	            .setParameter("postTitle", "%"+postTitle+"%")
	            .list();
	}
	
	@Override
	public List<Post> getByType(Integer postType) {
	    return getSession().createQuery("from Post WHERE postType = :postType", Post.class)
	            .setParameter("postType", postType)
	            .list();
	}

	@Override
	public List<Post> getAll() {
		return getSession().createQuery("from Post", Post.class).list();
	}


	
//	@Override
//	public List<Post> getByCompositeQuery(Map<String, String> map) {
//		if (map.size() == 0)
//			return getAll();
//
//		CriteriaBuilder builder = getSession().getCriteriaBuilder();
//		CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
//		Root<Post> root = criteria.from(Post.class);
//
//		List<Predicate> predicates = new ArrayList<>();
//
//		for (Map.Entry<String, String> row : map.entrySet()) {
//			if ("gUserID".equals(row.getKey())) {
//				predicates.add(builder.like(root.get("gUserID"), "%" + row.getValue() + "%"));
//			}
//
//			if ("oUserID".equals(row.getKey())) {
//				predicates.add(builder.like(root.get("oUserID"), "%" + row.getValue() + "%"));
//			}
//
//			if ("postTitle".equals(row.getKey())) {
//				predicates.add(builder.like(root.get("postTitle"), "%" + row.getValue() + "%"));
//			}
//			
//			if ("postContent".equals(row.getKey())) {
//				predicates.add(builder.like(root.get("postContent"), "%" + row.getValue() + "%"));
//			}
//		}
//
//		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
//		criteria.orderBy(builder.desc(root.get("postID")));
//		TypedQuery<Post> query = getSession().createQuery(criteria);
//
//		return query.getResultList();
//	}

	@Override
	public List<Post> getAll(int currentPage) {
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from Post", Post.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

	@Override
	public long getTotal() {
		return getSession().createQuery("select count(*) from Post", Long.class).uniqueResult();
	}

}
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class PostDAOImpl implements PostDAO{
//	private static final String INSERT_STMT = "INSERT INTO post(gUserID,oUserID, postTitle, postContent, postType,postTime, likeCnt) VALUES (?, ?, ?, ?, ?, ?, ?)";
//	private static final String UPDATE_STMT = "UPDATE post SET gUserID = ?, oUserID = ?, postTitle = ?, postContent = ?, postType = ?, postTime = ?,likeCnt = ? WHERE postID = ?";
//	private static final String DELETE_STMT = "DELETE FROM post WHERE postID = ?";
//	private static final String FIND_BY_PK = "SELECT * FROM post WHERE postID = ?";
//	private static final String GET_ALL = "SELECT * FROM post";
//	
//	static {
//		try {
//			Class.forName(Util.DRIVER);
//		}catch(ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
//	}
//	
//	
//	@Override
//	public void add(Post post) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setInt(1, post.getgUserID());
//			pstmt.setInt(2, post.getoUserID());
//			pstmt.setString(3, post.getPostTitle());
//			pstmt.setString(4, post.getPostContent());
//			pstmt.setInt(5, post.getPostType());
//			pstmt.setTimestamp(6, post.getPostTime());
//			pstmt.setInt(7, post.getLikeCnt());
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
//	public void update(Post post) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//	
//			pstmt.setInt(1, post.getgUserID());
//			pstmt.setInt(2, post.getoUserID());
//			pstmt.setString(3, post.getPostTitle());
//			pstmt.setString(4, post.getPostContent());
//			pstmt.setInt(5, post.getPostType());
//			pstmt.setTimestamp(6, post.getPostTime());
//			pstmt.setInt(7, post.getLikeCnt());
//			pstmt.setInt(8, post.getPostID());
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
//	@Override
//	public void delete(int postID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, postID);
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
//	public Post findByPK(Integer PostID) {
//		Post post = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1,PostID);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				post = new Post();
//				post.setPostID(rs.getInt("postID"));	
//				post.setgUserID(rs.getInt("gUserID"));		
//				post.setoUserID(rs.getInt("oUserID"));		
//				post.setPostTitle(rs.getString("postTitle"));		
//				post.setPostContent(rs.getString("postContent"));		
//				post.setPostType(rs.getInt("postType"));		
//				post.setPostTime(rs.getTimestamp("postTime"));		
//				post.setLikeCnt(rs.getInt("likeCnt"));		
//			}
//		}catch(SQLException se) {
//			se.printStackTrace();
//		}finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return post;
//	}
//	@Override
//	public List<Post> getAll() {
//		List<Post>postList = new ArrayList<>();
//		Post post = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
//			pstmt = con.prepareStatement(GET_ALL);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				post = new Post();
//				post.setPostID(rs.getInt("postID"));	
//				post.setgUserID(rs.getInt("gUserID"));		
//				post.setoUserID(rs.getInt("oUserID"));		
//				post.setPostTitle(rs.getString("postTitle"));		
//				post.setPostContent(rs.getString("postContent"));		
//				post.setPostType(rs.getInt("postType"));		
//				post.setPostTime(rs.getTimestamp("postTime"));		
//				post.setLikeCnt(rs.getInt("likeCnt"));
//				postList.add(post);
//			}
//		}catch(SQLException se) {
//			se.printStackTrace();
//		}finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return postList;
//	}
//	
//}
//
//
