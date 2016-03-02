package org.neu.webtools.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ORDERS")
public class Orders implements java.io.Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="o_id", unique=true, nullable=false)
	private int o_id;
	
	@Column(name="totalAmount")
	private double totalAmount;
	
	@Column(name="status")
	private String status;
	
	@Column(name="dateTime")
	private String dateTime;
	
	@OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;
	
	@ManyToOne
	@JoinColumn(name="c_id")
	private Customer customer;

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
 
}
