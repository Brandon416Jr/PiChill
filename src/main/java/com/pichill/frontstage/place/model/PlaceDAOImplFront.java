package com.pichill.frontstage.place.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.court.Court;
import com.pichill.place.Place;
import com.pichill.util.HibernateUtil;

public class PlaceDAOImplFront  implements PlaceDAOFront  {

	
		private final SessionFactory factory;

		public PlaceDAOImplFront() {
			factory = HibernateUtil.getSessionFactory();
		}

		private Session getSession() {
			return factory.getCurrentSession();
		}
		
		@Override
		public Place getPlaceByCourtID(Integer courtID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Place place = session.get(Place.class, courtID);
			session.getTransaction().commit();
			return place;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
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
//		List<Place> placeList = new ArrayList<>();
//		Place place = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(GET_ALL);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				place = new Place();
//				place.setPlaceID(rs.getInt("placeID"));
//				place.setCourtID(rs.getInt("courtID"));
//				place.setPlaceName(rs.getString("placeName"));
//				place.setPlaceFee(rs.getInt("placeFee"));
//				place.setBall(rs.getInt("ball"));
//				placeList.add(place);
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			closeResources(con, pstmt, rs);
//		}
//		return placeList;
	}
	
	public List<Place> findPlaceByCourtID(Integer courtID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Place> list = session
					.createQuery("select c from Place c where c.court.courtID = :courtID", Place.class)
					.setParameter("courtID", courtID).list();
			session.getTransaction().commit();
			System.out.println("查場地by球館成功!");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查場地by球館失敗QQ");
			session.getTransaction().rollback();
		}
		return null;
	}
}
