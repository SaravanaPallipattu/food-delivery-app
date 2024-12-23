<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.macfoods.dto.Restaurant" %>
    <%@ page import="java.util.ArrayList" %>
      <%@ page import="com.macfoods.dto.Menu" %>
      <%@ page import="com.macfoods.dao.UserDAO" %>
      <%@ page import="com.macfoods.dao.CartDAO" %>
      <%@ page import="com.macfoods.dao.CartDAOImpl" %>
      <%@ page import="com.macfoods.dto.Cart" %>
      <%@ page import="com.macfoods.dao.RestaurantDAO" %>
      <%@ page import="com.macfoods.dao.RestaurantDAOImpl" %>
      
      <%@ page import="com.macfoods.dto.ItemsInCart" %>
      <%@ page import="com.macfoods.dao.ItemsInCartDAO" %>
      <%@ page import="com.macfoods.dao.ItemsInCartDAOImpl" %>
      <%@ page import="com.macfoods.dao.MenuDAO" %>
      <%@ page import="com.macfoods.dao.MenuDAOImpl" %>
      <%@ page import="com.macfoods.dao.TotalCartDAO" %>
      <%@ page import="com.macfoods.dao.TotalCartDAOImpl" %>
      <%@ page import="com.macfoods.dto.TotalCart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="restaurant-menu-style.css">

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

.inc-dec-item{
   
   display:flex;
     gap:15px;
    justify-content:center; 
   position: relative;
    left:25%;
   top:-27px;
    
	
	width: 80px;
	margin:0;
	color: green;
	background-color: white;
	border: 2px solid green ;
	padding: 5px 10px;
	

}

.inc-dec-item button{
   position:initial;
   background-color:white;
   padding:0;
   margin:0;
   border:none;
   font-size:15px;
   
   
}

.description td{
   color:green;
}


#pay{
  
  border-top:5px solid grey;
  margin-top:20px;
  padding-top:10px;
  
  overflow:hidden;
 
}
#pay td{

   color:red;
}

#t-price{
  
  padding-right:90px;

}
.btn{

   width:100%;
  
   
   
   
   
}

#proceed-checkout-btn{
    
    
	
	width: 25%;
	color: green;
	background-color: white;
	border: 2px solid green ;
	padding: 10px 20px;
	margin-top:5%;
	margin-left:70%;
	font-size:15px;
	
	

}

.btn-edit{

   display:flex;
   gap:10%;
  justify-content:center;
  width:100%;
  align-items:center;
  

  
   

}

.btn-edit button{
   
  
	color: green;
	background-color: white;
	border: 2px solid green ;
	padding: 10px 20px;
	margin-top:5%;
	margin-bottom:10%;
	font-size:15px;

	


}
.inc-dec-btn{
   
    display:none;


}

#edit-btn{
   display:flex;
}

#confirm-btn{
   
   display:none;

}


.nav-icons img{
   
   margin-right:50px;
   
}



</style>
       
</head>
<body >
<div class="hidden">

  
        
         <%! UserDAO user=null; %>
           <%= user=(UserDAO)session.getAttribute("user") %>
           
           
