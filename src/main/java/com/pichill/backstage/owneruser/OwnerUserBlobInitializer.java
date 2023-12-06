package com.pichill.backstage.owneruser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.util.HibernateUtil;

public class OwnerUserBlobInitializer {
public static void main(String[] args) throws IOException {
		
		File dir = new File("src/main/resources/img/ownerUserBack/");
		String[] fileNames = dir.list();
		Arrays.sort(fileNames);
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			for (int i = 0; i < fileNames.length; i++) {
				FileInputStream fis = new FileInputStream(new File(dir, fileNames[i]));
				byte[] oProfilePic = fis.readAllBytes();
				
				
				
				OwnerUser ownerUser = session.get(OwnerUser.class, i +12000001);
				
				 if (ownerUser != null) {
					 ownerUser.setoProfilePic(oProfilePic);
				    } else {
				        System.out.println("OwnerUser object with ID " + (i + 1) + " not found in the database.");
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
