package org.neu.webtools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.neu.webtools.cart.ShoppingCart;
import org.neu.webtools.cart.ShoppingItem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShoppingCartUpdatesController {
	
	@RequestMapping(value = "/mycart", method = RequestMethod.GET)
	public String myCartGet(Locale locale, Model model, HttpServletRequest request) {
		
		 float sum = 0;
		 
		 try{
			 HttpSession session = request.getSession();
	            ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
	            
	            
	            if(scart==null)
	            {
	            	return "emptycart";
	            }
	            else{
	            ArrayList<ShoppingItem> sList = scart.getCartList();
	            if (sList.size() <= 0) {
	                
	            	return "emptycart";
	            	
	            } else {
	            	
	            	 for (ShoppingItem shoppingItem : sList) {
	                     sum = sum + (shoppingItem.getUnitPrice() * shoppingItem.getCount());
	                     
	            	 }
	            	 model.addAttribute("sum", sum);
	            	model.addAttribute("cartitem",sList);
	            	return "mycartpage";
	            
	            }
	            }
			 
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
		 
		return "mycartpage";
		
	}
	
	@RequestMapping(value = "/mycart", method = RequestMethod.POST)
	public String myCartPost( Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			HttpSession session = request.getSession();
			ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
			
			 //String productsType = request.getParameter("productType");
		    //    String url = null;
		        if (scart == null) {
		            //this.session = request.getSession();
		            ShoppingCart sCart = new ShoppingCart();
		            session.setAttribute("cart", sCart);
		        }
		        
		       // ArrayList<ShoppingItem> sList = scart.getCartList();
		        
		        
		        String type = request.getParameter("cartOpType");
		        int id = Integer.parseInt(request.getParameter("foodid"));
		        Integer cnt = null;
		        Float unitprice = null;
		        if ("update".equals(type)) {
		            cnt = Integer.parseInt(request.getParameter("fooditemCount"));
		            unitprice = Float.parseFloat(request.getParameter("foodunitcost"));
		        }

		        if ("add".equals(type)) {
		            addToShoppingCart(request, response);
		            return"redirect:/mycart";
		        } else if ("update".equals(type) && cnt < 0) {
		            return"error";
		           
		        } else if ("update".equals(type) && cnt == 0) {
		            deleteItems(request, response,id);
		            return"redirect:/mycart";
		        } else if ("update".equals(type)) {
		            updateCart(request, response, cnt,unitprice);
		            return"redirect:/mycart";
		        }
		      
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/plist";
	}
	
	@RequestMapping(value = "/mycartdelete", method = RequestMethod.GET)
	public String myCartDelete( Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			HttpSession session = request.getSession();
			ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
		    ArrayList<ShoppingItem> sList = scart.getCartList();
		        
			String opType = request.getParameter("cartOpType");
			int id = Integer.parseInt(request.getParameter("productId"));
			if ("delete".equals(opType)) {
	            deleteItems(request, response,id);
	            
	            if(sList.isEmpty())
	            {
	            	return "emptycart";
	            }
	            else
	            {
	            	return "redirect:/mycart";
	            }
	            
	        } else {
	            return "error";
	        }

		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/plist";
	}
	
	
	 private void addToShoppingCart(HttpServletRequest request, HttpServletResponse response) {
	       
		 HttpSession session = request.getSession();
		 ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
	        ShoppingItem item = null;
	        boolean alreadyPresent = false;
	        ArrayList<ShoppingItem> sList = scart.getCartList();

	        for (ShoppingItem shoppingItem : sList) {
	            if (Integer.parseInt(request.getParameter("foodid")) == shoppingItem.getFoodid()) {
	                item = shoppingItem;
	                alreadyPresent = true;
	                break;
	            }
	        }

	        if (alreadyPresent) {
	            item.setCount(item.getCount() + 1);
	            item.setTotalperitem(item.getCount()*item.getUnitPrice());
	        } else {
	            item = scart.addItemToCart();
	            item.setCount(1);
	            item.setFoodid(Integer.parseInt(request.getParameter("foodid")));
	            item.setFoodName(request.getParameter("foodName"));
	            item.setUnitPrice(Float.parseFloat(request.getParameter("foodUnitPrice")));
	            item.setTotalperitem(Float.parseFloat(request.getParameter("foodUnitPrice")));
	            item.setImage(request.getParameter("foodImage"));
	        }



	    }

	    private void deleteItems(HttpServletRequest request, HttpServletResponse response,int pid) {
	        
	    	

	        HttpSession session = request.getSession();
	        ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
	        ArrayList<ShoppingItem> sList = scart.getCartList();

	        for (Iterator<ShoppingItem> it = sList.iterator(); it.hasNext();) {
	            ShoppingItem shoppingItem = it.next();

	            if (shoppingItem.getFoodid() == pid) {
	                it.remove();
	                break;
	            }

	        }

	        //String userPath = request.getServletPath();

	       // String url = "/Cart";
	        try {
	            //request.getRequestDispatcher(url).forward(request, response);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }

	    }

	    private void updateCart(HttpServletRequest request, HttpServletResponse response, Integer cnt, Float unitPrice) {
	       
	    	Integer pid = Integer.parseInt(request.getParameter("foodid"));

	        HttpSession session = request.getSession();
	        ShoppingCart scart = (ShoppingCart) session.getAttribute("cart");
	        ArrayList<ShoppingItem> sList = scart.getCartList();
	        for (ShoppingItem shoppingItem : sList) {
	            
	        }
	        for (Iterator<ShoppingItem> it = sList.iterator(); it.hasNext();) {
	            ShoppingItem shoppingItem = it.next();

	            if (shoppingItem.getFoodid() == pid) {
	                if (shoppingItem.getCount() == cnt) {
	                    break;
	                } else {
	                    shoppingItem.setCount(cnt);
	                    shoppingItem.setTotalperitem(cnt*unitPrice);
	                }
	                break;
	            }

	        }

	        //String userPath = request.getServletPath();

	       // String url = "/Cart";
	        try {
	          //  request.getRequestDispatcher(url).forward(request, response);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	

}
