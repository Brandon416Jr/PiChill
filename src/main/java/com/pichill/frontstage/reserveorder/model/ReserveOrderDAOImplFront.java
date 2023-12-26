package com.pichill.frontstage.reserveorder.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.pichill.frontstage.reserveorder.model.ReserveOrderDAOFront;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.util.HibernateUtil;

public class ReserveOrderDAOImplFront implements ReserveOrderDAOFront {
	private SessionFactory factory;

		
		public ReserveOrderDAOImplFront() {
			factory = HibernateUtil.getSessionFactory();
		}
		
		private Session getSession() {
			return factory.getCurrentSession();
		}

	
	public List<ReserveOrder> findReserveOrderByoUserID(Integer oUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<ReserveOrder> list = session.createQuery("select r from ReserveOrder r where r.ownerUser.oUserID = :oUserID"
					, ReserveOrder.class)
			.setParameter("oUserID", oUserID)
            .list();
			session.getTransaction().commit();
			System.out.println("查企業會員預約紀錄成功!");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查企業會員預約紀錄失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
}
