package com.macfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;

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


public class RemoveItemsCart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		   
	int menuId=Integer.parseInt(request.getParameter("menuId"));
	
	int cartId=Integer.parseInt(request.getParameter("cartId"));
	
	int quantity=Integer.parseInt(request.getParameter("quantity"));
	float price=Float.parseFloat(request.getParameter("price"));
	
	int totalQuantity=Integer.parseInt(request.getParameter("totalQuantity"));
	float totalPrice=Float.parseFloat(request.getParameter("totalPrice"));
	
	    ItemsInCartDAO items=new ItemsInCartDAOImpl();
	    
	    items.removeMenuByCartId(cartId,menuId);
		
	    TotalCartDAO tCart=new TotalCartDAOImpl();
	    
	    tCart.UpdateTotalCart(cartId, totalPrice-(price*quantity), totalQuantity-quantity);
	    
	    
	    if(items.getItemsInCartByCartId(cartId).size()==0) {
	    	
	    	  tCart.removeCart(cartId);
	    	  CartDAO cart=new CartDAOImpl();
	    	  cart.removeCartByCartId(cartId);
	    	  
	    	  
	    	
	    }
	    
	    
	    RequestDispatcher rd=request.getRequestDispatcher("/user-cart.jsp");
        rd.include(request, response);
	    
	}

	
	

}
