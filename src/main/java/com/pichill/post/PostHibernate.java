package com.pichill.post;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PostHibernate {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Post post = new Post();
		post.setPostID(31000001);	
		post.setgUserID(22);		
		post.setoUserID(12000001);		
		post.setPostTitle("我是標題");		
		post.setPostContent("我是內容");		
		post.setPostType(0);		
		post.setPostTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));		
		post.setLikeCnt(9999);	
		session.save(post);

		tx.commit();
		session.close();
		factory.close();
	}
}
