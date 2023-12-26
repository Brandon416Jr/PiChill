package com.pichill.frontstage.reserveorder.model;
import java.util.List;

import com.pichill.reserveorder.entity.ReserveOrder;
public interface ReserveOrderDAOFront {
	List<ReserveOrder> findReserveOrderByoUserID(Integer oUserID);
}
