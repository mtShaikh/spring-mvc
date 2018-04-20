package com.demo.mvc.services;

import java.util.List;
import com.demo.mvc.entities.Order;

public interface OrderService {
 
 public List<Order> getOrders();
 public void saveOrder(Order newOrder);
 public Order getOrder(int orderId);
 public void deleteOrder(int orderId);
}
