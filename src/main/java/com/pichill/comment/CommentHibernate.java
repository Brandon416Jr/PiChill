package com.pichill.comment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CommentHibernate {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Comment comment = new Comment();
		comment.setCommentID(70);
		comment.setgUserID(null);
		comment.setPostID(null);
		comment.setCommentContent("HELLO");
		comment.setCommentTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
		session.save(comment);

		tx.commit();
		session.close();
		factory.close();
	}
}
