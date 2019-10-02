<%@page import="com.wms.model.PurchaseOrderHead"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.IInventoryManager"%>
<%@page import="com.wms.service.InventoryManagerServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Order</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- page content begins here -->

	<div class="col-xl-12 col-md-6 mb-12">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">




				 <div class="row">
					<div class="col mr-1">
						<div class="h5 text-primary mb-0 text-uppercase font-weight-bold">Purchase
							Orders</div>
					</div>
					<div class="col-auto">
						<i class="fas fa-clipboard-list fa-2x text-primary"></i>
					</div>
				</div>

				<div class="row ml-5 mt-3">
					<div class="mr-2">



						<button class="btn btn-primary btn-icon-split "
							data-toggle="modal" data-target="#addPurchaseOrder">
							<span class="icon text-white-100"> <i
								class="fas fa-plus-circle"></i>
							</span> <span class="text"> Add PO</span>
						</button>




					</div>

					<button type="submit" class="btn btn-danger btn-icon-split "
						data-toggle="modal" data-target="#deleteAll">
						<span class="icon text-white-100"> <i class="fas fa-trash"></i>
						</span> <span class="text">Delete All</span>
					</button>
				</div>









				<%
					IInventoryManager manager = new InventoryManagerServices();
					ArrayList<PurchaseOrderHead> list = manager.getAllPurchaseOrder();
					int i = 0;
					for (PurchaseOrderHead head : list) {

						if (i == 0) {
				%>
						<div class="row">
					
						<%
							
							}
						++i;
						%>				
				
				
				
				
					<div class="col-xl-4 col-4 mt-3">
						<div class="card shadow mb-4">
							<!-- Card Header - Dropdown -->
							<div class="card-header py-3 bg-gray-200">
								<h6 class="m-0 font-weight-bold text-primary "><%=head.getPoId() %></h6>
							</div>
							<!-- Card Body -->
							<div class="card-body text-dark bg-gray-100">
								Date : <%=head.getDate() %>
								<br>
								Status : <%=head.getStatus()%>
								<br>
								<div class="accordion" id="accordionExample">
  
  
 
        <h6 class="collapsed text-primary"   data-toggle="collapse" data-target="#<%=head.getPoId() %>" aria-expanded="false" 
        aria-controls="collapseThree">
          Description
        </h6>
     
    </div>
    <div id="<%=head.getPoId() %>" class="collapse" aria-labelledby="<%=head.getPoId() %>" data-parent="#accordionExample">
     
       <%=head.getDescription()%>
     
    </div>
  													
								<hr>
								<div class="row d-flex justify-content-center" >
									<form action="InventoryManagerServletManager?action=PRI" method="POST">
										<!-- view button -->
										
									<input type="hidden" name="poID" value="<%=head.getPoId() %>">
									<button  type="submit"
										class="btn btn-primary btn-circle mr-1 btn-sm" ><i
										class="fas fa-file-pdf"></i></button>
									
									
									</form>
									
									<form action="InventoryManagerServletManager?action=VIEW" method="POST">
										<!-- view button -->
										
									<input type="hidden" name="poID" value="<%=head.getPoId() %>">
									<button  type="submit"
										class="btn btn-info btn-circle mr-1 btn-sm" ><i
										class="fas fa-eye"></i></button>
									
									
									</form>
									
									<%if(head.getStatus().equals("NEW") || head.getStatus().equals("CREATED")){ %>
									<!--edit button  -->
									<form action="InventoryManagerServletManager?action=EDITPO" method="POST">
										
										
									<input type="hidden" name="poID" value="<%=head.getPoId() %>">
									<button  type="submit" data-role="update"
										class="btn btn-success btn-circle mr-1 btn-sm"><i
										class="far fa-edit"></i></button>
									
									
									</form>	
										

									<form action="InventoryManagerServletManager?action=DPO" method="POST">
										<input type="hidden" name="poID" value="<%=head.getPoId() %>">
										<button type="submit" class="btn btn-danger btn-circle btn-sm">
											<i class="fas fa-trash"></i>
										</button>
									</form>
									<%} %>
								</div>
							</div>
						</div>
					</div>
					
					
			
			
			<%		
						if(i == 3){
							i = 0;
							
							%>
							
							</div><%
						}
						}
			%>
			</div>
			</div> 
			
			
	
</div>	

	
	


<!-- Modal for add purchase order -->
  <div class="modal fade bd-example-modal-lg" id="addPurchaseOrder" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header bg-primary">
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="fas fa-plus mt-2"></i> ADD NEW Purchase Order </h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        <div class="card">
                            
                            <div class="content">
 								<div class="container-fluid">                         
                                <form method="POST" action="AddPurchaseOrder" name="PO"
							onsubmit="return PurchaseOrder()">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <i class="fas fa-calendar-alt text-primary mt-3 mb-2"> Date</i>
                                                <input type="date" class="form-control"  placeholder="Enter Item Name" name="date">
                                            </div>
                                        </div>
                                        
                                        
                                    </div>

                                    
                                   
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <i class="far fa-sticky-note text-primary mt-3 mb-2"> Description</i>
                                                <textarea rows="3" class="form-control" placeholder="Here can be your description" name="description"></textarea>
                                            </div>
                                        </div>
                                    </div>
									<div class="row">	
										<div class="">
                                    		<button type="submit" class="btn btn-primary"><i class="fas fa-plus-circle "></i> Add PO</button>
                                    	</div>
                                    </div>
                                </form>
                                </div>  
                            </div>
                       
        </div>
        </div>
        
        
        </div>
      </div>
    </div>


  <!-- Modal for delete all items -->
  <div class="modal fade bd-example-modal-lg" id="deleteAll" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered ml-10" role="document">
      <div class="modal-content">
        <div class="modal-header bg-danger">
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="fas fa-minus-circle"></i> ARE YOU WANT TO DELETE ALL PO</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        
        	<div class="row ml-5">
        		<div class="mr-5">
        		<form action="deleteAllItemsServlet?action=DAPO" method="POST">
        		<button type="submit"  class="btn btn-danger btn-icon-split ">
                    <span class="icon text-white-100">
                      <i class="fas fa-trash"></i>
                    </span>
                    <span class="text">Yes, I'm Sure</span>
                  </button></form>
               </div>   
                  <div class="ml-2">
                  <button  class="btn btn-info btn-icon-split " data-dismiss="modal">
                    <span class="icon text-white-100">
                      <i class="fas fa-check"></i>
                    </span>
                    <span class="text">No, I'm Sorry</span>
                  </button>
                 </div> 
           </div>
      </div>
    </div>
    
    
   </div> 
 </div> 







	<script src="js/InventoryManager.js"></script>
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