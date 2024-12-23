package com.macfoods.dao;

import java.util.List;

import com.macfoods.dto.OrderHistory;

public interface OrderHistoryDAO {

	
	int insertOrderHistory(OrderHistory oh);
	List<OrderHistory> getOrdersByUserId(int uid);
	int updateOrderHistory(int ohid,String status);
}
