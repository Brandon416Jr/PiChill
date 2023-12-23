package com.pichill.backstage.generaluser.service;

import java.sql.Date;
import java.util.List;

import com.pichill.backstage.generaluser.model.GeneralUserDAOImplBack;
import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.model.GeneralUserDAO;

public class GeneralUserServiceBack {
private final GeneralUserDAO dao;
	
	public GeneralUserServiceBack() {
		dao = new GeneralUserDAOImplBack();
	}

	public GeneralUser updateGeneralUser(Integer gUserID, Integer status) {
		
		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {
			
			generalUser.setStatus(status);
			
			dao.update(generalUser);
		}
		
		
		return generalUser;
	}
	
	public GeneralUser updateGeneralUserByReport(Integer gUserID, Integer status, Integer gReportCnt) {
		
		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {
			
			generalUser.setStatus(status);
			generalUser.setgReportCnt(gReportCnt);
			
			dao.update(generalUser);
		}
		
		
		return generalUser;
	}
	
	public GeneralUser updateGeneralUserByReportFail(Integer gUserID, Integer gReportCnt) {
		
		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {
			
//			generalUser.setStatus(status);
			generalUser.setgReportCnt(gReportCnt);
			
			dao.update(generalUser);
		}
		
		
		return generalUser;
	}


	public GeneralUser getOneGeneralUser(Integer gUserID) {
		return dao.findByPK(gUserID);
	}

	public List<GeneralUser> getAll() {
		return dao.getAll();
	}
}
