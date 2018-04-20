package com.demo.mvc.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.mvc.dao.OrderDAO;
import com.demo.mvc.entities.Order;
import com.demo.mvc.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
 
  @Autowired
  private OrderDAO orderDAO;
 
  @Transactional
  public List<Order> getOrders() {
   return orderDAO.getOrders();
  }
 
  @Transactional
  public void saveOrder(Order newOrder) {
    orderDAO.saveOrder(newOrder);
  }
 
  @Transactional
  public Order getOrder(int orderId) {
    return orderDAO.getOrder(orderId);
  }
 
  @Transactional
  public void deleteOrder(int orderId) {
    orderDAO.deleteOrder(orderId);
  }
}