package com.pichill.post.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

public class PostDAOImpl implements PostDAO {

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

	 public int insert(Post post) {
	        try {
	            SessionFactory factory = HibernateUtil.getSessionFactory();
	            Session session = factory.openSession();
	            Transaction tx = session.beginTransaction();

	            // 执行实际的插入操作
	            Integer id = (Integer) session.save(post);

	            tx.commit();
	            session.close(); // 关闭会话

	            return id; // 返回插入后帖子的ID
	        } catch (Exception e) {
	            e.printStackTrace(); // 记录异常或使用日志库
	            return -1; // 插入失败返回 null
	        }
	    }

	@Override
	public int update(Post entity) {
		try {
			SessionFactory factory2 = HibernateUtil.getSessionFactory();
			Session session = factory2.openSession();
			Transaction tx = session.beginTransaction();
//			getSession().update(entity);
			tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	 public int delete(Integer postID) {
	        Session session = null;
	        Transaction transaction = null;

	        try {
	            session = HibernateUtil.getSessionFactory().openSession();
	            transaction = session.beginTransaction();

	            Post post = session.get(Post.class, postID);
	            if (post != null) {
	                session.delete(post);
	                transaction.commit(); // Commit the transaction if successful
	                return 1; // Deletion successful
	            } else {
	                return -1; // Post not found, deletion failed
	            }
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback(); // Rollback the transaction if an exception occurs
	            }
	            e.printStackTrace();
	            return -1; // Deletion failed due to an exception
	        } finally {
	            if (session != null) {
	                session.close();
	            }
	        }
	    }

	  public Post getByPostID(Integer postID) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();

	            Post post = session.get(Post.class, postID);

	            transaction.commit();

	            return post;
	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception or use a logging library
	            return null;
	        }
	    }

	  public List<Post> getByTitle(String postTitle) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM Post WHERE postTitle LIKE :postTitle";
	            return session.createQuery(hql, Post.class)
	                .setParameter("postTitle", "%" + postTitle + "%")
	                .list();
	        } catch (Exception e) {
	            e.printStackTrace(); // Log the exception or use a logging library
	            return Collections.emptyList(); // Return an empty list in case of an exception
	        }
	    }

	  public List<Post> getByType(Integer postType) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM Post WHERE postType = :postType";
	            return session.createQuery(hql, Post.class)
	                .setParameter("postType", postType)
	                .list();
	        } catch (Exception e) {
	            e.printStackTrace(); // 日誌記錄異常或使用日誌庫
	            return Collections.emptyList(); // 在出現異常時返回一個空列表
	        }
	    }

	    public List<Post> getBygUserID(Integer gUserID) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM Post WHERE gUserID = :gUserID";
	            return session.createQuery(hql, Post.class)
	                .setParameter("gUserID", gUserID)
	                .list();
	        } catch (Exception e) {
	            e.printStackTrace(); // 日誌記錄異常或使用日誌庫
	            return Collections.emptyList(); // 在出現異常時返回一個空列表
	        }
	    }

	    public List<Post> getByoUserID(Integer oUserID) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM Post WHERE oUserID = :oUserID";
	            return session.createQuery(hql, Post.class)
	                .setParameter("oUserID", oUserID)
	                .list();
	        } catch (Exception e) {
	            e.printStackTrace(); // 日誌記錄異常或使用日誌庫
	            return Collections.emptyList(); // 在出現異常時返回一個空列表
	        }
	    }

	    public List<Post> getByCommentCnt() {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            String hql = "FROM Post ORDER BY commentCnt DESC";
	            return session.createQuery(hql, Post.class).list();
	        } catch (Exception e) {
	            e.printStackTrace(); // 日誌記錄異常或使用日誌庫
	            return Collections.emptyList(); // 在出現異常時返回一個空列表
	        }
	    }

//	    public List<Post> getByCommentCnt() {
//	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//	            Calendar calendar = Calendar.getInstance();
//	            calendar.add(Calendar.DAY_OF_MONTH, -3);
//	            Date threeDaysAgo = calendar.getTime();
//
//	            String hql = "FROM Post WHERE postTime >= :threeDaysAgo ORDER BY commentCnt DESC";
//	            
//	            return session.createQuery(hql, Post.class)
//	                .setParameter("threeDaysAgo", threeDaysAgo)
//	                .list();
//	        } catch (Exception e) {
//	            e.printStackTrace(); // 日誌記錄異常或使用日誌庫
//	            return Collections.emptyList(); // 在出現異常時返回一個空列表
//	        }
//	    }
	@Override
	public List<Post> getAll() {
		 SessionFactory factory = HibernateUtil.getSessionFactory();
		    Session session = factory.openSession();
		    
		    try {
		        Transaction tx = session.beginTransaction();
		        List<Post> posts = session.createQuery("from Post", Post.class).list();
		        tx.commit();
		        return posts;
		    } catch (Exception e) {
		        if (session.getTransaction() != null && session.getTransaction().isActive()) {
		            session.getTransaction().rollback();
		        }
		        throw e; // 抛出异常以通知上层代码
		    } finally {
		        session.close();
		    }
	}

