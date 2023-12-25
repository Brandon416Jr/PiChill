package com.pichill.frontstage.generaluser.service;

import java.sql.Date;
import java.util.List;

import com.pichill.frontstage.generaluser.model.GeneralUserDAOFront;
import com.pichill.frontstage.generaluser.model.GeneralUserDAOImplFront;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;

public class GeneralUserServiceFront {
	private final GeneralUserDAOFront dao;
	
	public GeneralUserServiceFront() {
		dao = new GeneralUserDAOImplFront();
	}
	
	public GeneralUser insertGeneralUser(String gName, String gTelephone, String gEmail, String gAddress, Integer status,
			Integer gGender, String gUsername, String gPassword, String gIDNum, String nicknameID, Integer gPostAmount,
			Integer commentAmount, Integer gReportCnt, Date gRegistDate, Date gBirth, Integer yoyakuCnt,
			byte[] gProfilePic) {
		GeneralUser generalUser = new GeneralUser();
		
		generalUser.setgName(gName);
		generalUser.setgTelephone(gTelephone);
		generalUser.setgEmail(gEmail);
		generalUser.setgAddress(gAddress);
		generalUser.setStatus(status);
		generalUser.setgGender(gGender);
		generalUser.setgUsername(gUsername);
		generalUser.setgPassword(gPassword);
		generalUser.setgIDNum(gIDNum);
		generalUser.setNicknameID(nicknameID);
//		generalUser.setgPostAmount(gPostAmount);
//		generalUser.setCommentAmount(commentAmount);
//		generalUser.setgReportCnt(gReportCnt);
		generalUser.setgBirth(gBirth);
		generalUser.setgRegistDate(gRegistDate);
//		generalUser.setYoyakuCnt(yoyakuCnt);
		generalUser.setgProfilePic(gProfilePic);
		dao.insert(generalUser);
		
		return generalUser;
	}
	
	public GeneralUser updateGeneralUserByYoyakuCnt(Integer gUserID, Integer yoyakuCnt) {

		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {

			generalUser.setYoyakuCnt(yoyakuCnt);

			dao.update(generalUser);
		}

		return generalUser;
	}
	
	public GeneralUser updateGeneralUser(Integer gUserID, String gName, String gTelephone, String gEmail, String gAddress, Integer status,
			Integer gGender, String gUsername, String gPassword, String gIDNum, String nicknameID, Integer gPostAmount,
			Integer commentAmount, Integer gReportCnt, Date gRegistDate, Date gBirth, Integer yoyakuCnt,
			byte[] gProfilePic) {
		
		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {
			generalUser.setgName(gName);
			generalUser.setgTelephone(gTelephone);
			generalUser.setgEmail(gEmail);
			generalUser.setgAddress(gAddress);
//			generalUser.setStatus(status);
			generalUser.setgGender(gGender);
			generalUser.setgUsername(gUsername);
			generalUser.setgPassword(gPassword);
			generalUser.setgIDNum(gIDNum);
			generalUser.setNicknameID(nicknameID);
//			generalUser.setgPostAmount(gPostAmount);
//			generalUser.setCommentAmount(commentAmount);
//			generalUser.setgReportCnt(gReportCnt);
			generalUser.setgBirth(gBirth);
			generalUser.setgRegistDate(gRegistDate);
//			generalUser.setYoyakuCnt(yoyakuCnt);
			generalUser.setgProfilePic(gProfilePic);
			dao.update(generalUser);
		}
		
		
		return generalUser;
	}
	
	 public GeneralUser updateGeneralUsers(GeneralUser generalUser) {
	     int updateResult = dao.update(generalUser);
	     
	     if (updateResult == 1) {
	         // 更新成功
	         return generalUser;
	     } else {
	         return null;
	     }
	 }
	
	public GeneralUser getOneGeneralUser(Integer gUserID) {
		return dao.findByPK(gUserID);
	}
	
	public GeneralUser getGeneralUserBygUsername(String gUsername) {
		return dao.findByGeneralUsergUsername(gUsername);
	}
	
	public boolean existsUsername(String gUsername) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUsernameExists(gUsername);
        return exists;
    }
	public boolean existsEmail(String gEmail) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isEmailExists(gEmail);
        return exists;
    }
	public boolean existsIDNum(String gIDNum) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isIDNumExists(gIDNum);
        return exists;
    }
	public boolean existsNicknameID(String nicknameID) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isNicknameIDExists(nicknameID);
        return exists;
    }
	
	public GeneralUser userAuth(String gUsername, String gPassword) {
    	return dao.findByUserNamePassword(gUsername, gPassword);
        
    }
	
	public GeneralUser getGeneralUserBygEmail(String gEmail) {
		return dao.findBygEmail(gEmail);
	}
}
