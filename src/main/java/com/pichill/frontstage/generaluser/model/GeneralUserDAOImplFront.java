package com.pichill.frontstage.generaluser.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.util.HibernateUtil;

public class GeneralUserDAOImplFront implements GeneralUserDAOFront {
	private final SessionFactory factory;

	public GeneralUserDAOImplFront() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public int insert(GeneralUser generalUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
//			Integer id = (Integer) session.save(manage);
			session.save(generalUser);
			
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("交易失敗");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;

	}
}
