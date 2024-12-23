package com.macfoods.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.ItemsInCart;
import com.macfoods.dto.User;

public class ItemsInCartDAOImpl implements ItemsInCartDAO {

	@Override
	public int insertItemsInCart(ItemsInCart items) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into itemsincart (cartid,menuid,quantity,subtotal)"
					 	+ " values (?,?,?,?)");
			  
			  
			  pstmt.setInt(1, items.getCartId());
			   
			  pstmt.setInt(2, items.getMenuId());
			  pstmt.setInt(3,items.getQuantity());
			  pstmt.setFloat(4, items.getSubtotal());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;
		}
	

	@Override
	public ItemsInCart isItemAvailableInCart(int cartId,int menuId) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from itemsincart where cartid=? and menuid=? ");
			
			pstmt.setInt(1, cartId);
			pstmt.setInt(2, menuId);
			
			
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			
			
			return new ItemsInCart(res.getInt(2),res.getInt(3),res.getInt(4),res.getFloat(5));
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}


	@Override
	public List<ItemsInCart> getItemsInCartByCartId(int cartId) {
    List<ItemsInCart> al=new ArrayList<ItemsInCart>();
		
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from itemsincart where cartid=?");
			
			
			pstmt.setInt(1, cartId);
			
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			
			
			al.add(new ItemsInCart(res.getInt(2),res.getInt(3),res.getInt(4),res.getFloat(5)));
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
	}


	@Override
	public int updateMnuQuantity(int cartId, int menuId,int quantity,float subtotal) {
		try {
			
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("update itemsincart set quantity=?,subtotal=? where cartid=? and menuid=? ");
			  
			  
			  pstmt.setInt(1, quantity);
			   pstmt.setFloat(2, subtotal);
			  pstmt.setInt(3, cartId);
			  pstmt.setInt(4,menuId);
			  
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
	   return 0;
	
	}


	@Override
	public int removeMenuByCartId(int cartId,int menuId) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("delete from itemsincart "
							+ "where cartid=? and menuid=?");
			
			pstmt.setInt(1, cartId);
			pstmt.setInt(2, menuId);
			
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return 0;
	}


	@Override
	public int removeAllItemsByCartId(int cartId) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("delete from itemsincart "
							+ "where cartid=?");
			
			pstmt.setInt(1, cartId);
			
			
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return 0;
		
	}

}
