<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.macfoods.dto.Restaurant" %>
    <%@ page import="java.util.ArrayList" %>
      <%@ page import="com.macfoods.dto.Menu" %>
      <%@ page import="com.macfoods.dao.UserDAO" %>
    
      <%@ page import="com.macfoods.dao.RestaurantDAO" %>
      <%@ page import="com.macfoods.dao.RestaurantDAOImpl" %>
      
      <%@ page import="com.macfoods.dto.OrderHistory" %>
      <%@ page import="com.macfoods.dao.OrderHistoryDAO" %>
      <%@ page import="com.macfoods.dao.OrderHistoryDAOImpl" %>
      <%@ page import="com.macfoods.dao.MenuDAO" %>
      <%@ page import="com.macfoods.dao.MenuDAOImpl" %>
      <%@ page import="com.macfoods.dto.OrderItems" %>
      <%@ page import="com.macfoods.dao.OrderItemsDAO" %>
      <%@ page import="com.macfoods.dao.OrderItemsDAOImpl" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>


<link rel="stylesheet" type="text/css" href="header-style.css">

<style>

  .username  {
	
    
    position:absolute;
    top:30px;
    right:50px;
}

.nav-bar{
   position:relative;
}

.hidden{

   display:none;
}

.restaurant-details{
	width: 70%;
	margin: 16px auto;
	margin-bottom: 70px;
	
}



.description{

   
	
	background-color: white;
	padding: 25px;
	border: 2px solid grey;
	box-shadow: 5px 10px #bbbbbbff;
	margin-top: 15px;
	border-radius: 5px;
	


}

.data{
   
   display:flex;
   gap:5%;

}

.res-image img{
   
   width:150px;
   height:100px;

}

.order-details p{

  font-size:12px;
  color:grey;
   
}

.order-time p{

    margin-left:150px;
   
   font-size:13px;
   color:grey;

}

.ordered-items-container{

    border-top:2px solid grey;
    
    display:flex;
    gap:60%;
    margin:2% 0;
    padding-top:2%;
    margin-bottom:0;
}

.ordered-items p{
  
  color:green;
  font-size:13px;

}

.total-paid p{
   
   color:red;
}



#proceed-checkout-btn{
  
	width: 25%;
	color: green;
	background-color: white;
	border: 2px solid green ;
	padding: 10px 20px;
	margin-top:5%;
	
	font-size:15px;

}

#total-items{
  
   color:black;
   margin-bottom:10px;
   font-size:15px;
 }
 #symbol{
 
    color:black;
    margin:0 5px;
    font-size:10px;
 }

.nav-icons img{
   
   margin-right:50px;
   
}

</style>
       
</head>
<body >
<div class="hidden">

  
        
         <%! UserDAO user=null;
         OrderHistoryDAO oh=null;
         
         OrderItemsDAO oi=null;
         MenuDAO menu=null;
         int userId=0;
         
         ArrayList<OrderHistory> orders=null;
         %>
           <% user=(UserDAO)session.getAttribute("user");
           userId=(int)session.getAttribute("userId");
        		   oh=new OrderHistoryDAOImpl();
        		   oi=new OrderItemsDAOImpl();
        	orders=(ArrayList<OrderHistory>) oh.getOrdersByUserId(userId);
        	menu=new MenuDAOImpl();
        		   
           %>
        
           
</div>



    <header class="nav-bar">
    
           
      
   	  <div class="logo"> 
   	  	<a href="homepage.jsp" target="_self"><img src="logocompany.png" /></a>
   	  </div>
   	  
   	  
   	  
   	  
   	  
   	
   	  

   	  
   	  

   	  
   	   
   	 
   	 <%  if(user!=null) 
   	  { %>
   	     
   	    <div class="nav-links">
   	  	
   	  	<a href="deals.html" target="_self">Help</a>
   	  	
   	  	<a href="homepage.jsp" target="_self">Home</a>
   	  	

   	    </div>
   	    
   	    <div class="username">
             
             <p><%= (String)session.getAttribute("username") %></p>

       </div>
       
       
   	     
   	  <%}else{%> 
   		  
   		<div class="nav-links">
   	  	<a href="offers.html" target="_self">Offers</a>
   	  	<a href="help.html" target="_self">Help</a>
   	  	<a href="login.html" target="_self">Login</a>
   	  	<a href="registration.html" target="_self">Signup</a>
   	  	</div>
   		  <% }%> 
    

   	  <div class="nav-icons">
   	  	
   	  	<img src="profile-icon.png">
   	  	

   	  </div>
   	 

   </header>
   
   
     <%  if(user!=null) 
   	  { %>
   	  
   	     
   	      
   	      <%for(OrderHistory order:orders) {%>
   	           
   	           <div class="hidden">
   	           <%!Restaurant res=null;
   	              RestaurantDAO resdao=new RestaurantDAOImpl();
   	              int restId=0;
   	           %>
   	           <%restId=order.getRestId() ;
   	           
   	               res=resdao.getRestaurantByID(restId);
   	           %>
   	           
   	           </div>
   	  
        
    <section class="restaurant-details">
   	
       
       

       	   <div class="description">
       	   
       	         <div class="data">
       	         
       	              <div class="res-image">
       	         
       	              <img src="">
       	        
       	          </div>
       	      
       	         <div class="order-details">
       	           
       	           <h4><%=res.getName() %></h4>
       	         <p><%=res.getAddress() %></p>
       	         <p>order #<%=order.getOrderId()%> | <%=order.getDate() %></p>
       	            
       	          </div>
       	      
       	          <div class="order-time">
       	      
       	            <p>Delivered on <%=order.getDate() %></p>
       	      
       	           </div>
       	         
       	         </div>
       	              <div class="hidden">
       	             <%!ArrayList<OrderItems> orderedItems =null; 
       	                 Menu m=null;
       	             %>
       	             <%=orderedItems=(ArrayList<OrderItems>)oi.getOrderItemsByOrderId(order.getOrderId()) %>
       	             </div>
       	            
       	          
       	        <div class="ordered-items-container">
       	        
       	            <div class="ordered-items">
       	               <p id="total-items">Total Items(<%=order.getTotalQuantity() %>)</p>
       	               
       	           <%for(OrderItems orderedItem:orderedItems){ %>
       	                <div class="hidden">
       	                <%= m=menu.getMenuById(orderedItem.getMenuId()) %> 
       	                 </div>
       	               <p><%=m.getItemName() %> <span id="symbol">X</span> <%= orderedItem.getQuantity()%></p>
       	              
       	               
       	            
       	            <%} %>
       	        </div>
       	        
       	           
       	        
       	        <div class="total-paid">
       	              
       	              <p>Total paid: ₹<%=order.getTotal() %>
       	              </p>
       	              
       	        </div>
       	        
       	        </div>
       	      
       	      
       	      
       	      
       	      <div class="btn">
       	      <button id="proceed-checkout-btn">Help</button>
       	      
       	      </div>
       	     

           </div>
     
   </section>
   
   
   
   
       

  
   
    <%} %>
   
       
   
                 
   
   <%}%>
   
    
   
    
</body>
</html>