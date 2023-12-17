package com.pichill.frontstage.owneruser.model;


import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;

public interface OwnerUserDAOFront {
	int insert(OwnerUser ownerUser);
	OwnerUser findByPK(Integer oUserID);
	boolean isUsernameExists(String oUserName);
	boolean isEmailExists(String oEmail);
	boolean isIDNumExists(String oIDNum);
	boolean isCompiledExists(String compiled);
	OwnerUser getOwnerUserByoUserName(String oUserName); 
	OwnerUser findByUserNamePassword(String oUserName,String oPassword);
	int update(OwnerUser OwnerUser);
	OwnerUser findByoEmail(String gEmail);
}
