package com.pichill.generaluser.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.util.HibernateUtil;

public class GeneralUserDAOImpl implements GeneralUserDAO{
private SessionFactory factory;
	
	public GeneralUserDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public int add(GeneralUser generalUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(generalUser);
			session.getTransaction().commit();
			System.out.println("新增成功!");
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("新增交易有錯QQ");
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(GeneralUser generalUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(generalUser);
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


	@Override
	public GeneralUser findByPK(Integer gUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			GeneralUser generalUser = session.get(GeneralUser.class, gUserID);
			session.getTransaction().commit();
			System.out.println("查單筆成功!");
			return generalUser;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查單筆失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<GeneralUser> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<GeneralUser> list = session.createQuery("from GeneralUser", GeneralUser.class).list();
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
//	@Override
//	public List<ReserveOrder> getAllList() {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
////			NativeQuery<ReserveOrder> query = session.createNativeQuery(
////					"SELECT r.reserveOrderID, g.gUserID, g.gName,  p.ball, c.loc, c.courtName, p.placeName, r.reserveDate, t.reserveTimer.orderTime, r.orderNum, r.totalCost, r.orderStatus"+
////			        "FROM reserveOrder r JOIN generalUser g ON r.gUserID = g.gUserID JOIN time t ON r.timeID = t.timeID JOIN place p ON r.placeID = p.placeID JOIN court c ON p.courtID = c.courtID WHERE g.gUserID = 11000001", ReserveOrder.class);
////			List<ReserveOrder> list = query.list();
//
//			List<ReserveOrder> list = session.createQuery("from ReserveOrder where gUserID = 11000001 order by reserveOrderID", ReserveOrder.class).list();
//			session.getTransaction().commit();
//			System.out.println("查全部成功!");
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("查全部失敗QQ");
//			session.getTransaction().rollback();
//		}
//		return null;
//	}

}
