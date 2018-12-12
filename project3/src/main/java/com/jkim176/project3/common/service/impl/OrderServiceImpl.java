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
	
	public Optional<Customer> findById(long id) {
		return this.customerRepository.findById(id);
	}
	
	@Override
	public List<Order> findOrderByCustomer(long customerId) {
		List<Order> orders = new ArrayList<>();
		Iterable<Order> it = this.orderRepository.findAll();
		it.forEach(order -> {
			if(order.getCustomer().getId() == customerId) {
				orders.add(order);
			}
		});
		
		return orders;
	}
}
