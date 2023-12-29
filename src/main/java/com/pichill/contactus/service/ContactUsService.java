package com.pichill.contactus.service;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;

public interface ContactUsService {

	ContactUs addContactUs(ContactUs contactUs);

	ContactUs getOneContactUs(Integer formID);

	List<ContactUs> getAll();

	List<ContactUs> getByUID(Integer generalUser);

	List<ContactUs> getByOID(Integer ownerUser);
}
