package com.pichill.backstage.contactus.model;

import java.util.List;

import com.pichill.backstage.contactus.entity.ContactUs;

public interface ContactUsDAOBack {

	int update(ContactUs contactUs);

	ContactUs getByFormID(Integer formID);
	
	List<ContactUs> getAll();
}
