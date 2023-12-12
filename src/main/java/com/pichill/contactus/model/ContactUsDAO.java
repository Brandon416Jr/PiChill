package com.pichill.contactus.model;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;

public interface ContactUsDAO {
	int add(ContactUs contactUs);

	int update(ContactUs contactUs);

	int delete(Integer formID);
	
	ContactUs getContactUsByFormID(Integer formID);

	List<ContactUs> getAll();

}
