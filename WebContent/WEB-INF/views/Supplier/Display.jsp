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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Display</title>



</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>


	<%	
		SupplierAcount acount = (SupplierAcount) session.getAttribute("Supplier");
		Supplier supplier = new SupplierServices();
		String supplierID = acount.getSupplierId();
		ArrayList<SupplierProduct> products = supplier.getProductTableList(supplierID);
		int a = 0;
		DecimalFormat form = new DecimalFormat("0.00");
	
	%>


	<div class="col-xl-12 col-md-6 mb-4">
		<div class="card shadow h-100 py-2">
			<div class="card-body">
			
			
			<ul class="nav nav-pills mb-3 nav-justified" id="pills-tab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="productTab" data-toggle="pill" href="#products" role="tab" aria-controls="products" aria-selected="true">Products</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="serviceTab" data-toggle="pill" href="#services" role="tab" aria-controls="services" aria-selected="false">Services</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="packageTab" data-toggle="pill" href="#package" role="tab" aria-controls="package" aria-selected="false">Packages</a>
                                    </li>
                                </ul>
                                
                                
                                
                                 <div class="tab-content" id="pills-tabContent">
                                 <div class="tab-pane fade show active" id="products"
						role="tabpanel" aria-labelledby="productTab">
                                <%for(SupplierProduct product : products){
                                	if(a == 0){%>
                                	<div class="row">
                                	
                                	<%} %>
                                	
                                
                               

					
						<div class="col-3 mt-3">
							<div class="card shadow h-100 py-2">
								<div class="card-body">
									<div class="product-thumbnail">
										<div class="product-img-head">
											<div class="product-img">
												<img src="img\Supplier\<%=product.getImageName()%>" alt="" class="img-fluid" style="width: 250%; height: 200px;">
											</div>

										</div>



										<div class="product-content mt-3">
											<div class="product-content-head">
												<h4 class="product-title text-dark"><%=product.getProductName()%></h4>



											</div>

											<div class="product-content-head">
												<h4 class="product-title text-danger"><%=form.format(product.getProPrice() )%></h4>
												<h6 class="product-title text-primary"><%=product.getDescription() %></h6>
												</div>


											<div class="product-btn mt-3">
												<a href="#" class="btn btn-primary">Add to Cart</a> <a
													href="#" class="btn btn-outline-light"></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					
					

					<%
						++a;
						if(a== 4){%>					
					</div>
					
					<%
					a=0;
						}
						}
					%>

					</div>
		</div>





					<div class="tab-pane fade" id="services" role="tabpanel" aria-labelledby="serviceTab">
                               
                                 <div class="row">
                                        
                                			<div class="col-3 mt-3">
							<div class="card shadow h-100 py-2">
								<div class="card-body">
									<div class="product-thumbnail">
										<div class="product-img-head">
											<div class="product-img">
												<img src="img\Supplier\s1.jpg" alt="" class="img-fluid" style="width: 100%; height: 200px;">
											</div>

										</div>



										<div class="product-content mt-3">
											<div class="product-content-head">
												<h4 class="product-title text-dark">Fork Lift</h4>



											</div>

											<div class="product-content-head">
												<h4 class="product-title text-danger">2000.00</h4>
												<h6 class="product-title text-primary">Per Hour</h6>
												</div>


											<div class="product-btn mt-3">
												<a href="#" class="btn btn-primary">Add to Cart</a> <a
													href="#" class="btn btn-outline-light"></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
                                		
                                	
                                	
                                	<!-- 2 -->
                                	
                                	  
                                        
                                			<div class="col-3 mt-3">
							<div class="card shadow h-100 py-2">
								<div class="card-body">
									<div class="product-thumbnail">
										<div class="product-img-head">
											<div class="product-img">
												<img src="img\Supplier\s2.jpg" alt="" class="img-fluid" style="width: 100%; height: 200px;">
											</div>

										</div>



										<div class="product-content mt-3">
											<div class="product-content-head">
												<h4 class="product-title text-dark">Crane</h4>



											</div>

											<div class="product-content-head">
												<h4 class="product-title text-danger">3000.00</h4>
												<h6 class="product-title text-primary">Per Hour</h6>
												</div>


											<div class="product-btn mt-3">
												<a href="#" class="btn btn-primary">Add to Cart</a> <a
													href="#" class="btn btn-outline-light"></a>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
                                		
                                		
                                		
                                		
                                		
                                		
                                	
                                	
                                	
                                	
                                	
                                		
                                		
                                		
                                		
                                		
                                		</div>
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                                        
                                
                                    </div>
                                    
                                    
                                    
                                    
                                    
                                      <div class="tab-pane fade" id="package" role="tabpanel" aria-labelledby="packageTab">
                                       
                                       
                                       			<div class="col-3 mt-3">
							<div class="card shadow h-100 py-2">
								<div class="card-body">
									<div class="product-thumbnail">
										<div class="product-img-head">
											<div class="product-img">
												<img src="img\Supplier\s2.jpg" alt="" class="img-fluid" style="width: 100%; height: 200px;">
											</div>

										</div>



										<div class="product-content mt-3">
											<div class="product-content-head">
												<h4 class="product-title text-dark">Crane with Driver</h4>



											</div>

											<div class="product-content-head">
												<h4 class="product-title text-danger">12000.00</h4>
												<h6 class="product-title text-primary">Per Day</h6>
												</div>


											<div class="product-btn mt-3">
												<a href="#" class="btn btn-primary">Add to Cart</a> <a
													href="#" class="btn btn-outline-light"></a>
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