//	@Override
//	public List<Post> getAll(int currentPage) {
//		SessionFactory factory2 = HibernateUtil.getSessionFactory();
//		Session session = factory2.openSession();
//		Transaction tx = session.beginTransaction();
//		int first = (currentPage - 1) * PAGE_MAX_RESULT;
//		List<Post> posts;
//
//		if (currentPage == 1 || currentPage == 2) {
//			posts = getSession().createQuery("from Post where postType in (0, 1) order by postID desc", Post.class)
//					.setFirstResult(first).setMaxResults(PAGE_MAX_RESULT).list();
//			System.out.println("post+++" + posts);
//		} else {
//			posts = getSession().createQuery("from Post where postType = 2 order by postID desc", Post.class).list();
//		}
//		tx.commit();
//		return posts;
//	}

//	@Override
//	public List<Post> getAll(int currentPage) {
//	    SessionFactory factory = HibernateUtil.getSessionFactory();
//	    Session session = factory.openSession();
//	    Transaction tx = null;
//	    List<Post> posts = null;
//
//	    try {
//	        tx = session.beginTransaction();
//	        int first = (currentPage - 1) * PAGE_MAX_RESULT;
//
//	        posts = session.createQuery("from Post where postType in (0, 1) order by postID desc", Post.class)
//	                .setFirstResult(first)
//	                .setMaxResults(PAGE_MAX_RESULT)
//	                .list();
//	        tx.commit();
//	    } catch (Exception e) {
//	        if (tx != null) {
//	            tx.rollback();
//	        }
//	        e.printStackTrace();
//	    } finally {
//	        session.close();
//	    }
//	    return posts;
//	}
//	
//	public List<Post> getTypeTwo() {
//	    SessionFactory factory = HibernateUtil.getSessionFactory();
//	    Session session = factory.openSession();
//	    Transaction tx = null;
//	    List<Post> posts = null;
//
//	    try {
//	        tx = session.beginTransaction();
//
//	        posts = session.createQuery("from Post where postType = 2 order by postID desc", Post.class)
//	                .list();
//	        tx.commit();
//	    } catch (Exception e) {
//	        if (tx != null) {
//	            tx.rollback();
//	        }
//	        e.printStackTrace();
//	    } finally {
//	        session.close();
//	    }
//	    return posts;
//	}
	@Override
	public long getTotal() {
	    SessionFactory factory = HibernateUtil.getSessionFactory();
	    Session session = factory.openSession();
	    Transaction tx = null;
	    
	    try {
	        tx = session.beginTransaction();
	        
	        long total = (Long) session.createQuery("select count(*) from Post")
	                .uniqueResult();
	        
	        tx.commit(); // 提交事務
	        return total;
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback(); // 回滾事務
	        }
	        e.printStackTrace(); // 或者處理異常
	        throw e; // 傳播異常
	    } finally {
	        session.close(); // 最後關閉 Session
	    }
	}

	 public int updateLike(Integer postID, Integer likeCnt) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            
	            int updatedRows = session.createQuery("UPDATE Post SET likeCnt = :likeCnt WHERE postID = :postID")
	                .setParameter("likeCnt", likeCnt)
	                .setParameter("postID", postID)
	                .executeUpdate();
	            
	            transaction.commit();
	            return updatedRows;
	        } catch (Exception e) {
	            e.printStackTrace(); // 记录异常或使用日志库
	            return -1; // 返回 -1 表示更新失败
	        }
	    }

	  public int updateComment(Integer postID, Integer commentCnt) {
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            Transaction transaction = session.beginTransaction();
	            
	            int updatedRows = session.createQuery("UPDATE Post SET commentCnt = :commentCnt WHERE postID = :postID")
	                .setParameter("commentCnt", commentCnt)
	                .setParameter("postID", postID)
	                .executeUpdate();
	            
	            transaction.commit();
	            return updatedRows;
	        } catch (Exception e) {
	            e.printStackTrace(); // 记录异常或使用日志库
	            return -1; // 返回 -1 表示更新失败
	        }
	    }
}

