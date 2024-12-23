package com.macfoods.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.macfoods.dao.UserDAO;
import com.macfoods.dto.Cart;
import com.macfoods.dto.ItemsInCart;
import com.macfoods.dto.Menu;
import com.macfoods.dto.Restaurant;
import com.macfoods.dto.TotalCart;
import com.macfoods.dao.CartDAO;
import com.macfoods.dao.CartDAOImpl;
import com.macfoods.dao.ItemsInCartDAO;
import com.macfoods.dao.ItemsInCartDAOImpl;
import com.macfoods.dao.TotalCartDAO;
import com.macfoods.dao.TotalCartDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserCart extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      HttpSession session=request.getSession();
	       
	      Restaurant  res=(Restaurant)session.getAttribute("RestaurantDetails");
	     ArrayList<Menu>   menu=(ArrayList<Menu>)session.getAttribute("MenuDetails");
	        
	          
	         UserDAO user=(UserDAO)session.getAttribute("user");
		

       
      int userId=(int)session.getAttribute("userId");
      CartDAO cart=new CartDAOImpl();
      ItemsInCartDAO items=new ItemsInCartDAOImpl();
      TotalCartDAO totalcart=new TotalCartDAOImpl();
      
      Cart cartdetails=cart.getCartByUserId(userId);
      
      
      
      if(cartdetails!=null && !(cartdetails.getRestId()==res.getRestaurantId())) {
    	  
    	  totalcart.removeCart(cartdetails.getCartId());
    	  items.removeAllItemsByCartId(cartdetails.getCartId());
    	  cart.removeCartByCartId(cartdetails.getCartId());
    	  
      }
      
      
      
      
      
      
      
      String arr=request.getParameter("itemNameArray");
      
      String totalCart=request.getParameter("totalCartCount");
     
      int totalCartCount=Integer.parseInt(totalCart);
      float totalprice=0;
      String[] itemArray=arr.split(",");
      
      
      int cartId=cart.getCartIdByUserIdAndRestId(userId, res.getRestaurantId());
      
      if(cartId==0) {
    	  
    	 cart.insertCart(new Cart(res.getRestaurantId(),userId));
    	cartId= cart.getCartIdByUserIdAndRestId(userId, res.getRestaurantId());
      }
                
      
     
     
    
      
      for(int i=1;i<itemArray.length;i++)
      {
    	  for(Menu m:menu) {
    		  
    		  if(itemArray[i].equalsIgnoreCase(m.getItemName())) {
    			 
    			  
    			  
    			  float price=m.getPrice();
    			  int quantity=Integer.parseInt(request.getParameter(itemArray[i]));
    			  float subtotal=price*quantity;
    			  totalprice+=subtotal;
    			  ItemsInCart itemsincart=items.isItemAvailableInCart(cartId, m.getMenuId());
    			  
    			  if(itemsincart!=null) {
    				  
    				 
    				  items.updateMnuQuantity(cartId, m.getMenuId(), quantity+itemsincart.getQuantity(),subtotal+itemsincart.getSubtotal());
    				  
    				  
    			  }
    			  else {
    				  
    				  items.insertItemsInCart(new ItemsInCart(cartId,m.getMenuId(),quantity,subtotal));
    				  
    			  }
    			  
    			    
    		  }
    	  }
    	  
    	  
      }
      
      
      
           TotalCart tCart= totalcart.checkCartIdPresent(cartId);
           
           if(tCart==null) {
        	   totalcart.insertTotalCart(new TotalCart(userId, totalCartCount, totalprice, cartId));
           }
           else {
        	   
        	   totalcart.UpdateTotalCart(cartId,totalprice+tCart.getTotalPrice() , totalCartCount+tCart.getTotalQuantity());
        	   
           }
     

           
           
	         response.sendRedirect("user-cart.jsp");
		
	}
	
	
	
	

}
