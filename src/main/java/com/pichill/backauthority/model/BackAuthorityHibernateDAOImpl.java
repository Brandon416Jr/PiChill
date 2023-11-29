package com.pichill.backauthority.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.backauthority.entity.BackAuthority;
import com.pichill.util.HibernateUtil;

public class BackAuthorityHibernateDAOImpl implements BackAuthorityDAO{
	
	@Override
	public int add(BackAuthority backAuthority) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Integer id = (Integer) session.save(backAuthority);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(BackAuthority backAuthority) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(backAuthority);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
		
	}


	@Override
	public List<BackAuthority> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<BackAuthority> list = session.createQuery("from BackAuthority", BackAuthority.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
