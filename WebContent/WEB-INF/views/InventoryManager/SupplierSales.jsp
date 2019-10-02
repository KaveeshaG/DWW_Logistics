<%@page import="java.text.DecimalFormat"%>
<%@page import="com.wms.model.SupplierProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.SupplierServices"%>
<%@page import="com.wms.service.Supplier"%>
<%@page import="com.wms.model.SupplierAcount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.search-btn {
    position: absolute;
    bottom: 20px;
    right: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
	
			



	 					<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 justify-content-center mt-10">
                            <div class="card">
                                <div class="card-body">
				<form
					class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search "
					action="IMSalesSearch" method="POST">
					<div class="input-group ">
						<input type="text" class="form-control bg-light border-0 small"
							placeholder="Search for..." aria-label="Search"
							aria-describedby="basic-addon2" name="serchTag">
						<div class="input-group-append">
							<button class="btn btn-primary" type="submit">
								<i class="fas fa-search fa-sm"></i>
							</button>
							
							
							
							
							
						</div>
						
						
						
					</div>
				</form>
				<!-- start -->
				
					<div class="col-xl-12 col-lg-9 col-md-7 col-sm-12 col-12 mt-5">
                            <div class="influence-profile-content pills-regular">
                                <ul class="nav nav-pills mb-3 nav-justified" id="pills-tab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="Supplier" data-toggle="pill" href="#SuppierView" role="tab" aria-controls="SuppierView" aria-selected="true">Suppliers</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="Products" data-toggle="pill" href="#ProductView" role="tab" aria-controls="ProductView" aria-selected="false">Products</a>
                                    </li>
                                    
                                </ul>
                                
                                
                                <div class="tab-content" id="pills-tabContent">
                                
                                
                                
                                	<!--start Supplier  -->
                                    <div class="tab-pane fade show active" id="SuppierView" role="tabpanel" aria-labelledby="Supplier">
                                        
                                  <%
                                  
                                  Supplier supplier = new SupplierServices();
      							ArrayList<SupplierAcount> supplierList = supplier.getSupplierTableList();
      							for(SupplierAcount acount : supplierList){
                                  
                                  %>
						
						
				<div class="mt-3">
				<div class="card">
                                <div class="card-body ">
                                    <div class="row align-items-center ">
                                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12 ">
                                           
                                               			<div class="row col-12">
                                                        <div class="user-avatar-name d-inline-block">
                                                            <h2 class="font-20 m-b-10 text-primary"><%=acount.getName()%></h2>
                                                        </div>
                                                        <div class="rating-star d-inline-block pl-xl-2 mb-2 mb-xl-0">
                                                            <i class="fa fa-fw fa-star text-warning"></i>
                                                            <i class="fa fa-fw fa-star text-warning"></i>
                                                            <i class="fa fa-fw fa-star text-warning"></i>
                                                          </div>
                                                    
                                                    </div>
                                                    
                                                    	<div class="row ">
                                                    
                                                    		<div class="col-4 c justify-content-center">
                                                        	<h5 class="mb-2 text-dark"><i class="fa fa-user-alt  text-primary "></i> <%=acount.getSupplierId() %>  </h5>
                                                            
                                                            </div>
                                                            <div class="col-4   justify-content-center">
                                                            <h5 class="mb-2 text-dark"><i class="fa fa-map-marker-alt  text-info "></i>  <%=acount.getAddress() %>    </h5>
                                                            
                                                     		</div>
                                                     		
                                                       <div class="col-4   justify-content-center">
                                                       <h5 class="mb-2 text-dark"><i class="fas fa-envelope text-danger"></i> <%=acount.getEmail() %>   </h5>
                                                            
                                                       		</div>
                                                    </div>
                                                    
                                                    
                                                    
                                                    <div class="row justify-content-center">

									<div class="col-4  ">
										<h5 class="mt-3 text-dark">
											<i class="fas fa-phone text-primary   text-success"></i>
											<%=acount.getContactNo()%>
										</h5>
									</div>
									
									<div class="col-4  ">
										<h5 class="mt-3 text-dark">
											<i class=" fas fa-align-justify  text-dark"></i>
											<%=acount.getReview()%>
										</h5>
									</div>
									
									<div class="form-group col-4 mt-2">
									
									<form action="InventoryManagerServletManager?action=SUPACCOUNT" method="POST">
									<input type="hidden" name="supID" value="<%=acount.getSupplierId() %>">
									<button type="submit" id="loginSubmit"
										class="btn btn-info loginFormElement">VIEW PROFILE</button>
									</form>
								</div>
                                                    
                                                    
                                                       		
                                                       		
                                                </div>
                                            </div>
                                            
                                            
                                            
                                            
                                            
                                    
                                        </div>
                                    </div>
                                    

				
					</div>
			</div> 
				<%
					}
				%> 
                                        
                                    </div>
                                    <!--end Supplier  -->
                                    
                                    
                                    <!--start product  -->
                                    <div class="tab-pane fade" id="ProductView" role="tabpanel" aria-labelledby="Products">
                                        
                                       
                                       
                                      <div> 
                                       
                                       <%
                                       
                                       
                               		Supplier supplierManager = new SupplierServices();
                               		ArrayList<SupplierProduct> products = supplier.getAllSuppliersproduct();
                               		int a = 0;
                               		DecimalFormat form = new DecimalFormat("0.00");
                                       
                                       for(SupplierProduct product : products){
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
											
											<form action="ViewMoreProductForSale" method="POST">
												<input type="hidden" name="proID" value="<%=product.getProductId()%>">
												<button  class="btn btn-primary">View More</button>
													</form>
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
                                       
                                       
                                        
                                        
                                    </div>
                                    
                                    <!--end product  -->

								</div>

							</div>
							
							</div>
				
				
				
				
				<!--end  -->
				
				
				
				
		
						
						
					
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
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