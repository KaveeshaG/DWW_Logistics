<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">
	
</head>
<body>
	
 	<%-- <jsp:include page="WEB-INF\views\InventoryManager\InventryManagerHome.jsp"></jsp:include>   --%>
 	 
 	   <%--  <jsp:include page="WEB-INF\views\Supplier\SearchProduct.jsp"></jsp:include>  --%>
 	   
   
  <div class="container">

   
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
           
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block ">
              
               <img class="img-fluid" src="img\Supplier\loin.jpg" style="width: 100%; height: 510px" alt="Sample image">
              </div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
                  </div>
                  <form class="user" action="Login?action=LOGIN" method="POST">
                    <div class="form-group">
                      <input type="text" class="form-control form-control-user" name="userName" id="exampleInputEmail" aria-describedby="emailHelp" placeholder="Enter User Name...">
                    </div>
                    <div class="form-group">
                      <input type="password" class="form-control form-control-user" name="password" id="exampleInputPassword" placeholder="Password">
                    </div>
                    <div class="form-group">
                      <div class="custom-control custom-checkbox small">
                        <input type="checkbox" class="custom-control-input" id="customCheck">
                        <label class="custom-control-label" for="customCheck">Remember Me</label>
                      </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-user btn-block">
                      Login
                    </button>
               
                    
                    
                  </form>
                  <hr>
                   <form class="user" action="Login?action=REG" method="POST">
                  <button type="submit" class="btn btn-google btn-user btn-block">
                      Supplier SignUp
                    </button>
                    </form>
                    <br>
                  <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="register.html">Create an Account!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

  </div> 

 <!--  Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

 <!--  Custom scripts for all pages -->
  <script src="js/sb-admin-2.min.js"></script>
 	 
 	   
 	   
 	    
 	   

	
</body>
</html>