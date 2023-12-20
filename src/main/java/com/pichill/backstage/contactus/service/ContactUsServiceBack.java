package com.pichill.backstage.contactus.service;


import java.util.List;

import com.pichill.backstage.contactus.model.ContactUsDAOBack;
import com.pichill.backstage.contactus.model.ContactUsDAOImplBack;
import com.pichill.contactus.entity.ContactUs;


public class ContactUsServiceBack {
	private final ContactUsDAOBack dao;
	
	public ContactUsServiceBack() {
		dao = new ContactUsDAOImplBack();
	}
	
	public int updateContactUs(ContactUs contactUs) {
		return dao.update(contactUs);
	}
	
	public ContactUs getOneForm(Integer formID) {
		return dao.getByFormID(formID);
	}
	
	public List<ContactUs> getAll() {
		return dao.getAll();
	}

}
