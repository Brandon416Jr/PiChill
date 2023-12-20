package com.pichill.manage.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.manage.model.ManageDAO;
import com.pichill.manage.model.ManageDAOImpl;

public class ManageService {
	private final ManageDAO dao;

	public ManageService() {
		dao = new ManageDAOImpl();
	}
	
	public Manage insertManage(String mName, String mUserName, String mPassword, Date mBirth, Integer mGender,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, Date mHiredate,
			String mID, String mEmail, byte[] mProfilePic, int mStatus) {
		
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
		manage.setmID(mID);
		manage.setmEmail(mEmail);
		manage.setmProfilePic(mProfilePic);
		manage.setmStatus(mStatus);
		System.out.println("insertManage:"+manage);
		dao.insert(manage);
		return manage;
	}
	
	public Manage updateManage(int manageID, String mName, String mUserName, String mPassword,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, String mEmail, byte[] mProfilePic, int mStatus) {
		Manage manage = dao.getManageByManageID(manageID);
		if (manage != null) {
			manage.setmName(mName);
			manage.setmUserName(mUserName);
			manage.setmPassword(mPassword);
//			manage.setmBirth(mBirth);
//			manage.setmGender(mGender);
			manage.setmTelephone(mTelephone);
			manage.setmEmgContact(mEmgContact);
			manage.setmEmgPhone(mEmgPhone);
			manage.setmAddress(mAddress);
//			manage.setmHiredate(mHiredate);
//			manage.setmID(mID);
			manage.setmEmail(mEmail);
			manage.setmProfilePic(mProfilePic);
			manage.setmStatus(mStatus);
			dao.update(manage);
		}
		return manage;
	}
	
	public Manage updateMyData(int manageID, String mName, String mUserName, String mPassword,
			String mTelephone, String mEmgContact, String mEmgPhone, String mAddress, String mEmail, byte[] mProfilePic) {
		Manage manage = dao.getManageByManageID(manageID);
		if (manage != null) {
			manage.setmName(mName);
			manage.setmUserName(mUserName);
			manage.setmPassword(mPassword);
//			manage.setmBirth(mBirth);
//			manage.setmGender(mGender);
			manage.setmTelephone(mTelephone);
			manage.setmEmgContact(mEmgContact);
			manage.setmEmgPhone(mEmgPhone);
			manage.setmAddress(mAddress);
//			manage.setmHiredate(mHiredate);
//			manage.setmID(mID);
			manage.setmEmail(mEmail);
			manage.setmProfilePic(mProfilePic);
//			manage.setmStatus(mStatus);
			dao.update(manage);
		}
		return manage;
	}
	
	public Manage userAuth(String mUserName, String mPassword) {
    	return dao.findByUserNamePassword(mUserName, mPassword);
        
    }
	
	public boolean existsUserName(String mUserName, Integer manageID) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUserNameExists(mUserName);
        return exists;
    }
	
	public boolean existsEmail(String mEmail, Integer manageID) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isEmailExists(mEmail);
        return exists;
    }
	
	public boolean existsUserNameByInsert(String mUserName) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUserNameExistsByInsert(mUserName);
        return exists;
    }
	
	public boolean existsEmailByInsert(String mEmail) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isEmailExistsByInsert(mEmail);
        return exists;
    }
	
	public boolean existsIDByInsert(String mID) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isIDExists(mID);
        return exists;
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
