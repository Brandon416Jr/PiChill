package com.pichill.backstage.contactus.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.model.ContactUsDAO;
import com.pichill.util.HibernateUtil;

public class ContactUsDAOImplBack implements ContactUsDAO {
	@Override
	public List<ContactUs> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<ContactUs> list = session.createQuery("from ContactUs", ContactUs.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public int update(ContactUs contactUs) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(contactUs);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	

	@Override
	public ContactUs getByFormID(Integer formID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ContactUs contactUs = session.get(ContactUs.class, formID);
			session.getTransaction().commit();
			return contactUs;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}
	
	
	

	@Override
	public int delete(Integer formID) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<ContactUs> getByPurpose(String formPurpose) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactUs> getByContent(String formContent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactUs> getByformPic(byte[] formPic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactUs> getByType(Integer formType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(ContactUs entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
