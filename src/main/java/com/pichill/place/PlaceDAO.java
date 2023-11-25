package com.pichill.place;

import java.util.List;

public interface PlaceDAO {
	void add(Place place);
	void update(Place place);
	void delete(int placeID);
	Place findByPK(Integer placeID);
	List<Place> getAll();
}
