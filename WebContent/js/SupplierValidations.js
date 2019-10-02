/**
 * 
 * 
 */

function SupllierSignUpvalidations() {
	var userName = document.forms["supSignUp"]["UserName"];
	var pasword = document.forms["supSignUp"]["Password"];
	var name = document.forms["supSignUp"]["Name"];
	var email = document.forms["supSignUp"]["Email"];
	var address = document.forms["supSignUp"]["Address"];
	var review = document.forms["supSignUp"]["Review"];
	var con = document.forms["supSignUp"]["ContactNumber"];
	var conlength = document.supSignUp.ContactNumber.value.length;
	var contact = document.supSignUp.ContactNumber.value;

	if (userName.value == "") {
		window.alert("Please Enter User Name");
		userName.focus();
		return false;
	}

	if (pasword.value == "") {
		window.alert("Please Enter Correct Password");
		pasword.focus();
		return false;
	}

	if (name.value == "") {
		window.alert("Please Enter Name");
		name.focus();
		return false;
	}

	if (address.value == "") {
		window.alert("Please Enter Address");
		address.focus();
		return false;
	}
	if (email.value == "") {
		window.alert("Please Enter Email");
		email.focus();
		return false;
	}

	if (contact == "") {
		window.alert("Please Enter Contact Number");
		con.focus();
		return false;
	}
	
	if (isNaN(contact)) {
		window.alert("Enter Number for contact Number");
		con.focus();
		return false;
	}
	
	if (conlength > 10) {
		window.alert("Contact Number Can not be Exceed 10 Numbers");
		con.focus();
		return false;
	}
	
	if (conlength < 10) {
		window.alert("Contact Number Can not be Less than 10 Numbers");
		con.focus();
		return false;
	}
	

	if (review.value == "") {
		window.alert("Please Enter Review");
		review.focus();
		return false;
	}

	return true;
}


function UpdateSupplierAccount() {
	var userName = document.forms["UpdateSupplier"]["UserName"];
	var pasword = document.forms["UpdateSupplier"]["Password"];
	var name = document.forms["UpdateSupplier"]["Name"];
	var email = document.forms["UpdateSupplier"]["Email"];
	var address = document.forms["UpdateSupplier"]["Address"];
	var review = document.forms["UpdateSupplier"]["Review"];
	var con = document.forms["UpdateSupplier"]["ContactNumber"];
	var conlength = document.UpdateSupplier.ContactNumber.value.length;
	var contact = document.UpdateSupplier.ContactNumber.value;

	if (userName.value == "") {
		window.alert("Please Enter User Name");
		userName.focus();
		return false;
	}

	if (pasword.value == "") {
		window.alert("Please Enter Correct Password");
		pasword.focus();
		return false;
	}

	if (name.value == "") {
		window.alert("Please Enter Name");
		name.focus();
		return false;
	}

	if (address.value == "") {
		window.alert("Please Enter Address");
		address.focus();
		return false;
	}
	if (email.value == "") {
		window.alert("Please Enter Email");
		email.focus();
		return false;
	}

	if (contact == "") {
		window.alert("Please Enter Contact Number");
		con.focus();
		return false;
	}
	
	if (isNaN(contact)) {
		window.alert("Enter Number for contact Number");
		con.focus();
		return false;
	}
	
	if (conlength > 10) {
		window.alert("Contact Number Can not be Exceed 10 Numbers");
		con.focus();
		return false;
	}
	
	if (conlength < 10) {
		window.alert("Contact Number Can not be Less than 10 Numbers");
		con.focus();
		return false;
	}
	

	if (review.value == "") {
		window.alert("Please Enter Review");
		review.focus();
		return false;
	}

	return true;
}




function AddProducts()                                    
{ 
    var pname = document.forms["Product"]["productName"];               
    var price = document.forms["Product"]["productPrice"];
    var pqty = document.forms["Product"]["productQuentity"];
    var pwrty = document.forms["Product"]["warrenty"];
    var pdesc = document.forms["Product"]["productDescription"];
    var pimage = document.forms["Product"]["imageName"];
    
    
    
    
    if (pname.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Name"); 
    	 pname.focus(); 
        return false; 
    } 
    
    if (price.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Price"); 
    	 price.focus(); 
        return false; 
    } 
    
    if (price.value < 0)                                  
    { 
    	 window.alert("Price Cannot Be Negative!"); 
    	 price.focus(); 
        return false; 
    } 
    
    if (pqty.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Quentity"); 
    	 pqty.focus(); 
        return false; 
    } 
    
    if (pqty.value < 0)                                  
    { 
    	 window.alert("Quentity Cannot Be Negative"); 
    	 pqty.focus(); 
        return false; 
    }
    
    if (pqty.value == 0)                                  
    { 
    	 window.alert("Quentity Cannot Be Negative"); 
    	 pqty.focus(); 
        return false; 
    }
    
    if (pwrty.value == "")                                  
    { 
    	 window.alert("Plese Enter Item 0"); 
    	 pwrty.focus(); 
        return false; 
    } 
    
    if (pdesc.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Description"); 
    	 pdesc.focus(); 
        return false; 
    } 
    
    if (pimage.value == "")                                  
    { 
    	 window.alert("Plese Enter Image"); 
    	 pimage.focus(); 
        return false; 
    } 

    
    return true; 
}


function UpdateProducts()                                    
{ 
    var pname = document.forms["UpdateProduct"]["productName"];               
    var price = document.forms["UpdateProduct"]["productPrice"];
    var pqty = document.forms["UpdateProduct"]["productQuentity"];
    var pwrty = document.forms["UpdateProduct"]["warrenty"];
    var pdesc = document.forms["UpdateProduct"]["productDescription"];
    var pimage = document.forms["UpdateProduct"]["imageName"];
    
    
    
    
    if (pname.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Name"); 
    	 pname.focus(); 
        return false; 
    } 
    
    if (price.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Price"); 
    	 price.focus(); 
        return false; 
    } 
    
    if (price.value < 0)                                  
    { 
    	 window.alert("Price Cannot Be Negative"); 
    	 price.focus(); 
        return false; 
    } 
    
    if (price.value == 0)                                  
    { 
    	 window.alert("Price Cannot Be 0"); 
    	 price.focus(); 
        return false; 
    } 
    
    if (pqty.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Quentity"); 
    	 pqty.focus(); 
        return false; 
    } 
    
    if (pqty.value < 0)                                  
    { 
    	 window.alert("Quentity Cannot Be Negative"); 
    	 pqty.focus(); 
        return false; 
    }
    
    if (pqty.value == 0)                                  
    { 
    	 window.alert("Quentity Cannot Be 0"); 
    	 pqty.focus(); 
        return false; 
    }
    
    if (pwrty.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Warrenty"); 
    	 pwrty.focus(); 
        return false; 
    } 
    
    if (pdesc.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Description"); 
    	 pdesc.focus(); 
        return false; 
    } 
    
    

    
    return true; 
}






















