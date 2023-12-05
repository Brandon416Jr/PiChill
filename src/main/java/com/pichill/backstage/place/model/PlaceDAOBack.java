package com.pichill.backstage.place.model;

import java.util.List;

import com.pichill.place.Place;



public interface PlaceDAOBack {
	Place getPlaceByPlaceID(Integer placeID); 
	List<Place> getAll();
}
