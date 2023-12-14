package com.pichill.contactus.service;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.model.ContactUsDAO;
import com.pichill.contactus.model.ContactUsDAOImpl;

public class ContactUsService {
	private final ContactUsDAO dao;

	public ContactUsService() {
		dao = new ContactUsDAOImpl();
	}

	public void addContactUs(ContactUs contactUs) {
		dao.add(contactUs);	
	}

	public void updateContactUs(ContactUs contactUs) {
		dao.update(contactUs);
	}
	
	public ContactUs getOneContactUs(Integer formID) {
		return dao.getContactUsByFormID(formID);
	}


	public List<ContactUs> getAll() {
		return dao.getAll();
	}
}
