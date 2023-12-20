package com.pichill.manage.model;

import java.util.List;
import java.util.Map;

import com.pichill.manage.entity.Manage;

public interface ManageDAO {
	int insert(Manage manage); // public abstract可不加，預設就會有
	int update(Manage manage);
	Manage getManageByManageID(Integer manageID); 
	Manage getManageBymUserName(String mUserName); 
	List<Manage> getAll();
	Manage findByUserNamePassword(String mUserName,String mPassword);
	boolean isUserNameExists(String mUserName);
	boolean isEmailExists(String mEmail);
	boolean isUserNameExistsByInsert(String mUserName);
	boolean isEmailExistsByInsert(String mEmail);
	boolean isIDExists(String mID);
//	int delete(Integer manageID); // 刪除需要篩選條件
	
//	Manage getManageBymName(String mName); 
//	Manage getManageBymEmail(String mEmail); 
	
//	List<Manage> getAll(int currentPage);
}
