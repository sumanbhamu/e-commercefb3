package com.suman.shopping.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.suman.shopping.model.Product;



@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	SessionFactory sessionFactory;

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	public Product get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	@Transactional

	public boolean savOrUpdate(Product product)
	{
		try {

			/*Session s = sessionFactory.getCurrentSession();
			Transaction t = s.beginTransaction();
			s.saveOrUpdate(product);
			t.commit();
*/
			
			sessionFactory.getCurrentSession().save(product);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	
	
	
}
