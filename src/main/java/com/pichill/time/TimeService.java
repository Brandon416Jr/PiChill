package com.pichill.time;

import java.util.List;


public class TimeService {
private final TimeDAO dao;
	
	public TimeService() {
		dao = new TimeDAOImpl();
	}

	public TimeRef getOneTime(Integer timeID) {
		return dao.findByPK(timeID);
	}


	public List<TimeRef> getAll() {
		return dao.getAll();
	}
}
