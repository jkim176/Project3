package com.jkim176.project3.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jkim176.project3.common.data.entity.Customer;
import com.jkim176.project3.common.data.entity.Order;
import com.jkim176.project3.common.data.repository.CustomerRepository;
import com.jkim176.project3.common.data.repository.OrderRepository;
import com.jkim176.project3.common.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final CustomerRepository customerRepository;
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
		this.customerRepository = customerRepository;
		this.orderRepository = orderRepository;
	}
	
	public Customer findCustomer(long id) {
		Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
		Customer customer;
		if(optionalCustomer.isPresent()) {
			customer = optionalCustomer.get();
		}
		else {
			customer = null;
		}
		return customer;
	}
	
	public List<Order> findOrderByCustomer(long id) {
		List<Order> orders = new ArrayList<>();
		Iterable<Order> it = this.orderRepository.findAll();
		if(it != null) {
			it.forEach(e -> {
				if(e.getCustomer().getId() == id) {
					orders.add(e);
				}
			});
		}
		
		return orders;
	}
}
