package org.neu.webtools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.neu.webtools.dao.FoodDao;
import org.neu.webtools.dao.PersonDao;
import org.neu.webtools.model.FoodCategory;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.FoodType;
import org.neu.webtools.model.Person;
import org.neu.webtools.test.FoodTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class FoodController {
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FoodDao foodDao;
	
	@RequestMapping(value = "/addNewProduct", method = RequestMethod.GET)
	public String addProductList(  Model model, HttpServletRequest request) {
		
		try
		{
				HttpSession session = request.getSession(false); 
				if(session!=null)
				{
					Person per = (Person)session.getAttribute("adminUser");
				
					if(per!=null)
					{
							List<FoodCategory> fcat = new ArrayList();
							fcat = foodDao.queryAllFoodCategory();
							model.addAttribute("fcat",fcat);
			
							List<FoodType> fType = new ArrayList();
							fType = foodDao.queryAllFoodType();
							model.addAttribute("fType",fType);
			
							return "addNewDishes";
					}
				}
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("person", new Person());
		return "superadminloginpage";
	}
	
	@RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
	public String uploadForm(@RequestParam("file") MultipartFile[] file,
			Model map, HttpServletRequest request) {
		
		String returnval = "error";
		try
		{
		String fname = request.getParameter("foodname");
		String description = request.getParameter("description");
		double cost = Double.parseDouble((request.getParameter("cost")));
		String spicylevel = request.getParameter("spicylevel");
		int category = Integer.parseInt(request.getParameter("category"));
		int type = Integer.parseInt(request.getParameter("type"));
		List<String> fileNames = new ArrayList<String>();

		
		
		if (null != file && file.length > 0) {
			for (MultipartFile multipartFile : file) {

				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {
					try {
						multipartFile.transferTo(new File(
								"C:/Misc/images/"
										+ fileName));
						FoodCategory fc = foodDao.queryGetFoodCategory(category);
						FoodType ft = foodDao.queryGetFoodType(type);
						foodDao.queryAddNewFoodItem(fname, description, cost, spicylevel, fc, ft, fileName);
						fileNames.add(fileName);
						return "redirect:/shadmin";
						
					} catch (Exception e) {
						System.out.println(e.getMessage());
						returnval = "error";
					}
					
				}
			}
		}
		map.addAttribute("files", fileNames);
		return returnval;
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
			returnval = "error";
		}

		//map.addAttribute("files", fileNames);
		return returnval;
	}
	
	@RequestMapping(value = "/foodstatus", method = RequestMethod.GET)
	public String foodStatusUpdate(Model model,HttpServletRequest request) throws ServletException, IOException{
		
		try
		{
			
			HttpSession session = request.getSession(false); 
			
			String enable = request.getParameter("enable");
			
			if(enable==null || enable.isEmpty())
			{
				return "error";
			}
			if(session!=null)
			{
				Person per = (Person)session.getAttribute("adminUser");
		
				if(per!=null)
				{
					int status = Integer.parseInt(enable);
					
					if(status<=0)
					{
						return "error";
					}
					
		
					foodDao.queryEnableDisableFoodItem(status);
		
					List<FoodMenu> fm = new ArrayList();
		
					fm = foodDao.queryAllFoodMenu();
					model.addAttribute("allHotelAdmin", fm);
					return "hoteladminhome";
				}
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("person", new Person());
		return "superadminloginpage";
	}
	
	@RequestMapping(value = "/updatefood", method = RequestMethod.GET)
	public String updateFoodItem(Model model,HttpServletRequest request) {
		
		//Person sa = new Person();
		
		try
		{
			HttpSession session = request.getSession(false); 
			
			String fid = request.getParameter("name");
			
			if(fid==null || fid.isEmpty())
			{
				return "error";
			}
			
			if(session!=null)
			{
				Person per = (Person)session.getAttribute("adminUser");
		
				if(per!=null)
				{
					int id = Integer.parseInt(fid);
					
					if(id<=0)
					{
						return "error";
					}
					
					FoodMenu fm = foodDao.queryViewPerticularFoodItem(id);
					model.addAttribute("foodmenu",fm);
					
					List<FoodCategory> fcat = new ArrayList();
					fcat = foodDao.queryAllFoodCategory();
					model.addAttribute("fcat",fcat);
	
					List<FoodType> fType = new ArrayList();
					fType = foodDao.queryAllFoodType();
					model.addAttribute("fType",fType);
					
					return "updatefooditem";
					
					
				}
			}
			}
			catch (Exception e) {
			
				e.printStackTrace();
				return "error";
			}
		
			model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
			model.addAttribute("person", new Person());
			return "superadminloginpage";
		
	}



@RequestMapping(value = "/updatefood", method = RequestMethod.POST)
public String updateFoodItemPost(Model model,HttpServletRequest request) {
	
	//Person sa = new Person();
	
	try
	{
		HttpSession session = request.getSession(false); 
		
		String foodid = request.getParameter("fid");
		
		if(foodid==null || foodid.isEmpty())
		{
			return "error";
		}
		
		if(session!=null)
		{
			Person per = (Person)session.getAttribute("adminUser");
	
			if(per!=null)
			{
				int fid = Integer.parseInt(foodid);
				
				//FoodMenu fm = foodDao.queryViewPerticularFoodItem(fid);
				
				String fname = request.getParameter("foodname");
				String description = request.getParameter("description");
				double cost = Double.parseDouble((request.getParameter("cost")));
				String spicylevel = request.getParameter("spicylevel");
				int category = Integer.parseInt(request.getParameter("category"));
				int type = Integer.parseInt(request.getParameter("type"));
				
				FoodCategory fc = foodDao.queryGetFoodCategory(category);
				FoodType ft = foodDao.queryGetFoodType(type);
				
				foodDao.queryUpdateFoodItem(fname, description, cost, spicylevel, fc, ft,fid);
				
				return "redirect:/shadmin";
				
				
			}
		}
		}
		catch (Exception e) {
		
			e.printStackTrace();
		}
	
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("person", new Person());
		return "superadminloginpage";
	
	}

}
