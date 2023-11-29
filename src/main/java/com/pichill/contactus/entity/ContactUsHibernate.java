package com.pichill.contactus.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class ContactUsHibernate {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure()
			.build();
		SessionFactory factory = (SessionFactory) new MetadataSources(registry)
			.buildMetadata()
			.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//交易區間
		ContactUs contactUs = new ContactUs();
		contactUs.setGUserID(null);
		contactUs.setOUserID(12000001);
		contactUs.setFormPurpose("如何上架球館?");
		contactUs.setFormContent("如何上架球館?");
		contactUs.setFormPic(null);
		contactUs.setFormTime(java.sql.Timestamp.valueOf("2023-11-28 12:03:01"));
		contactUs.setFormStatus(0);
		contactUs.setFormType(0);
		session.save(contactUs);

		tx.commit();
		session.close();
		factory.close();
	}
}