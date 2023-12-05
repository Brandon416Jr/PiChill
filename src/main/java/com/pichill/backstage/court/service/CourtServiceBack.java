package com.pichill.backstage.court.service;

import java.util.List;



import com.pichill.backstage.court.model.CourtDAOImplBack;
import com.pichill.court.Court;
import com.pichill.court.CourtDAO;


public class CourtServiceBack {
private final CourtDAO dao;
	
	public CourtServiceBack() {
		dao = new CourtDAOImplBack();
	}
	
	public void updateCourt(Court court) {
		dao.update(court);
	}
	
	public Court getOneCourt(Integer courtID) {
		return dao.findByPK(courtID);
	}
	
	public List<Court> getAll() {
		return dao.getAll();
	}

}
