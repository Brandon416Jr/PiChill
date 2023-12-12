package com.pichill.frontstage.owneruser.service;

import com.pichill.frontstage.owneruser.model.OwnerUserDAOFront;
import com.pichill.frontstage.owneruser.model.OwnerUserDAOImplFront;
import com.pichill.owneruser.entity.OwnerUser;

public class OwnerUserServiceFront {
private final OwnerUserDAOFront dao;
	
	public OwnerUserServiceFront() {
		dao = new OwnerUserDAOImplFront();
	}
	
	public int insertOwnerUser(OwnerUser ownerUser) {
		return dao.insert(ownerUser);
	}
	
	public OwnerUser getOneOwnerUser(Integer oUserID) {
		return dao.findByPK(oUserID);
	}
}
