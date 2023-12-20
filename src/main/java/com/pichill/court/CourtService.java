package com.pichill.court;

import java.util.List;
import java.util.Set;

import com.pichill.court.Court;
import com.pichill.court.CourtDAO;
import com.pichill.place.Place;
import com.pichill.place.PlaceDAO;
import com.pichill.place.PlaceDAOImpl;

public class CourtService {
	private final CourtDAO dao;
	private PlaceDAO placeDao;
	
	public CourtService() {
		dao = new CourtDAOImpl();
		placeDao = new  PlaceDAOImpl();
	}

	
	
	public int insertCourt(Court court) {
		return dao.add(court);	
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
	
	public Set<Place> getPlaceByPlaceID(Integer placeID) {
		return getOneCourt(placeID).getPlace();
	}
}
