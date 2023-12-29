package com.pichill.frontstage.owneruser.service;

import java.sql.Date;

import com.pichill.frontstage.owneruser.model.OwnerUserDAOFront;
import com.pichill.frontstage.owneruser.model.OwnerUserDAOImplFront;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.owneruser.entity.OwnerUser;

public class OwnerUserServiceFront {
private final OwnerUserDAOFront dao;
	
	public OwnerUserServiceFront() {
		dao = new OwnerUserDAOImplFront();
	}
	
	public OwnerUser insertOwnerUser(String oUserName, String oPassword, String oIDNum, 
			 String compiled, String oName,Integer oGender, Date oBirth, String oTelephone,
			 String oAddress, String oBankCode, String oBankAccount, byte[] oProfilePic,
			 Date oRegisterDate, Integer oPostAmount, Integer oReportCnt,
			 Integer courtArriveCnt, Integer rsvdCnts, String oEmail, Integer oStatus) {
		
		OwnerUser ownerUser = new OwnerUser();
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
		ownerUser.setoRegisterDate(oRegisterDate);
//		ownerUser.setoPostAmount(oPostAmount);
//		ownerUser.setoReportCnt(oReportCnt);
//		ownerUser.setCourtArriveCnt(courtArriveCnt);
//		ownerUser.setRsvdCnts(rsvdCnts);
		ownerUser.setoEmail(oEmail);
		ownerUser.setoStatus(oStatus);
		dao.insert(ownerUser);

		return ownerUser;
	}
	
	public OwnerUser updateOwnerUserByAll(Integer oUserID, String oUserName, String oName, String oPassword,
			String oTelephone, String oAddress, String oEmail, byte[] oProfilePic, String compiled, String oBankCode, String oBankAccount) {
		OwnerUser ownerUser = dao.findByPK(oUserID);
		if (ownerUser != null) {
			ownerUser.setoName(oName);
			ownerUser.setoAddress(oAddress);
			ownerUser.setoBankAccount(oBankAccount);
			ownerUser.setoBankCode(oBankCode);
			ownerUser.setoEmail(oEmail);
			ownerUser.setoPassword(oPassword);
			ownerUser.setoUserName(oUserName);
			ownerUser.setoProfilePic(oProfilePic);
			ownerUser.setcompiled(compiled);
			ownerUser.setoTelephone(oTelephone);

			dao.update(ownerUser);
		}
		return ownerUser;
	}
	
	public OwnerUser updateOwnerUserByRsvdCnts(Integer oUserID, Integer rsvdCnts) {

		OwnerUser ownerUser = dao.findByPK(oUserID); // 先獲取現有的 MemberVO 物件
		if (ownerUser != null) {

			ownerUser.setRsvdCnts(rsvdCnts);

			dao.update(ownerUser);
		}

		return ownerUser;
	}
	
	public int updateOwnerUser(OwnerUser ownerUser) {
		return dao.update(ownerUser);
	}
	
	public OwnerUser updateOwnerUsers(OwnerUser ownerUser) {
		int updateResult = dao.update(ownerUser);
	     
	     if (updateResult == 1) {
	         // 更新成功
	         return ownerUser;
	     } else {
	         return null;
	     }
	}
	
	public OwnerUser getOneOwnerUser(Integer oUserID) {
		return dao.findByPK(oUserID);
	}
	
	public boolean existsUsername(String oUserName) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUsernameExists(oUserName);
        return exists;
    }
	public boolean existsEmail(String oEmail) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isEmailExists(oEmail);
        return exists;
    }
	public boolean existsIDNum(String oIDNum) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isIDNumExists(oIDNum);
        return exists;
    }
	public boolean existsCompiled(String compiled) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isCompiledExists(compiled);
        return exists;
    }
	
	public OwnerUser getOneOwnerUser(String oUserName) {
		return dao.getOwnerUserByoUserName(oUserName);
	}
	
	public OwnerUser userAuth(String oUserName, String oPassword) {
    	return dao.findByUserNamePassword(oUserName, oPassword);
        
    }
	
	public OwnerUser getOwnerUserByoEmail(String oEmail) {
		return dao.findByoEmail(oEmail);
	}
}
