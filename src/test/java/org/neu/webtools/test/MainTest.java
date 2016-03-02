package org.neu.webtools.test;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.neu.webtools.dao.HibernateUtil;
import org.neu.webtools.model.Person;




public class MainTest {
	
	public static void main(String [] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
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
		
		t.commit();
		
		session.close();
		
		System.out.println("Success");
	}

}
