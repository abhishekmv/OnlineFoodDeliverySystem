package org.neu.webtools.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Abhishek
 *
 */
@Entity
@Table(name="FOODMENU")
public class FoodMenu implements java.io.Serializable, Comparable<FoodMenu> {
	
	@Id
    @GeneratedValue
    @Column(name="f_id", unique=true, nullable=false)
	private int f_id;
	
	@Column(name="foodName")
	private String foodName;
	
	@Column(name="cost")
	private double cost;
	
	@Column(name="spicyLevel")
	private String spicyLevel;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private String image;
	
	@ManyToOne
    @JoinColumn(name="cat_id")
	private FoodCategory foodCategory;
	
	@ManyToOne
    @JoinColumn(name="ftype_id")
	private FoodType foodType;
	
	@OneToOne(mappedBy="foodMenu", cascade=CascadeType.ALL)
	private OrderDetails orderDetails;
	
	@Column(name="enable_disable")
	private String enable_disable;
	
	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSpicyLevel() {
		return spicyLevel;
	}

	public void setSpicyLevel(String spicyLevel) {
		this.spicyLevel = spicyLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getEnable_disable() {
		return enable_disable;
	}

	public void setEnable_disable(String enable_disable) {
		this.enable_disable = enable_disable;
	}

	@Override
	public int compareTo(FoodMenu o) {
		// TODO Auto-generated method stub
		return (int)this.getCost()-(int)o.getCost();
	}

	

}
