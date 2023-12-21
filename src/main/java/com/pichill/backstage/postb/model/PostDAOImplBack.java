package com.pichill.backstage.postb.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.pichill.post.entity.Post;

import com.pichill.util.HibernateUtil;

public class PostDAOImplBack implements PostDAOBack {
	private SessionFactory factory;

	public PostDAOImplBack() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public int delete(Integer postID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Post post = session.get(Post.class, postID);
			if (post != null) {
				session.delete(post);
			}
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
//		Post post = getSession().get(Post.class, postID);
//		if (post != null) {
//			getSession().delete(post);
//			// 回傳給 service，1代表刪除成功
//			return 1;
//		} else {
//			// 回傳給 service，-1代表刪除失敗
//			return -1;
//		}
	}

	@Override
	public List<Post> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("開始查詢");
			List<Post> list = session.createQuery("from Post", Post.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("出示了阿北");
			session.getTransaction().rollback();
		}
		return null;
//		return getSession().createQuery("from Post", Post.class).list();
	}



	@Override
	public int update(Post entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Post getByPostID(Integer postID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Post post = session.get(Post.class, postID);
			session.getTransaction().commit();
			return post;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
//		 try {
//		        getSession().clear();
//		        return getSession().get(Post.class, postID);
//		    } catch (Exception e) {
//		        e.printStackTrace(); // 或使用日誌庫記錄異常
//		        return null;
//		    }
	}

	

}
