package org.neu.webtools;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.neu.webtools.dao.FoodDao;
import org.neu.webtools.model.FoodCategory;
import org.neu.webtools.model.FoodMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private FoodDao foodDao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeback( Model model) {

		return "home";
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public String filter( Model model,HttpServletRequest request) throws ServletException, IOException {
		
		try
		{
			String fil = request.getParameter("catno");
			if(fil==null || fil.isEmpty())
			{
				return "error";
			}
			
			int cat = Integer.parseInt(fil);
			if(cat<=0)
			{
				return "error";
			}
			if(cat!=0)
			{
		
				List<FoodMenu> foodMenus1 = new ArrayList();
				foodMenus1 = foodDao.queryAllFoodCategory(1, cat);
				model.addAttribute("starter", foodMenus1);
			

				List<FoodMenu> foodMenus2 = new ArrayList();
				foodMenus2 = foodDao.queryAllFoodCategory(2, cat);
				model.addAttribute("maincourse", foodMenus2);
				

				List<FoodMenu> foodMenus3 = new ArrayList();
				foodMenus3 = foodDao.queryAllFoodCategory(3, cat);
				model.addAttribute("dessert", foodMenus3);
				
				FoodCategory fsel = foodDao.queryGetFoodCategory(cat);
				model.addAttribute("catName",fsel.getCatergoryName());

			return "HomeFoodList";
			}
		}	
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return "redirect:/plist";
	}
	
	@RequestMapping(value = "/plist", method = RequestMethod.GET)
	public String foodType(Model model,HttpServletRequest request) throws ServletException, IOException {
		
		try
		{
		//	int cat = Integer.parseInt(request.getParameter("catno"));
		
			String sort = "1";
			
			String q = request.getQueryString();
			if(q!=null)
			{
				String[] split = q.split("=");
				
				if(split.length>0)
				{
					sort = split[1];
				}
			}
			Comparator cmp = null;
			
			if(sort.equals("1"))
			{
				model.addAttribute("catName","Cuisine");
				model.addAttribute("first","Starter");
				model.addAttribute("second","Main Course");
				model.addAttribute("third","Dessert");
			}
			else if(sort.equals("2"))
			{
				model.addAttribute("catName","Rating");
				model.addAttribute("first","Rated-5");
				model.addAttribute("second","Rated-4");
				model.addAttribute("third","Rated-3");
			}
			else if(sort.equals("3"))
			{
				model.addAttribute("catName","Low to High");
				model.addAttribute("first","$");
				model.addAttribute("second","$$");
				model.addAttribute("third","$$$");
			}
			else if(sort.equals("4"))
			{
				model.addAttribute("catName","High to Low");
				model.addAttribute("first","$$$");
				model.addAttribute("second","$$");
				model.addAttribute("third","$");
			}
				List<FoodMenu> foodMenus1 = new ArrayList();
				foodMenus1 = foodDao.queryAllFoodType(1);
				if(sort.equals("3"))
				{
					Collections.sort(foodMenus1);
				}
				model.addAttribute("starter", foodMenus1);
			

				List<FoodMenu> foodMenus2 = new ArrayList();
				foodMenus2 = foodDao.queryAllFoodType(2);
				if(sort.equals("3"))
				{
					Collections.sort(foodMenus2);
				}
				model.addAttribute("maincourse", foodMenus2);
				

				List<FoodMenu> foodMenus3 = new ArrayList();
				foodMenus3 = foodDao.queryAllFoodType(3);
				if(sort.equals("3"))
				{
					Collections.sort(foodMenus3);
				}
				model.addAttribute("dessert", foodMenus3);
				
			//	FoodCategory fsel = foodDao.queryGetFoodCategory(cat);
				model.addAttribute("catName","All Cuisine");

				return "HomeFoodList";
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/plist";
	}
	
	@RequestMapping(value = "/viewfooditem", method = RequestMethod.GET)
	public String viewFoodItem(Model model,HttpServletRequest request) throws ServletException, IOException {
		
		try
		{
			String catname = request.getParameter("view");
			if(catname.isEmpty() || catname==null)
			{
				return "error";
			}
			int cat = Integer.parseInt(catname);
			if(cat<=0)
			{
				return "error";
			}
			if(cat!=0)
			{
				FoodMenu fm = foodDao.queryViewPerticularFoodItem(cat);
				//FoodCategory fc = foodDao.queryGetFoodCategory(fm.getFoodCategory().);
				model.addAttribute("fooditem",fm);
				return "viewfooditem";
				
			}
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/plist";
	}
	@RequestMapping(value = "/googlemaps", method = RequestMethod.GET)
	public String loaction(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "googlemaps";
		}
	
	@RequestMapping(value = "/legal", method = RequestMethod.GET)
	public String termsCondition(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "Terms&Condition";
		}
	
	@RequestMapping(value = "/customfilter", method = RequestMethod.GET)
	public String customFoodFilter(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "customfilter";
		}
	
	@RequestMapping(value = "/customfilterpost", method = RequestMethod.GET)
	public String customFoodFilterPost(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "customfilterpost";
		}
}
