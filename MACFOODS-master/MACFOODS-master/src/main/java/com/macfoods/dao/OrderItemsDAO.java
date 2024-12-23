package com.macfoods.dao;

import java.util.List;

import com.macfoods.dto.OrderItems;


public interface OrderItemsDAO {
    int insertOrderItem(OrderItems oi);
    List<OrderItems> getOrderItemsByOrderId(int oi);
    
}
