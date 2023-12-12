package com.pichill.frontstage.generaluser.model;

import com.pichill.generaluser.entity.GeneralUser;

public interface GeneralUserDAOFront {
	int insert(GeneralUser generalUser);
	GeneralUser findByPK(Integer gUserID);
	GeneralUser findByGeneralUsergUsername(String gUsername);
	boolean isUsernameExists(String gUsername);
}
