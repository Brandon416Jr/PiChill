package com.pichill.manage.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.pichill.manage.entity.Manage;
import com.pichill.manage.model.ManageDAO;
import com.pichill.manage.model.ManageDAOImpl;

public class ManageService {
	private final ManageDAO dao;

	public ManageService() {
		dao = new ManageDAOImpl();
	}
	
	public int insertManage(Manage manage) {
		return dao.insert(manage);
	}
	
	public int updateManage(Manage manage) {
		return dao.update(manage);
	}
	
	public Manage userAuth(String mUserName, String mPassword) {
    	return dao.findByUserNamePassword(mUserName, mPassword);
        
    }

//	public Manage insertManage(String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
//			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
//			String mID, String mEmail, byte[] mProfilePic, int mStatus) {
//		    Manage manage = new Manage();
//		    manage.setmName(mName);
//    		manage.setmUserName(mUserName);
//    		manage.setmPassword(mPassword);
//    		manage.setmBirth(mBirth);
//    		manage.setmGender(mGender);
//    		manage.setmTelephone(mTelephone);
//    		manage.setmEmgContact(mEmgContact);
//    		manage.setmEmgPhone(mEmgPhone);
//    		manage.setmAddress(mAddress);
//    		manage.setmHiredate(mHiredate);
//    		manage.setmID(mID);
//    		manage.setmEmail(mEmail);
//    		manage.setmProfilePic(mProfilePic);
//    		manage.setmStatus(mStatus);
//	        dao.insert(manage);
//	        return manage;
//	}
//
//	public Manage updateManage(int manageID, String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
//			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
//			String mID, String mEmail, byte[] mProfilePic, int mStatus) {
//		 Manage manage = dao.getManageByManageID(manageID); 
//	        if (manage != null) {
//	    		manage.setManageID(manageID);
//	        	manage.setmName(mName);
//	    		manage.setmUserName(mUserName);
//	    		manage.setmPassword(mPassword);
//	    		manage.setmBirth(mBirth);
//	    		manage.setmGender(mGender);
//	    		manage.setmTelephone(mTelephone);
//	    		manage.setmEmgContact(mEmgContact);
//	    		manage.setmEmgPhone(mEmgPhone);
//	    		manage.setmAddress(mAddress);
//	    		manage.setmHiredate(mHiredate);
//	    		manage.setmID(mID);
//	    		manage.setmEmail(mEmail);
//	    		manage.setmProfilePic(mProfilePic);
//	    		manage.setmStatus(mStatus);
//	            dao.update(manage);
//	        }
//	        return dao.getManageByManageID(manageID);
//	}

	public Manage getOneManage(Integer manageID) {
		return dao.getManageByManageID(manageID);
	}
	
	public Manage getOneManage(String mUserName) {
		return dao.getManageBymUserName(mUserName);
	}

	public List<Manage> getAll() {
		return dao.getAll();
	}
	
//	public void deleteManage(Integer manageID) {
//	dao.delete(manageID);
//}
}
