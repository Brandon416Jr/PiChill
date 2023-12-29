package com.pichill.owneruser.service;

import java.sql.Date;
import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
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

//	public void updateOwnerUser(OwnerUser ownerUser) {
//		dao.update(ownerUser);
//	}
	
	public OwnerUser updateOwnerUser(Integer oUserID, String oUserName, String oPassword, String oIDNum, 
			 String compiled, String oName,Integer oGender, Date oBirth, String oTelephone,
			 String oAddress, String oBankCode, String  oBankAccount,byte[] oProfilePic,
			  String oEmail) {
		OwnerUser ownerUser = dao.getOwnerUserByOUserID(oUserID);
		if (ownerUser != null) {

		ownerUser.setoUserName(oUserName);
		ownerUser.setoPassword(oPassword);
		ownerUser.setoIDNum(oIDNum);
		ownerUser.setcompiled(compiled);
		ownerUser.setoName(oName);
		ownerUser.setoGender(oGender);
		ownerUser.setoBirth(oBirth);
		ownerUser.setoTelephone(oTelephone);
		ownerUser.setoAddress(oAddress);
		ownerUser.setoBankCode(oBankCode);
		ownerUser.setoBankAccount(oBankAccount);
		ownerUser.setoProfilePic(oProfilePic);
//		ownerUser.setoRegisterDate(oRegisterDate);
//		ownerUser.setoPostAmount(oPostAmount);
//		ownerUser.setoReportCnt(oReportCnt);
//		ownerUser.setCourtArriveCnt(courtArriveCnt);
//		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoEmail(oEmail);
//		ownerUser.setoStatus(oStatus);
		dao.update(ownerUser);
		}
		return ownerUser;
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