package com.bubbles.hotfudge;

public class HotFudgeSundae {

	private String restaurantName;
	private boolean brownie;
	private double price;
	private int id;

	public HotFudgeSundae(String restaurantName, boolean brownie, double price) {
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

	@Override
	public String toString() {
		return restaurantName + ":" + brownie + ":" + price;
	}
	
}
