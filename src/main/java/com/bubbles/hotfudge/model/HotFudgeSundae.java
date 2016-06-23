package com.bubbles.hotfudge.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HotFudgeSundae {

	private String restaurantName;
	private boolean brownie;
	private double price;
	private int id;
	private static final int RESTAURANT_NAME_CHAR_LIMIT = 70;
	
	@JsonCreator
	public HotFudgeSundae(@JsonProperty("restaurantName") String restaurantName, 
			@JsonProperty("brownie") boolean brownie, @JsonProperty("price") double price) {
		this.restaurantName = restaurantName;
		this.brownie = brownie;
		this.price = price;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public void setBrownie(boolean brownie) {
		this.brownie = brownie;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public boolean getBrownie() {
		return brownie;
	}
	
	public double getPrice() {
		return price;
	}
	
	public static int getRestaurantNameCharLimit() {
		return RESTAURANT_NAME_CHAR_LIMIT;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (brownie ? 1231 : 1237);
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotFudgeSundae other = (HotFudgeSundae) obj;
		if (brownie != other.brownie)
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return restaurantName + ":" + brownie + ":" + price;
	}
	
}
