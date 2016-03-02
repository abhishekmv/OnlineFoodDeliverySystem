package org.neu.webtools.cart;

public class ShoppingItem {
	
	   private int foodid;
	    private String foodName;
	    private int count;
	    private float unitPrice;
	    private float totalperitem;
	    private String image;
	    	    
		public int getFoodid() {
			return foodid;
		}
		public void setFoodid(int foodid) {
			this.foodid = foodid;
		}
		public String getFoodName() {
			return foodName;
		}
		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public float getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(float unitPrice) {
			this.unitPrice = unitPrice;
		}
		
		public float getTotalperitem() {
			return totalperitem;
		}
		public void setTotalperitem(float totalperitem) {
			this.totalperitem = totalperitem;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
	    
	    

}
