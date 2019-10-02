<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Packages</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	 <div class="col-xl-12 col-md-6 mb-4">
              <div class="card shadow h-100 py-2">
                <div class="card-body">
                
                <div class="card card-cascade narrower">

  <!--Card image-->
  <div
    class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">

   

    <a href="" class="white-text mx-3">PACKAGES</a>

    <div>
            <a href="#!"><button type="button" class="btn btn-primary" data-toggle="modal" href="#packagesModal">Add Packages</button></a>
<button type="button" class="btn btn-danger">Delete All</button>      
    </div>

  </div>
                
                
 <table class="table">
  <thead class=" bg-primary text-white">
    <tr>
      <th scope="col">Package Id</th>
      <th scope="col">Total Price</th>
      <th scope="col">Bonus</th>
     
      <th scope="col">OPTIONS</th>
      </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Markr</td>
      <td>Otto</td>
      
      <td><div>
      <button type="button" class="btn btn-outline-success btn-rounded btn-sm px-2">
        <i class="fas fa-pencil-alt mt-0"></i>
      </button>
      <button type="button" class="btn btn-outline-danger btn-rounded btn-sm px-2">
        <i class="far fa-trash-alt mt-0"></i>
      </button>
      
    </div></td>
      </tr>
      
      
     <tr>
      <th scope="row">1</th>
      <td>Markr</td>
      <td>Otto</td>
      
      <td><div>
      <button type="button" class="btn btn-outline-success btn-rounded btn-sm px-2">
        <i class="fas fa-pencil-alt mt-0"></i>
      </button>
      <button type="button" class="btn btn-outline-danger btn-rounded btn-sm px-2">
        <i class="far fa-trash-alt mt-0"></i>
      </button>
      
    </div></td>
      </tr>
    
  </tbody>
</table>


                  
                  
                  
                </div>
              </div>
            </div>
	
	</div>
	
	
	
<div class="modal fade bd-example-modal-lg" id="packagesModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
  <script src="js/sb-admin-2.js"></script>



</body>
</html>