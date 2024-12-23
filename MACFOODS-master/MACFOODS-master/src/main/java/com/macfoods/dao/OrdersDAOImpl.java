package com.macfoods.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.Orders;


public class OrdersDAOImpl implements OrdersDAO {

	@Override
	public int insertOrder(Orders order) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into orders (user_id,restaurant_id,total_amount,status,payment_option)"
					 	+ " values (?,?,?,?,?)");
			  
			  pstmt.setInt(1, order.getUserId());
			  pstmt.setInt(2, order.getRestaurantId());
			  pstmt.setFloat(3, order.getTotalAmount());
			  pstmt.setString(4, order.getStatus());
			  pstmt.setString(5, order.getPaymentOption());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;
	}

	@Override
	public Orders getOrderById(int oid) {
		Orders order=null;
	    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    			requestConnection().prepareStatement("select * from orders where order_id=?");
	    
	      pstmt.setInt(1, oid);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) {
	      order=new Orders(res.getInt(1),
	    		  res.getInt(2),
	    		  res.getInt(3),
	    		  res.getFloat(4),
	    		  res.getString(5),
	    		  
	    		  res.getString(7));
	      
	      }
	      else {
	    	  System.out.println("no orders found");
	      }
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return order;
	}

	@Override
	public int updateOrder(int oid, String status) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("update orders "
							+ "set status=? where order_id=?");
			
			pstmt.setString(1, status);
			pstmt.setInt(2, oid);
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
			
		return 0;		}

}
