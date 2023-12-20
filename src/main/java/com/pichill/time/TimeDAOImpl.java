package com.pichill.time;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.time.TimeRef;
import com.pichill.util.HibernateUtil;

public class TimeDAOImpl implements TimeDAO {
private SessionFactory factory;
	
	public TimeDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public TimeRef findByPK(Integer timeID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TimeRef timeRef = session.get(TimeRef.class, timeID);
			session.getTransaction().commit();
			System.out.println("查單筆成功!");
			return timeRef;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查單筆失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<TimeRef> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<TimeRef> list = session.createQuery("from Time", TimeRef.class).list();
			session.getTransaction().commit();
			System.out.println("查全部成功!");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查全部失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
}
