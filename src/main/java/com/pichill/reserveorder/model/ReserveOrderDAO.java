package com.pichill.reserveorder.model;

import java.util.List;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.reserveorder.entity.ReserveOrder;

public interface ReserveOrderDAO {
	int add(ReserveOrder reserveOrder);
	int update(ReserveOrder reserveOrder);
	ReserveOrder findByPK(Integer reserveOrderID);
	List<ReserveOrder> getAll();
	List<ReserveOrder> findBygUserID(Integer gUserID);
	
}


