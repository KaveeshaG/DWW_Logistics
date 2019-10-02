<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.wms.service.InventoryManagerServices"%>
<%@page import="com.wms.service.IInventoryManager"%>
<%@page import="java.util.List"%>
<%@page import="com.wms.model.PurchaseOrderDetails"%>
<%@page import="com.wms.model.PurchaseOrderHead"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit PO</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- page content begins here -->
	
	
	<%
		String poID =(String) request.getAttribute("poID");
		IInventoryManager manager =  new InventoryManagerServices();
		PurchaseOrderHead head = manager.getPoHeadDetailsList(poID);
		DecimalFormat form = new DecimalFormat("0.00");
		int count = 0;
	
	%>
	
	
	<div class="col-xl-12 col-md-6 mb-12">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">

			<h5 class="text-right">Purchase Order ID - <%=head.getPoId()%></h5>
			<h6 class="text-right">Date - <%=head.getDate() %></h6>
			<h5 class="text-left">Description</h5>
			<h6 class="text-left ml-5 mr-5"><%=head.getDescription() %></h6>
			
			
			
			<div class="row ml-5 mt-3">
					<div class="mr-2">



						<button class="btn btn-primary btn-icon-split "
							data-toggle="modal" data-target="#addPoDetails">
							<span class="icon text-white-100"> <i
								class="fas fa-plus-circle"></i>
							</span> <span class="text"> Add Item</span>
						</button>




					</div>
					

					<button type="submit" class="btn btn-danger btn-icon-split "
						data-toggle="modal" data-target="#deleteAll">
						<span class="icon text-white-100"> <i class="fas fa-trash"></i>
						</span> <span class="text">Delete All</span>
					</button>
					
				</div>
			
			
			
			
			
			
						<%
							
							List<PurchaseOrderDetails> poList = manager.getPurchaseOrderDetails(poID); 
							Iterator<PurchaseOrderDetails> it_list = poList.iterator();
							
						%>
						
						<div class="ml-5 mr-5">
			
			<table class="table table-hover mt-3 ">
								<thead class="p-3 mb-2 bg-primary text-white">
									<tr>
										<th scope="col">Item Name</th>
										<th scope="col">Quantity</th>
										<th scope="col">Expecting Price</th>
										<th scope="col">Actions</th>
										
									</tr>
								</thead>
								
							<%
							
							while (it_list.hasNext()) {
								PurchaseOrderDetails orderDetails = new PurchaseOrderDetails();
								orderDetails = it_list.next();
								count++;						
						%>
						
						<tbody>
									<tr id="<%=orderDetails.getPoDeId()%>">
										<td  data-target="name"><%=orderDetails.getItemName()%></td>
										<td  data-target="qty"><%=orderDetails.getQty()%></td>
										<td data-target="price"><%=form.format(orderDetails.getRequestedPrice())%></td>
										<td  data-target="poID" style="display: none;"><%= orderDetails.getPoDeId()%></td>
										<td  >
										
												 
            									<div class="row">
												<!--edit button  -->
								                  <a href="#" data-role="view" class="btn btn-success btn-circle mr-1 btn-sm" data-id="<%=orderDetails.getPoDeId()%>"><i class="far fa-edit"></i></a>
								                  
                  								<form action="deleteItemByIdServlet?action=DD" method="POST">
                  								  <input type="hidden" name="itemNo" value="<%=orderDetails.getPoDeId()%>">
                  								  <input type="hidden" name="poID" value="<%=orderDetails.getPoId()%>">
								                  <button type="submit" class="btn btn-danger btn-circle btn-sm">
								                    <i class="fas fa-trash"></i>
								                  </button>
								                 </form>
                  								</div>
											
										</td>
										
									</tr>
									
						</tbody>
						
						<%
							}
						%>
						
						</table>
						
						
						</div>
				<div class="row justify-content-center">


					<%
						if(count > 0){
					
					%>
					<form action="FinalizePurchaseOrder" method="POST">
						<input type="hidden" name="poID" value="<%=poID%>">
						<button type="submit" class="btn btn-primary btn-icon-split">
						
							<span class="icon text-white-50"> <i class="fas fa-check"></i>
							</span> <span class="text">Finalize And Process</span>
						</button>
					</form>
					
					<%} %>
					
					
					<form action="InventoryManagerServletManager?action=DPO" method="POST">
					<input type="hidden" name="poID" value="<%=head.getPoId() %>">
					<button type="submit" class="btn btn-danger btn-icon-split ml-2">
						<span class="icon text-white-50"> <i class="fas fa-trash"></i>
						</span> <span class="text">Remove Purchase Order</span>
					</button>
					</form>
					

				</div>

			</div>
      </div>
    </div>

		 <!-- Modal for add items -->
  <div class="modal fade bd-example-modal-lg" id="addPoDetails" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header bg-primary">
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="fas fa-plus mt-2"></i> ADD NEW ITEM </h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        <div class="card">
                            
                            <div class="content">
 								<div class="container-fluid">                         
                                <form method="POST" action="AddPurchaseOrderDetails" name="POD"
							onsubmit="return PurchaseOrderDetails()">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <i class="fas fa-list-alt text-primary mt-3 mb-2"> Item Name</i>
                                                <input type="text" class="form-control"  placeholder="Enter Item Name" name="itemName">
                                            </div>
                                        </div>
                                        
                                        
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
												<i class="fas fa-balance-scale text-primary mt-3 mb-2"> Quantity</i>
                                                <input type="number" class="form-control" placeholder="Enter Quentity" name="qty">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <i class="far fa-money-bill-alt text-primary mt-3 mb-2"> Expected Price</i>
                                                <input type="number" class="form-control" placeholder="Enter Expected Price" name="price">
                                            </div>
                                        </div>
                                    </div>
									<div class="row">	
										<div class="">
											<input type="hidden" name="poID" value="<%=poID%>">
                                    		<button type="submit" class="btn btn-primary"><i class="fas fa-plus-circle "></i> Add Item</button>
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
    
    
    <div class="modal fade bd-example-modal-lg" id="deleteAll" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered ml-10" role="document">
      <div class="modal-content">
        <div class="modal-header bg-danger">
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="fas fa-minus-circle"></i> ARE YOU WANT TO DELETE ALL ITEMS</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        
       
        
        	<div class="row ml-5">
        		<div class="mr-5">
        		<form action="DeletePurchaseOrderDetails" method="POST">
        		 <input type="hidden" name="poID" value="<%=poID%>">
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





 <!--edit modal  -->
   <div class="modal fade bd-example-modal-lg" id="view" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header bg-success" >
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="far fa-edit mt-2"></i> UPDATE</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        <div class="card">
                            
                            <div class="content">
 								<div class="container-fluid">                         
                                <form method="POST" action="UpdatePurchaseOrderDetails" name="uPOD" onsubmit="return UpdatePOD()">
                                    <div class="row">
                                        
                                        <div class="col-md-12">
                                            <div class="form-group">
                                               <i class="fas fa-list-alt text-success mt-3 mb-2"> Item Name</i>
                                                <input type="text" class="form-control" name="name" id="name">
                                            </div>
                                        </div>
                                        
                                        
                                    </div>
                                    
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <i class="fas fa-balance-scale text-success mt-3 mb-2"> Quantity</i>
                                                <input type="number" class="form-control" name="qty" id="qty">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                               <i class="far fa-money-bill-alt text-success mt-3 mb-2"> Expected Price</i>
                                                <input type="number" class="form-control" name="price" id="price">
                                            </div>
                                        </div>
                                        
                                        
                                    </div>
                                    

                                    

                                   
                                    
									<div class="row">	
										<div class="">
											<input type="hidden" name="poID" value="<%=poID%>">
											<input type="hidden" class="form-control" name="poDeID" id="poID" >
                                    		<button type="submit" class="btn btn-success"><i class="fas fa-edit "></i> Update	</button>
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
 
 <!--end of edit modal  -->





<script type="text/javascript">
$(document).ready(function(){
    $(document).on('click','a[data-role=view]',function(){
  	 
    	var id  = $(this).data('id');
        var name  = $('#'+id).children('td[data-target=name]').text();
        var quentity  = $('#'+id).children('td[data-target=qty]').text();
        var price  = $('#'+id).children('td[data-target=price]').text();
        var poID  = $('#'+id).children('td[data-target=poID]').text();
        
        $('#name').val(name);
        $('#qty').val(quentity);
        $('#price').val(price);
        $('#poID').val(poID);
        $('#view').modal('toggle');
  	  
       
        
        
    })
});
</script>




	<script src="js/InventoryManager.js"></script>
	<script src="js/InventoryUPOD.js"></script>
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

