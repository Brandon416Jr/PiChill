package com.pichill.place;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.owneruser.entity.OwnerUser;
import com.pichill.util.HibernateUtil;



public class PlaceDAOImpl implements PlaceDAO {
	private final SessionFactory factory;

	public PlaceDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

//	private static final String INSERT_STMT = "INSERT INTO place(courtID,placeName,placeFee,ball)VALUES(?,?,?,?)";
//	private static final String UPDATE_STMT = "UPDATE Place SET courtID=?,placeName=?,placeFee=?,ball=? WHERE placeID = ? ";
//	private static final String DELETE_STMT = "DELETE FROM place WHERE placeID = ?";
//	private static final String FIND_BY_PK = "SELECT * FROM place WHERE placeID = ?";
//	private static final String GET_ALL = "SELECT * FROM place";

//	static {
//		try {
//			Class.forName(Util.DRIVER);
//		} catch (ClassCastException ce) {
//			ce.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public int add(Place place) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
//			Integer id = (Integer) session.save(ownerUser);
			session.save(place);
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("交易失敗");
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			// pstmt.setInt(1, place.getPlaceID());
//			pstmt.setInt(1, place.getCourtID());
//			pstmt.setString(2, place.getPlaceName());
//			pstmt.setInt(3, place.getPlaceFee());
//			pstmt.setInt(4, place.getBall());
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//		return -1;
	}

	@Override
	public int update(Place place) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(place);
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("交易失敗");
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//
//			pstmt.setInt(1, place.getPlaceID());
//			pstmt.setInt(2, place.getCourtID());
//			pstmt.setString(3, place.getPlaceName());
//			pstmt.setInt(4, place.getPlaceFee());
//			pstmt.setInt(5, place.getBall());
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
	}

//	@Override
//	public void delete(int placeID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, placeID);
//
//			pstmt.executeUpdate();
//
//			// Handle any driver errors
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}

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
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return null;
//		Place place = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, placeID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				place = new Place();
//				place.setPlaceID(rs.getInt("placeID"));
//				place.setCourtID(rs.getInt("courtID"));
//				place.setPlaceName(rs.getString("placeName"));
//				place.setPlaceFee(rs.getInt("placeFee"));
//				place.setBall(rs.getInt("ball"));
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return place;
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

	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

	@Override
	public void delete(int placeID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Place> getByCompositeQuery(Map<String, String> map) {
		if (map.size() == 0)
			return getAll();

		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Place> criteria = builder.createQuery(Place.class);
		Root<Place> root = criteria.from(Place.class);

		List<Predicate> predicates = new ArrayList<>();

		if (map.containsKey("starthiredate") && map.containsKey("endhiredate"))
			predicates.add(builder.between(root.get("placeName"), Date.valueOf(map.get("starthiredate")), Date.valueOf(map.get("endhiredate"))));

		if (map.containsKey("startsal") && map.containsKey("endsal"))
			predicates.add(builder.between(root.get("sal"), new BigDecimal(map.get("startsal")), new BigDecimal(map.get("endsal"))));

		for (Map.Entry<String, String> row : map.entrySet()) {
			if ("ename".equals(row.getKey())) {
				predicates.add(builder.like(root.get("ename"), "%" + row.getValue() + "%"));
			}

			if ("job".equals(row.getKey())) {
				predicates.add(builder.equal(root.get("job"), row.getValue()));
			}

			if ("starthiredate".equals(row.getKey())) {
				if (!map.containsKey("endhiredate"))
					predicates.add(builder.greaterThanOrEqualTo(root.get("placeName"), Date.valueOf(row.getValue())));
			}

			if ("endhiredate".equals(row.getKey())) {
				if (!map.containsKey("starthiredate"))
					predicates.add(builder.lessThanOrEqualTo(root.get("placeName"), Date.valueOf(row.getValue())));

			}

			if ("startsal".equals(row.getKey())) {
				if (!map.containsKey("endsal"))
					predicates.add(builder.greaterThanOrEqualTo(root.get("placeFee"), new BigDecimal(row.getValue())));

			}

			if ("endsal".equals(row.getKey())) {
				if (!map.containsKey("startsal"))
					predicates.add(builder.lessThanOrEqualTo(root.get("placeFee"), new BigDecimal(row.getValue())));

			}

		}

		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		criteria.orderBy(builder.asc(root.get("courtID")));
		TypedQuery<Place> query = getSession().createQuery(criteria);

		return query.getResultList();
	}
	
}
