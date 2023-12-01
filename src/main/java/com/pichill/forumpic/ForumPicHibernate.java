package com.pichill.forumpic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pichill.forumpic.entity.ForumPic;

public class ForumPicHibernate {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		ForumPic forumPic = new ForumPic();
		forumPic.setForumPicID(35000011);
		forumPic.setPostID(31000011);
		forumPic.setPostPic(null);
		forumPic.setPicTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
		session.save(forumPic);

		tx.commit();
		session.close();
		factory.close();
	}
}
