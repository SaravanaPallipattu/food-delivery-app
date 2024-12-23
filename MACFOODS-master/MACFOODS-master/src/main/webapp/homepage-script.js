/**
 * 
 */

function getCity(){
	var selectedCity =document.getElementById("selectcity").value;
	
	localStorage.setItem("selectedCity", selectedCity);
	
   document.cookie = "selectCity=" + encodeURIComponent(selectedCity) + "; path=/";
   
   location.reload();
   
           
}



function getSelectedOption(){
	var selectedCity=localStorage.getItem("selectedCity");
	
	
	setSelectedValue(document.getElementById("selectcity"), selectedCity);
	
}

function setSelectedValue(selectObj, valueToSet) {
    for (var i = 0; i < selectObj.options.length; i++) {
        if (selectObj.options[i].text== valueToSet) {
            selectObj.options[i].selected = true;
            return;
        }
    }
}






 
 
 