package com.pichill.reserveorder.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.util.HibernateUtil;


public class ReserveOrderDAOImpl implements ReserveOrderDAO {
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
	public int delete(Integer reserveOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ReserveOrder reserveOrder = session.get(ReserveOrder.class, reserveOrderID);
			if (reserveOrder != null) {
				session.delete(reserveOrder);
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
}
