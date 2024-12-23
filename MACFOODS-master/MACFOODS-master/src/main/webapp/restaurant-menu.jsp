<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.macfoods.dto.Restaurant" %>
    <%@ page import="java.util.ArrayList" %>
      <%@ page import="com.macfoods.dto.Menu" %>
      <%@ page import="com.macfoods.dao.UserDAO" %>
      
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
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


.popup-container{
     position: fixed; 
 top: 50%; 
  left: 47%; 
  transform: translate(-50%, -50%); 
  display: none; 
  
  width: 450px; 
  height: 500px; 
 background-color:white;
 border-radius:20px;
 
 
 
}
.popup-container img{
  
  width: 450px; 
  height: 300px;
  border-radius:20px 20px 0 0;

}

body.no-scroll {
  overflow: hidden; 
 
  background-color:#F4EEEE;
  
}

.description.no-scroll{
   background-color:#F4EEEE;
}



#add-cart-item-btn{
    
    
	bottom: 20px;
	width: 120px;
	color: green;
	background-color: white;
	border: 2px solid green ;
	padding: 10px 20px;
	margin-left:-90%;
	margin-top:8%;

}

.desc-popup{
width: 400px;
    height: 43px;
	margin-top: 50px;
	color: grey;
	overflow: hidden;
	font-size: 13px;
	

}
#item-popup{
border:none;

}


.cross{
  
   width:35px;
   height:35px;
   position:absolute;
   background-color:white;
   left:90%;
   top:3%;
   border-radius:20px;
   font-size:17px;
   padding-bottom:30px;
   

}

.inc-dec-item{
   
   display:none;
     gap:15px;
     
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


#cart-items-number{
   
  background-color: yellow;
  padding:0 2px;
  position:absolute;
    top:28px;
    right:11px;
    font-size:12px;
    border-radius:10px;
    width:27px;
    height:20px;
    text-align:center;

}

.go-to-cart{

width: 250px;
margin:50px auto;

}

.go-to-cart-btn{

   bottom: 20px;
	width: 250px;
	color: green;
	background-color: white;
	border: 2px solid green ;
	padding: 10px 20px;
	
	
}






</style>

  <script type="text/javascript">
       function  userLogout(){    
     
    	   window.location.href="Logout";
          
       }
      </script> 
<script src="restaurant-menu-add-cart.js"></script>
</head>
<body >
<div class="hidden">

   <%!Restaurant res=null; 
       ArrayList<Menu> menu=null;
    %>
    <%= res=(Restaurant)session.getAttribute("RestaurantDetails")%>
        <%= menu=(ArrayList<Menu>)session.getAttribute("MenuDetails") %>
        
         <%! UserDAO user=null; %>
           <%= user=(UserDAO)session.getAttribute("user") %>
</div>

    <header class="nav-bar">
    
           
      
   	  <div class="logo"> 
   	  	<a href="homepage.jsp" target="_self"><img src="logocompany.png" /></a>
   	  </div>
   	  
   	  
   	  <div class="location">
   	       
   	      
   	  </div>
   	  
   	  
   	
   	  

   	  <div class="search-box"> 
           <input type="text" placeholder="Taste for your favourite food">
           <button>Explore</button>
   	  </div>
   	  

   	  
   	   
   	 
   	 <%  if(user!=null) 
   	  { %>
   	     
   	    <div class="nav-links">
   	  	<a href="offers.html" target="_self">Offers</a>
   	  	<a href="help.html" target="_self">Help</a>
   	  	<a href="restaurants.jsp" target="_self">Restaurants</a>
   	  	<a href="orders.jsp" target="_self">Orders</a>
   	  	<a onclick="userLogout()">Logout</a>

   	    </div>
   	    
   	    <div class="username">
             
             <p><%= (String)session.getAttribute("username") %></p>

       </div>
       
       <div id="cart-items-number">
             
             <p>0</p>

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
   	  	<a href="user-cart.jsp"><img src="cart-icon.png" ></a>

   	  </div>
   	 

   </header>
    
        
    <section class="restaurant-details">
   	
       <h1><%=res.getName() %></h1>
       

       	   <div class="description">

       	<div class="rating">  
       		<img src="rating.png">
       		<h4><%=res.getRatings() %></h4>

       	</div>

       	<span class="cuision"> 
       	    <%=res.getCuisineType() %>
       	</span>
       	
        <div class="reach-logo-time">
        	
           <img src="line.png">
           <h4 id="outlet">outlet</h4>
           <h4 id="expected-time"><%=res.getDeliveryTime() %> mins</h4>

        </div>

       </div>
       


   </section>

   <section class="menu-items"> 
   	     
   	     
         <div  class="items-group">
         	<h1>Available Items</h1>
         	
         	
         	<% for(Menu item:menu){%>
         	
                
                     <div class="item" data-item-name="<%=item.getItemName() %>">

              	<div class="details">
              		<h4><%=item.getItemName() %></h4>
              	<p>₹<%=(int)item.getPrice() %></p>

              	<p id="desc"><%= item.getDescription() %></p>

              	</div>

              	<div class="image-cart">
              		
                    <img src="chicken.avif">
                    <button id="add-btn" data-name="<%=item.getItemName()%>" data-price="<%=(int)item.getPrice() %>" data-description="<%= item.getDescription() %>" data-image=""  onclick="addbtnaction(this)">ADD</button>
                    <div class="inc-dec-item">
            
                    <button id="decrement" onclick="decItems(this)" >-</button>
                     <p id="item-count">1</p>
                     <button id="increment" onclick="incItems(this)" >+</button>
            
                     </div>
              	</div>

            

              </div>
     
              
              <div class="popup-container" >
                  
                 <button class="cross" onclick="removePopup()">x</button>
           
                 <img src="add-cart-image.avif">
                 
                 <div class="item" id="item-popup">

              	<div class="details">
              		<h4 id="popup-item-name"></h4>
              	<p id="popup-item-price"></p>

              	<p class="desc-popup" id="popup-item-description"></p>

              	</div>

              	<div>
              		
                    
                     <button id="add-cart-item-btn"  onclick="addToCart()">ADD ITEM</button>
                    
              	</div>

            

              </div>
                 
                
        
            </div>
            
            
              
          <%} %>

              


               
         </div>


   </section>
   
   <section class="go-to-cart">
   
   <%if(user!=null) {%>
   
  
     <button class="go-to-cart-btn" onclick="gotoCart()">goto cart</button>
    
   
   
   <%} %>
   
   </section>
   
   
    
 
   
    
    
    
</body>
</html>