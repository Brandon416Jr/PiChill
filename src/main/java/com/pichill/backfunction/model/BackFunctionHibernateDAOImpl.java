package com.pichill.backfunction.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.backfunction.entity.BackFunction;
import com.pichill.util.HibernateUtil;

public class BackFunctionHibernateDAOImpl implements BackFunctionDAO {
	
	@Override
	public List<BackFunction> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<BackFunction> list = session.createQuery("from BackFunction", BackFunction.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
