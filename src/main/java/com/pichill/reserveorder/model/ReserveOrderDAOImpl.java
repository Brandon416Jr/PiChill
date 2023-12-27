package com.pichill.reserveorder.model;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.post.entity.Post;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.util.HibernateUtil;


public class ReserveOrderDAOImpl implements ReserveOrderDAO {
private SessionFactory factory;
private ReserveOrder generalUser;
	
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
	
	@Override
	public ReserveOrder findByPK(Integer reserveOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ReserveOrder reserveOrder = session.get(ReserveOrder.class, reserveOrderID);
			session.getTransaction().commit();
			System.out.println("查單筆成功!");
			return reserveOrder;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查單筆失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
	@Override
	public List<ReserveOrder> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
//			NativeQuery<ReserveOrder> query = session.createNativeQuery(
//					"SELECT r.reserveOrderID, g.gUserID, g.gName,  p.ball, c.loc, c.courtName, p.placeName, r.reserveDate, t.reserveTimer.orderTime, r.orderNum, r.totalCost, r.orderStatus"+
//			        "FROM reserveOrder r JOIN generalUser g ON r.gUserID = g.gUserID JOIN time t ON r.timeID = t.timeID JOIN place p ON r.placeID = p.placeID JOIN court c ON p.courtID = c.courtID WHERE g.gUserID = 11000001", ReserveOrder.class);
//			List<ReserveOrder> list = query.list();

			List<ReserveOrder> list = session.createQuery("from ReserveOrder", ReserveOrder.class).list();
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
	public List<ReserveOrder> findBygUserID(Integer gUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<ReserveOrder> list = session.createQuery("select r from ReserveOrder r where r.generalUser.gUserID = :gUserID"
					, ReserveOrder.class)
			.setParameter("gUserID", gUserID)
            .list();
			session.getTransaction().commit();
			System.out.println("查會員預約紀錄成功!");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查會員預約紀錄失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
}
