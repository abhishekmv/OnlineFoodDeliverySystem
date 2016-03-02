package org.neu.webtools.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FOODCATEGORY")
public class FoodCategory implements java.io.Serializable {
	
	@Id
    @GeneratedValue
	@Column(name="CAT_ID", unique=true, nullable=false)
	private int cat_id;
	
	@Column(name="catergoryName")
	private String catergoryName;
	
	@OneToMany(mappedBy="foodCategory")
	private Set<FoodMenu> foodMenus;

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCatergoryName() {
		return catergoryName;
	}

	public void setCatergoryName(String catergoryName) {
		this.catergoryName = catergoryName;
	}

	public Set<FoodMenu> getFoodMenus() {
		return foodMenus;
	}

	public void setFoodMenus(Set<FoodMenu> foodMenus) {
		this.foodMenus = foodMenus;
	}
	
	

}
