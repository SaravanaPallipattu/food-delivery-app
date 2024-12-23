package com.macfoods.dao;

import com.macfoods.dto.TotalCart;

public interface TotalCartDAO {

	int insertTotalCart(TotalCart totalcart);
	TotalCart checkCartIdPresent(int cartId);
	int UpdateTotalCart(int cartId,float totalprice,int totalquantity);
	int removeCart(int cartId);
}
