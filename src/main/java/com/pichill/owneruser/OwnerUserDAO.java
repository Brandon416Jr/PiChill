package com.pichill.owneruser;

import java.util.List;


public interface OwnerUserDAO{
	void add(OwnerUser ownerUser);
	void update(OwnerUser ownerUser);
	void delete(Integer oUserID);
	public OwnerUser findByPK(Integer oUserID);
	List<OwnerUser> getAll();
}