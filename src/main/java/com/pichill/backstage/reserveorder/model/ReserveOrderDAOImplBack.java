package com.pichill.backstage.reserveorder.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.model.ReserveOrderDAO;
import com.pichill.util.HibernateUtil;

public class ReserveOrderDAOImplBack implements ReserveOrderDAO {
	private SessionFactory factory;
	
	@Override
	public int update(ReserveOrder reserveOrder) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					session.update(reserveOrder);
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
	
	@Override
	public int delete(Integer reserveOrderID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int add(ReserveOrder reserveOrder) {
		// TODO Auto-generated method stub
		return 0;
	}


}
