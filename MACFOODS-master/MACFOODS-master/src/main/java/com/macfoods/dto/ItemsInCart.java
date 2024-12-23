package com.macfoods.dto;

public class ItemsInCart {

	
    private int cartId;
	
	private int menuId;
	

	private int quantity;
	private float subtotal;
	
	
	public ItemsInCart(int cartId, int menuId, int quantity, float subtotal) {
		super();
		this.cartId = cartId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	
	
	
	
}
