<%@page import="com.wms.service.SupplierServices"%>
<%@page import="com.wms.service.Supplier"%>
<%@page import="com.wms.model.SupplierAcount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier Profile</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	
	<%
				SupplierAcount acount1 = (SupplierAcount) session.getAttribute("Supplier");
				String supplierID = acount1.getSupplierId();
				Supplier supplier = new SupplierServices();
				SupplierAcount acount = supplier.getSupplierDetailsByID(supplierID);
			%>
	
	
	 <div class="col-xl-12 col-md-6 mb-4">
              <div class="card shadow h-100 py-2">
                <div class="card-body">
                
                <div class="container-fluid ">
                
                	<h4 class="modal-title text-primary mb-3" id="exampleModalLabel"><%=acount.getUserName() %> Profile</h4>
                
                	<div class="row">

						<div class="col-md-12">
							<form role="form" action="SupplierSideBarManager?action=UPDATESUP" method="POST">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-primary">User Name</label> <input class="form-control"  placeholder="Enter UserName" type="text" disabled="disabled" value="<%=acount.getUserName() %>" name="UserName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Password
											</label> <input class="form-control " value="<%=acount.getPassword() %>" disabled="disabled"  placeholder="Enter Password" type="text" name="Password">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Name</label>
										<input class="form-control " placeholder="Enter Name"  value="<%=acount.getName()%>" disabled="disabled" type="text" name="Name">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Address</label>
										<input class="form-control " placeholder="Enter Address" type="text" disabled="disabled" value="<%=acount.getAddress() %>"  name="Address">
									</div>
								</div>
								
								
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Email</label>
										<input class="form-control " placeholder="Enter Email" type="text" disabled="disabled" value="<%=acount.getEmail()%>"  name="Email">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Contact Number</label>
										<input class="form-control " placeholder="Enter Contact Number" type="text" disabled="disabled" value="<%=acount.getContactNo()%>"  name="ContactNumber">
									</div>
								</div>
								
								
								<div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label  class="loginFormElement text-primary">Review</label>
                                                <input 
                                                class="form-control" placeholder="Review" disabled="disabled" name="Review" value="<%=acount.getReview()%>" >
                                            </div>
                                        </div>
                                    </div>


							

								<div class="form-group">
									<input type="hidden" value="<%=acount.getSupplierId()%>"  name="supID">
									<button type="submit" id="loginSubmit"
										class="btn btn-success loginFormElement">Update Profile</button>

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