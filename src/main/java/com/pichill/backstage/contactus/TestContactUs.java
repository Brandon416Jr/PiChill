package com.pichill.backstage.contactus;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.model.ContactUsDAO;

import java.util.List;

import com.pichill.backstage.contactus.model.ContactUsDAOImplBack;

public class TestContactUs {
	public static void main(String[] args) {
		ContactUsDAO dao = new ContactUsDAOImplBack();
		
				// 新增
//				ContactUs contactUs= new ContactUs();
//				contactUs.setOUserID(12000011);
//				contactUs.setGUserID(null);
//				contactUs.setFormPurpose("如何使用商城購買的優惠券?");
//				contactUs.setFormContent("如何使用商城購買的優惠券?");
//				contactUs.setFormPic(null);
//				contactUs.setFormTime(java.sql.Timestamp.valueOf("2022-12-31 23:59:59"));
//				contactUs.setFormStatus(0);
//				contactUs.setFormType(0);
//				dao.insert(contactUs);
				
				// 修改
				ContactUs contactUs2= new ContactUs();

				contactUs2.setOUserID(12000004);
				contactUs2.setGUserID(null);
				contactUs2.setFormPurpose("如何在商城購買優惠券?");
				contactUs2.setFormContent("如何在商城購買優惠券?");
				contactUs2.setFormPic(null);
				contactUs2.setFormTime(java.sql.Timestamp.valueOf("2022-12-31 23:59:59"));
				contactUs2.setFormStatus(0);
				contactUs2.setFormType(0);
				contactUs2.setFormID(22000001);				
				dao.update(contactUs2);
		
				// 刪除
//				dao.delete(22000011);
				// 查詢單筆
//				ContactUs contactUs3 = dao.getByFormID(22000001);
//				System.out.print(contactUs3.getOUserID() + ",");
//				System.out.println(contactUs3.getGUserID() + ",");
//				System.out.println(contactUs3.getFormPurpose() + ",");
//				System.out.println(contactUs3.getFormContent() + ",");
//				System.out.println(contactUs3.getFormPic() + ",");
//				System.out.println(contactUs3.getFormTime() + ",");
//				System.out.println(contactUs3.getFormStatus() + ",");
//				System.out.println(contactUs3.getFormType() + ",");
//				
//				System.out.println("---------------------");

//				// 查詢多筆
//				List<ContactUs> list = dao.getAll();
//				for (ContactUs contactUs : list) {
//				System.out.print(contactUs.getOUserID() + ",");
//				System.out.println(contactUs.getGUserID() + ",");
//				System.out.println(contactUs.getFormPurpose() + ",");
//				System.out.println(contactUs.getFormContent() + ",");
//				System.out.println(contactUs.getFormPic() + ",");
//				System.out.println(contactUs.getFormTime() + ",");
//				System.out.println(contactUs.getFormStatus() + ",");
//				System.out.println(contactUs.getFormType() + ",");
//				System.out.println();
//				}
	}

}
