package com.pichill.court;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class CourtHibernate {
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
		Court court = new Court();
//		court.setCourtID(61000011);
		court.setoUserID(12000004);
		court.setmanageID(null);
		court.setcourtOnTime(java.sql.Timestamp.valueOf("2023-11-27 15:45:00"));
		court.setcourtApplyTime(java.sql.Timestamp.valueOf("2023-11-26 11:45:00"));
		court.setcourtName("活力排球場");
		court.setcourtPic(null);
		court.setcourtTelephone("0228469117");
		court.setcourtAddress("臺北市松山區南京東路5段84號1樓");
		court.setcourtRule("暫無");
		court.setloc("松山區");
		court.setcourtApplyStatus(0);
		court.setcourtOpenTime(java.sql.Time.valueOf("07:00:00"));
		court.setcourtCloseTime(java.sql.Time.valueOf("22:00:00"));
		session.save(court);

		tx.commit();
		session.close();
		factory.close();
	}
}

