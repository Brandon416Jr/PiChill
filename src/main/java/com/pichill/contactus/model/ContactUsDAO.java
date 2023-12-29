package com.pichill.contactus.model;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;

public interface ContactUsDAO {
	int add(ContactUs entity);

//	int update(ContactUs entity);
//
//	int delete(Integer formID);
	
	ContactUs getContactUsByFormID(Integer formID);
//	ContactUs getContactUsByFormPurpose(String formPurpose);

	List<ContactUs> getAll();
	List<ContactUs> getAllByUID(Integer gUserID);
	List<ContactUs> getAllByOID(Integer oUserID);
	
	

}
