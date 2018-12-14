package com.jkim176.project3.common.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDERS")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ORDER_ID")
	private long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_ORDERED")
	private Date dateOrdered;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_SHIPPED")
	private Date dateShipped;
	
	@ManyToOne
	@JoinColumn(name="ORDER_CUSTOMER_ID")
	private Customer customer;
	
	protected Order() {}
	
	public Order(Customer customer, Date dateOrdered) {
		this.customer = customer;
		this.dateOrdered = dateOrdered;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public Date getDateShipped() {
		return dateShipped;
	}

	public void setDateShipped(Date dateShipped) {
		this.dateShipped = dateShipped;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
