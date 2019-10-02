<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.wms.model.Inventory"%>
<%@page import="java.util.List"%>
<%@page import="com.wms.service.InventoryManagerServices"%>
<%@page import="com.wms.service.IInventoryManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory Item View</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- page content begins here -->

	<div class="content">
		<div class="container-fluid">

			<div class="col-xl-12 col-md-6 mb-12">
				<div class="card border-left-info shadow h-100 py-2">
					<div class="card-body">
					
					<%
						String inventoryID = (String) request.getAttribute("inventoryID");
						IInventoryManager manager =  new InventoryManagerServices();
						int totalDays, remaingDays;
						Inventory inventory = manager.getInventoryItemById(inventoryID);
						totalDays = manager.getTotalDays(inventory.getItemNo());
						remaingDays = manager.getRemaingDays(inventory.getItemNo());
						double condition;
						DecimalFormat form = new DecimalFormat("0");
						if(remaingDays == 0 || remaingDays < 0){
							condition = 0;
						}
						else{
							condition = ((double)remaingDays / totalDays) * 100; 
						}
						if(inventory.getType().equals("Replace")){
					%>
					<h4 class="text-info mb-3 " id="exampleModalCenterTitle "><i class=" fas fa-list mt-2"></i><b> DETAILS OF INVENTORY ITEM - <%=inventory.getItemNo()%></b> </h4>
					<div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
												<i class="fas fa-file-code text-info mt-3 mb-2"> Item No</i>
                                                <input type="text" class="form-control"  name="employeeId" value="<%=inventory.getItemNo()%>" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <i class="fas fa-hourglass-half text-info mt-3 mb-2"> Remaining Days For Replacement</i>
                                                <input type="text" class="form-control" placeholder="Storage" name="location" value="<%=remaingDays %>" id="rem" disabled>
                                            </div>
                                        </div>
                                    </div>                    
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <i class="fas fa-list-alt text-info mt-3 mb-2"> Item Name</i>
                                                <input type="text" class="form-control"  placeholder="Enter Item Name" name="itemName" id="itemNames" value="<%=inventory.getName()%>" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                               <i class="far fa-calendar-check text-info mt-3 mb-2"> Warranty Day</i>
                                                <input type="date" class="form-control" name="warrentyDay" id="wrrDays" value="<%=inventory.getWarrentyYear()%>" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <i class="far fa-calendar-plus text-info mt-3 mb-2"> Added Date</i>
                                                <input type="date" class="form-control" name="addedDay" id="addDays" value="<%=inventory.getAddedDate()%>" disabled>
                                            </div>
                                        </div>
                                        
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
												<i class="fas fa-user text-info mt-3 mb-2"> Owner</i>
                                                <input type="number" class="form-control" placeholder="None" name="employeeId" id="owners" value="<%=inventory.getOwner()%>" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <i class="fas fa-map-marker-alt text-info mt-3 mb-2"> Location</i>
                                                <input type="text" class="form-control" placeholder="Storage" name="location" id="stores" value="<%=inventory.getLocation()%>" disabled>
                                            </div>
                                        </div>
                                    </div>
									
									<div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
												<i class="fas fa-recycle text-info mt-3 mb-2"> Status</i>
                                                <input type="text" class="form-control" placeholder="None" name="employeeId" id="status" value="<%=inventory.getStatus()%>" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <i class="fas fa-percent text-info mt-3 mb-2"> Condition</i>
                                                <input type="text" class="form-control"  value="<%=form.format(condition)%>%" disabled>
                                            </div>
                                        </div>
                                    </div>	
                                   
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <i class="far fa-sticky-note text-info mt-3 mb-2"> Item Description</i>
                                                <textarea rows="3" class="form-control" placeholder="<%=inventory.getDescription()%>" name="description"  id="dess" disabled></textarea>
                                            </div>
                                        </div>
                                    </div>
   							<%}else{ %>
   								
   								<h4 class="text-info mb-3 " id="exampleModalCenterTitle "><i class=" fas fa-list mt-2"></i><b> DETAILS OF INVENTORY ITEM - <%=inventory.getItemNo()%></b> </h4>
   								<div class="row">
                                    <div class="col-md-4">
                                            <div class="form-group">
												<i class="fas fa-file-code text-info mt-3 mb-2"> Item No</i>
                                                <input type="text" class="form-control"  name="employeeId" id="IItemNo" value="<%=inventory.getItemNo()%>" disabled>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <i class="fas fa-list-alt text-info mt-3 mb-2"> Item Name</i>
                                                <input type="text" class="form-control"  placeholder="Enter Item Name" name="itemName" id="itemNames" value="<%=inventory.getName()%>" disabled>
                                            </div>
                                        </div>
                                        
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <i class="far fa-calendar-plus text-info mt-3 mb-2"> Added Date</i>
                                                <input type="date" class="form-control" name="addedDay" id="addDays" value="<%=inventory.getAddedDate()%>" disabled>
                                            </div>
                                        </div>
                                        
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
												<i class="fas fa-user text-info mt-3 mb-2"> Owner</i>
                                                <input type="number" class="form-control" placeholder="None" name="employeeId" id="owners" value="<%=inventory.getOwner()%>" disabled>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <i class="fas fa-map-marker-alt text-info mt-3 mb-2"> Location</i>
                                                <input type="text" class="form-control" placeholder="Storage" name="location" id="stores" value="<%=inventory.getLocation()%>" disabled>
                                            </div>
                                        </div>
                                    </div>
									
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <i class="far fa-sticky-note text-info mt-3 mb-2"> Item Description</i>
                                                <textarea rows="3" class="form-control" placeholder="<%=inventory.getDescription()%>" name="description" id="dess" disabled></textarea>
                                            </div>
                                        </div>
                                    </div>
   							
   							
   							
   							
   							<%} %>
						<div class="row justify-content-center mt-3">
						
							<form action="#" method="POST">
										
										
									
									
									
									<button type="submit" class="btn btn-success btn-icon-split "
								data-toggle="modal" data-target="">
								<span class="icon text-white-100"> <i
									class="far fa-edit"></i>
								</span> <span class="text">Update</span>
							</button>
									
									
									</form>	
						
						
						
						
						
							<button type="submit" class="btn btn-danger btn-icon-split ml-2"
								data-toggle="modal" data-target="#deleteItem">
								<span class="icon text-white-100"> <i
									class="fas fa-trash"></i>
								</span> <span class="text">Delete</span>
							</button>
							
							
							
							
						</div>	
						</div>
					</div>
			</div>
		</div>
	</div>
	
	
	
<!-- Modal for delete Selected items -->
  <div class="modal fade bd-example-modal-lg" id="deleteItem" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered ml-10" role="document">
      <div class="modal-content">
        <div class="modal-header bg-danger">
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="fas fa-minus-circle"></i> ARE YOU WANT TO DELETE ITEM</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        
       
        
        	<div class="row ml-5">
        		<div class="mr-5">
        		<form action="deleteItemByIdServlet?action=RP" method="POST">
        		 <input type="hidden" name="itemNo" value="<%=inventoryID%>">
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