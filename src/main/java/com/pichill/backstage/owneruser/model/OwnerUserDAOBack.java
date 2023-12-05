package com.pichill.backstage.owneruser.model;

import java.util.List;

import com.pichill.owneruser.entity.OwnerUser;



public interface OwnerUserDAOBack {
	int update(OwnerUser ownerUser);
	OwnerUser getOwnerUserByoUserID(Integer oUserID); 
	List<OwnerUser> getAll();
}
