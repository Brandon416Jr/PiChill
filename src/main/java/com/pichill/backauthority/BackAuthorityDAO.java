package com.pichill.backauthority;

import java.util.List;

public interface BackAuthorityDAO {
	public abstract void add(BackAuthority backAutority); // public abstract可不加，預設就會有
	void update(BackAuthority backAutority);
	void delete(Integer backAuthorityID); // 刪除需要篩選條件
	BackAuthority getBackAuthorityByBackAuthorityID(Integer backAuthorityID); 
	List<BackAuthority> getAll();

}
