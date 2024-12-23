package com.macfoods.dto;

public class Restaurant {

	
	private int restaurantId;
	private String name;
	private String cuisineType;
	private int deliveryTime;
	private boolean isActive;
	private float ratings;
	private String imgPath;
    private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Restaurant(int restaurantId, String name, String cuisineType, int deliveryTime, boolean isActive,
			float ratings, String imgPath,String address) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imgPath = imgPath;
		this.address=address;
	}
	
	public Restaurant(String name, String cuisineType, int deliveryTime, boolean isActive,
			float ratings, String imgPath,String address) {
		
		super();
		
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.isActive = isActive;
		this.ratings = ratings;
		this.imgPath = imgPath;
		this.address=address;
	}
	
	
	public Restaurant() {
		super();
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

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return restaurantId+" "+ name+" "+cuisineType+" "
				+deliveryTime+" " +isActive+ " "+ ratings+" "+imgPath+" "+address;
	}
	
	

	
	
}
