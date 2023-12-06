package com.pichill.backstage.announcement;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.backstage.announcement.entity.Announcement;
import com.pichill.util.HibernateUtil;

public class AnnouncementBlobInitializer {
	public static void main(String[] args) throws IOException {
		File dir = new File("src/main/resources/img/announcementBack/");
		String[] fileNames = dir.list();
		Arrays.sort(fileNames);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			for (int i = 0; i < fileNames.length; i++) {
				FileInputStream fis = new FileInputStream(new File(dir, fileNames[i]));
				byte[] annoPic = fis.readAllBytes();
				
				
				
				Announcement announcement= session.get(Announcement.class, i +21000001);
				
				 if (announcement != null) {
					 announcement.setAnnoPic(annoPic);
				    } else {
				        System.out.println("Announcement object with ID " + (i + 1) + " not found in the database.");
				    }
				
				fis.close();
			}

			session.getTransaction().commit();
			System.out.println("上傳圖片完成");

		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.shutdown();
		}
	}

}
