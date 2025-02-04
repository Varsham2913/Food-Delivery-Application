package com.tap.model;

public class Menu {

	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private int price;
	private float ratings;
	private boolean isAvailable;
	private String imagePath;
	
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}


	public Menu(int menuId, int restaurantId, String itemName, String description, int price, 
			float ratings,boolean isAvailable, String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.ratings = ratings;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public float getRatings() {
		return ratings;
	}

	
	
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}


	public boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public String getImagePath() {
		return imagePath;
	}

	

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
	
}
