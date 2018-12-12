package com.jkim176.project3.common.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jkim176.project3.common.data.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
