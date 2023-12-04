package com.pichill.backstage.owneruser.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.owneruser.OwnerUser;
import com.pichill.util.HibernateUtil;

public class OwnerUserDAOImplBack implements ownerUserDAOBack {
	private SessionFactory factory;

	@Override
	public int update(OwnerUser ownerUser) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					session.update(ownerUser);
					session.getTransaction().commit();
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					session.getTransaction().rollback();
				}
				return -1;
	}

	@Override
	public OwnerUser getOwnerUserByoUserID(Integer oUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			OwnerUser ownerUser = session.get(OwnerUser.class, oUserID);
			session.getTransaction().commit();
			return ownerUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
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
