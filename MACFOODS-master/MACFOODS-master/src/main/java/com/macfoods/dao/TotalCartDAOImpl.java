package com.macfoods.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.TotalCart;

public class TotalCartDAOImpl implements TotalCartDAO{

	
	
	
	
	
	
	@Override
	public int insertTotalCart(TotalCart totalcart) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into totalcart (userid,totalquantity,totalprice,cartid)"
					 	+ " values (?,?,?,?)");
			  
			  
			  pstmt.setInt(1, totalcart.getUserId());
			   
			  pstmt.setInt(2, totalcart.getTotalQuantity());
			  
			  pstmt.setFloat(3, totalcart.getTotalPrice());
			   
			  pstmt.setInt(4, totalcart.getCartId());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;
		}

	@Override
	public TotalCart checkCartIdPresent(int cartId) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("select * from totalcart where cartid=?");
			  
			  
			  pstmt.setInt(1, cartId);
			  
			ResultSet res= pstmt.executeQuery();
			
			while(res.next()) {
				
				return new TotalCart(res.getInt(1),res.getInt(2),res.getFloat(3),res.getInt(4));
			}
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return null;
		}

	@Override
	public int UpdateTotalCart(int cartId,float totalprice,int totalquantity) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("update totalcart "
							+ "set totalquantity=?,totalprice=? where cartid=?");
			
			pstmt.setInt(1, totalquantity);
			pstmt.setFloat(2, totalprice);
			pstmt.setInt(3, cartId);
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
			
		return 0;	
			
			
		}

	@Override
	public int removeCart(int cartId) {
		
		try {
		PreparedStatement pstmt=ConnectorFactory.requestConnection()
				.prepareStatement("delete from totalcart "
						+ "where cartid=?");
		
		pstmt.setInt(1, cartId);
		
		
		
	 return pstmt.executeUpdate();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}

	
	
	
	return 0;
}
	
	 
	
	}


