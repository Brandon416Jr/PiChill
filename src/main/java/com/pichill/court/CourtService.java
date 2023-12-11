package com.pichill.court;

import java.util.List;

import com.pichill.court.Court;
import com.pichill.court.CourtDAO;
import com.pichill.court.CourtDAOImpl;

public class CourtService {
	private final CourtDAO dao;
	public CourtService() {
		dao = new CourtDAOImpl();
	}

	public int insertCourt(Court court) {
		return dao.insert(court);	
	}

	public int updateCourt(Court court) {
		return dao.update(court);
	}

	public Court getOneCourt(Integer courtID) {
		return dao.getCourtByCourtID(courtID);
	}

	public List<Court> getAll() {
		return dao.getAll();
	}
	
//	public void deleteManage(Integer manageID) {
//	dao.delete(manageID);
//}
}
