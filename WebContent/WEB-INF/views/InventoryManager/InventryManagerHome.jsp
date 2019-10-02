<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IM Home</title>

<style type="text/css">

.border-left-dark {
  border-left: 0.25rem solid #9400D3 !important;
 
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
		<!-- page content begins here -->
		<div class="content">
		<div class="container-fluid">

			
		 <div class="row">

            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 font-weight-bold text-primary text-uppercase mb-1">Inventory</div>
                      <div class="text-s mb-0 font-weight-bold text-primary">Replacing & Refilling</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-calendar fa-2x text-primary"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 font-weight-bold text-success text-uppercase mb-1">Purchase Orders</div>
                      <div class="text-s mb-0 font-weight-bold text-success">Permission Received<sup>*</sup></div>
                    </div>
                    <div class="col-auto">
                      <i class="far fa-list-alt fa-2x text-success"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-info shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 font-weight-bold text-info text-uppercase mb-1">Quotations</div>
                      <div class="text-s mb-0 font-weight-bold text-info">Item Quantity Get Low !</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-clipboard-list fa-2x text-info"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>
			 </div>
			 
			 
			 <div class="row">
			 
            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-warning shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 font-weight-bold text-warning text-uppercase mb-1">Auction</div>
                      <div class="text-s mb-0 font-weight-bold text-warning">Next On 31<sup>st</sup> Aug 2019</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-x-ray fa-2x text-warning"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div> 
			 
			 
			 <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-danger shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 font-weight-bold text-danger text-uppercase mb-1">Suppliers</div>
                      <div class="text-s mb-0 font-weight-bold text-danger">20<sup>+</sup></div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-users fa-2x text-danger"></i>
                    </div>
                  </div>
                </div>
              </div>
            </div> 
            
            <div class="col-xl-4 col-md-6 mb-4">
              <div class="card border-left-dark shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="h5 font-weight-bold text-uppercase mb-1" style="color:#9400D3; ">Sales</div>
                      <div class="text-s mb-0 font-weight-bold " style="color:#9400D3;">30000.00 /-</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-chart-line fa-2x" style="color:#9400D3; "></i>
                    </div>
                  </div>
                </div>
              </div>
            </div>



				
			</div>
			
			
					<div class="row">

            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Sales Overview</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">Auction Income</h6>
                  <div class="dropdown no-arrow">
                    
                    
                  </div>
                </div>
                <div class="card-body">
                  <div class="chart-pie pt-4 pb-2">
                    <canvas id="myPieChart"></canvas>
                  </div>
                  <div class="mt-4 text-center small">
                    <span class="mr-2">
                      <i class="fas fa-circle text-primary"></i> Old
                    </span>
                    <span class="mr-2">
                      <i class="fas fa-circle text-success"></i> Sales
                    </span>
                    <span class="mr-2">
                      <i class="fas fa-circle text-info"></i> New
                    </span>
                  </div>
                </div>
                
              </div>
            </div>
          </div>
          








		</div>
		</div>
		
		
		
		
		<script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>
		
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>