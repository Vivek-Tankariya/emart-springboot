package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Entity.Order;
import com.example.Services.OrderService;

@RestController
@RequestMapping("/api/Order")
@CrossOrigin()
public class OrderController {

	@Autowired
	private OrderService manager;
	
	@GetMapping
	public ResponseEntity<?> getAllOrder()
	{
		return new ResponseEntity<>(manager.getAllOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/{Orderid}")
	public ResponseEntity<?> getOrderById(@PathVariable int id )
	{
		return new ResponseEntity<>(manager.getOrderById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<?>AddOrder(@RequestBody Order o)
	{
		return new ResponseEntity<>(manager.saveOrder(o),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Orderid}")
	public ResponseEntity<?> EditOrder(@RequestBody Order o,@PathVariable int id )
	{
		return new ResponseEntity<>(manager.update(o, id),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{Orderid}")
	public void deleteOrder(@PathVariable int id)
	{
		manager.deleteOrder(id);
	}
	
	
	
}
