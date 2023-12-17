package com.pichill.reserveorder.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.util.HibernateUtil;


public class ReserveOrderDAOImpl implements ReserveOrderDAO {
private SessionFactory factory;
	
	public ReserveOrderDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public int add(ReserveOrder reserveOrder) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(reserveOrder);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public ReserveOrder findByPK(Integer reserveOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ReserveOrder reserveOrder = session.get(ReserveOrder.class, reserveOrderID);
			session.getTransaction().commit();
			return reserveOrder;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<ReserveOrder> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<ReserveOrder> list = session.createQuery("from ReserveOrder", ReserveOrder.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	@Override
	public int update(ReserveOrder reserveOrder) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(reserveOrder);
			session.getTransaction().commit();
			System.out.println("修改成功!");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改交易有錯QQ");
			session.getTransaction().rollback();
		}
		return -1;
	}
}
