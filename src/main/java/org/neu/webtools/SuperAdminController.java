package org.neu.webtools;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.*;
import org.neu.webtools.dao.FoodDao;
import org.neu.webtools.dao.PersonDao;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class SuperAdminController {
	
	@Autowired
	@Qualifier("superAdminUserValidator")
	private Validator validator;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private FoodDao foodDao;
	
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(value = "/sadmin", method = RequestMethod.GET)
	public String sAdminHome(Locale locale, Model model, HttpServletRequest request) {
		
		Person sa = new Person();
		 
		model.addAttribute("person", sa);
		return "superadminloginpage";
		
	}
	
	@RequestMapping(value = "/sadmin", method = RequestMethod.POST)
	public String sAdminLoginForm(Model model, @Validated Person sAdmin, BindingResult result, HttpServletRequest request, HttpServletResponse response)
	{
		//String returnVal = "superadminhome";
		
 
		if(result.hasErrors())
		{
			return "superadminloginpage";
		}
		else
		{
			try
			{
				String admintype = request.getParameter("admintype");
				String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		        System.out.println(gRecaptchaResponse);
		        HttpSession session = request.getSession();
		        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
		        
		        if(admintype.equals("SuperAdmin")&& verify==true)
		        {
		        	Person sad = personDao.queryUserByNameAndPassword(sAdmin.getUserName(), sAdmin.getPassword(),admintype);
					System.out.println("User=" + sAdmin.getUserName() + "::password=" + sAdmin.getPassword() + "::Captcha Verify"+verify);
					
					if(sad!=null)
					{
						//messages.setUserName(u.getUserName());
						//HttpSession session = request.getSession();
					//	session.setAttribute("sAdmin", sAdmin);
					
						
					//	model.addAttribute("adminUser",sad);
						
						session.setAttribute("adminUser", sad);
						List<Person> hotel = new ArrayList();
						hotel = personDao.queryAllHotelAdmin();
					
						model.addAttribute("allHotelAdmin", hotel);
						return "superadminhome";
					}
					else {

						if(sad==null)
			            {
			            	String a = "<font color=red>UserName and password and roletype not matching.. Retry again!.</font>";
			            	model.addAttribute("a",a);
			            }
			            return "superadminloginpage";
			        }
					
		        }
		        
		        else if(admintype.equals("HotelAdmin")&& verify==true)
		        {
		        	Person had = personDao.queryUserByNameAndPassword(sAdmin.getUserName(), sAdmin.getPassword(),admintype);
					System.out.println("User=" + sAdmin.getUserName() + "::password=" + sAdmin.getPassword() + "::Captcha Verify"+verify);
					
					if(had!=null)
					{
						if(had.getEnable_disable().equals("Disable"))
						{
							model.addAttribute("staterror","<font color=red>Your access has been denied! Contact your admin for more details !!</font>");
							return "superadminloginpage";
							
						}

						//model.addAttribute("adminUser",had);
						session.setAttribute("adminUser", had);
						List<FoodMenu> foodMenus = new ArrayList();
						foodMenus = foodDao.queryAllFoodMenu();
						model.addAttribute("allHotelAdmin", foodMenus);
						return "hoteladminhome";
					}
					else {

						if(had==null)
			            {
			            	String a = "<font color=red>UserName and password  and roletype not matching.. Retry again!.</font>";
			            	model.addAttribute("a",a);
			            }
			            return "superadminloginpage";
			        }
					
		        	
		        }
		        else
		        {
		        	 if(verify==false)
			            {
			            	String c = "<font color=red>You missed the Captcha.</font>";
			            	model.addAttribute("c",c);
			            	return "superadminloginpage";
			            }
		        }
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("person", new Person());
		return "superadminloginpage";
		
	}
	
	@RequestMapping(value = "/shadmin", method = RequestMethod.GET)
	public String sAdminHomeReEntry(Locale locale, Model model, HttpServletRequest request) {
		
		
		Person sa = new Person();
		try
		{
			
			HttpSession session = request.getSession(false); 
		if(session!=null)
		{
			Person per = (Person)session.getAttribute("adminUser");
			
			if(per!=null)
			{
				if(per.getRoleType().equals("SuperAdmin"))
				{
				//	Person sad = personDao.queryUserByNameAndPassword(per.getUserName(), per.getPassword(),per.getRoleType());
					List<Person> hotel = new ArrayList();
					hotel = personDao.queryAllHotelAdmin();
				
					model.addAttribute("allHotelAdmin", hotel);
					return "superadminhome";
				
				}
				else if(per.getRoleType().equals("HotelAdmin"))
				{
				//	Person sad = personDao.queryUserByNameAndPassword(per.getUserName(), per.getPassword(),per.getRoleType());
					List<FoodMenu> foodMenus = new ArrayList();
					foodMenus = foodDao.queryAllFoodMenu();
					model.addAttribute("allHotelAdmin", foodMenus);
					return "hoteladminhome";
				}
			}
		}
	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("person", sa);
		return "superadminloginpage";
		
	}
	
	@RequestMapping(value="/superAdminChangePassword" ,method=RequestMethod.GET)
	public String changePasswordForm(Model model,HttpServletRequest request) throws ServletException, IOException{
		
		try
		{
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
				Person id = (Person)session.getAttribute("adminUser");
				if(id!=null)
				{
					if(id.getRoleType().equals("SuperAdmin"))
					{
						String upass = id.getPassword();
						model.addAttribute("pass",upass);
						return "superadminchangepassword";
					}
					
					
					else if(id.getRoleType().equals("HotelAdmin"))
					{
						String upass = id.getPassword();
						model.addAttribute("pass",upass);
						return "hoteladminchangepassword";
					}
				}
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("person", new Person());
		return "superadminloginpage";
	}
	
	
	
	
	@RequestMapping(value="/superAdminChangePassword" ,method=RequestMethod.POST)
	public String changePasswordPost(Model model,HttpServletRequest request) throws ServletException, IOException{
		
		try
		{
			
			HttpSession session = request.getSession(); 
			Person id = (Person)session.getAttribute("adminUser");
			//String uname = id.getUserName();
			//int uid = id.getPid();

			//String role = id.getRoleType();
			String newPass = request.getParameter("password1");
			
			personDao.queryUpdateSuperAdminPassword(newPass,id);
			System.out.println(id.getPassword());
			return "updatepassword";
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		String a ="<font color=red>Sorry, your password could not be updated. It will be fixed in our next release!! </font>";
		model.addAttribute("passerror",a);
		return "superadminloginpage";
	}

	@RequestMapping(value = "/hoteladminadd", method = RequestMethod.GET)
	public String addHotelAdmin(Locale locale, Model model, HttpServletRequest request) {
		Person sa = new Person();
		
		try
		{
		HttpSession session = request.getSession(false); 
		if(session!=null)
		{
			Person per = (Person)session.getAttribute("adminUser");
		
			if(per!=null)
			{
				return "addhoteladmin";
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
	
	@RequestMapping(value = "/hoteladminadd", method = RequestMethod.POST)
	public String addHotelAdminPost(Model model,HttpServletRequest request) {
		
		try
		{
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String emailid = request.getParameter("emailid");
		String roletype = "HotelAdmin";
		String contactNo = request.getParameter("number");	
		personDao.queryAddNewHotelAdmin(username, password, firstname, lastname, emailid, roletype,contactNo);
		return "redirect:/shadmin";
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("d","<font color=red>Enter details in all the field correctly!!<br> Dont try to act smart!! </font>");
		return "addhoteladmin";
		
	}
	
	@RequestMapping(value = "/userstatus", method = RequestMethod.GET)
	public String enableDisableHotelAdmin(Model model,HttpServletRequest request) {
		
		try
		{
			HttpSession session = request.getSession(false);
			int status = Integer.parseInt(request.getParameter("stat"));
			//Person id = (Person)session.getAttribute("adminUser");

				personDao.queryUpdateUserStatus(status);
				return "redirect:/shadmin";
				
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		model.addAttribute("d","<font color=red>Sorry, user status could not be updated. It will be fixed in our next release!!</font>");
		return "addhoteladmin";
		
	}
	
	@RequestMapping(value="/emaildetails" ,method=RequestMethod.GET)
	public String email(Model model,HttpServletRequest request) throws ServletException  {

			try {
					String em = request.getParameter("em");
					
					if(em.isEmpty())
					{
						int id = Integer.parseInt(em);
					
						Person pre = personDao.queryPersonDetails(id);
					
						HtmlEmail email = new HtmlEmail();
						email.setHostName("smtp.googlemail.com");
						email.setSmtpPort(465);
						email.setAuthenticator(new DefaultAuthenticator("abhishekmv.91", "abhishek@123"));
						email.setSSL(true);
						email.setFrom("abhishekmv.91@gmail.com", "Admin");
						email.setSubject("User Login Details");
						email.setHtmlMsg("<html><body> Hi "+pre.getFirstName()+", <br>Below Are your Hotel Admin Details <br> User Name: "+pre.getUserName()+"<br> Password: "+pre.getPassword()+"<br>"
							  + "After you login change your password <br> Regards,<br>Super Admin</body></html>");
						email.addTo(pre.getEmailID(), "Delivery.com");
						email.send();
						return "redirect:/shadmin";
					}
					else
					{
						return "error";
					}
							
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
			model.addAttribute("person", new Person());
			return "superadminloginpage";
	}
	
	
	
	@RequestMapping(value="/adminLogout" ,method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request) throws ServletException  {

			try {
				
				HttpSession session = request.getSession(false);
			//	Person per = (Person)session.getAttribute("adminUser");
				//session.setAttribute(null, "adminUser");
				//session.setAttribute(null, per);
				if(session!=null)
				{
				 session.removeAttribute("adminUser");
					 session.invalidate();
					 
					System.out.println(session);
					return "signoutpage";	
				}
				else
				{
					return "error";
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				//return "error";
			}
			
		return "redirect:/sadmin";
	}
}
