package com.pichill.generaluser;

import java.util.List;

public interface GeneralUserDAO {
	
	void add(GeneralUser generalUser);
	void update(GeneralUser generalUser);
	void delete(int gUserID);
	GeneralUser findByPK(Integer gUserID);
	List<GeneralUser> getAll();
}
