package com.jkim176.project3.common.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jkim176.project3.common.data.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
