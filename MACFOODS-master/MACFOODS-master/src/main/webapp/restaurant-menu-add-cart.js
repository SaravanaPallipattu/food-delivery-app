/**
 * 
 */
let itemCounts={};
let totalCartCount=0;
let itemNameArray={};
var queryString=null;
var queryStringCount=null;
 function addbtnaction(button){
	const itemName = button.getAttribute('data-name');
	document.getElementById('popup-item-name').textContent = itemName;
	document.getElementById('popup-item-price').textContent = "₹"+button.getAttribute('data-price');
	document.getElementById('popup-item-description').textContent =button.getAttribute('data-description');
    document.querySelector(".popup-container").style.display = "block";
	document.body.classList.add('no-scroll');
	document.querySelector(".description").classList.add('no-scroll');
	button.closest('.item').dataset.itemName = itemName;
	    
	
 }
 
 function removePopup(){
	document.querySelector(".popup-container").style.display = "none";
	document.body.classList.remove('no-scroll');
	document.querySelector(".description").classList.remove('no-scroll');
	
	
 }
 
 function addToCart(){
	      
	       
	       const itemName = document.getElementById('popup-item-name').textContent;
	       
	       if(!itemCounts[itemName]){
			   
			   itemNameArray[itemName]=itemName;
			   
			   itemCounts[itemName]=1;
		        
		        
			   
			   totalCartCount++;
			   
			   
			
			   
			
               
			   document.querySelector("#cart-items-number").querySelector("p").textContent=totalCartCount;
			   
		   }
		   
		   
		 const itemElement = document.querySelector(`.item[data-item-name="${itemName}"]`);
	       const addButton = itemElement.querySelector('#add-btn');
	       const incDecItem = itemElement.querySelector('.inc-dec-item');
	      
	       
	        
	        addButton.style.display = 'none';
	        incDecItem.style.display='flex';
	        
	       incDecItem.querySelector('#item-count').textContent = itemCounts[itemName];
	       
	       
	       removePopup();
	 
	
	
         }
         
         
   function incItems(button){
	     const itemName = button.closest('.item').dataset.itemName;
	     const itemElement = document.querySelector(`.item[data-item-name="${itemName}"]`);
	       
	     itemCounts[itemName]++;
	     totalCartCount++;
	     itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
	      document.querySelector("#cart-items-number").querySelector("p").textContent=totalCartCount;
	      
	   
	
	    
   }
   
   function decItems(button){
	     const itemName = button.closest('.item').dataset.itemName;
	     const itemElement = document.querySelector(`.item[data-item-name="${itemName}"]`);
	       const addButton = itemElement.querySelector('#add-btn');
	       const incDecItem = itemElement.querySelector('.inc-dec-item');
	     
	     itemCounts[itemName]--;
	     totalCartCount--;
	    
	     if(itemCounts[itemName]<=0){
			
			itemCounts[itemName]=0;
			
			document.querySelector("#cart-items-number").querySelector("p").textContent=totalCartCount;
	       
	       
	       
	        
	        addButton.style.display = 'flex';
	        incDecItem.style.display='none';
		 }
		 else{
			
	       
	     itemElement.querySelector("#item-count").textContent=itemCounts[itemName];
	     document.querySelector("#cart-items-number").querySelector("p").textContent=itemCounts[itemName];
	      document.querySelector("#cart-items-number").querySelector("p").textContent=totalCartCount;
	   }
	
	    
   }
   
   function gotoCart(){
	
	  for (let value of Object.keys(itemNameArray)) {
		
          
                queryString=queryString+","+itemNameArray[value];
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
   
  
   
  
    
 
 
 