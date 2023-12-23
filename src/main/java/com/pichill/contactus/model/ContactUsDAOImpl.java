package com.pichill.contactus.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.contactus.Util;
import com.pichill.contactus.entity.ContactUs;
import com.pichill.post.entity.Post;


public class ContactUsDAOImpl implements ContactUsDAO{
	
	
	private static final int PAGE_MAX_RESULT = 3;
	private SessionFactory factory;

	public ContactUsDAOImpl() {
		factory = com.pichill.util.HibernateUtil.getSessionFactory();
	}
	
	// Session 為 not thread-safe，所以此方法在各個增刪改查方法裡呼叫
	// 以避免請求執行緒共用了同個 Session
	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int add(ContactUs entity) {
//		SessionFactory factory2 = HibernateUtil.getSessionFactory();
//		Session session = factory2.openSession();
//		Transaction tx = session.beginTransaction();
		// 回傳給 service 剛新增成功的自增主鍵值
//		entity.setPostTime(new java.sql.Timestamp(System.currentTimeMillis()));
//		session.save(entity);
//		tx.commit();
//		return 1;
		return(Integer)getSession().save(entity);
	}

	@Override
	public int update(ContactUs entity) {
		try {
//			SessionFactory factory2 = HibernateUtil.getSessionFactory();
//			Session session = factory2.openSession();
//			Transaction tx = session.beginTransaction();
			getSession().update(entity);
//			tx.commit();
			return 1;
		} catch (Exception e) {
			return -1;
		}
	}

	@Override
	public int delete(Integer id) {
		ContactUs contactUs = getSession().get(ContactUs.class, id);
		if (contactUs != null) {
			getSession().delete(contactUs);
			// 回傳給 service，1代表刪除成功
			return 1;
		} else {
			// 回傳給 service，-1代表刪除失敗
			return -1;
		}
	}
	@Override
	public ContactUs getContactUsByFormID(Integer formID) {
		getSession().clear();
		return getSession().get(ContactUs.class,formID);
	}
	
//	@Override
//	public List<ContactUs> getByPurpose(String formPurpose) {
//		return getSession().createQuery("from ContactUs WHERE formPurpose like :formPurpose", ContactUs.class)
//	            .setParameter("formPurpose", "%"+formPurpose+"%")
//	            .list();
//	}
//	
//	@Override
//	public List<ContactUs> getByContent(String formContent) {
//		return getSession().createQuery("from ContactUs WHERE formContent like :formContent", ContactUs.class)
//	            .setParameter("formContent", "%"+formContent+"%")
//	            .list();
//	}
//	
//	@Override
//	public List<ContactUs> getByformPic(byte[] formPic) {
//		return getSession().createQuery("from ContactUs WHERE formPic like :formPic", ContactUs.class)
//	            .setParameter("formPic", "%"+formPic+"%")
//	            .list();
//	}
//	
//	@Override
//	public List<ContactUs> getByType(Integer formType) {
//	    return getSession().createQuery("from Post WHERE formType = :formType", ContactUs.class)
//	            .setParameter("postType", formType)
//	            .list();
//	}

	@Override
	public List<ContactUs> getAll() {
		return getSession().createQuery("from ContactUs", ContactUs.class).list();
	}

	
	
		
	
