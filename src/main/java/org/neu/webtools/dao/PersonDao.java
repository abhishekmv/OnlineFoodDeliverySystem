package org.neu.webtools.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.Person;

public class PersonDao extends DAO{
	
	public Person queryUserByNameAndPassword(String name, String password, String admintype)
            throws Exception {
        try {
      //      begin();
        	
            Query q = getSession().createQuery("from Person where userName = :name1 and password = :password1 and roleType = :role");
            q.setString("name1", name);
            q.setString("password1", password);
            q.setString("role", admintype);
            Person p = (Person) q.uniqueResult();
          // System.out.println(p.getId());
            
          
           return p;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + name, e);
        }
	}
	
	
	public List<Person> queryAllHotelAdmin()
            throws Exception {
        try {
      //      begin();
        	
            Query q = getSession().createQuery("from Person where roleType = :role");
            q.setString("role", "HotelAdmin");
            

            return q.list();
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public void queryUpdateSuperAdminPassword(String np, Person obj)
            throws Exception {
        try {
          // begin();
        	
        //	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        	Session session = getSession();
        	
        	Transaction t = session.beginTransaction();
        	//session.flush();
           // Query q = getSession().createQuery("UPDATE Person set password = :newPass WHERE pid = :uid and roleType = :role");
           // q.setParameter("newPass", np);
           // q.setParameter("uid", userid);
           // q.setParameter("role", admintype);
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
	
	public void queryAddNewHotelAdmin(String uname , String pass,String first,String last, String email, String role, String contactNo)
            throws Exception {
        try {
        	
        	Session session = getSession();;
    		
    		Transaction t = session.beginTransaction();

    		
        	Person admin = new Person();
        	admin.setUserName(uname);
        	admin.setPassword(pass);
        	admin.setFirstName(first);
        	admin.setLastName(last);
    		admin.setEmailID(email);
    		admin.setRoleType(role);
    		admin.setContactNo(contactNo);
    		admin.setEnable_disable("Enable");
    		session.save(admin);
    		t.commit();
    	//	session.close();
            
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public void queryUpdateUserStatus(int id)
            throws Exception {
        try {
          // begin();
        	
        //	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        	Session session = getSession();
        	
        	Transaction t = session.beginTransaction();
   
    		Query q = getSession().createQuery("from Person where pid = :fname");
    		q.setInteger("fname", id);
    		Person p = (Person) q.uniqueResult();
    		
    		if(p.getEnable_disable().equals("Enable"))
        	{
        		p.setEnable_disable("Disable");
        	}
        	else if(p.getEnable_disable().equals("Disable"))
        	{
        		 p.setEnable_disable("Enable");
        	}
    		
    		 session.update(p);

             t.commit();
          //  session.close();
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public Person queryPersonDetails(int id)
            throws Exception {
        try {
          // begin();
        	
        //	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        	Session session = getSession();
        	
        	Transaction t = session.beginTransaction();
   
    		Query q = getSession().createQuery("from Person where pid = :fname");
    		q.setInteger("fname", id);
    		Person p = (Person) q.uniqueResult();
    		
    		//String email = p.getEmailID();
    		return p;
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}

}
