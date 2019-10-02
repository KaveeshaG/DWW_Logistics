<%@page import="java.text.DecimalFormat"%>
<%@page import="com.wms.model.SupplierAcount"%>
<%@page import="com.wms.service.Supplier"%>
<%@page import="com.wms.model.SupplierProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.wms.service.SupplierServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<%
		SupplierAcount acount = (SupplierAcount) session.getAttribute("Supplier");
		String supplierID = acount.getSupplierId();
	%>
	<jsp:include page="header.jsp"></jsp:include>

	<div class="col-xl-12 col-md-6 mb-4">
		<div class="card shadow h-100 py-2">
			<div class="card-body">

				<div class="">

					<!--Card image-->
					<div
						class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">



						<a href="SupplierSideBarManager?action=ALLVIEW" class="white-text mx-3">PRODUCTS</a>

						<div class="row">
							<a href="#!"><button type="button" class="btn btn-primary"
									data-toggle="modal" href="#addModal">Add Products</button></a>
									
							<form action="SupplierDeleteAllProducts" method="POST">
								<input type="hidden" name="supID" value="<%=supplierID%>">
								<button type="submit" class="btn btn-danger ml-1">Delete All</button>
								
							</form>
						</div>

					</div>
					
					
						<%
						DecimalFormat form = new DecimalFormat("0.00");
							Supplier isupplier = new SupplierServices();
							ArrayList<SupplierProduct> productList= isupplier.getProductTableList(acount.getSupplierId());
						
							
						%>
					
					
					
					


					<table class="table">
						<thead class=" bg-primary text-white">
							<tr>
								<th scope="col">Product ID</th>
								<th scope="col">Product Name</th>
								<th scope="col">Product Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Warranty</th>
								<th scope="col">Product Description</th>
								<th scope="col">OPTIONS</th>
							</tr>
						</thead>
						
						<%
							for(SupplierProduct product : productList){%>
						
						
						<tbody>
							<tr>
								<th scope="row"><%=product.getProductId()%></th>
								<td><%=product.getProductName()%></td>
								<td><%=form.format(product.getProPrice())%></td>
								<td><%=product.getQty()%></td>
								<td><%=product.getWarranty()%></td>
								<td><%=product.getDescription()%></td>
								<td><div class="row">
										<form action="SupplierServletManager?action=EDITPRO" method="POST">
										<input type="hidden" value="<%=product.getProductId()%>" name="proID">
										<button type="submit"
											class="btn btn-outline-success btn-rounded btn-sm px-2">
											<i class="fas fa-pencil-alt mt-0"></i>
										</button>
										
										
										</form>
										<form action="SupplierDeleteProductByID" method="POST">
											<button type="submit"
												class="btn btn-outline-danger btn-rounded btn-sm px-2 ml-2">
												<i class="far fa-trash-alt mt-0"></i>
											</button>
											<input type="hidden" name="productID" value="<%=product.getProductId()%>">

										</form>

									</div></td>
							</tr>


							
						</tbody>
						
						<%} %>
					</table>





				</div>
			</div>
		</div>

	</div>



	<div class="modal fade bd-example-modal-lg" id="addModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title text-white" id="exampleModalLabel">Add Products</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" style="color: white ">&times;</span>
					</button>
				</div>

				

				<div class="container">



					<div class="row">

						<div class="col-md-12">
							<form role="form" action="AddNewProduct" method="POST" name="Product" onsubmit="return AddProducts()">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-primary">Product
											Name</label> <input class="form-control"  placeholder="Enter Name" type="text" name="productName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Product
											Price</label> <input class="form-control "  placeholder="Enter Price" type="number" name="productPrice">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Quantity</label>
										<input class="form-control " placeholder="Enter Quantity" type="number" name="productQuentity">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Warranty</label>
										<input class="form-control " placeholder="Enter Warranty" type="text" name="warrenty">
									</div>
								</div>
								
								<div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label  class="loginFormElement text-primary">Product Description</label>
                                                <textarea rows="3" class="form-control" placeholder="description"  name="productDescription"></textarea>
                                            </div>
                                        </div>
                                    </div>


								<div class="form-group">

									<label class="control-label text-primary">Product Image</label><br/>
									<input class="filestyle" data-icon="false" type="file" name="imageName">

								</div>

								<div class="form-group">
									<input type="hidden" name="supID" value="<%=acount.getSupplierId() %>">
									<button type="submit" id="loginSubmit"
										class="btn btn-primary loginFormElement">Add Product</button>

								</div>
							</form>

						</div>









					</div>



				</div>
			</div>
		</div>
	</div>

       


	<script src="js/SupplierValidations.js"></script>

	<!-- <script src="js/SupplierValidations.js"></script> -->
	<jsp:include page="footer.jsp"></jsp:include>
	
	<!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

</body>
</html>