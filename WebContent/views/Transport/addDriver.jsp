<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%@page import ="com.wms.model.dataModel"%>
<%@page import ="com.wms.util.dbConnector" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>DWW Logistics</title>

  <!-- Custom fonts for this template-->
  <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link
    href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
    rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="../../css/sb-admin-2.min.css" rel="stylesheet">
  <link href="../../css/transport-admin.css" rel="stylesheet">

</head>

<body id="page-top">

  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-dolly"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Transport Admin</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider">

       <!-- Nav Item - Driver -->
      <li class="nav-item">
        <a class="nav-link" href="transport.jsp">
          <i class="fas fa-truck"></i>
          <span>Transport</span></a>
      </li>
      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Driver -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true"
          aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Driver</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="py-2 collapse-inner rounded">
            <ul class="sub-menu-t">
              <li class="nav-item active">
                <a href="addDriver.jsp" class="nav-link ">
                  <span class="title">Add New Driver</span>
                </a>
              </li>
              <li class="nav-item">
                <a href="allDrivers.jsp" class="nav-link ">
                  <span class="title">All Drivers</span>
                </a>
              </li>
              <li class="nav-item">
                <a href="driverPayment.jsp" class="nav-link ">
                  <span class="title">Driver Payment</span>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </li>
      <!-- Nav Item - Job-post -->
      <li class="nav-item">
        <a class="nav-link" href="jobPost.jsp">
          <i class="fas fa-tasks"></i>
          <span>Jobs</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

      <!-- Sidebar Toggler (Sidebar) -->
      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- Topbar Search -->
          <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
              <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                aria-label="Search" aria-describedby="basic-addon2">
              <div class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fas fa-search fa-sm"></i>
                </button>
              </div>
            </div>
          </form>

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
              <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-search fa-fw"></i>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                aria-labelledby="searchDropdown">
                <form class="form-inline mr-auto w-100 navbar-search">
                  <div class="input-group">
                    <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                      aria-label="Search" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                      <button class="btn btn-primary" type="button">
                        <i class="fas fa-search fa-sm"></i>
                      </button>
                    </div>
                  </div>
                </form>
              </div>
            </li>

            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-bell fa-fw"></i>
                <!-- Counter - Alerts -->
                <span class="badge badge-danger badge-counter">3+</span>
              </a>
              <!-- Dropdown - Alerts -->
             <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                aria-labelledby="alertsDropdown">
                <h6 class="dropdown-header">
                  Alerts Center
                </h6>
                 <%try{

              		dbConnector db = new dbConnector();
              		String sql = "SELECT * FROM job";
            	    ResultSet rs = db.getData(sql);   
            	    
            	    while(rs.next()){ %>
            	    
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="mr-3">
                    <div class="icon-circle bg-primary">
                      <i class="fas fa-file-alt text-white"></i>
                    </div>
                  </div>                 
                  <div>
                    <div class="small text-gray-500"><%= rs.getString("date") %></div>
                    <span class="font-weight-bold">New Hire Avalable From <%= rs.getString("tripFrom") %>To <%= rs.getString("tripTo") %></span>
                  </div>
                </a> 
                <%
            	    }
                 }catch(Exception e){
                 	e.printStackTrace();
                 }
                 
                %>            
                <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
              </div>
            </li>

            <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
              <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-envelope fa-fw"></i>
                <!-- Counter - Messages -->
                <span class="badge badge-danger badge-counter">7</span>
              </a>
              <!-- Dropdown - Messages -->
              <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                aria-labelledby="messagesDropdown">
                <h6 class="dropdown-header">
                  Message Center
                </h6>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/fn_BT9fwg_E/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div class="font-weight-bold">
                    <div class="text-truncate">Hi there! I am wondering if you can help me with a problem I've been
                      having.</div>
                    <div class="small text-gray-500">Emily Fowler � 58m</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/AU4VPcFN4LE/60x60" alt="">
                    <div class="status-indicator"></div>
                  </div>
                  <div>
                    <div class="text-truncate">I have the photos that you ordered last month, how would you like them
                      sent to you?</div>
                    <div class="small text-gray-500">Jae Chun � 1d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/CS2uCrpNzJY/60x60" alt="">
                    <div class="status-indicator bg-warning"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Last month's report looks great, I am very happy with the progress so
                      far, keep up the good work!</div>
                    <div class="small text-gray-500">Morgan Alvarez � 2d</div>
                  </div>
                </a>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <div class="dropdown-list-image mr-3">
                    <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
                    <div class="status-indicator bg-success"></div>
                  </div>
                  <div>
                    <div class="text-truncate">Am I a good boy? The reason I ask is because someone told me that people
                      say this to all dogs, even if they aren't good...</div>
                    <div class="small text-gray-500">Chicken the Dog � 2w</div>
                  </div>
                </a>
                <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
              </div>
            </li>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
                <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
              </a>
              <!-- Dropdown - User Information -->
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="profile.jsp ">
                  <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                  Profile
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Settings
                </a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                  Activity Log
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">
          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Add Driver</h1>
          <!-- Content Row -->
          <div class="row">
            <div class="col-xl-12 ">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Basic Information</h6>
                </div>
                <div class="card-body">
                  <form class="user" id="driverInfoForm">
                    <div class="form-group row">
                      <!--  <div class="col-12">
	                    <div class="alert alert-success" style="display:none; transition-duration: 5s;" role="alert" id="succerssMsg">
	                    	Data Insert Successful! 
	                    </div>
	                    <div class="alert alert-danger" style="display:none; transition-duration: 5s;" role="alert" id="errorMsg">
	                    	Data Insert Unsuccessful! 
	                    </div> 
                    </div> -->
                      <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" name="Fname" id="Fname"
                          placeholder="First Name">
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" name="Lname" placeholder="Last Name" id="Lname">
                      </div>
                    </div>
                    <div class="form-group row">
                      <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" name="address1" id ="address1" placeholder="Address 1" >
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" name="address2" id="address2"placeholder="Address 2">
                      </div>
                    </div>
                    <div class="form-group row">
                      <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" name="city" placeholder="City" id="city">
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user" name="mobileNum" id="mobileNum"
                          placeholder="Mobile Number">
                      </div>
                    </div>
                    <div class="form-group row">
                    <div class="col-sm-6">
                      <input type="email" class="form-control form-control-user" name="email" id="email" 
                        placeholder="Email Address">
                        </div>
                    </div>
                    <div class="form-group row">
                       <div class="col-sm-6 mb-3 mb-sm-0">
                        <lable style="margin-left: 12px;">Gender :</lable>
                        <input type="radio" class="form-control-user" name="gender" id="gender"  value="Male" style="margin-top: 28px; margin-left: 60px;"> 
                        Male
                      </input>
                      <input type="radio" class="form-control-user" name="gender" id="gender" value="Female" style="margin-top: 28px; margin-left: 60px;"> 
                      Female
                    </input>
                      </div>
                      <!-- <div class="col-sm-6">
                        <fieldset disabled>
                          <input type="text" class="form-control form-control-user "  
                            placeholder="Upload Profile Photo">
                        </fieldset>
                        <input type="file" name="file"  class="upload-btn-click" value="upload">
                        <i class="fas fa-file-upload upload-btn"></i>

                      </div>   -->                        
                    </div>
                     <hr>
                       <div class="btn-driver-form">                   
                     <!-- <button type="submit" id="addDriverdata-btn" class="btn btn-success btn-circle btn-lg btn-block"> 
                        <i class="fas fa-check"></i>
                        </button> -->
                      
				<!-- <button id="clear-btn" class="btn btn-danger btn-circle btn-lg">
                        <i class="fas fa-trash"></i></button> --> 
                      
                    </div>
                    
                  </form>
                </div>
              </div>
              <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
          </div>
          <!-- End of Content Wrapper -->
          <!-- Content Row -->
          <div class="row">
            <div class="col-xl-12 ">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Vehicle Information</h6>
                </div>
                <div class="card-body">
                  <form class="user" id="driverInfoForm2">
                    <div class="form-group row">
	                    <div class="col-12">
		                    <div class="alert alert-success" style="display:none; transition-duration: 5s;" role="alert" id="succerssMsg">
		                    	Data Insert Successful! 
		                    </div>
		                    <div class="alert alert-danger" style="display:none; transition-duration: 5s;" role="alert" id="errorMsg">
		                    	Data Insert Unsuccessful! 
		                    </div>
	                    </div>
                      <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user" id="vehicleNumber"
                          placeholder="Vehicle Number" required >
                      </div>
                      <div class="col-sm-6">
                        <input type="text" class="form-control form-control-user"  id="vehicalType"
                          placeholder="Vehicle Type">
                      </div>
                    </div>
                    <div class="form-group row">
                      <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="text" class="form-control form-control-user"id="vehicleModel"
                          placeholder="Vehicle Model">
                      </div>
                      <div class="col-sm-6">
                        <input type="date" class="form-control form-control-user" id="insuranceRenewalDate"
                          placeholder="Insurance Renewal Date">
                      </div>

                    </div>
                    <div class="form-group row">
                      <div class="col-sm-6 mb-3 mb-sm-0">
                        <input type="date" class="form-control form-control-user" id="taxRenewalDate"
                          placeholder="Tax Renewal Date">
                      </div>
                     <!-- <div class="col-sm-6">
	                        <fieldset disabled>
	                          <input type="text" class="form-control form-control-user " id="vehicleDocUpload"
	                            placeholder="Upload Vehicle Document">
	                        </fieldset>
	                        <input type="file" class="upload-btn-click">
	                        <i class="fas fa-file-upload upload-btn"></i>
                      	</div> -->

                    </div>


                    <hr>
                    <div class="btn-driver-form">
                   
                      <button type="submit" id="addDriverdata-btn" class="btn btn-success btn-circle btn-lg btn-block"> 
                        <i class="fas fa-check"></i>
                        </button>

                      
                    
                    </div>
                  </form>
                </div>
              </div>
              <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->
          </div>
          <!-- End of Content Wrapper -->
        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
          <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
          aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">�</span>
                </button>
              </div>
              <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
              <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="login.jsp">Logout</a>
              </div>
            </div>
          </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="../../vendor/jquery/jquery.min.js"></script>
        <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="../../js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="../../vendor/chart.js/Chart.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


        
        <script type="text/javascript">
        
        $(document).ready(function(){
        	$("#addDriverdata-btn").click(
        			function (e){ 
        				e.preventDefault(); 
        				var Fname = $('#Fname').val();
        				var Lname = $('#Lname').val();
        				var address1 = $('#address1').val();
        				var address2 = $('#address2').val();
        				var email = $('#email').val();
        				var contact = $('#mobileNum').val();
        				var gender = $('#gender').val();
        				var city = $('#city').val(); 
        				var vehicalNum = $('#vehicleNumber').val();
        				var VehicalType = $('#vehicalType').val();
        				var VehicalModel = $('#vehicleModel').val();
        				var InsuranceData = $('#insuranceRenewalDate').val();
        				var TaxReDate = $('#taxRenewalDate').val();   
        				
        				$.ajax({
        						type: "POST",
        						url: "http://localhost:8080/Warehouse_Managment_System/addDriverData",
        						data : "vehicleNumber="+ vehicalNum +"&vehicalType="+ VehicalType +"&vehicleModel="+ VehicalModel +"&insuranceRenewalDate="+ InsuranceData +"&taxRenewalDate=" + TaxReDate + "&Fname=" + Fname + "&Lname="+ Lname + "&address1=" +address1+ "&address2=" +address2+" &city="+city+ "&gender="+gender+ "&email="+email+"&mobileNum="+contact,
        						success : function(msg){
        							
       							$('#succerssMsg').css({"display": "block"}); 
        							$('#errorMsg').css({"display": "none"}); 
        							document.getElementById("driverInfoForm").reset();
                					document.getElementById("driverInfoForm2").reset();
                					
                					
        						},        						
        						error: function(en){
        							
        							
        						}
        						
        					});  
        				
        				
        					
        					
        					
        	});
     
	
        
        });
        
        
        
        
        </script>

</body>
</html>