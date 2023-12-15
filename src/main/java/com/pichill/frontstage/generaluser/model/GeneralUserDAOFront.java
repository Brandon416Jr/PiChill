package com.pichill.frontstage.generaluser.model;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;

public interface GeneralUserDAOFront {
	int insert(GeneralUser generalUser);
	GeneralUser findByPK(Integer gUserID);
	List<GeneralUser> findByGeneralUsergUsername(String gUsername);
	boolean isUsernameExists(String gUsername);
	boolean isEmailExists(String gEmail);
	boolean isIDNumExists(String gUDNum);
	boolean isNicknameIDExists(String nicknameID);
	GeneralUser findByUserNamePassword(String gUsername, String gPassword);
}
