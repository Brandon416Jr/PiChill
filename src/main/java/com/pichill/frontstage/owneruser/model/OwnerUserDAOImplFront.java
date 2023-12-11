package com.pichill.frontstage.owneruser.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.util.HibernateUtil;

public class OwnerUserDAOImplFront implements OwnerUserDAOFront{
	private final SessionFactory factory;
	
	public OwnerUserDAOImplFront() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Override
	public int insert(OwnerUser ownerUser) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();

				try {
					session.beginTransaction();
//					Integer id = (Integer) session.save(manage);
					session.save(ownerUser);
					
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
