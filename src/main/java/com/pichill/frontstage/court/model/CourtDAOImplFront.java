package com.pichill.frontstage.court.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.court.Court;

import com.pichill.util.HibernateUtil;

public class CourtDAOImplFront implements CourtDAOFront {
	private SessionFactory factory;

	public CourtDAOImplFront() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	public List<Court> findCourtByoUserID(Integer oUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Court> list = session
					.createQuery("select c from Court c where c.ownerUser.oUserID = :oUserID", Court.class)
					.setParameter("oUserID", oUserID).list();
			session.getTransaction().commit();
			System.out.println("查企業會員球館成功!");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查企業會員球館失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}

	public Court getCourtByCourtID(Integer courtID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Court court = session.get(Court.class, courtID);
			session.getTransaction().commit();
			return court;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	@Override
	public int update(Court court) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					session.update(court);
					session.getTransaction().commit();
					return 1;
					
				} catch (Exception e) {
					e.printStackTrace();
					session.getTransaction().rollback();
				}
				return -1;
			
		
	}
}
