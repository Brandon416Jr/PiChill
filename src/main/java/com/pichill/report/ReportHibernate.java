package com.pichill.report;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ReportHibernate {
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Report report =new Report();
		report.setReportID(34000011);
		report.setManageID(13000002);
		report.setPostID(13000002);
		report.setCommentID(32000007);
		report.setReportTime(java.sql.Timestamp.valueOf("2023-11-10 12:00:00"));
		report.setReportStatus(1);
		report.setReportType(5);
		session.save(report);

		tx.commit();
		session.close();
		factory.close();
	}
}
