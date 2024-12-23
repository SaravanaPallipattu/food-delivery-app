package com.macfoods.dao;

import java.util.List;

import com.macfoods.dto.ItemsInCart;


public interface ItemsInCartDAO {
	 int insertItemsInCart(ItemsInCart items);
	 ItemsInCart isItemAvailableInCart(int cartId,int menuId);
	 List<ItemsInCart> getItemsInCartByCartId(int cartId);
	 int updateMnuQuantity(int cartId,int menuId,int quantity,float subtotal);
	 int removeMenuByCartId(int cartId,int menuId);
	 int removeAllItemsByCartId(int cartId);
}
