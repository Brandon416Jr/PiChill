package com.pichill.owneruser.service;

import java.util.List;

import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.owneruser.model.OwnerUserDAO;
import com.pichill.owneruser.model.OwnerUserDAOImpl;

public class OwnerUserService {
	private final OwnerUserDAO dao;

	public OwnerUserService() {
		dao = new OwnerUserDAOImpl();
	}

	public void addOwnerUser(OwnerUser ownerUser) {
		dao.add(ownerUser);	
	}

	public void updateOwnerUser(OwnerUser ownerUser) {
		dao.update(ownerUser);
	}
	
	public OwnerUser getOneGeneralUser(Integer oUserID) {
		return dao.findByPK(oUserID);
	}


	public List<OwnerUser> getAll() {
		return dao.getAll();
	}
}