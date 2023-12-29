package com.pichill.frontstage.place.service;

import java.util.List;

import com.pichill.court.Court;
import com.pichill.frontstage.place.model.PlaceDAOFront;
import com.pichill.frontstage.place.model.PlaceDAOImplFront;
import com.pichill.place.Place;


public class PlaceServiceFront {
	private PlaceDAOFront dao;

	public PlaceServiceFront() {
		dao = new PlaceDAOImplFront();
	}
	
	public int insertPlaceAll(Place place) {
		return dao.insert(place);	
	}
	
	public Place getOnePlace(Integer courtID) {
		return dao.getPlaceByCourtID(courtID);
	}

	public List<Place> getAll() {
		return dao.getAll();	
	}
	
	public List<Place> getPlaceByCourt(Integer courtID) {
		return dao.findPlaceByCourtID(courtID);
	}
	
}
