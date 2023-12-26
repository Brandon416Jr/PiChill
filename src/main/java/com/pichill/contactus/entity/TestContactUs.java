package com.pichill.contactus.entity;

import java.util.List;

import com.pichill.contactus.model.ContactUsDAO;
import com.pichill.contactus.model.ContactUsDAOImpl;

public class TestContactUs {
	public static void main(String[] args) {
		ContactUsDAO dao = new ContactUsDAOImpl();
		
				// 新增
//				ContactUs contactUsAdd= new ContactUs();
//				contactUsAdd.setOwnerUser(OwnerUser.getoUserID());
//				contactUsAdd.setGeneralUser(null);
//				contactUsAdd.setformPurpose("如何使用商城購買的優惠券?");
//				contactUsAdd.setformContent("如何使用商城購買的優惠券?");
//				contactUsAdd.setformPic(null);
//				contactUsAdd.setformTime(new Timestamp(System.currentTimeMillis()));
//				contactUsAdd.setformStatus(0);
//				contactUsAdd.setformType(0);
//				dao.add(contactUsAdd);
				
				// 修改
//				ContactUs contactUs2= new ContactUs();

//				contactUs2.setOUserID(12000011);
//				contactUs2.setGUserID(null);
//				contactUs2.setFormPurpose("如何在商城購買優惠券?");
//				contactUs2.setFormPurpose("如何在商城購買優惠券?");
//				contactUs2.setFormTime(new Timestamp(System.currentTimeMillis()));
//				contactUs2.setFormStatus(0);
//				contactUs2.setFormType(0);
//				contactUs.setFormID(22000011);				
//				dao.update(contactUs2);
		
				// 刪除
//				dao.delete(22000011);
				// 查詢單筆
		System.out.println(122);
				ContactUs getFormID = dao.getContactUsByFormID(22000003);
				System.out.print(getFormID.getOwnerUser().getoUserID() + ",");
				System.out.println(getFormID.getGeneralUser() + ",");
				System.out.println(getFormID.getformPurpose() + ",");
				System.out.println(getFormID.getformContent() + ",");
				System.out.println(getFormID.getformPic() + ",");
				System.out.println(getFormID.getformTime() + ",");
				System.out.println(getFormID.getformStatus() + ",");
				System.out.println(getFormID.getformType() + ",");
				
				System.out.println("---------------------");

//				// 查詢多筆
				List<ContactUs> list = dao.getAll();
				
				if (list!=null) {
					for (ContactUs contactUsAllForm : list) {
						System.out.print(contactUsAllForm.getOwnerUser().getoName() + ",");
						System.out.println(contactUsAllForm.getGeneralUser().getgName() + ",");
						System.out.println(contactUsAllForm.getformPurpose() + ",");
						System.out.println(contactUsAllForm.getformContent() + ",");
						System.out.println(contactUsAllForm.getformPic() + ",");
						System.out.println(contactUsAllForm.getformTime() + ",");
						System.out.println(contactUsAllForm.getformStatus() + ",");
						System.out.println(contactUsAllForm.getformType() + ",");
						System.out.println();
				}
				} else {
					System.out.println("list is null, check plz");
				}
	}
}
