package com.macfoods.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.macfoods.dao.CartDAO;
import com.macfoods.dao.CartDAOImpl;
import com.macfoods.dto.Restaurant;

import jakarta.servlet.http.HttpSession;


public class UserCartMenu extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		 CartDAO cart=new CartDAOImpl();
		 int userId=(int)session.getAttribute("userId");
		 Restaurant  res=(Restaurant)session.getAttribute("RestaurantDetails");
		 
		int cartId= cart.getCartIdByUserIdAndRestId(userId,res.getRestaurantId());
	}


}
