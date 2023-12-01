package com.pichill.backstage.comment.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.comment.entity.Comment;
import com.pichill.comment.model.CommentDAO;
import com.pichill.util.HibernateUtil;

public class CommentDAOImplBack implements CommentDAO {

	@Override
	public int delete(Integer commentID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Comment comment = session.get(Comment.class, commentID);
			if (comment != null) {
				session.delete(comment);
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
	public List<Comment> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Comment> list = session.createQuery("from Comment", Comment.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public Comment getByCommentID(Integer commentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

}
