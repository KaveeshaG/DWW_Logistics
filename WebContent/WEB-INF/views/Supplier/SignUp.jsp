<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block ">
          <img class="img-fluid" src="img\Supplier\SignUp.jpg" style="width: 100%; height: 610px" alt="Sample image">
          </div>
          <div class="col-lg-7">
            <div class="p-5">
							<div class="form-group col-md-12 text-dark text-center">
										<h2>
											<b>SUPPLIER SIGNUP</b>
										</h2>
									</div>
									
									
									<form role="form" action="AddSupplier?action=SIGNUP" method="POST" class="user" name="supSignUp" onsubmit="return SupllierSignUpvalidations()">
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
										<input class="form-control " placeholder="Enter Contact Number" type="text+" name="ContactNumber">
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

									<button type="submit" class="btn btn-primary btn-user btn-block">
									Supplier SignUp</button>

								</div>
							</form>
									
									
									
							

						</div>
          </div>
        </div>
      </div>
    </div>

  </div>
  
  
  <script src="js/SupplierValidations.js"></script>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

</body>
</html>