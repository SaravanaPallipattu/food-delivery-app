package com.macfoods.dao;

import com.macfoods.dto.Orders;

public interface OrdersDAO {

	 int insertOrder(Orders order);
	 Orders getOrderById(int oid);
	 int updateOrder(int oid,String status);
}
