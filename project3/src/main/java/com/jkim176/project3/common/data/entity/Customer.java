package com.jkim176.project3.common.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID")
	private long id;
	
	@Column(name="CUSTOMER_FNAME")
	private String firstName;
	
	@Column(name="CUSTOMER_LNAME")
	private String lastName;
	
	@OneToMany(mappedBy="customer",
				fetch=FetchType.EAGER,
				cascade=CascadeType.ALL)
	private List<Order> orders = new ArrayList<>();
	
	protected Customer() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
		order.setCustomer(this);
	}
	
	public void removeOrder(Order order) {
		orders.remove(order);
		order.setCustomer(null);
	}
}
