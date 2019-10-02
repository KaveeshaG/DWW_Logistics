/**
 * 
 */

function InventoryReplace()                                    
{ 
    var iname = document.forms["RegForm"]["itemName"];               
    var warr = document.forms["RegForm"]["warrentyDay"];
    var add = document.forms["RegForm"]["addedDay"];
    var loc = document.forms["RegForm"]["location"];
    var des = document.forms["RegForm"]["description"];
    var timeNow = new Date();
    var warrentyDate = document.RegForm.warrentyDay.value;
    var wrday = new Date(warrentyDate);
    var addInput = document.RegForm.addedDay.value;
    var addedDay = new Date(addInput);
    
    
    if (iname.value == "")                                  
    { 
        window.alert("Please Enter Item Name!"); 
        iname.focus(); 
        return false; 
    } 
    
    if (warr.value == "")                                  
    { 
        window.alert("Plese Enter Warrenty Date"); 
        warr.focus(); 
        return false; 
    }
    
    if (timeNow > wrday)                                  
    { 
        window.alert("Warrenty day can not be Today or Previous Day"); 
        warr.focus(); 
        return false; 
    }

    
    
    
    if (add.value == "")                                  
    { 
        window.alert("Plese Enter Added Date"); 
        add.focus(); 
        return false; 
    }
    
    if (addedDay > wrday)                                  
    { 
        window.alert("Warrenty day can not be Less than Added Day"); 
        warr.focus(); 
        return false; 
    }
    
    if (loc.value == "")                                  
    { 
        window.alert("Plese Enter Item Location"); 
        loc.focus(); 
        return false; 
    }
    
    if (des.value == "")                                  
    { 
        window.alert("Plese Enter Item Description"); 
        des.focus(); 
        return false; 
    }
    
    return true; 
}


function InventoryReplaceEDIT()                                    
{ 
	var iname = document.forms["EditRp"]["itemName"];               
    var warr = document.forms["EditRp"]["warrentyDay"];
    var add = document.forms["EditRp"]["addedDay"];
    var loc = document.forms["EditRp"]["location"];
    var des = document.forms["EditRp"]["description"];
    var timeNow = new Date();
    var warrentyDate = document.EditRp.warrentyDay.value;
    var wrday = new Date(warrentyDate);
    var addInput = document.EditRp.addedDay.value;
    var addedDay = new Date(addInput);
    
    
    if (iname.value == "")                                  
    { 
        window.alert("Please Enter Item Name!"); 
        iname.focus(); 
        return false; 
    } 
    
    if (warr.value == "")                                  
    { 
        window.alert("Plese Enter Warrenty Date"); 
        warr.focus(); 
        return false; 
    }
    
    if (timeNow > wrday)                                  
    { 
        window.alert("Warrenty day can not be Today or Previous Day"); 
        warr.focus(); 
        return false; 
    }

    
    
    
    if (add.value == "")                                  
    { 
        window.alert("Plese Enter Added Date"); 
        add.focus(); 
        return false; 
    }
    
    if (addedDay > wrday)                                  
    { 
        window.alert("Warrenty day can not be Less than Added Day"); 
        warr.focus(); 
        return false; 
    }
    
    if (loc.value == "")                                  
    { 
        window.alert("Plese Enter Item Location"); 
        loc.focus(); 
        return false; 
    }
    
    if (des.value == "")                                  
    { 
        window.alert("Plese Enter Item Description"); 
        des.focus(); 
        return false; 
    }
    
    return true;  
}

function InventoryRefill()                                    
{ 
    var iname = document.forms["Refill"]["itemName"];               
    var add = document.forms["Refill"]["addedDay"];
    var loc = document.forms["Refill"]["location"];
    var des = document.forms["Refill"]["description"];
    
    
    
    if (iname.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Name"); 
    	iname.focus(); 
        return false; 
    } 
    
    
    
    if (add.value == "")                                  
    { 
    	window.alert("Plese Enter Added Date"); 
    	add.focus(); 
        return false; 
    }
    
    if (loc.value == "")                                  
    { 
        window.alert("Plese Enter Item Location"); 
        loc.focus(); 
        return false; 
    }
    
    if (des.value == "")                                  
    { 
    	window.alert("Plese Enter Item Description"); 
    	des.focus(); 
        return false; 
    }
    
    return true; 
}

