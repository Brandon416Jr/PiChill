package com.pichill.place;

import java.util.List;

public interface PlaceDAO {
	int add(Place place);
	int update(Place place);
	void delete(int placeID);
	public Place getPlaceByPlaceID(Integer placeID);
	List<Place> getAll();
	void addList(List<Place> list);
}
