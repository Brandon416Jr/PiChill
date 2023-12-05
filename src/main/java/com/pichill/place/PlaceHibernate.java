package com.pichill.place;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class PlaceHibernate {
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
		Place place = new Place();
		place.setPlaceID(62000011);
		place.setCourtID(61000010);
		place.setPlaceName("A");
		place.setPlaceFee(400);
		place.setBall(2);
		session.save(place);

		tx.commit();
		session.close();
		factory.close();
	}
}
