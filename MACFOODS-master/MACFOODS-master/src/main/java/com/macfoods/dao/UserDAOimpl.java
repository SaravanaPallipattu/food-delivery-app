package com.macfoods.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.macfoods.connector.ConnectorFactory;
import com.macfoods.dto.User;

public class UserDAOimpl implements UserDAO{

	@Override
	public int insertUser(User user) {

	    
	  try {
		
		  PreparedStatement pstmt=ConnectorFactory.requestConnection()
		  .prepareStatement("insert into user (username,password,email,mobile)"
				 	+ " values (?,?,?,?)");
		  
		  pstmt.setString(1, user.getUserName());
		  pstmt.setString(2, user.getPassword());
		  pstmt.setString(3, user.getEmail()); 
		  pstmt.setString(4, user.getMobile());
		  
		 return pstmt.executeUpdate();
	} 
	  
	catch (Exception e) {
		e.printStackTrace();
	}
	  
	  
		
		return 0;
	}
	
	@Override
	public String getPwdByEmail(String email) {
		
	    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    			requestConnection().prepareStatement("select * from user where email=?");
	    
	      pstmt.setString(1, email);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) {
	          
	    	  return  res.getString(5);
	      }
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return "";
	}
	
	@Override
	public List<User> getUsers() {
		List<User> al=new ArrayList<User>();
		
		try {
			Statement stmt=ConnectorFactory.requestConnection()
			        .createStatement();
			
		ResultSet res=	stmt.executeQuery("select * from user");
	    
		while(res.next()) {
		  
			User user=new User(res.getInt(1),
					res.getString(2),
					res.getString(3),
					res.getString(4),
					res.getString(5),
					res.getString(6),
					res.getString(7));
			
			al.add(user);
			
			
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return al;
	}
	
	@Override
	public int updateUserById(int userId,String address) {
		
	try {
		PreparedStatement pstmt=ConnectorFactory.requestConnection()
				.prepareStatement("update user "
						+ "set address=? where user_id=?");
		
		pstmt.setString(1, address);
		pstmt.setInt(2, userId);
		
	 return pstmt.executeUpdate();
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
		
	return 0;	
		
		
	}
	
	@Override
	public int deleteUserByID(int id) {
		
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("delete from user "
							+ "where user_id=?");
			
			pstmt.setInt(1, id);
			
			
		 return pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return 0;
	}

	@Override
	public boolean isEmailExist(String email) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("select count(email) from user where email=? ");
			
			pstmt.setString(1, email);
			
			   ResultSet res=pstmt.executeQuery();
			    res.next();
			    if(res.getInt(1)>=1) {
			    	 return true;
			    }
			    
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return false;
	}

	@Override
	public boolean isMobileExist(String mobile) {
		try {
			PreparedStatement pstmt=ConnectorFactory.requestConnection()
					.prepareStatement("select count(mobile) from user where mobile=? ");
			
			pstmt.setString(1, mobile);
			
			   ResultSet res=pstmt.executeQuery();
			    res.next();
			    if(res.getInt(1)>=1) {
			    	 return true;
			    }
			    
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		
		
		
		return false;

	}

	@Override
	public String getUsernameByEmail(String email) {
	    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    			requestConnection().prepareStatement("select * from user where email=?");
	    
	      pstmt.setString(1, email);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) {
	          
	    	  return  res.getString(2);
	      }
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return "";
	}

	@Override
	public int getUserIdByEmail(String email) {
    try {
			
	    	PreparedStatement pstmt=ConnectorFactory.
	    			requestConnection().prepareStatement("select * from user where email=?");
	    
	      pstmt.setString(1, email);
	      
	      ResultSet res=pstmt.executeQuery();
	      
	      if(res.next()) {
	          
	    	  return  res.getInt(1);
	      }
	    	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
