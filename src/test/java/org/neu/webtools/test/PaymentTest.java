package org.neu.webtools.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.neu.webtools.dao.HibernateUtil;
import org.neu.webtools.model.Customer;
import org.neu.webtools.model.CustomerAddress;
import org.neu.webtools.model.Payment;

public class PaymentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Customer c1 = new Customer();
		c1.setContactNo("1234567890");
		c1.setFirstName("Sachin");
		c1.setLastName("T");
		c1.setGender("Male");
		c1.setUserName("sachin");
		c1.setPassword("sachin123");
		
		
		Customer c2 = new Customer();
		c2.setContactNo("1234567890");
		c2.setFirstName("Veer");
		c2.setLastName("S");
		c2.setGender("Male");
		c2.setUserName("veer");
		c2.setPassword("veer123");
		
		
		CustomerAddress ad1 = new CustomerAddress();
		ad1.setStreetName("75 saint alphonsus street");
		ad1.setCity("Boston");
		ad1.setState("MA");
		ad1.setCountry("USA");
		ad1.setZipCode(02120);
		
		CustomerAddress ad2 = new CustomerAddress();
		ad2.setStreetName("360 Huntington ave");
		ad2.setCity("Boston");
		ad2.setState("MA");
		ad2.setCountry("USA");
		ad2.setZipCode(02115);
		
		c1.getCustomerAddresses().add(ad2);
		c2.getCustomerAddresses().add(ad1);
		c1.getCustomerAddresses().add(ad1);
		c2.getCustomerAddresses().add(ad2);
		
		session.save(c1);
		session.save(c2);
		
		Payment p1 = new Payment();
		p1.setCardNumber("1111222233334444");
		p1.setCardType("MasterCard");
		p1.setCvvNumber(123);
		p1.setExpiryDate("02/02/2015");
		p1.setCustomer(c2);
		session.save(p1);
		
		Payment p2 = new Payment();
		p2.setCardNumber("1111222233334444");
		p2.setCardType("VISA");
		p2.setCvvNumber(123);
		p2.setExpiryDate("03/03/2015");
		p2.setCustomer(c1);
		session.save(p2);
		
		t.commit();
		session.close();
		
		System.out.println("Success");

	}

}
