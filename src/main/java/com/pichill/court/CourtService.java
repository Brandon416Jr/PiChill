package com.pichill.court;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pichill.court.Court;
import com.pichill.court.CourtDAO;
import com.pichill.place.Place;
import com.pichill.place.PlaceDAO;
import com.pichill.place.PlaceDAOImpl;

public class CourtService {
	String driver = "com.mysql.cj.jdbc.Driver";
	private final CourtDAO dao;
	private PlaceDAO placeDao;
	
	public CourtService() {
		dao = new CourtDAOImpl();
		placeDao = new  PlaceDAOImpl();
	}

	
	
//	public int insertCourt(Court court) {
//		return dao.add(court);	
//	}

	
	public void insertCourt(Court court , Place place) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pichill?serverTimezone=Asia/Taipei", "root", "Hn88567369");
			pstmt = con.prepareStatement("SELECT *  FROM court LEFT JOIN place on court.courtID;"
					                   + "INSERT INTO court (courtID,oUserID,courtName,courtPic,ourtTelephone,courtAddress,courtRule,loc,courtOpenTime,courtCloseTime)");

			pstmt.setInt(1, court.getCourtID());
			
			pstmt.setInt(2, court.getOwnerUser().getoUserID());
			pstmt.setString(2, court.getCourtName());
			pstmt.setBytes(3, court.getCourtPic());
			pstmt.setString(4, court.getCourtTelephone());
			pstmt.setString(5, court.getCourtAddress());
			pstmt.setString(6, court.getCourtRule());
			pstmt.setString(7, court.getLoc());
			pstmt.setTime(8, court.getCourtOpenTime());
			pstmt.setTime(9, court.getCourtCloseTime());
			pstmt.setInt(10, place.getPlaceID());
			pstmt.setString(11, place.getPlaceName());
			pstmt.setInt(12, place.getPlaceFee());
			pstmt.setInt(13, place.getBall());
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
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

	}

	
	
	public int updateCourt(Court court) {
		return dao.update(court);
	}

	public Court getOneCourt(Integer courtID) {
		return dao.getCourtByCourtID(courtID);
	}

//	public List<Court> getAll() {
//		return dao.getAll();
//	}
	
    public List<Map> getAll() throws SQLException {
    	List<Map> rtnList = new ArrayList<Map>();
    	ResultSet rs = null;
    	Statement stmt = null;
    	Connection conn = null;
    	try {
    		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pichill?serverTimezone=Asia/Taipei", "root", "Hn88567369");
    	    stmt = conn.createStatement();
    	    rs = stmt.executeQuery("SELECT *  FROM court LEFT JOIN place on court.courtID ");
            while (rs.next()) {
            	Map<String, Object> resultMap = new HashMap<String, Object>();
            	resultMap.put("courtID", rs.getString("courtID"));
            	resultMap.put("oUserID", rs.getString("oUserID"));
            	resultMap.put("courtName", rs.getString("courtName"));
            	resultMap.put("courtTelephone", rs.getString("courtTelephone"));
            	resultMap.put("loc", rs.getString("loc"));
            	resultMap.put("courtAddress", rs.getString("courtAddress"));
            	resultMap.put("courtRule", rs.getString("courtRule"));
             	resultMap.put("courtPic", rs.getBytes("courtPic"));
            	resultMap.put("courtOpenTime", rs.getString("courtOpenTime"));
            	resultMap.put("courtCloseTime", rs.getString("courtCloseTime"));
            	resultMap.put("courtApplyTime", rs.getString("courtApplyTime"));
            	resultMap.put("courtOnTime", rs.getString("courtOnTime"));
            	resultMap.put("courtApplyStatus", rs.getString("courtApplyStatus"));   	
            	resultMap.put("placeName", rs.getString("placeName"));
            	resultMap.put("placeFee", rs.getString("placeFee"));
            	resultMap.put("ball", rs.getString("ball"));
            	rtnList.add(resultMap);
            }
    	} finally {
    		if(rs!= null) {
    			rs.close();
    		}
    		if(stmt!= null) {
    			stmt.close();
    		}
    		if(conn!= null) {
    			conn.close();
    		}
		}
		return rtnList;
	}
	
	public Set<Place> getPlaceByPlaceID(Integer placeID) {
		return getOneCourt(placeID).getPlace();
	}
}
