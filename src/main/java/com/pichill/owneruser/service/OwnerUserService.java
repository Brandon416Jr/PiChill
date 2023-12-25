package com.pichill.owneruser.service;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
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
	
	public OwnerUser getOneOwnerUser(Integer oUserID) {
		return dao.getOwnerUserByOUserID(oUserID);
	}


	public List<OwnerUser> getAll() {
		return dao.getAll();
	}
	
	public OwnerUser updateByoPostAmount(Integer oUserID, Integer oPostAmount) {

		OwnerUser ownerUser = dao.getOwnerUserByOUserID(oUserID); // 先獲取現有的 MemberVO 物件
		if (ownerUser != null) {

			ownerUser.setoPostAmount(oPostAmount);

			dao.update(ownerUser);
		}

		return ownerUser;
	}
}