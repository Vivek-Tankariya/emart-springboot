package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Order;
import com.example.Repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public Order saveOrder(Order o)
	{
		return orderRepo.save(o);
	}
	
	public Order getOrderById(int id)
	{
		return orderRepo.findById(id).get();
	}
	
	public List<Order>getAllOrders()
	{
		return orderRepo.findAll();
	}
	
	public void deleteOrder(int id)
	{
		Order o = orderRepo.findById(id).get();
		if(o!=null)
		{
			orderRepo.delete(o);
		}
	}
	
	public Order update(Order o,int id)
	{
		Order order = orderRepo.findById(id).get();
		order.setCustID(o.getCustID());
		order.setShippingAdd(o.getShippingAdd());
		order.setOrderDate(o.getOrderDate());
		order.setDeliverydate(o.getDeliverydate());
		order.setCustID(o.getCustID());
		order.setInvoiceID(o.getInvoiceID());
		return orderRepo.save(order);
		
		
	}
	
}
