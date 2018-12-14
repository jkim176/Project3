package com.jkim176.project3.common.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jkim176.project3.common.data.entity.Customer;
import com.jkim176.project3.common.data.entity.Order;
import com.jkim176.project3.common.service.OrderService;

@RestController
@RequestMapping(value="/api")
public class OrderServiceController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable long id) {
		return this.orderService.findCustomer(id);
	}
	
	@GetMapping("/orders/showorder/{id}")
	public List<Order> getOrderByCustomer(@PathVariable long id) {
		return this.orderService.findOrderByCustomer(id);
	}
	
	@PostMapping("/orders/placeorder")
	public Order createOrderByCustomer(@RequestBody Order order) {
		this.orderService.addOrderByCustomer(order);
		
		return order;
	}
	
	@DeleteMapping("/orders/removeorder")
	public void removeOrderByCustomer(@RequestBody Order order) {
		this.orderService.deleteOrderByCustomer(order);
	}
}
