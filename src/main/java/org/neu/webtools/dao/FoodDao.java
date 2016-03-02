package org.neu.webtools.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.neu.webtools.model.FoodCategory;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.FoodType;
import org.neu.webtools.model.Person;

public class FoodDao extends DAO {
	
	
	public List<FoodMenu> queryAllFoodMenu()
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from FoodMenu");
            //q.setString("name2", name);
            

            return q.list();
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public List<FoodCategory> queryAllFoodCategory()throws Exception
	{
		 try {
		      //      begin();
			 Query q = getSession().createQuery("from FoodCategory");

		            return q.list();
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not get user ", e);
		        }
		
	}
	
	public List<FoodType> queryAllFoodType()throws Exception
	{
		 try {
		      //      begin();
		            Query q = getSession().createQuery("from FoodType");

		            return q.list();
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not get user ", e);
		        }
		
	}
	
	public void queryAddNewFoodItem(String fname , String description,double cost,String spicylevel, FoodCategory category, FoodType type,String imageName)
            throws Exception {
        try {
        	
        	Session session = getSession();
    		
    		Transaction t = session.beginTransaction();

    		
        	FoodMenu fm = new FoodMenu();
        	fm.setFoodName(fname);
        	fm.setDescription(description);
        	fm.setCost(cost);
        	fm.setSpicyLevel(spicylevel);
        	fm.setFoodCategory(category);
        	fm.setFoodType(type);
        	fm.setImage(imageName);
        	fm.setEnable_disable("Enable");
    		session.save(fm);
    		t.commit();
    		//session.close();
            
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public FoodCategory queryGetFoodCategory(int fcid)
            throws Exception {
        try {
      //      begin();
        	
        	//Query q = getSession().createQuery("from FoodCategory where cat_id = :fname");
           // q.setInteger("fname", fcid);
        	
        	Criteria cr = getSession().createCriteria(FoodCategory.class)
        			.add(Restrictions.eq("cat_id", fcid));

            FoodCategory fc = (FoodCategory) cr.uniqueResult();
          // System.out.println(p.getId());
            
          
           return fc;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get foodcategory ", e);
        }
	}
	
	public FoodType queryGetFoodType(int ftid)
            throws Exception {
        try {
      //      begin();
        	
        	Query q = getSession().createQuery("from FoodType where ftype_id = :fname");
            q.setInteger("fname", ftid);

            FoodType ft = (FoodType) q.uniqueResult();
          // System.out.println(p.getId());
            
          
           return ft;
           
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get foodcategory ", e);
        }
	}
	
	public void queryEnableDisableFoodItem(int id)
            throws Exception {
        try {
        	
         		//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
         		Session session = getSession();
        	
         		Transaction t = session.beginTransaction();
         		
        		Query q = getSession().createQuery("from FoodMenu where f_id = :fname");
        		q.setInteger("fname", id);
        		
        		FoodMenu fm = (FoodMenu) q.uniqueResult();
        		
        		if(fm.getEnable_disable().equals("Enable"))
            	{
            		fm.setEnable_disable("Disable");
            	}
            	else if(fm.getEnable_disable().equals("Disable"))
            	{
            		 fm.setEnable_disable("Enable");
            	}
        		
        		session.update(fm);
        		t.commit();
        		//session.close();
           // System.out.println(result);
            
            
            
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
            throw new Exception("Could not get user " + id, e);
        }
	}
	

	public List<FoodMenu> queryAllFoodCategory(int st, int cat)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from FoodMenu where ftype_id = :fname and cat_id = :fcat and enable_disable = :ed ");
            q.setInteger("fname", st);
            q.setInteger("fcat", cat);
            q.setString("ed", "Enable");
            return q.list();
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public List<FoodMenu> queryAllFoodType(int st)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from FoodMenu where ftype_id = :fname and enable_disable = :ed");
            q.setInteger("fname", st);
            q.setString("ed", "Enable");

            return q.list();
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	
	public FoodMenu queryViewPerticularFoodItem(int view)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from FoodMenu where f_id = :fid");
            q.setInteger("fid", view);
         //   q.setString("ed", "Enable");
            FoodMenu fm = (FoodMenu)q.uniqueResult();
            return fm;
            
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
	}
	 
	public void queryUpdateFoodItem(String fname , String description,double cost,String spicylevel, FoodCategory category, FoodType type,int fid)
            throws Exception {
        try {
        	
        	Session session = getSession();
    		
    		Transaction t = session.beginTransaction();
    		
    		Query q = getSession().createQuery("from FoodMenu where f_id = :fname");
    		q.setInteger("fname", fid);
    		
    		FoodMenu fm = (FoodMenu) q.uniqueResult();
    		
        	fm.setFoodName(fname);
        	fm.setDescription(description);
        	fm.setCost(cost);
        	fm.setSpicyLevel(spicylevel);
        	fm.setFoodCategory(category);
        	fm.setFoodType(type);
        
        	
        	session.update(fm);
    		t.commit();
    		//session.close();
            
            
        } catch (HibernateException e) {
           // rollback();
            e.printStackTrace();
            throw new Exception("Could not get user ", e);
        }
	}
	

}
