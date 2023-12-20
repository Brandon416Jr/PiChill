package com.pichill.backstage.announcement.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;
import com.pichill.util.HibernateUtil;

public class AnnouncementDAOImplBack implements AnnouncementDAOBack {

	@Override
	public int insert(AnnouncementGetOne announcement) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					Integer id = (Integer) session.save(announcement);
					session.getTransaction().commit();
					return id;
				} catch (Exception e) {
					e.printStackTrace();
					session.getTransaction().rollback();
				}
				return -1;
	}

	@Override
	public int update(AnnouncementGetOne announcement) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					session.update(announcement);
					session.getTransaction().commit();
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					session.getTransaction().rollback();
				}
				return -1;
	}

	@Override
	public AnnouncementGetOne getAnnouncementByAnnounceID(Integer announceID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AnnouncementGetOne announcement = session.get(AnnouncementGetOne.class, announceID);
			session.getTransaction().commit();
			return announcement;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<AnnouncementGetOne> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<AnnouncementGetOne> list = session.createQuery("from AnnouncementGetOne", AnnouncementGetOne.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
