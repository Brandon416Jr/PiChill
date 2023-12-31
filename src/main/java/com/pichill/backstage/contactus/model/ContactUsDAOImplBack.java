package com.pichill.backstage.contactus.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.backstage.contactus.model.ContactUsDAOBack;
import com.pichill.util.HibernateUtil;

public class ContactUsDAOImplBack implements ContactUsDAOBack {
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
			String hql = "UPDATE ContactUs c SET c.formStatus = :formStatus WHERE c.formID = :formID";

			int result = session.createQuery(hql)
			                    .setParameter("formStatus", contactUs.getformStatus())   
			                    .setParameter("formID", contactUs.getformID())
			                    .executeUpdate();
			session.getTransaction().commit();
			System.out.println("交易成功");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("交易失敗");
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
	

}
