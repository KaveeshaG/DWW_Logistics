<%@page import="com.wms.service.SupplierServices"%>
<%@page import="com.wms.service.Supplier"%>
<%@page import="com.wms.model.SupplierAcount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Supplier</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	
	<%
		String supplierID = (String) request.getAttribute("supID");
		Supplier supplier = new SupplierServices();
		SupplierAcount acount = supplier.getSupplierDetailsByID(supplierID);
	
	
	
	%>
	
	
	 <div class="col-xl-12 col-md-6 mb-4">
              <div class="card shadow h-100 py-2">
                <div class="card-body">
                
                <div class="container-fluid ">
                
                	<h4 class="modal-title text-success mb-3" id="exampleModalLabel">Update Supplier</h4>
                
                	<div class="row">

						<div class="col-md-12">
							<form role="form" action="UpdateSupplierAccount" method="POST" name="UpdateSupplier" onsubmit="return UpdateSupplierAccount()">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-success">User Name</label> <input class="form-control"  placeholder="Enter UserName" type="text" value="<%=acount.getUserName() %>" name="UserName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success">Password
											</label> <input class="form-control " value="<%=acount.getPassword() %>"   placeholder="Enter Password" type="text" name="Password">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success ">Name</label>
										<input class="form-control " placeholder="Enter Name"  value="<%=acount.getName()%>" type="text" name="Name">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success">Address</label>
										<input class="form-control " placeholder="Enter Address" type="text" value="<%=acount.getAddress() %>"  name="Address">
									</div>
								</div>
								
								
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success ">Email</label>
										<input class="form-control " placeholder="Enter Email" type="text" value="<%=acount.getEmail()%>"  name="Email">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success">Contact Number</label>
										<input class="form-control " placeholder="Enter Contact Number" type="text" value="<%=acount.getContactNo()%>"  name="ContactNumber">
									</div>
								</div>
								
								
								<div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label  class="loginFormElement text-success">Review</label>
                                                <input 
                                                class="form-control" placeholder="Review" name="Review" value="<%=acount.getReview()%>" >
                                            </div>
                                        </div>
                                    </div>


							

								<div class="form-group">
									<input type="hidden" value="IM"  name="place">
									<input type="hidden" value="<%=acount.getSupplierId()%>"  name="supID">
									<button type="submit" id="loginSubmit"
										class="btn btn-success loginFormElement">Update Supplier</button>

								</div>
							</form>

						</div>









					</div>



                
                
                
                </div>
 </div>
  </div>
</div>
        
        
		
	
	



	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>
  <script src="js/sb-admin-2.js"></script>





</body>
</html>