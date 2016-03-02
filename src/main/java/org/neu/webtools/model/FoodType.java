package org.neu.webtools.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="FOODTYPE")
public class FoodType implements java.io.Serializable{
	
	@Id
    @GeneratedValue
    @Column(name="ftype_id", unique=true, nullable=false)
	private int ftype_id;
	
	@Column(name="foodTypeName")
	private String foodTypeName;
	
	@OneToMany(mappedBy="foodType")
	private Set<FoodMenu> foodMenus;

	public int getFtype_id() {
		return ftype_id;
	}

	public void setFtype_id(int ftype_id) {
		this.ftype_id = ftype_id;
	}

	public String getFoodTypeName() {
		return foodTypeName;
	}

	public void setFoodTypeName(String foodTypeName) {
		this.foodTypeName = foodTypeName;
	}

	public Set<FoodMenu> getFoodMenus() {
		return foodMenus;
	}

	public void setFoodMenus(Set<FoodMenu> foodMenus) {
		this.foodMenus = foodMenus;
	}

	
	

}