</div>



    <header class="nav-bar">
    
           
      
   	  <div class="logo"> 
   	  	<a href="homepage.jsp" target="_self"><img src="logocompany.png" /></a>
   	  </div>
   	  
   	  
   	  
   	  
   	  
   	
   	  

   	  
   	  

   	  
   	   
   	 
   	 <%  if(user!=null) 
   	  { %>
   	     
   	    <div class="nav-links">
   	  	
   	  	<a href="deals.html" target="_self">Help</a>
   	  	
   	  	<a href="orders.jsp" target="_self">Orders</a>
   	  	<a href="homepage.jsp" target="_self">Home</a>

   	    </div>
   	    
   	    <div class="username">
             
             <p><%= (String)session.getAttribute("username") %></p>

       </div>
       
       
   	     
   	  <%}else{%> 
   		  
   		<div class="nav-links">
   	  	<a href="fashion.html" target="_self">Offers</a>
   	  	<a href="deals.html" target="_self">Help</a>
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
   	  
   	  
   	  <div class="hidden">

            <%! Cart cart=null; %>
            <%CartDAO cartdao=new CartDAOImpl(); %>
             
            <%=cart= cartdao.getCartByUserId((int)session.getAttribute("userId"))%>
        
       </div>
       
        <%  if(cart!=null) 
   	      { %>
   	      
   	             <div class="hidden">
                         
                         <%!Restaurant res=null; %>
                         <%RestaurantDAO resdao=new RestaurantDAOImpl(); %>
                         <%= res =resdao.getRestaurantByID(cart.getRestId()) %>
                         <%!TotalCart totalCart=null; %>
                         <%TotalCartDAO totalCartDao=new TotalCartDAOImpl(); %>
                         <%= totalCart =totalCartDao.checkCartIdPresent(cart.getCartId()) %>
                         
                 </div>
        
    <section class="restaurant-details">
   	
       <h1><%=res.getName() %></h1>
       

       	   <div class="description">

       	      
       	      <table width="100%">
       	       
       	          <tr>
       	          
       	              <td><p>Total Items in cart</p></td>
       	              <td><p id="total-quantity"><%=totalCart.getTotalQuantity() %></p></td>
       	          
       	          
       	          </tr>
       	           <tr>
       	          
       	              <td><p>Total Price</p></td>
       	              <td><p id="total-price"><%=totalCart.getTotalPrice() %></p></td>
       	          
       	          
       	          </tr>
       	     
       	    
       	      </table>
       	      
       	     
       	      
       	      <table id="pay" width="100%">
       	          
       	           <tr>
       	          
       	          
       	              <td id="t-price"><h4>To Pay</h4></td>
       	              <td > <h4><%=totalCart.getTotalPrice() %></h4></td>
       	          
       	          
       	          </tr>
       	      
       	      </table>
       	      
       	      <div class="btn">
       	      <button id="proceed-checkout-btn" onclick="placeOrder()">Place Order</button>
       	      
       	      </div>
       	      
       	      
              
              
              
              
              
             
       
       	
        

           </div>
       


   </section>
   
       <div class="hidden">
                      <%!ArrayList<ItemsInCart> itemscart=null;%>  
                      <%ItemsInCartDAO itemsincart=new ItemsInCartDAOImpl(); %> 
                      
                      <%= itemscart=(ArrayList<ItemsInCart>)itemsincart.getItemsInCartByCartId(cart.getCartId()) %>
                   
                      
                 </div>

   <section class="menu-items"> 
   
           
   	     
   	     
         <div  class="items-group">
         	<h1>Items in cart</h1>
         	
        <% for(ItemsInCart itemsCart:itemscart){%>
               
               
               <div class="hidden">
                      
                      <%!Menu m=null ;%>
                      
                      <%MenuDAO menu=new MenuDAOImpl(); %>
                      
                      <%= m=menu.getMenuById(itemsCart.getMenuId()) %>
               
                      
                 </div>
               
               
         	 
         	
              <div class="item" data-item-name="<%=m.getItemName() %>"  data-item-id="<%= m.getMenuId()%>" data-item-cart="<%= cart.getCartId()%>"  data-item-price="<%=m.getPrice() %>" data-item-quantity="<%=itemsCart.getQuantity() %>">

              	<div class="details">
              		<h4><%=m.getItemName() %></h4>
              	<p >₹<%=(int)m.getPrice() %></p>

              	<p id="desc"><%= m.getDescription() %></p>

              	</div>

              	<div class="image-cart">
              		
                    <img src="chicken.avif">
                   
                    <div class="inc-dec-item">
            
                    <button class="inc-dec-btn" id="decrement" onclick="decItems(this)" >-</button>
                     <p id="item-count" ><%=itemsCart.getQuantity() %></p>
                     <button class="inc-dec-btn" id="increment" onclick="incItems(this)" >+</button>
            
                     </div>
              	</div>

                       

              </div>
              
              
            
                  
              
             
          
            <%} %>
              


               
         </div>
         
          <div class="btn-edit">
       	     
       	      <button id="edit-btn" onclick="editQuantity(this)">Edit Order Quantity</button>
       	      <button id="confirm-btn" onclick="gotoCart()">Confirm</button>
       	     <button onclick="addmore()">Add More Items</button>
       	      
       	      </div>

         
       

   </section>
   
   
    
   
       
   
                 <%}else{%>
                       
                  <center><h1 >You Have No Items In Your Cart</h1>
                      <h1 ><a href="restaurants.jsp" style="color:green">Click here</a> to add items</h1></center>
                       
                    <% }%> 
   
   <%}else{%>
      
       <%response.sendRedirect("login.html"); %> 
   
    
 <% }%> 
   
    
    <script src="user-cart.js"></script>
    
</body>
</html>