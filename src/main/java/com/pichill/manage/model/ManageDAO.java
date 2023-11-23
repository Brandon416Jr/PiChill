package com.pichill.manage.model;

import java.util.List;
import java.util.Map;

import com.pichill.manage.entity.Manage;

public interface ManageDAO {
	int insert(Manage manage); // public abstract可不加，預設就會有
	int update(Manage manage);
	int delete(Integer manageID); // 刪除需要篩選條件
	Manage getManageByManageID(Integer manageID); 
	Manage getManageBymName(String mName); 
	Manage getManageBymEmail(String mEmail); 
	List<Manage> getAll();
	List<Manage> getAll(int currentPage);
}
