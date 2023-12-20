package com.pichill.frontstage.generaluser.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.pichill.generaluser.entity.GeneralUser;
import com.pichill.manage.entity.Manage;
import com.pichill.util.HibernateUtil;

public class GeneralUserDAOImplFront implements GeneralUserDAOFront {
	private final SessionFactory factory;

	public GeneralUserDAOImplFront() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public int insert(GeneralUser generalUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		try {
			session.beginTransaction();
//			Integer id = (Integer) session.save(manage);
			session.save(generalUser);

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
	public int update(GeneralUser generalUser) {
		// TODO Auto-generated method stub
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				try {
					session.beginTransaction();
					session.update(generalUser);
					session.getTransaction().commit();
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					session.getTransaction().rollback();
				}
				return -1;
	}

	@Override
	public GeneralUser findByPK(Integer gUserID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			GeneralUser generalUser = session.get(GeneralUser.class, gUserID);
			session.getTransaction().commit();
			return generalUser;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public GeneralUser findByGeneralUsergUsername(String gUsername) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<GeneralUser> query = getSession().createQuery("from GeneralUser where gUsername = :gUsername",
					GeneralUser.class);
			query.setParameter("gUsername", gUsername);
			GeneralUser generalUser = (GeneralUser) query.uniqueResult();

			System.out.println(generalUser);
			session.getTransaction().commit();
			return generalUser;
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
	public boolean isUsernameExists(String gUsername) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE gUsername = :gUsername")
					.setParameter("gUsername", gUsername).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (generalUser != null) {
				System.out.println("有找到相同會員帳號");
				System.out.println(generalUser);
				return true;
			} else {
				System.out.println("沒有找到相同會員帳號");
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
	public boolean isEmailExists(String gEmail) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE gEmail = :gEmail")
					.setParameter("gEmail", gEmail).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (generalUser != null) {
				System.out.println("有找到相同會員信箱");
				System.out.println(generalUser);
				return true;
			} else {
				System.out.println("沒有找到相同會員信箱");
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
	public boolean isIDNumExists(String gIDNum) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE gIDNum = :gIDNum")
					.setParameter("gIDNum", gIDNum).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (generalUser != null) {
				System.out.println("有找到相同會員身分證");
				System.out.println(generalUser);
				return true;
			} else {
				System.out.println("沒有找到相同會員身分證");
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
	public boolean isNicknameIDExists(String nicknameID) {
		Session session = getSession();
		try {
			session.beginTransaction();
			System.out.println("查詢前");
			GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE nicknameID = :nicknameID")
					.setParameter("nicknameID", nicknameID).uniqueResult();
			System.out.println("查詢後");

			session.getTransaction().commit();
			System.out.println("交易後");
			if (generalUser != null) {
				System.out.println("有找到相同會員暱稱ID");
				System.out.println(generalUser);
				return true;
			} else {
				System.out.println("沒有找到相同會員暱稱ID");
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
	
	public GeneralUser findByUserNamePassword(String gUsername, String gPassword) {
	    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	    try {
	        session.beginTransaction();

	        String hql = "from GeneralUser where gUsername = :gUsername and gPassword = :gPassword";
	        Query<GeneralUser> query = session.createQuery(hql, GeneralUser.class);
	        query.setParameter("gUsername", gUsername);
	        query.setParameter("gPassword", gPassword);

	        GeneralUser generalUser = query.uniqueResult(); // Assuming there should be only one matching user.

	        session.getTransaction().commit();
	        return generalUser;
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
	
	public GeneralUser findBygEmail(String gEmail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			GeneralUser generalUser = (GeneralUser) session.createQuery("FROM GeneralUser WHERE gEmail = :gEmail")
	                 .setParameter("gEmail",gEmail)
	                 .uniqueResult();
			session.getTransaction().commit();
			return generalUser;
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
