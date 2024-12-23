package com.macfoods.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.OrderItems;


public class OrderItemsDAOImpl implements OrderItemsDAO {

	@Override
	public int insertOrderItem(OrderItems oi) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into order_items (order_id,menu_id,quantity,subtotal)"
					 	+ " values (?,?,?,?)");
			  
			  pstmt.setInt(1, oi.getOrderId());
			  pstmt.setInt(2, oi.getMenuId());
			  pstmt.setInt(3, oi.getQuantity());
			  pstmt.setFloat(4, oi.getSubTotal());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;

	}

	@Override
	public List<OrderItems> getOrderItemsByOrderId(int oid) {
		
List<OrderItems> al=new ArrayList<OrderItems>();
		
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from order_items where order_id=?");
			
			pstmt.setInt(1, oid);
			
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			OrderItems oi=new OrderItems(res.getInt(1),
					res.getInt(2),
					res.getInt(3),
					res.getInt(4),
					res.getFloat(5));
			
			al.add(oi);
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
	
	}
      
}
