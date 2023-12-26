package com.pichill.contactus.model;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;

public interface ContactUsDAO {
	int add(ContactUs entity);

	int update(ContactUs entity);

	int delete(Integer formID);
	
	ContactUs getContactUsByFormID(Integer formID);
//	ContactUs getContactUsByFormPurpose(String formPurpose);

	List<ContactUs> getAll();

}
