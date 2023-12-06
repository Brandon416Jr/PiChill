package com.pichill.backstage.post.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.post.entity.Post;
import com.pichill.post.model.PostDAO;
import com.pichill.util.HibernateUtil;

public class PostDAOImplBack implements PostDAO {
	private SessionFactory factory;

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
	}

	@Override
	public List<Post> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Post> list = session.createQuery("from Post", Post.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public int insert(Post entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Post entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Post getByPostID(Integer postID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getByTitle(String postTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getByType(Integer postType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

}
