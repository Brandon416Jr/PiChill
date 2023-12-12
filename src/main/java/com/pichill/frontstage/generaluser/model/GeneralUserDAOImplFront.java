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
	
	private Session getSession() {
		return factory.getCurrentSession();
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
	
	@Override
	public GeneralUser findByPK(Integer gUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			GeneralUser generalUser = session.get(GeneralUser.class, gUserID);
			session.getTransaction().commit();
			return generalUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	@Override
	public GeneralUser findByGeneralUsergUsername(String gUsername) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE gUsername = :gUsername")
	                 .setParameter("gUsername",gUsername)
	                 .uniqueResult();
			session.getTransaction().commit();
			return generalUser;
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
	public boolean isUsernameExists(String gUsername) {
	    Session session = getSession();
	    try {
	        session.beginTransaction();
	        GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE gUsername = :gUsername")
	             .setParameter("gUsername", gUsername)
	             .uniqueResult();
	        session.getTransaction().commit();
	        return generalUser != null; // 如果找到會員，返回true，表示用户名已存在
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    return false; // 如果發生異常或没有找到會員，也返回false
	}
}
