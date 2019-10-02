/**
 * 
 */


function UpdatePOD()                                    
{ 
    var name = document.forms["uPOD"]["itemName"];               
    var qty = document.forms["uPOD"]["qty"];
    var pri = document.forms["uPOD"]["price"];
    
    
    
    
    if (name.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Name"); 
    	 name.focus(); 
        return false; 
    } 
    
    
    
    if (qty.value == "")                                  
    { 
    	window.alert("Plese Enter Item Quantity"); 
    	qty.focus(); 
        return false; 
    }
    
    if (qty.value <= 0)                                  
    { 
    	window.alert("Quantity can not be Negative, Plese Enter Possitive Value"); 
    	qty.focus(); 
        return false; 
    }
    
    if (qty.value == 0)                                  
    { 
    	window.alert("Quantity can not be 0, Plese Enter Possitive Value"); 
    	qty.focus(); 
        return false; 
    }
    
    if (pri.value == "")                                  
    { 
    	window.alert("Plese Enter Expected Price"); 
    	pri.focus(); 
        return false; 
    }
    
    if (pri.value <= 0)                                  
    { 
    	window.alert("Price can not be Negative, Plese Enter Possitive Value");
    	pri.focus(); 
        return false; 
    }
    
    if (pri.value == 0)                                  
    { 
    	window.alert("Price can not be 0, Plese Enter Possitive Value");
    	pri.focus(); 
        return false; 
    }
 
    return true; 
}