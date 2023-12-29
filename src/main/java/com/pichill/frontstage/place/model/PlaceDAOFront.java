package com.pichill.frontstage.place.model;

import java.util.List;

import com.pichill.court.Court;
import com.pichill.place.Place;

public interface PlaceDAOFront {
	public Place getPlaceByCourtID(Integer courtID);
	List<Place> getAll();
	List<Place> findPlaceByCourtID(Integer courtID);
	int insert(Place place); 
}
