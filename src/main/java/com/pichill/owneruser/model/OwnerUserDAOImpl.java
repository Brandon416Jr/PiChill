package com.pichill.owneruser.model;



import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.util.HibernateUtil;




public class OwnerUserDAOImpl implements OwnerUserDAO {
private  final SessionFactory factory;
	
	public OwnerUserDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	@Override
	public int add(OwnerUser ownerUser) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		try {
			session.beginTransaction();
//			Integer id = (Integer) session.save(ownerUser);
			session.save(ownerUser);
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("交易失敗");
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
	}


	@Override
	public int update(OwnerUser ownerUser) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(ownerUser);
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("交易失敗");
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
	}

	

	@Override
	public OwnerUser getOwnerUserByOUserID(Integer oUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			OwnerUser ownerUser = session.get(OwnerUser.class, oUserID);
			session.getTransaction().commit();
			return ownerUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<OwnerUser> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<OwnerUser> list = session.createQuery("from OwnerUser", OwnerUser.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
}
	
