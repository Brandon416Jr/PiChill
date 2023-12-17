package com.pichill.time;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.time.Time;
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
	public Time findByPK(Integer timeID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Time time = session.get(Time.class, timeID);
			session.getTransaction().commit();
			System.out.println("查單筆成功!");
			return time;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查單筆失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Time> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Time> list = session.createQuery("from Time", Time.class).list();
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
