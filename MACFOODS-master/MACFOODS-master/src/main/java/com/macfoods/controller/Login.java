package com.macfoods.controller;

import java.io.IOException;

import com.macfoods.dao.UserDAO;
import com.macfoods.dao.UserDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class Login extends HttpServlet {
	
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		
		UserDAO user=new UserDAOimpl();
		
		
		   
		
		if(user.isEmailExist(email)) {
			 
			if(user.getPwdByEmail(email).equals(pwd)) {
				HttpSession session=request.getSession();
			    session.setAttribute("user",user);
			    session.setAttribute("username", user.getUsernameByEmail(email));
			    session.setAttribute("userId", user.getUserIdByEmail(email));
			    
			           
			    
				request.getRequestDispatcher("/homepage.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("pwdinvalid.html");
			}
			
		}
		else {
			response.sendRedirect("noaccount.html");
		}
		
		  
	}

}
