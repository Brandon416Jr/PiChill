package com.pichill.contactus.model;

import java.util.List;

import com.pichill.contactus.entity.ContactUs;

public interface ContactUsDAO {
	public abstract void add(ContactUs contactus);
	void update(ContactUs contactus);
	void delete(Integer formID);
	public ContactUs getContactUsByFormID(Integer formID);
	public List<ContactUs> getAll();
}
