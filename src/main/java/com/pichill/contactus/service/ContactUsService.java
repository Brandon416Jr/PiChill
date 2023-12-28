package com.pichill.contactus.service;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.contactus.model.ContactUsDAO;
import com.pichill.contactus.model.ContactUsDAOImpl;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;

public class ContactUsService {
	private final ContactUsDAO dao;

	public ContactUsService() {
		dao = new ContactUsDAOImpl();
	}

	public int addContactUs(ContactUs contactUs) {
		return dao.add(contactUs);	
	}

//	public void updateContactUs(ContactUs contactUs) {
//		dao.update(contactUs);
//	}
	
	public ContactUs getOneContactUs(Integer formID) {
		return dao.getContactUsByFormID(formID);
	}


	public List<ContactUs> getAll() {
		return dao.getAll();
	}
	
	public List<ContactUs> getByUID(Integer generalUser){
		return dao.getAllByUID(generalUser);
		
	}
	public List<ContactUs> getByOID(Integer ownerUser){
		return dao.getAllByOID(ownerUser);
		
	}
}
