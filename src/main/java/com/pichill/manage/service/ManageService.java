package com.pichill.manage.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.pichill.manage.entity.Manage;
import com.pichill.manage.model.ManageDAO;
import com.pichill.manage.model.ManageDAOImpl;

public class ManageService {
	private final ManageDAO dao;

	public ManageService() {
		dao = new ManageDAOImpl();
	}

	public void insertManage(Manage manage) {
		dao.insert(manage);	
	}

	public void updateManage(Manage manage) {
		dao.update(manage);
	}

	public Manage getOneManage(Integer manageID) {
		return dao.getManageByManageID(manageID);
	}

	public List<Manage> getAll() {
		return dao.getAll();
	}
	
//	public void deleteManage(Integer manageID) {
//	dao.delete(manageID);
//}
}
