package com.pichill.generaluser;

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
		
		File dir = new File("src/main/resources/imgs/");
		String[] fileNames = dir.list();
		Arrays.sort(fileNames);

		SessionFactory factory = HibernateUtil.getSessionFactory();

		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			for (int i = 0; i < fileNames.length; i++) {
				FileInputStream fis = new FileInputStream(new File(dir, fileNames[i]));
				byte[] gProfilePic = fis.readAllBytes();

				GeneralUser generaluser = session.get(GeneralUser.class, i + 11000001);
				
				if (generaluser != null) {
					generaluser.setgProfilePic(gProfilePic);
				}else {
					System.out.println("找不到編號為" + (i+1) + "的會員");
				}

				fis.close();
			}

			session.getTransaction().commit();
			System.out.println("圖片上傳完成");

		} catch (Exception e) {
			factory.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();

		} finally {
			HibernateUtil.shutdown();
		}
	}
}
