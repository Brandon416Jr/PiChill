package com.pichill.test.service;

import java.util.List;

import com.pichill.test.entity.GeneralUser;
import com.pichill.test.model.GeneralUserDAO;
import com.pichill.test.model.GeneralUserDAOImpl;

public class GeneralUserService {
	private final GeneralUserDAO dao;

	public GeneralUserService() {
		dao = new GeneralUserDAOImpl();
	}

	public void addGeneralUser(GeneralUser generalUser) {
		dao.add(generalUser);	
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
