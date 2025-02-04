package com.tap.model;

public class CartItem {

	private int menuId;
	private int restaurantId;
	private String name;
	private int price;
	private int quantity;
	private String imagePath;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(int menuId,int restaurantId, String name, int price, int quantity,String imagePath) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imagePath=imagePath;
	}

	

	public int getMenuId() {
		return menuId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "[ "+menuId+", "+restaurantId+", "+name+", "+price+","+quantity+" ]";
	}
	
	
	
}
