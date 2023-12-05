package com.pichill.backstage.place.model;

import java.util.List;

import org.hibernate.Session;

import com.pichill.manage.entity.Manage;
import com.pichill.place.Place;
import com.pichill.util.HibernateUtil;

public class PlaceDAOImplBack implements PlaceDAOBack {

	@Override
	public Place getPlaceByPlaceID(Integer placeID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Place place = session.get(Place.class, placeID);
			session.getTransaction().commit();
			return place;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Place> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Place> list = session.createQuery("from Place", Place.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
