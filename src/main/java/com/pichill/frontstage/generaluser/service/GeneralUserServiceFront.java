package com.pichill.frontstage.generaluser.service;

import com.pichill.frontstage.generaluser.model.GeneralUserDAOFront;
import com.pichill.frontstage.generaluser.model.GeneralUserDAOImplFront;
import com.pichill.generaluser.entity.GeneralUser;

public class GeneralUserServiceFront {
	private final GeneralUserDAOFront dao;
	
	public GeneralUserServiceFront() {
		dao = new GeneralUserDAOImplFront();
	}
	
	public int insertGeneralUser(GeneralUser generalUser) {
		return dao.insert(generalUser);
	}
	
	public GeneralUser getOneGeneralUser(Integer gUserID) {
		return dao.findByPK(gUserID);
	}
	
	public GeneralUser getGeneralUserBygUsername(String gUsername) {
		return dao.findByGeneralUsergUsername(gUsername);
	}
	
	public boolean existsUsername(String gUsername) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUsernameExists(gUsername);
        return exists;
    }
}
