package com.pichill.backstage.generaluser.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.model.GeneralUserDAO;
import com.pichill.util.HibernateUtil;

public class GeneralUserDAOImplBack implements GeneralUserDAO {
	private SessionFactory factory;

	@Override
	public int update(GeneralUser generalUser) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					session.update(generalUser);
					session.getTransaction().commit();
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
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
			return generalUser;
		} catch (Exception e) {
			e.printStackTrace();
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
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
		
	}
	
	@Override
	public int add(GeneralUser generalUser) {
		// TODO Auto-generated method stub
				return 0;
	}

}
