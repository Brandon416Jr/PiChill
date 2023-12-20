package com.pichill.generaluser.model;

import java.util.List;
import java.util.Set;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;


public interface GeneralUserDAO {
	
	int add(GeneralUser generalUser);
	int update(GeneralUser generalUser);
	GeneralUser findByPK(Integer gUserID);
	List<GeneralUser> getAll();
	//查詢某部門的員工(一對多)(回傳 Set)
//    public Set<ReserveOrder> getReserveBygUserID(Integer gUserID);
}
