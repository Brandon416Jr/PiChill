package com.pichill.contactus.model;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;

public interface ContactUsDAO {
	int insert(ContactUs entity);

	int update(ContactUs entity);

	int delete(Integer formID);
	
	ContactUs getByFormID(Integer formID);
	
	List<ContactUs> getByPurpose(String formPurpose);
	
	List<ContactUs> getByContent(String formContent);
	
	List<ContactUs> getByformPic(byte[] formPic);
	
	List<ContactUs> getByType(Integer formType);

	List<ContactUs> getAll();

//
//	long getTotal();
}
