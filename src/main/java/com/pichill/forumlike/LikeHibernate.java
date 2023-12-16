package com.pichill.forumlike;
//package com.pichill.like;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//
//import com.pichill.like.entity.Like;
//
//public class LikeHibernate {
//	public static void main(String[] args) {
//		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//
//		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//
//		Like like = new Like();
//		like.setLikeID(33000001);
//		like.setgUserID(11000001);
//		like.setPostID(31000002);
//		session.save(like);
//
//		tx.commit();
//		session.close();
//		factory.close();
//	}
//}
