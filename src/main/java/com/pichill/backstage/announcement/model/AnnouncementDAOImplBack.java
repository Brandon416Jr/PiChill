package com.pichill.backstage.announcement.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.backstage.announcement.entity.Announcement;
import com.pichill.util.HibernateUtil;

public class AnnouncementDAOImplBack implements AnnouncementDAOBack {

	@Override
	public int insert(Announcement announcement) {
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
	public int update(Announcement announcement) {
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
	public Announcement getAnnouncementByAnnounceID(Integer announceID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Announcement announcement = session.get(Announcement.class, announceID);
			session.getTransaction().commit();
			return announcement;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Announcement> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Announcement> list = session.createQuery("from Announcement", Announcement.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
