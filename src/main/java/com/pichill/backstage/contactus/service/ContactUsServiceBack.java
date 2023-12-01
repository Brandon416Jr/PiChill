package com.pichill.backstage.contactus.service;


import java.util.List;

import com.pichill.backstage.contactus.model.ContactUsDAOImplBack;
import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.model.ContactUsDAO;


public class ContactUsServiceBack {
	private final ContactUsDAO dao;
	
	public ContactUsServiceBack() {
		dao = new ContactUsDAOImplBack();
	}
	
	public void updateContactUs(ContactUs contactUs) {
		dao.update(contactUs);
	}
	
	public ContactUs getOneForm(Integer formID) {
		return dao.getByFormID(formID);
	}
	
	public List<ContactUs> getAll() {
		return dao.getAll();
	}

}
