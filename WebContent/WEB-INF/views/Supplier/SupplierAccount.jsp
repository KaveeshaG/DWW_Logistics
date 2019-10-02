<%@page import="com.wms.model.SupplierAcount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supplier Account</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
	SupplierAcount acount = (SupplierAcount) session.getAttribute("Supplier");
	
	%>
	

  <h2 class="h1-responsive font-weight-bold text-center my-5 text-dark">SUPPLIER SPACE <%=acount.getSupplierId() %></h2>

  <div class="row">

    <div class="col-lg-4 col-md-12 mb-lg-0 mb-5">

      <!-- Featured news -->
      <div class="single-news mb-3">

        <!-- Image -->
        <div class="view overlay rounded z-depth-2 mb-4">
          <img class="img-fluid" src="img\Supplier\pro.jpg" style="width: 100%; height: 200px" alt="Sample image">
          <a>
            <div class="mask rgba-white-slight"></div>
          </a>
        </div>

        <!-- Grid row -->
        <div class="row mb-3">

          <!-- Grid column -->
          <div class="col-12">

            <!-- Badge -->
            <a href="#!"><button type="button" class="btn btn-primary" data-toggle="modal" href="#addModal">Add Products</button></a>

          </div>
          <!-- Grid column -->

        </div>
        <!-- Grid row -->

        <!-- Title -->
        <div class="d-flex justify-content-between">
          <div class="col-11 text-truncate pl-0 mb-3">
          <a href="SupplierSideBarManager?action=SVIEW"><button type="button" class="btn btn-info">View</button></a><br>
          
            <a class="font-weight-bold">Product Management</a>
            
          </div>
          <a><i class="fas fa-angle-double-right"></i></a>
        </div>

      </div>
      
	</div>
    
    <div class="col-lg-4 col-md-6 mb-md-0 mb-5">

      <!-- Featured news -->
      <div class="single-news mb-3">

        <!-- Image -->
        <div class="view overlay rounded z-depth-2 mb-4">
          <img class="img-fluid" src="img\Supplier\ser.jpg" style="width: 100%; height: 200px" alt="Sample image">
          <a>
            <div class="mask rgba-white-slight"></div>
          </a>
        </div>

        <!-- Grid row -->
        <div class="row mb-3">

          <!-- Grid column -->
          <div class="col-12">

            <!-- Badge -->
            <a href="#!"><button type="button" class="btn btn-success"  data-toggle="modal" href="#btModal">Add Services</button></a>

          </div>
          <!-- Grid column -->

        </div>
        <!-- Grid row -->

        <!-- Title -->
        <div class="d-flex justify-content-between">
          <div class="col-11 text-truncate pl-0 mb-3">
          
          <a href="SupplierSideBarManager?action=SERVIEW"><button type="button" class="btn btn-info">View</button></a><br>
            <a class="font-weight-bold">Service Management</a>
          </div>
          <a><i class="fas fa-angle-double-right"></i></a>
        </div>

      </div>
      

    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-lg-4 col-md-6 mb-0">

      <!-- Featured news -->
      <div class="single-news mb-3">

        <!-- Image -->
        <div class="view overlay rounded z-depth-2 mb-4">
          <img class="img-fluid" src="img\Supplier\pac.jpg" style="width: 100%; height: 200px" alt="Sample image">
          <a>
            <div class="mask rgba-white-slight"></div>
          </a>
        </div>

        <!-- Grid row -->
        <div class="row mb-3">

          <!-- Grid column -->
          <div class="col-12">

            <!-- Badge -->
            <a href="#!"><button type="button" class="btn btn-warning"  data-toggle="modal" href="#pkModal">Add Packages</button></a>

          </div>
          <!-- Grid column -->

        </div>
        <!-- Grid row -->

        <!-- Title -->
        <div class="d-flex justify-content-between">
          <div class="col-11 text-truncate pl-0 mb-3">
          
           <a href="SupplierSideBarManager?action=PKGVIEW"><button type="button" class="btn btn-info">View</button></a><br>
            <a class="font-weight-bold">Package Management</a>
          </div>
          <a><i class="fas fa-angle-double-right"></i></a>
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










	
	<div class="modal fade bd-example-modal-lg" id="btModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title text-white" id="exampleModalLabel">Add Services</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" style="color: white ">&times;</span>
					</button>
				</div>

				

				<div class="container">



					<div class="row">

						<div class="col-md-12">
							<form role="form" action="AddNewProduct" method="POST">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-primary">Service Name</label> <input class="form-control"  placeholder="Enter Name" type="text" name="servicetName">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Service
											Price</label> <input class="form-control "  placeholder="Enter Service Price" type="number" name="servicetPrice">
									</div>
								
								</div>
								<div class="row mt-1">
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary ">Hour Amount</label>
										<input class="form-control " placeholder="Hour Amount" type="number" name="hourAmount">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Service Description</label>
										<input class="form-control " placeholder="Enter Description" type="text" name="description">
									</div>
								</div>
								
								

								

								<div class="form-group">

									<button type="submit" id="loginSubmit"
										class="btn btn-primary loginFormElement">Add Service</button>

								</div>
							</form>

						</div>









					</div>



				</div>
			</div>
		</div>
	</div>




<div class="modal fade bd-example-modal-lg" id="pkModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h5 class="modal-title text-white" id="exampleModalLabel">Add Packages</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" style="color: white ">&times;</span>
					</button>
				</div>

				

				<div class="container">



					<div class="row">

						<div class="col-md-12">
							<form role="form" action="AddNewProduct" method="POST">
								<div class="row mt-2">
									<div class="form-group col-md-6"> 
										<label  class="loginFormElement text-primary">Total Price</label> <input class="form-control"  placeholder="Enter total price" type="number" name="totalPrice">
									</div>
	
	
									<div class="form-group col-md-6">
										<label  class="loginFormElement text-primary">Bonus
											</label> <input class="form-control "  placeholder="Enter bonus" type="number" name="bonus">
									</div>
								
								</div>
								
								
								

								

								<div class="form-group">

									<button type="submit" id="loginSubmit"
										class="btn btn-primary loginFormElement">Add Package</button>

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
  <script src="js/SupplierValidations.js"></script>

</body>
</html>