package com.pichill.generaluser.service;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.generaluser.model.GeneralUserDAO;
import com.pichill.generaluser.model.GeneralUserDAOImpl;
import com.pichill.reserveorder.entity.ReserveOrder;
import com.pichill.reserveorder.service.ReserveOrderService;

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
	
	public GeneralUser updateByPostAmount(Integer gUserID, Integer gPostAmount) {

		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {

			generalUser.setgPostAmount(gPostAmount);

			dao.update(generalUser);
		}

		return generalUser;
	}
	
	public GeneralUser updateByCommentAmount(Integer gUserID, Integer CommentAmount) {

		GeneralUser generalUser = dao.findByPK(gUserID); // 先獲取現有的 MemberVO 物件
		if (generalUser != null) {

			generalUser.setCommentAmount(CommentAmount);

			dao.update(generalUser);
		}

		return generalUser;
	}
//	public List<ReserveOrder> getAllList(Integer gUserID) {
//		return dao.getAllList();
//	}
}
