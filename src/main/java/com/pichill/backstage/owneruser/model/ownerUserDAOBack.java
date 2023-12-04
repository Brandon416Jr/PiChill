package com.pichill.backstage.owneruser.model;

import java.util.List;

import com.pichill.owneruser.OwnerUser;



public interface ownerUserDAOBack {
	int update(OwnerUser ownerUser);
	OwnerUser getOwnerUserByoUserID(Integer oUserID); 
	List<OwnerUser> getAll();
}