function InventoryRefilluPDATE()                                    
{ 
    var iname = document.forms["RefillUPPDATE"]["itemName"];               
    var add = document.forms["RefillUPPDATE"]["addedDay"];
    var loc = document.forms["RefillUPPDATE"]["location"];
    var des = document.forms["RefillUPPDATE"]["description"];
    
    
    
    if (iname.value == "")                                  
    { 
    	 window.alert("Plese Enter Item Name"); 
    	iname.focus(); 
        return false; 
    } 
    
    
    
    if (add.value == "")                                  
    { 
    	window.alert("Plese Enter Added Date"); 
    	add.focus(); 
        return false; 
    }
    
    if (loc.value == "")                                  
    { 
        window.alert("Plese Enter Item Location"); 
        loc.focus(); 
        return false; 
    }
    
    if (des.value == "")                                  
    { 
    	window.alert("Plese Enter Item Description"); 
    	des.focus(); 
        return false; 
    }
    
    return true; 
}


function PurchaseOrder()                                    
{ 
    var date = document.forms["PO"]["date"];               
    var des = document.forms["PO"]["description"];
    
    
    
    
    if (date.value == "")                                  
    { 
    	 window.alert("Plese Enter Date"); 
    	 date.focus(); 
        return false; 
    } 
    
    
    
    if (des.value == "")                                  
    { 
    	window.alert("Plese Enter Description"); 
    	des.focus(); 
        return false; 
    }
    
    
    
    
    return true; 
}


function PurchaseOrderDetails()                                    
{ 
    var name = document.forms["POD"]["itemName"];               
    var qty = document.forms["POD"]["qty"];
    var pri = document.forms["POD"]["price"];
    
    
    
    
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
    
    if (qty.value < 0)                                  
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
    
    if (pri.value < 0)                                  
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





function addQuotation()                                    
{ 
    var SupNAme = document.forms["AddQuotation"]["supName"];
    var contactForFocus = document.forms["AddQuotation"]["con"];
    var contact = document.AddQuotation.con.value.length;
    var contactvalue = document.AddQuotation.con.value;
    var supEmail = document.forms["AddQuotation"]["email"];
    var supAaddress1 = document.forms["AddQuotation"]["ad1"];
    var supAaddress2 = document.forms["AddQuotation"]["ad2"];
    var supDiscount = document.forms["AddQuotation"]["dis"];
    var supUP = document.forms["AddQuotation"]["price"]; 
    var supDes = document.forms["AddQuotation"]["desc"];
    var button = document.forms["AddQuotation"]["btn"];
 
    if (SupNAme.value == "")                                  
    { 
    	 window.alert("Plese Enter Supplier Name!"); 
    	 SupNAme.focus(); 
        return false; 
    }
    
    if (contactForFocus.value == "")                                  
    { 
    	 window.alert("Plese Enter Supplier Contact Number!"); 
    	 contactForFocus.focus(); 
        return false; 
    }
    
    if (isNaN(contactvalue))                                  
    { 
    	 window.alert("Supplier Contact can not contain Strings!"); 
    	 contactForFocus.focus(); 
        return false; 
    }
    
    
    
    if (contact > 10)                                  
    { 
    	 window.alert("Supplier Contact Number can not be Greater Than 10!"); 
    	 contactForFocus.focus(); 
        return false; 
    }
    
    if (contact < 10)                                  
    { 
    	 window.alert("Supplier Contact Number can not be Less Than 10!"); 
    	 contactForFocus.focus(); 
        return false; 
    }
    
    if (supEmail.value == "")                                  
    { 
    	 window.alert("Plese Enter Supplier Email!"); 
    	 supEmail.focus(); 
        return false; 
    }
    
    if (supAaddress1.value == "")                                  
    { 
    	 window.alert("Plese Enter Supplier Address Line 1!"); 
    	 supAaddress1.focus(); 
        return false; 
    }
    
    if (supAaddress2.value == "")                                  
    { 
    	 window.alert("Plese Enter Supplier Address Line 2!"); 
    	 supAaddress2.focus(); 
        return false; 
    }
    
    if (supDiscount.value == "")                                  
    { 
    	 window.alert("Plese Enter Discount For PO!"); 
    	 supDiscount.focus(); 
        return false; 
    }
    
    if (supUP.value == "")                                  
    { 
    	window.alert("Plese Enter Prices!");
    	supUP.focus();
    	return false; 
    	  
    }
    
    if (supDes.value == "")                                  
    { 
    	 window.alert("Plese Enter Description!"); 
    	 supDes.focus(); 
        return false; 
    }
    
    
    
    
   
    return true; 
}




