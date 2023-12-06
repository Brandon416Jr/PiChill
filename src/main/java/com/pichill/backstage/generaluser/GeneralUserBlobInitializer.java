package com.pichill.backstage.generaluser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.util.HibernateUtil;

public class GeneralUserBlobInitializer {
public static void main(String[] args) throws IOException {
		
		File dir = new File("src/main/resources/img/generalUserBack/");
		String[] fileNames = dir.list();
		Arrays.sort(fileNames);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			for (int i = 0; i < fileNames.length; i++) {
				FileInputStream fis = new FileInputStream(new File(dir, fileNames[i]));
				byte[] gProfilePic = fis.readAllBytes();
				
				
				
				GeneralUser generalUser = session.get(GeneralUser.class, i +11000001);
				
				 if (generalUser != null) {
					 generalUser.setgProfilePic(gProfilePic);
				    } else {
				        System.out.println("GeneralUser object with ID " + (i + 1) + " not found in the database.");
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
