package com.jkim176.project3.common.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jkim176.project3.common.data.entity.Customer;
import com.jkim176.project3.common.data.entity.Order;
import com.jkim176.project3.common.service.OrderService;

@RestController
@RequestMapping(value="/api")
public class OrderServiceController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/{id}")
	public Optional<Customer> findById(@PathVariable("id") long id) {
		return this.orderService.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/orderservice/{id}")
	public List<Order> findAllOrdersByCustomer(@PathVariable("id") long id) {
		return this.orderService.findOrderByCustomer(id);
	}
}
