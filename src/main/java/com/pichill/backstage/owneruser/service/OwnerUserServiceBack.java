package com.pichill.backstage.owneruser.service;

import java.util.List;

import com.pichill.backstage.owneruser.model.OwnerUserDAOBack;
import com.pichill.backstage.owneruser.model.OwnerUserDAOImplBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.owneruser.entity.OwnerUser;

public class OwnerUserServiceBack {
	private final OwnerUserDAOBack dao;

	public OwnerUserServiceBack() {
		dao = new OwnerUserDAOImplBack();
	}

	public void updateOwnerUser(OwnerUser ownerUser) {
		dao.update(ownerUser);
	}

	public OwnerUser updateOwnerUserByReport(Integer oUserID, Integer oReportCnt) {

		OwnerUser ownerUser = dao.getOwnerUserByoUserID(oUserID); // 先獲取現有的 MemberVO 物件
		if (ownerUser != null) {

			ownerUser.setoReportCnt(oReportCnt);

			dao.update(ownerUser);
		}

		return ownerUser;
	}
	
	public OwnerUser updateOwnerUserByCourtArrive(Integer oUserID, Integer courtArriveCnt) {

		OwnerUser ownerUser = dao.getOwnerUserByoUserID(oUserID); // 先獲取現有的 MemberVO 物件
		if (ownerUser != null) {

			ownerUser.setCourtArriveCnt(courtArriveCnt);

			dao.update(ownerUser);
		}

		return ownerUser;
	}

	public OwnerUser getOneOwnerUser(Integer oUserID) {
		return dao.getOwnerUserByoUserID(oUserID);
	}

	public List<OwnerUser> getAll() {
		return dao.getAll();
	}
}
