package com.macfoods.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.Cart;

public class CartDAOImpl implements CartDAO{

	@Override
	public int getCartIdByUserIdAndRestId(int userId,int restId) {
		
		try {
			
		PreparedStatement pstmt=ConnectorFactory.requestConnection().prepareStatement("select * from cart where userid=? and restid=?");
		pstmt.setInt(1, userId);
		pstmt.setInt(2, restId);
		
		  ResultSet res= pstmt.executeQuery();
		  
		  while(res.next()) {
			  
			  return res.getInt(1);
		  }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int insertCart(Cart c) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into cart (restid,userid)"
					 	+ " values (?,?)");
			  
			  
			  pstmt.setInt(1, c.getRestId());
			   
			  pstmt.setInt(2, c.getUserId());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;
		}

	@Override
	public Cart getCartByUserId(int userId) {
		try {
			
			PreparedStatement pstmt=ConnectorFactory.requestConnection().prepareStatement("select * from cart where userid=?");
			pstmt.setInt(1, userId);
			
			
			  ResultSet res= pstmt.executeQuery();
			  
			  while(res.next()) {
				  
				  return new Cart(res.getInt(1),res.getInt(2),res.getInt(3));
			  }
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
	}

	@Override
	public int removeCartByCartId(int cartId) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("delete from cart "
							+ "where cartid=?");
			
			pstmt.setInt(1, cartId);
			
			
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return 0;
	}
		
	

}
