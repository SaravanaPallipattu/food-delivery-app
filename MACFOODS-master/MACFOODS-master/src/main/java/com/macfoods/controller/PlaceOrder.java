package com.macfoods.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.macfoods.dao.CartDAO;
import com.macfoods.dao.CartDAOImpl;
import com.macfoods.dao.ItemsInCartDAO;
import com.macfoods.dao.ItemsInCartDAOImpl;
import com.macfoods.dao.OrderHistoryDAO;
import com.macfoods.dao.OrderHistoryDAOImpl;
import com.macfoods.dao.OrderItemsDAO;
import com.macfoods.dao.OrderItemsDAOImpl;
import com.macfoods.dao.TotalCartDAO;
import com.macfoods.dao.TotalCartDAOImpl;
import com.macfoods.dao.UserDAO;
import com.macfoods.dto.Cart;
import com.macfoods.dto.ItemsInCart;
import com.macfoods.dto.OrderHistory;
import com.macfoods.dto.OrderItems;
import com.macfoods.dto.TotalCart;

import jakarta.servlet.http.HttpSession;

public class PlaceOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HttpSession session=request.getSession();
		 
		 UserDAO user=(UserDAO)session.getAttribute("user");
		 
		 int userId=(int)session.getAttribute("userId");
	      CartDAO cart=new CartDAOImpl();
	      ItemsInCartDAO items=new ItemsInCartDAOImpl();
	      TotalCartDAO totalcart=new TotalCartDAOImpl();
	      
	    Cart cartdetails=cart.getCartByUserId(userId);
	    
	    int  cartId=cartdetails.getCartId();
	      
	    int restId=cartdetails.getRestId();  
	    
	    TotalCart tCart=totalcart.checkCartIdPresent(cartId);
	    
	    float totalPrice=tCart.getTotalPrice();
	    
	    int totalQuantity=tCart.getTotalQuantity();
	    
	    
	    ArrayList<ItemsInCart> orderedItems=(ArrayList<ItemsInCart>) items.getItemsInCartByCartId(cartId);
	    
	    //insert cart into order history
	    
	      OrderHistoryDAO oh=new OrderHistoryDAOImpl();
	      oh.insertOrderHistory(new OrderHistory(userId,cartId,totalPrice,restId,totalQuantity));
	    
	      
	      OrderItemsDAO oi=new OrderItemsDAOImpl();
	      
	      for(ItemsInCart menuItems:orderedItems) {
	    	  
	    	  oi.insertOrderItem(new OrderItems(cartId,menuItems.getMenuId(),menuItems.getQuantity(),menuItems.getSubtotal()));
	    	  
	    	  
	    	  
	      }
	      
	      
	      
	      //removing cart details
	      
	      
	      totalcart.removeCart(cartId);
	      items.removeAllItemsByCartId(cartId);
	      cart.removeCartByCartId(cartId);
	      
	      
	      response.sendRedirect("order-success.html");
	      
	      
	    
	    
	    
	}


}
