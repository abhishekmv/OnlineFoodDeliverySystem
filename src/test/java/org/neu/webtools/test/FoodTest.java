package org.neu.webtools.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.neu.webtools.dao.HibernateUtil;
import org.neu.webtools.model.FoodCategory;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.FoodType;


public class FoodTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
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
		
		t.commit();
		
		session.close();
		
		System.out.println("Success");

	}

}
