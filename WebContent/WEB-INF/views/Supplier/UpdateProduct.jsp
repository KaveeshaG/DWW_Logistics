<%@page import="java.text.DecimalFormat"%>
<%@page import="com.wms.service.SupplierServices"%>
<%@page import="com.wms.service.Supplier"%>
<%@page import="com.wms.model.SupplierProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	
	<%
				String productID = (String) request.getAttribute("proID");
				Supplier supplier = new SupplierServices();
				SupplierProduct product  = supplier.getProductByID(productID);
				DecimalFormat form = new DecimalFormat("0.00");
	%>

	<div class="col-xl-12 col-md-6 mb-4">
		<div class="card shadow h-100 py-2">
			<div class="card-body">

				<div class="container-fluid ">

					<h4 class="modal-title text-success mb-3" id="exampleModalLabel">Update
						Product</h4>
					<div>
					<div class="row">

						<div class="col-md-12">
						
							<div class="row">

						<div class="col-md-12">
							<form role="form" action="UpdateSupplierProduct" method="POST" name="UpdateProduct" onsubmit="return UpdateProducts()">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-success">Product
											Name</label> <input class="form-control"  value="<%=product.getProductName()%>" type="text" name="productName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success">Product
											Price</label> <input class="form-control "  value="<%=form.format(product.getProPrice())%>" type="number" name="productPrice">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success ">Quantity</label>
										<input class="form-control " value="<%=product.getQty()%>" type="number" name="productQuentity">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-success">Warranty</label>
										<input class="form-control " value="<%=product.getWarranty()%>" type="text" name="warrenty">
									</div>
								</div>
								
								<div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label  class="loginFormElement text-success">Product Description</label>
                                                <input  class="form-control" value="<%=product.getDescription()%>"  name="productDescription">
                                            </div>
                                        </div>
                                    </div>


								<div class="form-group">

									<label class="control-label text-success">Product Image - <%=product.getImageName()%></label><br/>
									<input class="filestyle" data-icon="false"  type="file" name="imageName">

								</div>
								<input type="hidden" name="proID" value="<%=product.getProductId()%>">
								<input type="hidden" name="imageDbNAme" value="<%=product.getImageName()%>">
								
								<div class="form-group">
									<button type="submit" id="loginSubmit"
										class="btn btn-success loginFormElement">Update</button>

								</div>
								
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