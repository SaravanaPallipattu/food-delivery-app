package com.macfoods.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.macfoods.dao.UserDAO;
import com.macfoods.dao.UserDAOimpl;
import com.macfoods.dto.User;

public class Register extends HttpServlet {
	
	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		
		UserDAO user=new UserDAOimpl();
		if(user.isMobileExist(mobile)) {
			
			response.sendRedirect("alreadyhaveaccount.html");
		}
		else if(user.isEmailExist(email)) {
			
			response.sendRedirect("alreadyhaveaccount.html");
		}
		
		else if(pwd.equals(request.getParameter("confirmpwd"))) {
			
			User u=new User(name,pwd,mobile,email);
			
			if(user.insertUser(u)>0) {
				response.sendRedirect("registersuccess.html");
			}
			else {
				
				response.sendRedirect("registerfail.html");
			}
			
			
		}
		else {
			
			response.sendRedirect("confirmpwdfails.html");
			
		}
		
	}

	
}
