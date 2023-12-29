package com.pichill.frontstage.court.model;

import java.util.List;


import com.pichill.court.Court;

public interface CourtDAOFront {
	List<Court> findCourtByoUserID(Integer oUserID);
	int update(Court court);
	public Court getCourtByCourtID(Integer courtID);
	int insert(Court court); // public abstract可不加，預設就會有
}
