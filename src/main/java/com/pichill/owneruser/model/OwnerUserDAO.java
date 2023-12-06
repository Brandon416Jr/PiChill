package com.pichill.owneruser.model;

import java.util.List;
import com.pichill.owneruser.entity.OwnerUser;

public interface OwnerUserDAO{
	int add(OwnerUser ownerUser);
	int update(OwnerUser ownerUser);
	OwnerUser getOwnerUserOUserID(Integer oUserID);
	List<OwnerUser> getAll();
}