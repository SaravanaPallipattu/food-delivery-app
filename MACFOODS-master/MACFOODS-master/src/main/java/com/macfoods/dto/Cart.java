package com.macfoods.dto;

public class Cart {
   
	private int cartId;
	
	private int restId;
	

	private int userId;
	
	public Cart(int cartId, int restId, int userId) {
		super();
		this.cartId = cartId;
	
		this.restId = restId;
	
		
		this.userId = userId;
	}

	public Cart(int restId, int userId) {
		super();
		
		this.restId = restId;
		
		
		this.userId = userId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	
	

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
