package com.pichill.managejdbc.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.pichill.managejdbc.entity.Manage;
import com.pichill.managejdbc.model.ManageDAO;
import com.pichill.managejdbc.model.ManageDAOImpl;

public class ManageService {
	private final ManageDAO dao;

	public ManageService() {
		dao = new ManageDAOImpl();
	}

	public void addManage(Manage manage) {
		dao.insert(manage);	
	}

	public void updateManage(Manage manage) {
		dao.update(manage);
	}

//	public void deleteManage(Integer manageID) {
//		dao.delete(manageID);
//	}

	public Manage getOneManage(Integer manageID) {
		return dao.findByPrimaryKey(manageID);
	}

	public List<Manage> getAll() {
		return dao.getAll();
	}
}
