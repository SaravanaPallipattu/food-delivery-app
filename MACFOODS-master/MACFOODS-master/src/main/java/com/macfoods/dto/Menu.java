package com.macfoods.dto;

public class Menu {

	private int menuId;
	private String itemName;
	private String description;
	private float price;
	private boolean isAvailable;
	private String imagePath;
	private int restaurantId;
	
	
	public Menu(int menuId, String itemName, String description, float price, boolean isAvailable, String imagePath,
			int restaurantId) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
		this.restaurantId = restaurantId;
	}
	
	public Menu(String itemName, String description, float price, boolean isAvailable, String imagePath,
			int restaurantId) {
		super();
		
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
		this.restaurantId = restaurantId;
	}
	
	public Menu() {
		super();
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return menuId+ " "+ itemName+" "+ description+ " "+ price +" "+
				isAvailable +" "+imagePath+ " " +restaurantId;
	}
	
	
	
	
	
}
