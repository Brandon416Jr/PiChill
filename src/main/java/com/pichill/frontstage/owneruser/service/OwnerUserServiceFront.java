package com.pichill.frontstage.owneruser.service;

import com.pichill.frontstage.owneruser.model.OwnerUserDAOFront;
import com.pichill.frontstage.owneruser.model.OwnerUserDAOImplFront;
import com.pichill.manage.entity.Manage;
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
	public boolean existsEmail(String oEmail) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isEmailExists(oEmail);
        return exists;
    }
	public boolean existsIDNum(String oIDNum) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isIDNumExists(oIDNum);
        return exists;
    }
	public boolean existsCompiled(String compiled) {
        // 這裡使用了假設的 UserRepository 方法 isUsernameExists()，您應根據實際情況修改它
        boolean exists = dao.isCompiledExists(compiled);
        return exists;
    }
	
	public OwnerUser getOneOwnerUser(String oUserName) {
		return dao.getOwnerUserByoUserName(oUserName);
	}
	
	public OwnerUser userAuth(String oUserName, String oPassword) {
    	return dao.findByUserNamePassword(oUserName, oPassword);
        
    }
}