	//以下是JDBC寫法
//	private static final String INSERT_STMT= "INSERT INTO contactUs(oUserID,gUserID,formPurpose,formContent,formPic,formTime,formStatus,formType)VALUES(?,?,?,?,?,?,?,?)";
//    private static final String UPDATE_STMT= "UPDATE contactUs SET oUserID=?,gUserID=?,formPurpose=?,formContent=?,formPic=?,formTime=?,formStatus=?,formType=? WHERE formID = ? ";
//    private static final String DELETE_STMT= "DELETE FROM contactUs WHERE formID = ?";
//    private static final String FIND_BY_PK = "SELECT * FROM contactUs WHERE formID = ?";
//    private static final String GET_ALL= "SELECT * FROM contactUs";  
//    
//	static {
//		try {
//			Class.forName(Util.DRIVER);
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
//	}
//
//	@Override
//	public void add(ContactUs contactUs) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setInt(1, contactUs.getOUserID());
//			pstmt.setInt(2, contactUs.getGUserID());
//			pstmt.setString(3, contactUs.getFormPurpose());
//			pstmt.setString(4, contactUs.getFormContent());
//			pstmt.setBytes(5, contactUs.getFormPic());
//			pstmt.setString(6, contactUs.getFormContent());
//			pstmt.setInt(7, contactUs.getFormStatus());
//			pstmt.setInt(8, contactUs.getFormType());
//			
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//	}
//
//
//	@Override
//	public void update(ContactUs contactUs) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		try {
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(UPDATE_STMT);
//
//			pstmt.setInt(1, contactUs.getFormID());
//			pstmt.setInt(2, contactUs.getOUserID());
//			pstmt.setInt(3, contactUs.getGUserID());
//			pstmt.setString(4, contactUs.getFormPurpose());
//			pstmt.setString(5, contactUs.getFormContent());
//			pstmt.setBytes(6, contactUs.getFormPic());
//			pstmt.setString(7, contactUs.getFormContent());
//			pstmt.setInt(8, contactUs.getFormStatus());
//			pstmt.setInt(9, contactUs.getFormType());
//			
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//	}
//
//	@Override
//	public void delete(Integer formID) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(DELETE_STMT);
//
//			pstmt.setInt(1, formID);
//
//			pstmt.executeUpdate();
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, null);
//		}
//
//	}
//
//	@Override
//	public ContactUs getContactUsByFormID(Integer formID) { 
//		ContactUs contactUs = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FIND_BY_PK);
//			pstmt.setInt(1, formID);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				contactUs = new ContactUs();
//				contactUs.setFormID(rs.getInt("formID"));
//				contactUs.setOUserID(rs.getInt("oUserID"));
//				contactUs.setGUserID(rs.getInt("gUserID"));
//				contactUs.setFormPurpose(rs.getString("formPurpose"));
//				contactUs.setFormContent(rs.getString("formContent"));
//				contactUs.setFormPic(rs.getBytes("formPic"));
//				contactUs.setFormTime(rs.getTimestamp("formTime"));
//				contactUs.setFormStatus(rs.getInt("formStatus"));
//				contactUs.setFormStatus(rs.getInt("formType"));
//				
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//			// Clean up JDBC resources
//		} finally {
//			Util.closeResources(con, pstmt, rs);
//		}
//		return contactUs;
//	}
//
//	@Override
//	public List<ContactUs> getAll() {
//		List<ContactUs> contactUsList = new ArrayList<>();
//		ContactUs contactUs = null;
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
//				contactUs = new ContactUs();
//				contactUs.setFormID(rs.getInt("formID"));
//				contactUs.setOUserID(rs.getInt("oUserID"));
//				contactUs.setGUserID(rs.getInt("gUserID"));
//				contactUs.setFormPurpose(rs.getString("formPurpose"));
//				contactUs.setFormContent(rs.getString("formContent"));
//				contactUs.setFormPic(rs.getBytes("formPic"));
//				contactUs.setFormTime(rs.getTimestamp("formTime"));
//				contactUs.setFormStatus(rs.getInt("formStatus"));
//				contactUs.setFormType(rs.getInt("formType"));
//				
//				contactUsList.add(contactUs);
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			closeResources(con, pstmt, rs);
//		}
//		return contactUsList;
//	}
//
//	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException se) {
//				se.printStackTrace(System.err);
//			}
//		}
//		if (con != null) {
//			try {
//				con.close();
//			} catch (Exception e) {
//				e.printStackTrace(System.err);
//			}
//		}
//	}
}
    