package com.tap.model;

public class Restaurant {

	
	private int restaurantId;
	private String name;
	private String address;
	private String phone;
	private double rating;
	private String cusineType;
	private boolean isActive;
	private int deliveryTime;
	private int adminUserId;
	private String imagePath;
	
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}


	public Restaurant(int restaurantId, String name, String address, String phone, double rating, String cusineType,
			boolean isActive, int deliveryTime, int adminUserId, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cusineType = cusineType;
		this.isActive = isActive;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.imagePath = imagePath;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getCusineType() {
		return cusineType;
	}


	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public boolean getisActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public int getdeliveryTime() {
		return deliveryTime;
	}


	public void setEta(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public int getAdminUserId() {
		return adminUserId;
	}


	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

	@Override
	public String toString() {
		
		return restaurantId+" "+name+" "+address+" "+phone+" "+rating+" "+cusineType+
				" "+isActive+" "+deliveryTime+" "+adminUserId+" "+imagePath;
	}
	
}
