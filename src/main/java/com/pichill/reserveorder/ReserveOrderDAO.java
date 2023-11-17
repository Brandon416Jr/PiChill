package com.pichill.reserveorder;

import java.util.List;

public interface ReserveOrderDAO {
	void add(ReserveOrder reserveOrder);
	void update(ReserveOrder reserveOrder);
	void delete(int reserveOrderID);
	ReserveOrder findByPK(Integer reserveOrderID);
	List<ReserveOrder> getAll();
}
