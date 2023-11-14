package com.pichill.manage;

import java.util.List;

public interface ManageDAO {
	public abstract void add(Manage manage); // public abstract可不加，預設就會有
	void update(Manage manage);
	void delete(Integer manageID); // 刪除需要篩選條件
	Manage getManageByManageID(Integer manageID); 
	List<Manage> getAll();

}
