<%@page import="com.wms.model.SupplierAcount"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.SupplierServices"%>
<%@page import="com.wms.service.Supplier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Suppliers</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

 <div class="col-xl-12 col-md-6 mb-4">
		<div class="card shadow h-100 py-2 border-left-primary">
			<div class="card-body">

				<div class="">

					<!--Card image-->
					<div
						class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center mt-3">



						<h4 class="text-primary">All Suppliers</h4>

						<div class="row">
							<a href="#!"><button type="button" class="btn btn-primary"
									data-toggle="modal" href="#addsuptModal">Add Suppliers</button></a>
									
							<form action="SupplierDeleteAllAccounts" method="POST">
								<button type="submit" class="btn btn-danger ml-1">Delete All</button>
								
							</form>
						</div>

					</div>
					
					
						
					
					
					


					<table class="table">
						<thead class=" bg-primary text-white">
							<tr>
								<th scope="col">SupplierId</th>
								<th scope="col">UserName</th>
								<th scope="col">Password</th>
								<th scope="col">Name</th>
								<th scope="col">Address</th>
								<th scope="col">Email</th>
								<th scope="col">ContactNo</th>
								<th scope="col">Review</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						
						<%
							Supplier supplier = new SupplierServices();
							ArrayList<SupplierAcount> supplierList = supplier.getSupplierTableList();
							for(SupplierAcount acount : supplierList){
						
						%>



						<tbody>
							<tr>
								<th scope="row"><%=acount.getSupplierId() %></th>
								<td><%=acount.getUserName()%></td>
								<td><%=acount.getPassword()%></td>
								<td><%=acount.getName() %></td>
								<td><%=acount.getAddress() %></td>
								<td><%=acount.getEmail()%></td>
								<td><%=acount.getContactNo()%></td>
								<td><%=acount.getReview()%></td>
								

								<td><div class = row>
										<form action="SupplierServletManager?action=USA" method="POST">
										<input type="hidden" name="supplierID" value="<%=acount.getSupplierId()%>">
										<button type="submit"
											class="btn btn-outline-success btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										
										
										</form>
										<form action="SupplierDeleteAccountById" method="POST">
											<button type="submit"
												class="btn btn-outline-danger btn-rounded btn-sm px-2 ml-2">
												<i class="far fa-trash-alt mt-0"></i>
											</button>
											<input type="hidden" name="supplierID" value="<%=acount.getSupplierId()%>">

										</form>

									</div></td>
							</tr>



						</tbody>

						<%
							}
						%>
					</table>





				</div>
			</div>
		</div>

	</div>



	<div class="modal fade bd-example-modal-lg" id="addsuptModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title text-white" id="exampleModalLabel">Add Suppliers</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" style="color: white ">&times;</span>
					</button>
				</div>

				

				<div class="container">



					<div class="row">

						<div class="col-md-12">
							<form role="form" action="AddSupplier?action=IM" method="POST" class="user" name="supSignUp" onsubmit="return SupllierSignUpvalidations()">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-primary">Username</label> <input class="form-control"  placeholder="Enter UserName" type="text" name="UserName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Password
											</label> <input class="form-control "  placeholder="Enter Password" type="password" name="Password">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Name</label>
										<input class="form-control " placeholder="Enter Name" type="text" name="Name">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Address</label>
										<input class="form-control " placeholder="Enter Address" type="text" name="Address">
									</div>
								</div>
								
								
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Email</label>
										<input class="form-control " placeholder="Enter Email" type="email" name="Email">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Contact Number</label>
										<input class="form-control " placeholder="Enter Contact Number" type="text" name="ContactNumber">
									</div>
								</div>
								
								
								<div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label  class="loginFormElement text-primary">Review</label>
                                                <textarea rows="3" class="form-control" placeholder="Review" type="text"  name="Review"></textarea>
                                            </div>
                                        </div>
                                    </div>


							

								<div class="form-group">

									<button type="submit" id="loginSubmit"
										class="btn btn-primary loginFormElement">Add Suppliers</button>

								</div>
							</form>

						</div>









					</div>



				</div>
			</div>
		</div>
	</div>


<script src="js/SupplierValidations.js"></script>

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