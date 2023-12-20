package com.pichill.place;

import java.util.List;
import java.util.Map;



public interface PlaceDAO {
	int add(Place place);
	int update(Place place);
	void delete(int placeID);
	public Place getPlaceByPlaceID(Integer placeID);
	List<Place> getAll();
	List<Place> getByCompositeQuery(Map<String, String> map);
}
