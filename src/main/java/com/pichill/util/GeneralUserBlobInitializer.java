package com.pichill.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.generaluser.entity.GeneralUser;

public class GeneralUserBlobInitializer {

	public static void main(String[] args) throws IOException {
		
		File dir = new File("src/main/resources/img/");
		String[] fileNames = dir.list();
		Arrays.sort(fileNames);

		SessionFactory factory = HibernateUtil.getSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			for (int i = 0; i < fileNames.length; i++) {
				FileInputStream fis = new FileInputStream(new File(dir, fileNames[i]));
				byte[] gProfilePic = fis.readAllBytes();

				GeneralUser generaluser = session.get(GeneralUser.class, i + 1);
				generaluser.setgProfilePic(gProfilePic);

				fis.close();
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();

		} finally {
			HibernateUtil.shutdown();
		}
	}
}
