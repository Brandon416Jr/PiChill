package com.pichill.backauthority.model;

import java.util.List;

import com.pichill.backauthority.entity.BackAuthority;

public interface BackAuthorityDAO {
	int add(BackAuthority backAutority); // public abstract可不加，預設就會有
	int update(BackAuthority backAutority);
//	void delete(Integer backAuthorityID); // 刪除需要篩選條件
//	BackAuthority getBackAuthorityByBackAuthorityID(Integer backAuthorityID); 
	List<BackAuthority> getAll();

}
