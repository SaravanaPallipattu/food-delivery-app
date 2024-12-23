package com.macfoods.dto;

public class TotalCart {
   
    private int userId;
    private int totalQuantity;
    private float totalPrice;
    private int cartId;
    
	
	
	public TotalCart(int userId, int totalQuantity, float totalPrice, int cartId) {
		super();
		
		this.userId = userId;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.cartId = cartId;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	
    
    
    
}
