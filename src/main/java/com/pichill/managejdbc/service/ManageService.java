package com.pichill.managejdbc.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.pichill.managejdbc.entity.Manage;
import com.pichill.managejdbc.model.ManageDAO;
import com.pichill.managejdbc.model.ManageDAOImpl;

public class ManageService {
	private ManageDAO dao;

	public ManageService() {
		dao = new ManageDAOImpl();
	}

	public Manage addManage(String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
			Timestamp mLastLogTime, String mID, String mEmail, byte[] mProfilePic) {

		Manage manage = new Manage();

		manage.setmName(mName);
		manage.setmUserName(mUserName);
		manage.setmPassword(mPassword);
		manage.setmBirth(mBirth);
		manage.setmGender(mGender);
		manage.setmTelephone(mTelephone);
		manage.setmEmgContact(mEmgContact);
		manage.setmEmgPhone(mEmgPhone);
		manage.setmAddress(mAddress);
		manage.setmHiredate(mHiredate);
		manage.setmLastLogTime(mLastLogTime);
		manage.setmID(mID);
		manage.setmEmail(mEmail);
		manage.setmProfilePic(mProfilePic);
		dao.insert(manage);

		return manage;
	}

	public Manage updateManage(Integer manageID, String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
			Timestamp mLastLogTime, String mID, String mEmail, byte[] mProfilePic) {

		Manage manage = new Manage();

		manage.setManageID(manageID);
		manage.setmName(mName);
		manage.setmUserName(mUserName);
		manage.setmPassword(mPassword);
		manage.setmBirth(mBirth);
		manage.setmGender(mGender);
		manage.setmTelephone(mTelephone);
		manage.setmEmgContact(mEmgContact);
		manage.setmEmgPhone(mEmgPhone);
		manage.setmAddress(mAddress);
		manage.setmHiredate(mHiredate);
		manage.setmLastLogTime(mLastLogTime);
		manage.setmID(mID);
		manage.setmEmail(mEmail);
		manage.setmProfilePic(mProfilePic);
		dao.update(manage);

		return manage;
	}

	public void deleteManage(Integer manageID) {
		dao.delete(manageID);
	}

	public Manage getOneManage(Integer manageID) {
		return dao.findByPrimaryKey(manageID);
	}

	public List<Manage> getAll() {
		return dao.getAll();
	}
}
