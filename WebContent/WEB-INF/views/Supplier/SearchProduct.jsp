<%@page import="java.text.DecimalFormat"%>
<%@page import="com.wms.model.SupplierAcount"%>
<%@page import="com.wms.model.SupplierProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.SupplierServices"%>
<%@page import="com.wms.service.Supplier"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/sb-admin-2.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Search Products</title>



</head>
<body>

	<%
				String productID = (String) request.getAttribute("proID");
				Supplier supplier = new SupplierServices();
				SupplierProduct product  = supplier.getProductByID(productID);
				DecimalFormat form = new DecimalFormat("0.00");
	%>
	
	<jsp:include page="header.jsp"></jsp:include>

	<div class="col-xl-12 col-md-6 mb-4">
		<div class="card shadow h-100 py-2">
			<div class="card-body">
				<div class="row">
				
				<div class="col-md-4 ">
				
					<img alt="Sample Product Image" src="img/Supplier/<%=product.getImageName() %>" style="width:100%;height:428px;" class="rounded"> 
					<!--object-fit: cover  -->
				
				
				</div>
				
				
				
              <div class="col-md-8">
                	<div class="card shadow h-100 py-2">
			<div class="card-body">

				<div class="container-fluid ">

					<h4 class="modal-title text-primary mb-3" id="exampleModalLabel"><%=productID%></h4>
					<div>
					<div class="row">

						<div class="col-md-12">
						
							<div class="row">

						<div class="col-md-12">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-primary">Product
											Name</label> <input class="form-control"  value="<%=product.getProductName()%>" type="text" name="productName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Product
											Price</label> <input class="form-control "  value="<%=form.format(product.getProPrice())%>" type="number" name="productPrice">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Quantity</label>
										<input class="form-control " value="<%=product.getQty()%>" type="number" name="productQuentity">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Warranty</label>
										<input class="form-control " value="<%=product.getWarranty()%>" type="text" name="warrenty">
									</div>
								</div>
								
								<div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label  class="loginFormElement text-primary">Product Description</label>
                                                <input  class="form-control" value="<%=product.getDescription()%>"  name="productDescription">
                                            </div>
                                        </div>
                                    </div>
								
							<div class="row d-flex justify-content-center" >
								
								
								<form action="SupplierServletManager?action=EDITPRO" method="POST">
										<input type="hidden" value="<%=product.getProductId()%>" name="proID">
										<button type="submit"
											class="btn btn-success ">Update
											
										</button>
										
										
										</form>
										<form action="SupplierDeleteProductByID" method="POST">
											<button type="submit"
												class="btn btn-danger ml-2">Delete
												
											</button>
											<input type="hidden" name="productID" value="<%=product.getProductId()%>">

										</form>
								
								
								

							</div>
								
								
						

						</div>




</div>




					</div>
							
						
						
						
						
						
						
						</div>
					</div>
				</div>
			</div>
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