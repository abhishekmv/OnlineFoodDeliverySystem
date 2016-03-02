package org.neu.webtools.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.neu.webtools.model.Customer;
import org.neu.webtools.model.CustomerAddress;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.OrderDetails;
import org.neu.webtools.model.Orders;
import org.neu.webtools.model.Payment;
import org.neu.webtools.model.Person;



public class CustomerDao extends DAO{
	
	public Customer queryUserByNameAndPassword(String name, String password)
            throws Exception {
        try {
      //      begin();
        	
            Query q = getSession().createQuery("from Customer where userName = :name1 and password = :password1");
            q.setString("name1", name);
            q.setString("password1", password);
            Customer c = (Customer) q.uniqueResult();
          // System.out.println(p.getId());
            
          
           return c;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + name, e);
        }
	}
	
	public void queryAddNewCustomerDetails(String uname,String pname,String fname,String lname,String email,String ph,String stname,String city,String state, String country,int zip,String gender)
            throws Exception {
        try {
        	
        	Session session = getSession();
    		
    		Transaction t = session.beginTransaction();

    		
        	Customer c = new Customer();
        	c.setUserName(uname);
        	c.setPassword(pname);
        	c.setFirstName(fname);
        	c.setLastName(lname);
        	c.setEmailID(email);
        	c.setContactNo(ph);
        	c.setGender(gender);
        	
        	CustomerAddress ca = new CustomerAddress();
        	ca.setStreetName(stname);
        	ca.setCity(city);
        	ca.setState(state);
        	ca.setCountry(country);
        	ca.setZipCode(zip);
        	
        	c.getCustomerAddresses().add(ca);
        
    		session.save(c);
    		t.commit();
    		session.close();
            
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public List<CustomerAddress> queryAllAddress(int i)
            throws Exception {
        try {
        	/* Query q = getSession().createQuery("from CustomerAddress join Customer c where c.c_id =: cid");
        	 q.setInteger("cid", i);*/
        		
        	Criteria c = getSession().createCriteria(CustomerAddress.class, "ca");
        	c.createAlias("ca.customers", "cus");
        	c.add(Restrictions.eq("cus.c_id", i));
        	c.list();
        	 return c.list();
        	 
        	}
        catch (HibernateException e) {
            // rollback();
             e.printStackTrace();
             throw new Exception("Could not get user ", e);
         }
	}
	
	public void queryAddNewCustomerAddress(Customer c, String stname,String city,String state, String country,int zip)
            throws Exception {
        try {
        	
        	//getSession().close();
        	Session session = getSession();
    		
    		Transaction t = session.beginTransaction();
        	
        	CustomerAddress ca = new CustomerAddress();
        	ca.setStreetName(stname);
        	ca.setCity(city);
        	ca.setState(state);
        	ca.setCountry(country);
        	ca.setZipCode(zip);
        	//ca.getCustomers().add(c);
        	c.getCustomerAddresses().add(ca);
        
        	session.save(c);
        	//session.update(c);
        	//session.save(ca);
    		t.commit();
    	//close();
            
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public CustomerAddress queryCustomerAdress(int id)
            throws Exception {
        try {
      //      begin();
        	
            Query q = getSession().createQuery("from CustomerAddress where add_id = :aid");
            q.setInteger("aid", id);
            CustomerAddress c = (CustomerAddress) q.uniqueResult();
          // System.out.println(p.getId());
 
           return c;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public Payment queryCustomerPayment(int id)
            throws Exception {
        try {
      //      begin();
        	
            Query q = getSession().createQuery("from Payment where p_id = :aid");
            q.setInteger("aid", id);
            Payment c = (Payment) q.uniqueResult();
          // System.out.println(p.getId());
 
           return c;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public void queryCustomerNewPayment(String cname, String cno, int cvv, String date, Customer c)
            throws Exception {
        try {
        	
        		Session session = getSession();
    		
        		Transaction t = session.beginTransaction();
        		
        		Payment p = new Payment();
        		p.setCardType(cname);
        		p.setCardNumber(cno);
        		p.setCvvNumber(cvv);
        		p.setExpiryDate(date);
        		p.setCustomer(c);
        		
        		session.save(p);
        		t.commit();
        	//	session.close();
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public Orders queryCustomerOrder(float sum, String time, Customer c)
            throws Exception {
        try {
        	
        		Session session = getSession();
    		
        		Transaction t = session.beginTransaction();
        		
        		Orders o = new Orders();
        		o.setDateTime(time);
        		o.setStatus("Pending");
        		o.setTotalAmount(sum);
        		o.setCustomer(c);
        		session.save(o);
        		t.commit();
        		return o;
        	//	session.close();
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public void queryCustomerOrderDetails(FoodMenu fm, Orders o, int quantity, float totalcost)
            throws Exception {
        try {
        	
        		Session session = getSession();
    		
        		Transaction t = session.beginTransaction();
        		
        		OrderDetails od = new OrderDetails();
        		
        		od.setFoodMenu(fm);
        		od.setFoodName(fm.getFoodName());
        		od.setOrders(o);
        		od.setQuantity(quantity);
        		od.setTotalCost(totalcost);
        			
        		session.save(od);
        		
        		t.commit();
        		
        		close();        
        		
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public void queryUpdateCustomerPassword(String np, Customer obj)
            throws Exception {
        try {
          // begin();
        	
        
        	Session session = getSession();
        	
        	Transaction t = session.beginTransaction();
        	
            obj.setPassword(np);
            session.update(obj);
           // Person p = (Person)q;
           // q.executeUpdate();
           // session.update(q);
            t.commit();
           // session.close();
           // session.close();
            System.out.println("commit");
          //  commit();
            
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}

}
