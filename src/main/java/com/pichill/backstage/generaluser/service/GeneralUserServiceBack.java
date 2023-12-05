package com.pichill.backstage.generaluser.service;

import java.util.List;

import com.pichill.backstage.generaluser.model.GeneralUserDAOImplBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.model.GeneralUserDAO;

public class GeneralUserServiceBack {
private final GeneralUserDAO dao;
	
	public GeneralUserServiceBack() {
		dao = new GeneralUserDAOImplBack();
	}

	public void updateGeneralUser(GeneralUser generalUser) {
		dao.update(generalUser);
	}

	public GeneralUser getOneGeneralUser(Integer gUserID) {
		return dao.findByPK(gUserID);
	}

	public List<GeneralUser> getAll() {
		return dao.getAll();
	}
}
