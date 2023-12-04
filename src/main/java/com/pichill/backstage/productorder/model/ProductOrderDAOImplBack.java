package com.pichill.backstage.productorder.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pichill.productOrder.entity.ProductOrder;
import com.pichill.productOrder.model.ProductOrderDAO;
import com.pichill.util.HibernateUtil;

public class ProductOrderDAOImplBack implements ProductOrderDAO{
	private SessionFactory factory;

	@Override
	public int update(ProductOrder productOrder) {
		// TODO Auto-generated method stub
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
	public ProductOrder getProductOrderByProductOrderID(Integer productOrderID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ProductOrder productOrder = session.get(ProductOrder.class, productOrderID);
			session.getTransaction().commit();
			return productOrder;
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
	
	@Override
	public int insert(ProductOrder productOrder) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(Integer productOrderID) {
		// TODO Auto-generated method stub
		return 0;
	}
}
