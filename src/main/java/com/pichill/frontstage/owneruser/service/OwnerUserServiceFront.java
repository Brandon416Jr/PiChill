package com.pichill.frontstage.owneruser.service;

import com.pichill.frontstage.owneruser.model.OwnerUserDAOFront;
import com.pichill.frontstage.owneruser.model.OwnerUserDAOImplFront;
import com.pichill.owneruser.entity.OwnerUser;

public class OwnerUserServiceFront {
private final OwnerUserDAOFront dao;
	
	public OwnerUserServiceFront() {
		dao = new OwnerUserDAOImplFront();
	}
	
	public int insertOwnerUser(OwnerUser ownerUser) {
		return dao.insert(ownerUser);
	}
	
	public OwnerUser getOneOwnerUser(Integer oUserID) {
		return dao.findByPK(oUserID);
	}
	
	public boolean existsUsername(String oUserName) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isUsernameExists(oUserName);
        return exists;
    }
}
