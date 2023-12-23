package com.pichill.court;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.court.Court;
import com.pichill.util.HibernateUtil;

public class CourtBlobInitializer {

	public static void main(String[] args) throws IOException {
		File dir = new File("src/main/resources/courtpic");
		String[] fileNames = dir.list();
		Arrays.sort(fileNames);
		System.out.println("123");

		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			System.out.println("start");

			Session session = factory.getCurrentSession();
			session.beginTransaction();

			for (int i = 0; i < fileNames.length; i++) {
				FileInputStream fis = new FileInputStream(new File(dir, fileNames[i]));
				byte[] courtPic = fis.readAllBytes();
				
				
				
				Court court = session.get(Court.class, i +61000001);
				
				 if (court != null) {
					 court.setCourtPic(courtPic);
				    } else {
				        System.out.println("Court object with ID " + (i + 1) + " not found in the database.");
				    }
				
				fis.close();
			}

			session.getTransaction().commit();
			System.out.println("上傳圖片完成");

		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
			System.out.println("failed");
		} finally {
			HibernateUtil.shutdown();
		}

	}
}
