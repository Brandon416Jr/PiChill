package com.pichill.backstage.court.model;

import java.util.List;

import org.hibernate.Session;


import com.pichill.court.Court;
import com.pichill.court.CourtDAO;

import com.pichill.util.HibernateUtil;

public class CourtDAOImplBack implements CourtDAO{

	

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
	
	@Override
	public List<Court> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Court> list = session.createQuery("from Court", Court.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	@Override
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
	public void delete(int courtID) {
		// TODO Auto-generated method stub
		
	}

	
	
	
//	@Override
//	public int add(Court court) {
//		// TODO Auto-generated method stub
//		return 0;
//		
//	}

	@Override
	public int insert(Court court) {
		// TODO Auto-generated method stub
		return 0;
	}

}
