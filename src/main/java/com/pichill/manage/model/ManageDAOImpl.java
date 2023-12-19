package com.pichill.manage.model;

import static com.pichill.util.Constants.PAGE_MAX_RESULT;

//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.query.Query;

//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.util.HibernateUtil;


public class ManageDAOImpl implements ManageDAO {
	private final SessionFactory factory;
	
	public ManageDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(Manage manage) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
//			Integer id = (Integer) session.save(manage);
			session.save(manage);
			
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("交易失敗");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
	}

	@Override
	public int update(Manage manage) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			session.update(manage);
			session.getTransaction().commit();
			System.out.println("交易成功");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			System.out.println("交易失敗");
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return -1;
		
	}
	
	@Override
	public boolean isUserNameExists(String mUserName) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			Manage manage = (Manage) session.createQuery("FROM Manage WHERE mUserName = :mUserName AND manageID != :manageID")
					.setParameter("mUserName", mUserName).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (manage != null) {
				System.out.println("有找到相同管理員帳號");
				System.out.println(manage);
				return true;
			} else {
				System.out.println("沒有找到相同管理員帳號");
				return false;
			}

		} catch (Exception e) {
			System.out.println("例外處理");
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("最後跑到這");
		return false; // 如果發生異常或没有找到會員，也返回false
	}
	
	public boolean isUserNameExistsByInsert(String mUserName) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			Manage manage = (Manage) session.createQuery("FROM Manage WHERE mUserName = :mUserName")
					.setParameter("mUserName", mUserName).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (manage != null) {
				System.out.println("有找到相同管理員帳號");
				System.out.println(manage);
				return true;
			} else {
				System.out.println("沒有找到相同管理員帳號");
				return false;
			}

		} catch (Exception e) {
			System.out.println("例外處理");
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("最後跑到這");
		return false; // 如果發生異常或没有找到會員，也返回false
	}
	
	@Override
	public boolean isEmailExists(String mEmail) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			Manage manage = (Manage) session.createQuery("FROM Manage WHERE mEmail = :mEmail AND manageID != :manageID")
					.setParameter("mEmail", mEmail).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (manage != null) {
				System.out.println("有找到相同管理員信箱");
				System.out.println(manage);
				return true;
			} else {
				System.out.println("沒有找到相同管理員信箱");
				return false;
			}

		} catch (Exception e) {
			System.out.println("例外處理");
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("最後跑到這");
		return false; // 如果發生異常或没有找到會員，也返回false
	}
	
	public boolean isEmailExistsByInsert(String mEmail) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			Manage manage = (Manage) session.createQuery("FROM Manage WHERE mEmail = :mEmail")
					.setParameter("mEmail", mEmail).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (manage != null) {
				System.out.println("有找到相同管理員信箱");
				System.out.println(manage);
				return true;
			} else {
				System.out.println("沒有找到相同管理員信箱");
				return false;
			}

		} catch (Exception e) {
			System.out.println("例外處理");
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("最後跑到這");
		return false; // 如果發生異常或没有找到會員，也返回false
	}
	
	@Override
	public boolean isIDExists(String mID) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			Manage manage = (Manage) session.createQuery("FROM Manage WHERE mID = :mID")
					.setParameter("mID", mID).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (manage != null) {
				System.out.println("有找到相同管理員身分證");
				System.out.println(manage);
				return true;
			} else {
				System.out.println("沒有找到相同管理員身分證");
				return false;
			}

		} catch (Exception e) {
			System.out.println("例外處理");
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		System.out.println("最後跑到這");
		return false; // 如果發生異常或没有找到會員，也返回false
	}

//	@Override
//	public int delete(Integer manageID) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Manage manage = session.get(Manage.class, manageID);
//			if (manage != null) {
//				session.delete(manage);
//			}
//			session.getTransaction().commit();
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return -1;
//	}
	
	@Override
	public Manage getManageByManageID(Integer manageID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
			Manage manage = session.get(Manage.class, manageID);
			session.getTransaction().commit();
			return manage;
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
	public Manage getManageBymUserName(String mUserName) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
//			Manage manage = session.get(Manage.class, mUserName);
			Query<Manage> query = getSession().createQuery("from Manage where mUserName = :mUserName",
					Manage.class);
			query.setParameter("mUserName", mUserName);
			Manage manage = (Manage) query.uniqueResult();
//			System.out.println(manage);
			session.getTransaction().commit();
			return manage;
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
	
//	@Override
//	public Manage getManageBymName(String mName) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Manage manage = session.get(Manage.class, mName);
//			session.getTransaction().commit();
//			return manage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
//	}

//	@Override
//	public Manage getManageBymEmail(String mEmail) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			Manage manage = session.get(Manage.class, mEmail);
//			session.getTransaction().commit();
//			return manage;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
//	}

	@Override
	public List<Manage> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Manage> list = session.createQuery("from Manage", Manage.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} 
		return null;
	}


//	@Override
//	public List<Manage> getAll(int currentPage) {
//		// TODO Auto-generated method stub
//		int first = (currentPage - 1) * PAGE_MAX_RESULT;
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			List<Manage> list = session.createQuery("from Manage", Manage.class).list();
//			session.getTransaction().commit();
//			return list;
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}
//		return null;
//	}

	public Manage findByUserNamePassword(String mUserName, String mPassword) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try {
	        session.beginTransaction();

	        String hql = "from Manage where mUserName = :mUserName and mPassword = :mPassword";
	        Query<Manage> query = session.createQuery(hql, Manage.class);
	        query.setParameter("mUserName", mUserName);
	        query.setParameter("mPassword", mPassword);

	        Manage manage = query.uniqueResult(); // Assuming there should be only one matching user.

	        session.getTransaction().commit();
	        return manage;
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

}
