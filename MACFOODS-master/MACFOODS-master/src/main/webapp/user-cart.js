/**
 * 
 */

let itemCounts={};
let totalCartCount=0;
let itemNameArray={};
var queryString=null;
var queryStringCount=null;
let itemCountsinitially={};




 function editQuantity(button){
	
	var element=document.getElementsByClassName("inc-dec-btn");
	
	for (var i=0;i<element.length;i+=1){
		
       element[i].style.display = 'flex';
       
       }
       
	document.getElementById("edit-btn").style.display="none";
	document.getElementById("confirm-btn").style.display="flex";
	


	
	
	
	
 }
 



 function incItems(button){
	     const itemName = button.closest('.item').dataset.itemName;
	     const itemElement = document.querySelector(`.item[data-item-name="${itemName}"]`);
	      
	     
	     
	     
	     
	     
	     if(!itemCounts[itemName]){
			   
			   itemNameArray[itemName]=itemName;
			   
			   itemCounts[itemName]=itemElement.querySelector("#item-count").textContent;
			   itemCountsinitially[itemName]=itemElement.querySelector("#item-count").textContent;
			   
		       itemCounts[itemName]++;
			   totalCartCount++;
			   
               itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
			   
			   
		   }
		   else{
			itemCounts[itemName]++;
	     totalCartCount++;
	     itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
			
			
		   }
	       
	     
	    
	      
	   
	
	    
   }
   
   function decItems(button){
	     const itemName = button.closest('.item').dataset.itemName;
	     const itemElement = document.querySelector(`.item[data-item-name="${itemName}"]`);
	       const addButton = itemElement.querySelector('#add-btn');
	       const incDecItem = itemElement.querySelector('.inc-dec-item');
	       const itemId = button.closest('.item').dataset.itemId;
	       const itemCart = button.closest('.item').dataset.itemCart;
	       const quantity=button.closest('.item').dataset.itemQuantity;
	       const price=button.closest('.item').dataset.itemPrice;
	       	const totalQuantity=document.getElementById("total-quantity").textContent;
             const totalPrice=document.getElementById("total-price").textContent;


	       
	        if(!itemCounts[itemName]){
			   
			   itemNameArray[itemName]=itemName;
			   
			   itemCounts[itemName]=itemElement.querySelector("#item-count").textContent;
			    itemCountsinitially[itemName]=itemElement.querySelector("#item-count").textContent;
			   
		       itemCounts[itemName]--;
			   totalCartCount--;
			   
			     if(itemCounts[itemName]<=0){
			
			         itemCounts[itemName]=0;
			   
			       itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
			       
			       window.location.href="RemoveItemsCart?menuId="+itemId+"&cartId="+itemCart+"&quantity="+quantity+"&price="+price+"&totalQuantity="+totalQuantity+"&totalPrice="+totalPrice;
	                        
		           }
		           else{
			
	       
	                 itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
	     
	     
	                  }
			   
               
			   
			   
		   }
		   else{
			itemCounts[itemName]--;
	     totalCartCount--;
	     
	     if(itemCounts[itemName]<=0){
			
			         itemCounts[itemName]=0;
			   
			           itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
			           
			           window.location.href="RemoveItemsCart?menuId="+itemId+"&cartId="+itemCart+"&quantity="+quantity+"&price="+price+"&totalQuantity="+totalQuantity+"&totalPrice="+totalPrice;
	                        
		           }
		           else{
			
	       
	                 itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
	     
	     
	                  }
			   
	    
			
			
		   }
	       
	    
	    
	   
	
	    
   }
   
   function gotoCart(){
	
	   
	
	  for (let value of Object.keys(itemNameArray)) {
		
          
                queryString=queryString+","+itemNameArray[value];
                
      }
      
      for(let value of Object.keys(itemCountsinitially)){
		
		
		     itemCounts[value]-=itemCountsinitially[value];
	  }
      
      for (let value of Object.keys(itemCounts)) {
		
          
                queryStringCount=queryStringCount+"&"+value+"="+itemCounts[value];
      }
	
	    
	     
	     
	     itemNameArray=null;
	     console.log(queryStringCount)
	     console.log(queryString)
	     console.log(totalCartCount);
	
	   window.location.href="UserCart?itemNameArray="+queryString+"&totalCartCount="+totalCartCount+"&"+queryStringCount;
	   
   }
   
   function addmore(){
	
	window.location.href="restaurant-menu.jsp";
	   
   }
   
   function placeOrder()
   {
	window.location.href="PlaceOrder";
   }   
   
   
   
   
   
   