package org.neu.webtools.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer implements java.io.Serializable{
	
	@Id
    @Column(name="c_id", unique=true, nullable=false)
    @GeneratedValue
	private int c_id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="contactNo")
	private String contactNo;
	
	@Column(name="emailID")
	private String emailID;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="CUSTOMER_ADDRESS", 
                joinColumns={@JoinColumn(name="c_id")}, 
                inverseJoinColumns={@JoinColumn(name="add_id")})
	private Set<CustomerAddress> customerAddresses = new HashSet<CustomerAddress>();

	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL)
    private Payment payments;
	
	@OneToMany(mappedBy="customer")
    private Set<Orders> orders;
	
	
	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Set<CustomerAddress> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public Payment getPayments() {
		return payments;
	}

	public void setPayments(Payment payments) {
		this.payments = payments;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	
	
	
	

}
