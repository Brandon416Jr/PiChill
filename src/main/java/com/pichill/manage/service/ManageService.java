package com.pichill.manage.service;

import java.util.List;

import com.pichill.manage.entity.Manage;

public interface ManageService {
	Manage addManage(Manage manage);
	Manage updateManage(Manage manage);
	void deleteManage(Integer manage);
	Manage getManageByManageID(Integer manageID);
	Manage getManageBymName(String mName); 
	Manage getManageBymEmail(String mEmail); 
	List<Manage>getAllManages(int currentPage);
	List<Manage>getAllManages();
}
