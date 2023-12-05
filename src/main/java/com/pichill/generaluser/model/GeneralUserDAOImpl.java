package com.pichill.generaluser.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.util.HibernateUtil;

public class GeneralUserDAOImpl implements GeneralUserDAO{
private SessionFactory factory;
	
	public GeneralUserDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public int add(GeneralUser generalUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(generalUser);
			session.getTransaction().commit();
			System.out.println("嗨3");
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("交易有錯3");
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(GeneralUser generalUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(generalUser);
			session.getTransaction().commit();
			System.out.println("嗨4");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("交易有錯4");
			session.getTransaction().rollback();
		}
		return -1;
	}


	@Override
	public GeneralUser findByPK(Integer gUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			GeneralUser generalUser = session.get(GeneralUser.class, gUserID);
			session.getTransaction().commit();
			return generalUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<GeneralUser> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<GeneralUser> list = session.createQuery("from GeneralUser", GeneralUser.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
}
