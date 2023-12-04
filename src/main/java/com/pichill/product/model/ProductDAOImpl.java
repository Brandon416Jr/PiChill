package com.pichill.product.model;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.product.entity.Product;
import com.pichill.util.HibernateUtil;

@Entity
public class ProductDAOImpl implements ProductDAO {
	private SessionFactory factory;

	@Override
	public int insert(Product product) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			int id = (int) session.save(product);
			session.getTransaction().commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;
	}

	@Override
	public int update(Product product) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return -1;

	}
	
	@Override
	public int delete(Integer productID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Product product = session.get(Product.class, productID);
			if (product != null) {
				session.delete(product);
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
	public Product getProductByProductID(Integer productID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Product product = session.get(Product.class, productID);
			session.getTransaction().commit();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

	@Override
	public List<Product> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<Product> list = session.createQuery("from Product", Product.class).list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return null;
	}

}
