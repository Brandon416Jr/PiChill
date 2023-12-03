package com.pichill.productOrder.model;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.productOrder.entity.ProductOrder;
import com.pichill.util.HibernateUtil;

@Entity
public class ProductOrderDAOImpl implements ProductOrderDAO {
	private SessionFactory factory;

	@Override
	public int insert(ProductOrder productOrder) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			int id = (int) session.save(productOrder);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(ProductOrder productOrder) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(productOrder);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;

	}
	
	@Override
	public int delete(Integer productOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ProductOrder productOrder = session.get(ProductOrder.class, productOrderID);
			if (productOrder != null) {
				session.delete(productOrder);
			}
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}
	

	@Override
	public ProductOrder getProductOrderByProductOrderID(Integer productOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ProductOrder product = session.get(ProductOrder.class, productOrderID);
			session.getTransaction().commit();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<ProductOrder> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<ProductOrder> list = session.createQuery("from ProductOrder", ProductOrder.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
