package com.pichill.contactus.entity;

import java.sql.Timestamp;
import java.util.List;

import com.pichill.contactus.model.ContactUsDAO;
import com.pichill.contactus.model.ContactUsDAOImpl;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;

public class TestContactUs {
	public static void main(String[] args) {
		ContactUsDAO dao = new ContactUsDAOImpl();

		// 新增
		ContactUs contactUsAdd = new ContactUs();
		if (contactUsAdd.getOwnerUser() != null) {
			System.out.println(contactUsAdd.getOwnerUser().getoUserID());
		} else {
		    System.out.println("OwnerUser is null");
		}
		if (contactUsAdd.getGeneralUser() != null) {
			System.out.println(contactUsAdd.getGeneralUser().getgUserID());
		} else {
			System.out.println("generalUser is null");
		}
		contactUsAdd.getOwnerUser();
		contactUsAdd.getGeneralUser();
		contactUsAdd.setformPurpose("教室裡有人嗎?");
		contactUsAdd.setformContent("你們還活著嗎小孩?");
		contactUsAdd.setformPic(null);
		contactUsAdd.setformTime(new Timestamp(System.currentTimeMillis()));
		contactUsAdd.setformStatus(0);
		contactUsAdd.setformType(0);
		dao.add(contactUsAdd);

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
//		ContactUs getFormID = dao.getContactUsByFormID(22000023);
//		if (getFormID.getOwnerUser() != null) {
//			Integer oUserID = getFormID.getOwnerUser().getoUserID();
//			System.out.println(oUserID);
//			String oUserName = getFormID.getOwnerUser().getoName();
//			System.out.println(oUserName);
//			System.out.print(getFormID.getOwnerUser().getoUserName() + ",");
//		} else {
//		    System.out.println("OwnerUser is null");
//		}
//
//		if (getFormID.getGeneralUser() != null) {
//			Integer gUserID = getFormID.getGeneralUser().getgUserID();
//			String gUserName = getFormID.getGeneralUser().getgName();
//			System.out.println(gUserID);
//			System.out.println(gUserName);
//		} else {
//			System.out.println("GeneralUser is null");
//		}
//		
//		System.out.println(getFormID.getformPurpose() + ",");
//		System.out.println(getFormID.getformContent() + ",");
//		System.out.println(getFormID.getformPic() + ",");
//		System.out.println(getFormID.getformTime() + ",");
//		System.out.println(getFormID.getformStatus() + ",");
//		System.out.println(getFormID.getformType() + ",");

		System.out.println("---------------------");
		
//		//by使用者名稱列出全部
//		List<ContactUs> listByUID = dao.getAllByUID(11000008);
//		if (listByUID != null) {
//			for (ContactUs allFormByUID : listByUID) {
//				System.out.println(allFormByUID.getGeneralUser().getgUserID() + ",");
//				System.out.println(allFormByUID.getGeneralUser().getgName() + ",");
//				System.out.println(allFormByUID.getformPurpose() + ",");
//				System.out.println(allFormByUID.getformContent() + ",");
//				System.out.println(allFormByUID.getformPic() + ",");
//				System.out.println(allFormByUID.getformTime() + ",");
//				System.out.println(allFormByUID.getformStatus() + ",");
//				System.out.println(allFormByUID.getformType() + ",");
//				System.out.println();
//			}
//		} else {
//			System.out.println("list is null, check plz");
//		}
//
//		System.out.println("---------------------");
//		//by企業使用者名稱列出全部
//				List<ContactUs> listByOID = dao.getAllByOID(12000008);
//				if (listByOID != null) {
//					for (ContactUs allFormByOID : listByOID) {
//						System.out.println(allFormByOID.getOwnerUser().getoUserID() + ",");
//						System.out.println(allFormByOID.getOwnerUser().getoName() + ",");
//						System.out.println(allFormByOID.getformPurpose() + ",");
//						System.out.println(allFormByOID.getformContent() + ",");
//						System.out.println(allFormByOID.getformPic() + ",");
//						System.out.println(allFormByOID.getformTime() + ",");
//						System.out.println(allFormByOID.getformStatus() + ",");
//						System.out.println(allFormByOID.getformType() + ",");
//						System.out.println();
//					}
//				} else {
//					System.out.println("list is null, check plz");
//				}
//
//				System.out.println("---------------------");


//				// 查詢多筆
//		List<ContactUs> list = dao.getAll();
//
//		if (list != null) {
//			for (ContactUs contactUsAllForm : list) {
//				System.out.print(contactUsAllForm.getOwnerUser().getoName() + ",");
//				System.out.println(contactUsAllForm.getGeneralUser().getgName() + ",");
//				System.out.println(contactUsAllForm.getformPurpose() + ",");
//				System.out.println(contactUsAllForm.getformContent() + ",");
//				System.out.println(contactUsAllForm.getformPic() + ",");
//				System.out.println(contactUsAllForm.getformTime() + ",");
//				System.out.println(contactUsAllForm.getformStatus() + ",");
//				System.out.println(contactUsAllForm.getformType() + ",");
//				System.out.println();
//			}
//		} else {
//			System.out.println("list is null, check plz");
//		}
	}
}
