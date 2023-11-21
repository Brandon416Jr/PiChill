package com.pichill.managejdbc.model;

//import static com.pichill.util.Constants.PAGE_MAX_RESULT;

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





import com.pichill.managejdbc.entity.Manage;


public class ManageDAOImpl implements ManageDAO {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/pichill?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "Vv4161911";

	private static final String INSERT_STMT = "INSERT INTO manage(mName, mUserName, mPassword, mBirth, mGender, mTelephone, mEmgContact, mEmgPhone, mAddress, mHiredate, mLastLogTime, mID, mEmail, mProfilePic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE manage SET mName = ?, mUserName = ?, mPassword = ?, mBirth = ?, mGender = ?, mTelephone = ?, mEmgContact = ?,  mEmgPhone = ?, mAddress = ?, mHiredate = ?, mLastLogTime = ?, mID = ?,  mEmail = ?, mProfilePic = ?  WHERE manageID = ?";
	private static final String DELETE = "DELETE FROM manage WHERE manageID = ?";
	private static final String GET_ONE_STMT = "SELECT * FROM manage WHERE manageID = ?";
	private static final String GET_ALL_STMT = "SELECT * FROM manage";
	
	
	public void insert(Manage manage) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, manage.getmName());
			pstmt.setString(2, manage.getmUserName());
			pstmt.setString(3, manage.getmPassword());
			pstmt.setDate(4, manage.getmBirth());
			pstmt.setInt(5, manage.getmGender());
			pstmt.setString(6, manage.getmTelephone());
			pstmt.setString(7, manage.getmEmgContact());
			pstmt.setString(8, manage.getmEmgPhone());
			pstmt.setString(9, manage.getmAddress());
			pstmt.setDate(10, manage.getmHiredate());
			pstmt.setTimestamp(11, manage.getmLastLogTime());
			pstmt.setString(12, manage.getmID());
			pstmt.setString(13, manage.getmEmail());
			pstmt.setBytes(14, manage.getmProfilePic());

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
	
	public void update(Manage manage) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, manage.getmName());
			pstmt.setString(2, manage.getmUserName());
			pstmt.setString(3, manage.getmPassword());
			pstmt.setDate(4, manage.getmBirth());
			pstmt.setInt(5, manage.getmGender());
			pstmt.setString(6, manage.getmTelephone());
			pstmt.setString(7, manage.getmEmgContact());
			pstmt.setString(8, manage.getmEmgPhone());
			pstmt.setString(9, manage.getmAddress());
			pstmt.setDate(10, manage.getmHiredate());
			pstmt.setTimestamp(11, manage.getmLastLogTime());
			pstmt.setString(12, manage.getmID());
			pstmt.setString(13, manage.getmEmail());
			pstmt.setBytes(14, manage.getmProfilePic());
			pstmt.setInt(15, manage.getManageID());

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

	public void delete(Integer manageID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, manageID);

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

	public Manage findByPrimaryKey(Integer manageID) {

		Manage manage = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, manageID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				manage = new Manage();
				manage.setManageID(rs.getInt("manageID"));
				manage.setmName(rs.getString("mName"));
				manage.setmUserName(rs.getString("mUserName"));
				manage.setmPassword(rs.getString("mPassword"));
				manage.setmBirth(rs.getDate("mBirth"));
				manage.setmGender(rs.getInt("mGender"));
				manage.setmTelephone(rs.getString("mTelephone"));
				manage.setmEmgContact(rs.getString("mEmgContact"));
				manage.setmEmgPhone(rs.getString("mEmgPhone"));
				manage.setmAddress(rs.getString("mAddress"));
				manage.setmHiredate(rs.getDate("mHiredate"));
				manage.setmLastLogTime(rs.getTimestamp("mLastLogTime"));
				manage.setmID(rs.getString("mID"));
				manage.setmEmail(rs.getString("mEmail"));
				manage.setmProfilePic(rs.getBytes("mProfilePic"));
			}

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
		return manage;
	}

	public List<Manage> getAll() {
		List<Manage> list = new ArrayList<Manage>();
		Manage manage = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				manage = new Manage();
				manage.setManageID(rs.getInt("manageID"));
				manage.setmName(rs.getString("mName"));
				manage.setmUserName(rs.getString("mUserName"));
				manage.setmPassword(rs.getString("mPassword"));
				manage.setmBirth(rs.getDate("mBirth"));
				manage.setmGender(rs.getInt("mGender"));
				manage.setmTelephone(rs.getString("mTelephone"));
				manage.setmEmgContact(rs.getString("mEmgContact"));
				manage.setmEmgPhone(rs.getString("mEmgPhone"));
				manage.setmAddress(rs.getString("mAddress"));
				manage.setmHiredate(rs.getDate("mHiredate"));
				manage.setmLastLogTime(rs.getTimestamp("mLastLogTime"));
				manage.setmID(rs.getString("mID"));
				manage.setmEmail(rs.getString("mEmail"));
				manage.setmProfilePic(rs.getBytes("mProfilePic"));
				list.add(manage);
			}

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
		return list;
	}
	


	
	
	
	
	
}
