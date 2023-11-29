package com.pichill.forumpic.service;

import java.util.List;

import com.pichill.forumpic.entity.ForumPic;
import com.pichill.forumpic.model.ForumPicDAO;
import com.pichill.forumpic.model.ForumPicDAOImpl;

public class ForumPicServiceImpl implements ForumPicService {

	private ForumPicDAO dao;

	public ForumPicServiceImpl() { // 建構子，初始化DAO
		dao = new ForumPicDAOImpl();
	}

	@Override
	public ForumPic add(ForumPic forumPic) {
		Integer id = dao.add(forumPic);
		forumPic = dao.getByForumPicID(id);
		return forumPic;
	}

	@Override
	public ForumPic update(ForumPic forumPic) {
		if (dao.update(forumPic) == 1) {
			return forumPic;
		} else
			return null;
	}

	@Override
	public void delete(int forumPicID) {
		dao.delete(forumPicID);
	}

	@Override
	public ForumPic getByForumPicID(Integer forumPicID) {
		return dao.getByForumPicID(forumPicID);
	}

	@Override
	public List<ForumPic> getAll() {
		return dao.getAll();
	}

}
