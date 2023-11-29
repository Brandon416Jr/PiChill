package com.pichill.test.model;

import java.util.List;

import com.pichill.test.entity.GeneralUser;

public interface GeneralUserDAO {
	
	int add(GeneralUser generalUser);
	int update(GeneralUser generalUser);
	GeneralUser findByPK(Integer gUserID);
	List<GeneralUser> getAll();
}
