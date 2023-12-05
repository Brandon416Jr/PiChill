package com.pichill.backstage.place.service;

import java.util.List;

import com.pichill.backstage.place.model.PlaceDAOBack;
import com.pichill.backstage.place.model.PlaceDAOImplBack;
import com.pichill.place.Place;

public class PlaceServiceBack {
	private final PlaceDAOBack dao;
	
	public PlaceServiceBack() {
		dao = new PlaceDAOImplBack();
	}
	
	public Place getOnePlace(Integer placeID) {
		return dao.getPlaceByPlaceID(placeID);
	}

	public List<Place> getAll() {
		return dao.getAll();
	}
}
