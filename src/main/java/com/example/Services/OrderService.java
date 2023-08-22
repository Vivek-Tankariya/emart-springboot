package com.example.Services;

import java.util.List;

import com.example.Entity.Order;

public interface OrderService {

	public Order saveOrder(Order o);
	public Order getOrderById(int id);
	public List<Order>getAllOrders();
	public void deleteOrder(int id);
	public Order update(Order o,int id);
	
	
}
