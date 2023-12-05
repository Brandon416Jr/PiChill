package com.pichill.contactus.service;

import java.util.List;
import com.pichill.contactus.entity.ContactUs;

public interface ContactUsService {
	//dao的save方法還回主鍵值 再透過主鍵值用get方法找到資料庫的物件
		ContactUs addContactUs(ContactUs contactUs);
//		ContactUs addContactUs(String formPurpose,String formContent,Integer formType);
		
		ContactUs updateContactUs(ContactUs contactUs);
		
//		void deleteContactUs(Integer postID); ContactUs沒有刪除欄位
		
		ContactUs getByPostID(Integer formID);
		
		List<ContactUs> getContactUsByformPurpose(String formPurpose);
		
		List<ContactUs> getContactUsByformContent(String formContent);
		
		List<ContactUs> getContactUsByformPic(byte[] formPic);
		
		List<ContactUs> getContactUsByformType(Integer formType);
		
		List<ContactUs>getAllContactUss();
		
//		int getPageTotal();
//		List<Post>getPostsByCompositeQuery(Map<String,String[]>map);
}
