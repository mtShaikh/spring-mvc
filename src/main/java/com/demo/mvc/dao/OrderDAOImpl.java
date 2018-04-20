package com.demo.mvc.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import com.demo.mvc.dao.OrderDAO;
import com.demo.mvc.entities.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory factory;

	public List<Order> getOrders() {
		// get the current hibernate session
		Session session = factory.getCurrentSession();
		Query theQuery = session.createQuery("from Order");

		// execute query and get result list
		List<Order> orders = theQuery.list();

		// return the result
		return orders;
	}

	public void saveOrder(Order newOrder) {
		// get the current hibernate session
		Session session = factory.getCurrentSession();

		// create the order object to the database table
		session.saveOrUpdate(newOrder);
	}
	
	public Order getOrder(int orderId) {
		// get the current hibernate session
		Session session = factory.getCurrentSession();

		// get the order using the passed id (primary key)
		return (Order) session.get(Order.class, orderId);
	}

	public void deleteOrder(int orderId) {

		// get the current hibernate session
		Session session = factory.getCurrentSession();

		// delete the order using the passed id (primary key)
		Query theQuery = session.createQuery("delete from Order where id=:Id");
		theQuery.setParameter("Id", orderId);
		theQuery.executeUpdate();
	}
}