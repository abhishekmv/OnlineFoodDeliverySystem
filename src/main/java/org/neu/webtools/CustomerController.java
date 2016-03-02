package org.neu.webtools;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.neu.webtools.cart.ShoppingCart;
import org.neu.webtools.cart.ShoppingItem;
import org.neu.webtools.dao.CustomerDao;
import org.neu.webtools.dao.FoodDao;
import org.neu.webtools.model.Customer;
import org.neu.webtools.model.CustomerAddress;
import org.neu.webtools.model.FoodCategory;
import org.neu.webtools.model.FoodMenu;
import org.neu.webtools.model.Orders;
import org.neu.webtools.model.Payment;
import org.neu.webtools.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
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
import org.springframework.webflow.execution.RequestContext;


@Controller
public class CustomerController {
	
	/*@Autowired
	@Qualifier("customerValidator")
	private Validator validator;*/
	
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private FoodDao foodDao;

	/*@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}*/
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String customerlogin(Locale locale, Model model, HttpServletRequest request) throws ServletException, IOException {
		
		Customer ca = new Customer();
		HttpSession session = request.getSession();
		Customer cus = (Customer) session.getAttribute("customerUser");
		try
		{	
			if(cus!=null)
			{
				return"redirect:/customerhome";
				
			}
			else
			{
				if(request.getCookies() != null)
				{
				for(Cookie c : request.getCookies())
				{
					
					if(c.getName().equals("customerUsernameCookie"))
					{
						
						ca.setUserName(c.getValue());
						
					}
					if(c.getName().equals("customerPasswordCookie"))
					{
						ca.setPassword(c.getValue());
					}
				}
				
				if(ca.getUserName()!=null && ca.getPassword()!=null)
				{
					model.addAttribute("customer", ca);
					return "customerlogin";
				}
				
			  }
			}
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("customer", ca);
		return "customerlogin";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String customerLoginPost(Model model, @Validated Customer customer, BindingResult result, HttpServletRequest request, HttpServletResponse response)
	{
		String returnVal = "customerhomepage";
		//String username
		if(result.hasErrors())
		{
			return "customerlogin";
		}
		else
		{
		  try{
			  
			String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
	        System.out.println(gRecaptchaResponse);
	        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
	        
	        String user = request.getParameter("userName");
	        String pass = request.getParameter("password");
	        
	        if(user==null || pass==null)
	        {
	        	String d = "<font color=red>Do not leave the text field empty !!.</font>";
            	model.addAttribute("d",d);
            	return "customerlogin";
	        }
	        
	        if(user.isEmpty() || pass.isEmpty())
	        {
	        	String d = "<font color=red>Do not leave the text field empty !!.</font>";
            	model.addAttribute("d",d);
            	return "customerlogin";
	        }
	        
			Customer ca = new Customer();
			Customer cad = customerDao.queryUserByNameAndPassword(customer.getUserName(), customer.getPassword());
			float sum=0;

			System.out.println("User=" + customer.getUserName() + "::password=" + customer.getPassword() + "::Captcha Verify"+verify);
			
			if(cad!=null&& verify==true)
			{
				//messages.setUserName(u.getUserName());
				//HttpSession session = request.getSession();
				//	session.setAttribute("sAdmin", sAdmin);
				
				if(request.getParameter("remember-me") != null)
				{
					Cookie cookieUsername = new Cookie("customerUsernameCookie", customer.getUserName());
					Cookie cookiePassword = new Cookie("customerPasswordCookie", customer.getPassword());
					cookieUsername.setMaxAge(60*60*24*7);
					cookiePassword.setMaxAge(60*60*24*7);
					response.addCookie(cookieUsername);
					response.addCookie(cookiePassword);
				}
				
			//	model.addAttribute("customerUser",cad);
				
				HttpSession session = request.getSession();
				session.setAttribute("customerUser", cad);
				ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
				
				if(scart==null)
				{
					return "customeremptycart";
				}
				else
				{
					ArrayList<ShoppingItem> sList = scart.getCartList();
					
					for (ShoppingItem shoppingItem : sList) 
					{
	                     sum = sum + (shoppingItem.getUnitPrice() * shoppingItem.getCount());             
					}
					model.addAttribute("sum", sum);
					model.addAttribute("customercart", sList);
					return returnVal;
				}
				
			}
			else {

				if(cad==null)
	            {
	            	String a = "<font color=red>UserName and password not matching.. Retry again!.</font>";
	            	model.addAttribute("a",a);
	            }
				
				if(verify==false)
	            {
	            	String c = "<font color=red>You missed the Captcha.</font>";
	            	model.addAttribute("c",c);
	            	
	            }
				return "customerlogin";
	        }

		}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	
		return "error";
	}
	
	@RequestMapping(value = "/customerhome", method = RequestMethod.GET)
	public String customerHome( Model model, HttpServletRequest request) throws ServletException, IOException
	{
		Customer ca = new Customer();
		HttpSession session = request.getSession(false); 
		float sum =0;
		try{
		if(session!=null)
		{
			Customer cus = (Customer)session.getAttribute("customerUser");
			
			if(cus!=null)
			{
				
					//Customer cad = customerDao.queryUserByNameAndPassword(cus.getUserName(), cus.getPassword());
					ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
					if(scart !=null)
					{
						ArrayList<ShoppingItem> sList = scart.getCartList();
						for (ShoppingItem shoppingItem : sList) {
		                     sum = sum + (shoppingItem.getUnitPrice() * shoppingItem.getCount());
		                     
		            	 }
						 model.addAttribute("sum", sum);
						model.addAttribute("customercart", sList);
						return "customerhomepage";
					}
					else
					{
						return "customeremptycart";
					}
				
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
			model.addAttribute("customer", ca);
			return "customerlogin";
	}
	
	@RequestMapping(value = "/addnewcustomer", method = RequestMethod.GET)
	public String addNewCustomerGet( Model model, HttpServletRequest request) throws ServletException, IOException
	{

		return "addnewcustomerpage";
	}
	
	@RequestMapping(value = "/addnewcustomer", method = RequestMethod.POST)
	public String addNewCustomer( Model model, HttpServletRequest request) throws ServletException, IOException
	{
		
		Customer ca = new Customer();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String emailid = request.getParameter("emailid");
		String number = request.getParameter("number");
		String streetname = request.getParameter("streetname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String gender = request.getParameter("gender");
		
		
		try
		{
			
			customerDao.queryAddNewCustomerDetails(username, password, firstname, lastname, emailid, number, streetname,city,state,country,zipcode,gender);
			return "successfulsignup";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "error";
		
	}
	
	@RequestMapping(value = "/continuecheckout", method = RequestMethod.GET)
	public String customerCheckoutCart(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		
		try{
			HttpSession session = request.getSession(false); 
			
			if(session!=null)
			{
				Customer cus = (Customer)session.getAttribute("customerUser");
			
				if(cus!=null)
				{
					ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
					if(scart !=null)
					{
				
					List<CustomerAddress> cadd = new ArrayList();
					cadd = customerDao.queryAllAddress(cus.getC_id());
					model.addAttribute("cusAddress",cadd);
					return "customeraddress";
					}
					else
					{
						return "redirect:/customerhome";
					}
				}
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("customer", new Customer());
		return "customerlogin";
	}
	
	@RequestMapping(value = "/continuecheckout", method = RequestMethod.POST)
	public String customerCheckoutPost(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		int addid = Integer.parseInt(request.getParameter("addid"));
		try
		{	
			HttpSession session = request.getSession();
			Customer cus = (Customer)session.getAttribute("customerUser");
			
			if(cus!=null)
			{
				CustomerAddress cadd = (CustomerAddress)customerDao.queryCustomerAdress(addid);
				session.setAttribute("customeraddress",cadd);
				
				if(cus.getPayments() == null)
				{
					return "addnewpaymentpage";
				}
				else
				{
					Payment p = cus.getPayments();
					model.addAttribute("cuspayment",p);
					return "customerpayment";
					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}
	
	@RequestMapping(value = "/continuepayment", method = RequestMethod.GET)
	public String customerPaymentGet(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		
		try
		{	//int payid = Integer.parseInt(request.getParameter("payid"));
			HttpSession session = request.getSession();
			if(session!=null)
			{
				Customer cus = (Customer)session.getAttribute("customerUser");
				float sum =0;
			
			if(cus!=null)
			{
				ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
				if(scart !=null)
				{
				
					ArrayList<ShoppingItem> sList = scart.getCartList();
					for (ShoppingItem shoppingItem : sList) 
					{
	                     sum = sum + (shoppingItem.getUnitPrice() * shoppingItem.getCount());             
					}
					model.addAttribute("sum", sum);
					model.addAttribute("customercart", sList);
					
					return "finalordersummery";
				}
				else
				{
					return "customeremptycart";
				}
			  }
			else
			{
				model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
				model.addAttribute("customer", new Customer());
				return "customerlogin";
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}
	
	@RequestMapping(value = "/continuepayment", method = RequestMethod.POST)
	public String customerPayment(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		
		try
		{	int payid = Integer.parseInt(request.getParameter("payid"));
			HttpSession session = request.getSession();
			Customer cus = (Customer)session.getAttribute("customerUser");
			float sum =0;
			
			if(cus!=null)
			{
				ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
				if(scart !=null)
				{
					Payment pay = (Payment)customerDao.queryCustomerPayment(payid);
					session.setAttribute("cuspay",pay);
					
					//model.addAttribute("cuspayment",pay);
				
				//	CustomerAddress add = (CustomerAddress)request.getAttribute("cusaddress");
				//	model.addAttribute("cusaddress", add);
				
				
					ArrayList<ShoppingItem> sList = scart.getCartList();
					for (ShoppingItem shoppingItem : sList) 
					{
	                     sum = sum + (shoppingItem.getUnitPrice() * shoppingItem.getCount());             
					}
					model.addAttribute("sum", sum);
					model.addAttribute("customercart", sList);
					return "finalordersummery";
				}
				else
				{
					return "customeremptycart";
				}
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}
	
	
	
	@RequestMapping(value = "/addnewpayment", method = RequestMethod.POST)
	public String customerNewPayment(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		
		try
		{	

			String cardname = request.getParameter("cardtype"); 
			String cardno = request.getParameter("cardno");
			int cvv = Integer.parseInt(request.getParameter("cvv"));
			String date = request.getParameter("expiry");
			
			HttpSession session = request.getSession();
			Customer cus = (Customer)session.getAttribute("customerUser");
			
			customerDao.queryCustomerNewPayment(cardname, cardno, cvv, date, cus);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return "error";
	}
	
	@RequestMapping(value = "/addnewpayment", method = RequestMethod.GET)
	public String customerNewPaymentGet(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false); 
		try{
			if(session!=null)
			{
				Customer cus = (Customer)session.getAttribute("customerUser");
			
				if(cus!=null)
				{
					return "addnewpaymentpage";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("customer", new Customer());
		return "customerlogin";
		
	}
	
	@RequestMapping(value = "/addnewaddress", method = RequestMethod.GET)
	public String customerNewAddress(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false); 
		try{
			if(session!=null)
			{
				Customer cus = (Customer)session.getAttribute("customerUser");
			
				if(cus!=null)
				{
					return "addnewcustomeraddress";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("customer", new Customer());
		return "customerlogin";
		
	}
	
	@RequestMapping(value = "/addnewaddress", method = RequestMethod.POST)
	public String customerNewAddressPost(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false); 
		try{
			if(session!=null)
			{
				Customer cus = (Customer)session.getAttribute("customerUser");
			
				if(cus!=null)
				{
					String streetname = request.getParameter("streetname");
					String city = request.getParameter("city");
					String state = request.getParameter("state");
					String country = request.getParameter("country");
					int zipcode = Integer.parseInt(request.getParameter("zipcode"));
					
					customerDao.queryAddNewCustomerAddress(cus, streetname,city,state,country,zipcode);
					
					return "redirect:/continuecheckout";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("customer", new Customer());
		return "customerlogin";
		
	}
	
	@RequestMapping(value = "/placefinalorder", method = RequestMethod.POST)
	public String customerFinalcheckout(Model model, HttpServletRequest request) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false); 
		try{
			if(session!=null)
			{
				Customer cus = (Customer)session.getAttribute("customerUser");
			
				if(cus!=null)
				{
					float sum = Float.parseFloat(request.getParameter("sum"));
					String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
					
					Orders o = customerDao.queryCustomerOrder(sum, timeStamp, cus);
					
					ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
					
					ArrayList<ShoppingItem> sList = scart.getCartList();
					for (ShoppingItem shoppingItem : sList) 
					{
	                     FoodMenu fm = foodDao.queryViewPerticularFoodItem(shoppingItem.getFoodid());
	                     
	                     customerDao.queryCustomerOrderDetails(fm, o, shoppingItem.getCount(), shoppingItem.getTotalperitem());
					}
					session.removeAttribute("cart");
					
					return "successfulorderplacement";
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("customer", new Customer());
		return "customerlogin";
		
	}
	
	@RequestMapping(value="/customerChangePassword" ,method=RequestMethod.GET)
	public String changePasswordForm(Model model,HttpServletRequest request) throws ServletException, IOException{
		
		try
		{
			HttpSession session = request.getSession(false);
			if(session!=null)
			{
				Customer id = (Customer)session.getAttribute("customerUser");
				if(id!=null)
				{
					String upass = id.getPassword();
					model.addAttribute("pass",upass);
					return "customerchangepassword";
				}
			}
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("c","<font color=red>Login before you try to access the pages</font>");
		model.addAttribute("customer", new Customer());
		return "customerlogin";
	}
	
	
	
	
	@RequestMapping(value="/customerChangePassword" ,method=RequestMethod.POST)
	public String changePasswordPost(Model model,HttpServletRequest request) throws ServletException, IOException{
		
		try
		{
			
			HttpSession session = request.getSession(); 
			Customer id = (Customer)session.getAttribute("customerUser");
			//String uname = id.getUserName();
			//int uid = id.getPid();

			//String role = id.getRoleType();
			String newPass = request.getParameter("password1");
			
			customerDao.queryUpdateCustomerPassword(newPass,id);
			System.out.println(id.getPassword());
			return "updatecustomerpassword";
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		String a ="<font color=red>Sorry, your password could not be updated. It will be fixed in our next release!! </font>";
		model.addAttribute("passerror",a);
		return "superadminloginpage";
	}
	
	
	@RequestMapping(value="/customerLogout" ,method=RequestMethod.GET)
	public String customerLogout(Model model, HttpServletRequest request) throws ServletException  {

			try {
				
				HttpSession session = request.getSession(false);
			//	Customer per = (Customer)session.getAttribute("customerUser");
				//session.setAttribute(null, "adminUser");
				//session.setAttribute(null, per);
				if(session!=null)
				{
				 session.removeAttribute("customerUser");
				 session.removeAttribute("cart");
				 session.removeAttribute("customeraddress");
				 session.removeAttribute("cuspay");
					 session.invalidate();
					 
					System.out.println(session);
					return "customersignout";	
				}
				else
				{
					return "error";
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		
		
		return "home";
	}
	
	@RequestMapping(value="/error" ,method=RequestMethod.GET)
	public String error(Model model, HttpServletRequest request) throws ServletException  {

			try {
				
				return "error";
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		
		
			return "error";
	}
	
	@RequestMapping(value="/customererror" ,method=RequestMethod.GET)
	public String customerError(Model model, HttpServletRequest request) throws ServletException  {

			try {
				
				return "customersignout";
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		
		
			return "customersignout";
	}
	
	@RequestMapping(value = "/orderhistory", method = RequestMethod.GET)
	public String customerOrderHistory(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "orderhistory";
		}
	
	@RequestMapping(value = "/reorder", method = RequestMethod.GET)
	public String customerReOrder(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "oneclickreorder";
		}
	
	@RequestMapping(value = "/orderplacement", method = RequestMethod.GET)
	public String customerReOrderSuccessfulOrderPlaced(Model model,HttpServletRequest request) throws ServletException, IOException {
		
			return "successfulorderplacement";
		}
}
