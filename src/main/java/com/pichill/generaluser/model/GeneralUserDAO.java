package com.pichill.generaluser.model;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;

public interface GeneralUserDAO {
	
	int add(GeneralUser generalUser);
	int update(GeneralUser generalUser);
	GeneralUser findByPK(Integer gUserID);
	List<GeneralUser> getAll();
}
