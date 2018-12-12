package com.jkim176.project3.common.service;

import java.util.List;
import java.util.Optional;

import com.jkim176.project3.common.data.entity.Order;
import com.jkim176.project3.common.data.entity.Customer;

public interface OrderService {

	Optional<Customer> findById(long id);
	List<Order> findOrderByCustomer(long id);
}
