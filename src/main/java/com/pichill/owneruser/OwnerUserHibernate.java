package com.pichill.owneruser;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.pichill.owneruser.entity.OwnerUser;


public class OwnerUserHibernate {
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
		OwnerUser ownerUser = new OwnerUser();
		ownerUser.setoUserID(12000011);
		ownerUser.setoUserName("hfhjfj888@gmail.com");
		ownerUser.setoPassword("SHE5566firy");
		ownerUser.setoIDNum("A189920113");
		ownerUser.setcompiled("85116896");
		ownerUser.setoName("李又善");
		ownerUser.setoGender(0);
		ownerUser.setoBirth(java.sql.Date.valueOf("1990-09-09"));
		ownerUser.setoTelephone("0918999024");
		ownerUser.setoAddress("臺北市萬華區寶興街38巷7號4樓");
		ownerUser.setoBankCode("008");
		ownerUser.setoBankAccount("810100097303");
		ownerUser.setoProfilePic(null);
		ownerUser.setoRegisterDate(java.sql.Date.valueOf("2023-10-09"));
		ownerUser.setoPostAmount(0);
		ownerUser.setoReportCnt(0);
		ownerUser.setCourtArriveCnt(0);
		ownerUser.setRsvdCnts(0);
		ownerUser.setoEmail("hfhjfj888@gmail.com");
		session.save(ownerUser);

		tx.commit();
		session.close();
		factory.close();
	}
}
