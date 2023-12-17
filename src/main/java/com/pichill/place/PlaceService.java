package com.pichill.place;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;

import com.pichill.place.Place;
import com.pichill.place.PlaceDAO;
import com.pichill.place.PlaceDAOImpl;
import com.pichill.util.HibernateUtil;
import com.pichill.court.Court;

public class PlaceService {
	private PlaceDAO dao;

	public PlaceService() {
		dao = new PlaceDAOImpl();
	}
	
	public int addPlace(Place place) {
		return dao.add(place);	
	}

	public int updatePlace(Place place) {
		return dao.update(place);
	}
	
	public Place getOnePlace(Integer placeID) {
		return dao.getPlaceByPlaceID(placeID);
	}

	public List<Place> getAll() {
		return dao.getAll();	
	}
	
}
