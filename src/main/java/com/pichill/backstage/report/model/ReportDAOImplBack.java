package com.pichill.backstage.report.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.report.entity.Report;
import com.pichill.report.model.ReportDAO;
import com.pichill.util.HibernateUtil;

public class ReportDAOImplBack implements ReportDAO {
	private SessionFactory factory;
	
	public ReportDAOImplBack() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public int delete(int reportID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Report report = session.get(Report.class, reportID);
			if (report != null) {
				session.delete(report);
			}
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public Report getByReportID(Integer reportID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Report report = session.get(Report.class, reportID);
			session.getTransaction().commit();
			return report;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Report> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Report> list = session.createQuery("from Report", Report.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	@Override
	public int add(Report report) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Report report) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			getSession().update(report);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}
		
	}
}
