package com.macfoods.dao;

import com.macfoods.dto.Cart;

public interface CartDAO {
    int getCartIdByUserIdAndRestId(int userId,int restId);
    int insertCart(Cart c);
    Cart getCartByUserId(int userId);
    
    int removeCartByCartId(int cartId);
}
