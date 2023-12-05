package com.pichill.backstage.owneruser.service;

import java.util.List;

import com.pichill.backstage.owneruser.model.OwnerUserDAOBack;
import com.pichill.backstage.owneruser.model.OwnerUserDAOImplBack;
import com.pichill.owneruser.OwnerUser;

public class OwnerUserServiceBack {
	private final OwnerUserDAOBack dao;
	
	public OwnerUserServiceBack() {
		dao = new OwnerUserDAOImplBack();
	}
	
	public void updateOwnerUser(OwnerUser ownerUser) {
		dao.update(ownerUser);
	}

	public OwnerUser getOneOwnerUser(Integer oUserID) {
		return dao.getOwnerUserByoUserID(oUserID);
	}

	public List<OwnerUser> getAll() {
		return dao.getAll();
	}
}
