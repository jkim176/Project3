package com.jkim176.project3.common.service;

import java.util.List;

import com.jkim176.project3.common.data.entity.Order;
import com.jkim176.project3.common.data.entity.Customer;

public interface OrderService {

	Customer findCustomer(long id);
	List<Order> findOrderByCustomer(long id);
	
	Order addOrderByCustomer(Order order);
	
	void deleteOrderByCustomer(Order order);
}
