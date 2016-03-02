package org.neu.webtools.cart;

import java.util.ArrayList;


	public class ShoppingCart {
		
		private ArrayList<ShoppingItem> cartList;
		

	    public ShoppingCart() {
	        this.cartList = new ArrayList<ShoppingItem>();
	    }

	    public ArrayList<ShoppingItem> getCartList() {
	        return cartList;
	    }
	    
	    public ShoppingItem addItemToCart(){
	        ShoppingItem item = new ShoppingItem();
	        this.cartList.add(item);
	        return item;
	        
	    }
	    
	    public void deleteItemFromCart(ShoppingItem deleteItem){
	        this.cartList.remove(deleteItem);
	        
	    }
	}


