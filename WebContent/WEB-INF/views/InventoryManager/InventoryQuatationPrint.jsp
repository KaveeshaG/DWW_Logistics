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
<title>Purchase Order Print</title>
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
	
	%>
	
	
	<div class="col-xl-12 col-md-6 mb-12" id="HTMLtoPDF">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body" >
			<a href="#" class="fas fa-file-pdf text-primary text-right fa-2x" onclick="HTMLtoPDF()"></a>
			
			<h5 class="text-right">D.W.W Warehouse</h5>
			<h6 class="text-right">dww_warehouse@gmail.com</h6>
			<h6 class="text-right">+94111234567</h6>
			<h6 class="text-right">Purchase Order ID - <%=head.getPoId()%></h6>
			<h6 class="text-right">Date - <%=head.getDate() %></h6>
			<h5 class="text-center"><u>Requesting For Quoatation </u></h5>
			<h6 class="text-left ml-5 mr-5 mb-3"><%=head.getDescription() %></h6>
			
			
			
			
			
			
						<%
							
							List<PurchaseOrderDetails> poList = manager.getPurchaseOrderDetails(poID); 
							Iterator<PurchaseOrderDetails> it_list = poList.iterator();
							
						%>
			
			<table class="table table-hover mt-5">
								<thead class="p-3 mb-2 bg-primary text-white">
									<tr>
										<th scope="col">Item Name</th>
										<th scope="col">Quantity</th>
										<th scope="col">Expecting Price</th>
										<th scope="col">Unit Price</th>
										<th scope="col">Description</th>
										
										
										
									</tr>
								</thead>
								
							<%
							
							while (it_list.hasNext()) {
								PurchaseOrderDetails orderDetails = new PurchaseOrderDetails();
								orderDetails = it_list.next();
								
						%>
						
						<tbody>
									<tr >
										<td ><%=orderDetails.getItemName()%></td>
										<td ><%=orderDetails.getQty()%></td>
										<td ><%=form.format(orderDetails.getRequestedPrice())%></td>
										<td >_ _ _ _ _ _ _ _ _ _ _</td>
										<td >_ _ _ _ _ _ _ _ _ _ _</td>
										
										
										
									</tr>
									
						</tbody>
						
						<%
							}
						%>
						
						</table>
						
						
						
						<div class="row mt-3 mr-2">
                                        <div class="col-lg-4 col-sm-5">
                                        </div>
                                        <div class="col-lg-4 col-sm-5 ml-auto" >
                                            
                                            <hr>
                                            <h6 class="text-right">Sub Total :   _ _ _ _ _ _ _ _ _ _ _</h6>
                                            <hr>
                                            
                                            <h6 class="text-right">Discount (...%) :   _ _ _ _ _ _ _ _ _ _ _</h6>
                                            <hr>
                                            
                                            <h5 class="text-right">Total :   _ _ _ _ _ _ _ _ _ _ _</h5>
                                            <hr>
                                            
                                            
                                              
                                        </div>
                                    </div>
						
			</div>
      </div>
    </div>

	



<script src="js/jspdf.js"></script>
	<script src="js/jquery-2.1.3.js"></script>
	<script src="js/pdfFromHTML.js"></script>

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