package com.pichill.frontstage.owneruser.model;

import com.pichill.owneruser.entity.OwnerUser;

public interface OwnerUserDAOFront {
	int insert(OwnerUser ownerUser);
	OwnerUser findByPK(Integer oUserID);
	boolean isUsernameExists(String oUserName);
}
