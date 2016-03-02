package org.neu.webtools.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.neu.webtools.dao.HibernateUtil;
import org.neu.webtools.model.Customer;
import org.neu.webtools.model.CustomerAddress;
import org.neu.webtools.model.FoodCategory;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.FoodType;
import org.neu.webtools.model.OrderDetails;
import org.neu.webtools.model.Orders;
import org.neu.webtools.model.Payment;
import org.neu.webtools.model.Person;



public class CompleteTest {
	
	public static void main(String[] args) {
		
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t = session.beginTransaction();
	
	//Person - sAdmin- HAdmin
	
	Person p1 = new Person();
	p1.setUserName("admin");
	p1.setPassword("admin");
	p1.setFirstName("Shobha");
	p1.setLastName("DM");
	p1.setContactNo("6178402505");
	p1.setEmailID("abimnm@gmail.com");
	p1.setRoleType("SuperAdmin");
	
	
	Person s1 = new Person();
	s1.setFirstName("Megha");
	s1.setLastName("V");
	s1.setUserName("super");
	s1.setPassword("super123");
	s1.setContactNo("6178402505");
	s1.setEmailID("abimnm@gmail.com");
	s1.setRoleType("HotelAdmin");
	
	Person h1 = new Person();
	h1.setFirstName("Siri");
	h1.setLastName("Gowri");
	h1.setUserName("hotel1");
	h1.setPassword("hotel123");
	h1.setContactNo("6178402505");
	h1.setEmailID("abimnm@gmail.com");
	h1.setRoleType("HotelAdmin");
	
	Person h2 = new Person();
	h2.setFirstName("Supriya");
	h2.setLastName("K");
	h2.setUserName("hotel2");
	h2.setPassword("hotel321");
	h2.setContactNo("6178402505");
	h2.setEmailID("abimnm@gmail.com");
	h2.setRoleType("HotelAdmin");
	
	
	
	session.persist(p1);
	session.persist(s1);
	session.persist(h1);
	session.persist(h2);
	
	System.out.println("Person-Sadmin-Hadmin Success");
	
	
	//Food Menu 
	FoodCategory fc1 = new FoodCategory();
	fc1.setCatergoryName("Indian");
	session.save(fc1);

	FoodCategory fc2 = new FoodCategory();
	fc2.setCatergoryName("Chinese");
	session.save(fc2);
	

	FoodCategory fc3 = new FoodCategory();
	fc3.setCatergoryName("Mediterranean");
	session.save(fc3);
	
	FoodCategory fc4 = new FoodCategory();
	fc4.setCatergoryName("Mexican");
	session.save(fc4);
	
	FoodType ft1 = new FoodType();
	ft1.setFoodTypeName("Starter");
	session.save(ft1);
	
	FoodType ft2 = new FoodType();
	ft2.setFoodTypeName("Main Course");
	session.save(ft2);
	
	FoodType ft3 = new FoodType();
	ft3.setFoodTypeName("Dessert");
	session.save(ft3);
	
	FoodMenu fm1 = new FoodMenu();
	fm1.setCost(10.98);
	fm1.setDescription("Few dishes can arouse the taste buds like a spicy plate of Thai minced pork mixed"
			+ " with onions and dried chili flakes. Smother it in lime juice and fish sauce and you’ve got"
			+ " an exciting dish that perfectly compliments a blob of sticky rice!");
	fm1.setFoodName("Minced Pork Salad");
	fm1.setImage("abc.jpej");
	fm1.setSpicyLevel("Medium");
	fm1.setFoodCategory(fc1);
	fm1.setFoodType(ft2);
	session.save(fm1);
	
	FoodMenu fm2 = new FoodMenu();
	fm2.setCost(25.98);
	fm2.setDescription("Blah 222!!! Few dishes can arouse the taste buds like a spicy plate of Thai minced pork mixed"
			+ " with onions and dried chili flakes. Smother it in lime juice and fish sauce and you’ve got"
			+ " an exciting dish that perfectly compliments a blob of sticky rice!");
	fm2.setFoodName("Kid Meal");
	fm2.setImage("def.jpej");
	fm2.setSpicyLevel("spicy");
	fm2.setFoodCategory(fc2);
	fm2.setFoodType(ft1);
	session.save(fm2);
	
	System.out.println("Food Menu success");
	
	
	//Customer - address
	
	Customer c1 = new Customer();
	c1.setContactNo("1234567890");
	c1.setFirstName("Sachin");
	c1.setLastName("T");
	c1.setGender("Male");
	c1.setUserName("sachin");
	c1.setPassword("sachin123");
	c1.setEmailID("abimnm@gmail.com");
	
	Customer c2 = new Customer();
	c2.setContactNo("1234567890");
	c2.setFirstName("Veer");
	c2.setLastName("S");
	c2.setGender("Male");
	c2.setUserName("veer");
	c2.setPassword("veer123");
	c2.setEmailID("abimnm@gmail.com");
	
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
	
	System.out.println("Customer-Address Success");
	
	
	//Payment
	
	Payment pay1 = new Payment();
	pay1.setCardNumber("1111222233334444");
	pay1.setCardType("MasterCard");
	pay1.setCvvNumber(123);
	pay1.setExpiryDate("02/02/2015");
	pay1.setCustomer(c1);
	session.save(pay1);
	
	Payment pay2 = new Payment();
	pay2.setCardNumber("1111222233334444");
	pay2.setCardType("VISA");
	pay2.setCvvNumber(123);
	pay2.setExpiryDate("03/03/2015");
	pay2.setCustomer(c2);
	session.save(pay2);
	
	System.out.println("Customer-Address-Payment Success");
	
	// Order-Details
	
	Orders o1 = new Orders();
	o1.setTotalAmount(89.70);
	o1.setDateTime("03/03/2015");
	o1.setStatus("pending");
	o1.setCustomer(c1);
	session.save(o1);

	OrderDetails od1 = new OrderDetails();
	od1.setFoodMenu(fm2);
	od1.setFoodName(fm2.getFoodName());
	od1.setOrders(o1);
	od1.setQuantity(3);
	od1.setTotalCost(30.85);
	//fm1.setOrderDetails(od1);
	
	//session.save(fm1);
	session.save(od1);
	
	OrderDetails od2 = new OrderDetails();
	od2.setFoodMenu(fm1);
	od2.setFoodName(fm1.getFoodName());
	od2.setOrders(o1);
	od2.setQuantity(5);
	od2.setTotalCost(50.85);
	
	//fm2.setOrderDetails(od1);
	
	//session.save(fm2);
	session.save(od2);
	
	System.out.println("Order-Details Success");
	
	t.commit();
	
	session.close();
	
	System.out.println("Complete-Success");
	
	}

}
