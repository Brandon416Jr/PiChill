package com.pichill.contactus.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pichill.owneruser.entity.OwnerUser;


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
		contactUs.setGeneralUser(null);
		contactUs.setOwnerUser(null);
		contactUs.setformPurpose("如何上架球館?");
		contactUs.setformContent("如何上架球館?");
		contactUs.setformPic(null);
		contactUs.setformTime(java.sql.Timestamp.valueOf("2023-11-28 12:03:01"));
		contactUs.setformStatus(0);
		contactUs.setformType(0);
		session.save(contactUs);

		tx.commit();
		session.close();
		factory.close();
	}
}