package com.macfoods.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.Restaurant;



public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public List<Restaurant> getRestaurants() {
		
        List<Restaurant> al=new ArrayList<Restaurant>();
		
        try {
			Statement stmt=ConnectorFactory.requestConnection()
			        .createStatement();
			
		ResultSet res=	stmt.executeQuery("select * from restaurant");
	    
		while(res.next()) {
		  
			Restaurant rest=new Restaurant(res.getInt(1),
		    		  res.getString(2),
		    		  res.getString(3),
		    		  res.getInt(4),
		    		  res.getBoolean(5),
		    		  res.getFloat(6),
		    		  res.getString(7),
		    		  res.getString(8));
			
			al.add(rest);
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
	}

	@Override
	public Restaurant getRestaurantByID(int restId) {
		Restaurant rest=null;
	    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    			requestConnection().prepareStatement("select * from restaurant where restaurant_id=?");
	    
	      pstmt.setInt(1, restId);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) {
	      rest=new Restaurant(res.getInt(1),
	    		  res.getString(2),
	    		  res.getString(3),
	    		  res.getInt(4),
	    		  res.getBoolean(5),
	    		  res.getFloat(6),
	    		  res.getString(7),res.getString(8));
	      }
	      else {
	    	  System.out.println("no restaurant found");
	      }
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return rest;
	}

	@Override
	public int insertRestaurant(Restaurant rest) {
		 try {
				
			  PreparedStatement pstmt=ConnectorFactory.requestConnection()
			  .prepareStatement("insert into restaurant (name,cuisine_type,delivery_time,isactive,ratings,imgpath)"
					 	+ " values (?,?,?,?,?,?)");
			  
			  pstmt.setString(1, rest.getName());
			  pstmt.setString(2, rest.getCuisineType());
			  pstmt.setInt(3, rest.getDeliveryTime());
			  pstmt.setBoolean(4, rest.isActive());
			  pstmt.setFloat(5, rest.getRatings());
			  pstmt.setString(6, rest.getImgPath());
			  
			 return pstmt.executeUpdate();
		} 
		  
		catch (Exception e) {
			e.printStackTrace();
		}
		  
		  
			
			return 0;
	}
	

	@Override
	public int updateRestaurantById(int restaurantId, float ratings) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("update restaurant "
							+ "set ratings=? where restaurant_id=?");
			
			pstmt.setFloat(1, ratings);
			pstmt.setInt(2, restaurantId);
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
			
		return 0;	
	}

	@Override
	public int deleteRestaurantByID(int id) {
		
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("delete from restaurant "
							+ "where restaurant_id=?");
			
			pstmt.setInt(1, id);
			
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return 0;

	}

	@Override
	public List<Restaurant> getRestaurantsByLocation(String cityName) {
		
			
	        List<Restaurant> al=new ArrayList<Restaurant>();
			
	        try {
				PreparedStatement pstmt=ConnectorFactory.requestConnection()
				        .prepareStatement("select * from restaurant where address=?");
				pstmt.setString(1, cityName);
				
			ResultSet res=	pstmt.executeQuery();
		    
			while(res.next()) {
			  
				Restaurant rest=new Restaurant(res.getInt(1),
			    		  res.getString(2),
			    		  res.getString(3),
			    		  res.getInt(4),
			    		  res.getBoolean(5),
			    		  res.getFloat(6),
			    		  res.getString(7),
			    		  res.getString(8));
				
				al.add(rest);
				
				
			}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return al;
	}

	@Override
	public List<Restaurant> getTopRestaurants(String cityName) {
		List<Restaurant> al=new ArrayList<Restaurant>();
		
        try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
			        .prepareStatement("select * from restaurant where address=? order by ratings desc");
			pstmt.setString(1, cityName);
			
		ResultSet res=	pstmt.executeQuery();
	    
		while(res.next()) {
		  
			Restaurant rest=new Restaurant(res.getInt(1),
		    		  res.getString(2),
		    		  res.getString(3),
		    		  res.getInt(4),
		    		  res.getBoolean(5),
		    		  res.getFloat(6),
		    		  res.getString(7),
		    		  res.getString(8));
			
			al.add(rest);
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;

	}

}
