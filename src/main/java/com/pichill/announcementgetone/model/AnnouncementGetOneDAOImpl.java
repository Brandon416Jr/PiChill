package com.pichill.announcementgetone.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.announcementgetone.entity.AnnouncementGetOne;
import com.pichill.util.HibernateUtil;

public class AnnouncementGetOneDAOImpl implements AnnouncementGetOneDAO {
	@Override
	public AnnouncementGetOne getAnnouncementByAnnounceID(Integer announceID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			AnnouncementGetOne AnnouncementGetOne = session.get(AnnouncementGetOne.class, announceID);
			session.getTransaction().commit();
			return AnnouncementGetOne;
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
	
//	@Override
//	public AnnouncementGetOne getAnnouncementByAnnoTitle(String annoTitle) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			AnnouncementGetOne AnnouncementGetOne = session.get(AnnouncementGetOne.class, annoTitle);
//			session.getTransaction().commit();
//			return AnnouncementGetOne;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
//	}
//前台只需要查單筆跟多筆，沒有新增修改刪除功能
//	@Override
//	public int insert(Announcement announcement) {
//		// TODO Auto-generated method stub
//				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//				try {
//					session.beginTransaction();
//					Integer id = (Integer) session.save(announcement);
//					session.getTransaction().commit();
//					return id;
//				} catch (Exception e) {
//					e.printStackTrace();
//					session.getTransaction().rollback();
//				}
//				return -1;
//	}

//	@Override
//	public int update(Announcement announcement) {
//		// TODO Auto-generated method stub
//				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//				try {
//					session.beginTransaction();
//					session.update(announcement);
//					session.getTransaction().commit();
//					return 1;
//				} catch (Exception e) {
//					e.printStackTrace();
//					session.getTransaction().rollback();
//				}
//				return -1;
//	}


}
