package com.pichill.manage.model;

import static com.pichill.util.Constants.PAGE_MAX_RESULT;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.manage.Util;
import com.pichill.manage.entity.Manage;
import com.pichill.util.HibernateUtil;





public class ManageDAOImpl implements ManageDAO {
	private SessionFactory factory;
	
	public ManageDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public Integer add(Manage manage) {
		// TODO Auto-generated method stub
		return (Integer) getSession().save(manage);
	}

	@Override
	public Integer update(Manage manage) {
		// TODO Auto-generated method stub
		try {
			getSession().update(manage);
			return 1;
		} catch (Exception e) {
			return -1;
		}
		
	}

	@Override
	public Integer delete(Integer manageID) {
		// TODO Auto-generated method stub
		Manage manage = getSession().get(Manage.class, manageID);
		if (manage != null) {
			getSession().delete(manage);
			return 1;
		} else {
			return -1;
		}
	}
	
	@Override
	public Manage getManageByManageID(Integer manageID) {
		// TODO Auto-generated method stub
		return getSession().get(Manage.class, manageID);
	}

	@Override
	public Manage getManageBymName(String mName) {
		// TODO Auto-generated method stub
		return getSession().get(Manage.class, mName);
	}

	@Override
	public Manage getManageBymEmail(String mEmail) {
		// TODO Auto-generated method stub
		return getSession().get(Manage.class, mEmail);
	}

	@Override
	public List<Manage> getAll() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Manage", Manage.class).list();
	}


	@Override
	public List<Manage> getAll(int currentPage) {
		// TODO Auto-generated method stub
		int first = (currentPage - 1) * PAGE_MAX_RESULT;
		return getSession().createQuery("from Manage", Manage.class)
				.setFirstResult(first)
				.setMaxResults(PAGE_MAX_RESULT)
				.list();
	}

	
	
	
	
	
}
