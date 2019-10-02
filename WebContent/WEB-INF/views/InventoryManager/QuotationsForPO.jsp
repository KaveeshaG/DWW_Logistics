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
<title>Quotation For PO</title>
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


	<div class="col-xl-12 col-md-6 mb-12">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">
				<h2 class="text-center text-primary mb-4">
					Enter Quotation For
					<%=head.getPoId() %></h2>
				<form action="AddQuoatation" method="POST" name="AddQuotation" onsubmit="return addQuotation()">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<i class="fas fa-user text-primary mt-3 mb-2"> Suppler Name</i>
								<input type="text" class="form-control" name="supName"
									placeholder="Enter Supplier Name">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<i class="fas fa-phone text-primary mt-3 mb-2"> Contact
									Number</i> <input type="text" class="form-control"
									placeholder="Enter Contact Number" name="con">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<i class="fas fa-envelope text-primary mt-3 mb-2"> Email</i> <input
									type="email" class="form-control" placeholder="Enter Email"
									name="email">
							</div>
						</div>

					</div>


					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<i class=" fas fa-map-marker-alt text-primary mt-3 mb-2">
									Address Line 1</i> <input type="text" class="form-control"
									placeholder="Enter Address Line 1" name="ad1">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<i class=" fas fa-map-marker-alt text-primary mt-3 mb-2">
									Address Line 2</i> <input type="text" class="form-control"
									placeholder="Enter Address Line 1" name="ad2">
							</div>
						</div>
					</div>






					<%
							
							List<PurchaseOrderDetails> poList = manager.getPurchaseOrderDetails(poID); 
							Iterator<PurchaseOrderDetails> it_list = poList.iterator();
							
						%>

					<table class="table table-hover mt-5 ml-">
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
							<tr id="<%=orderDetails.getPoDeId()%>">
								<td data-target="name"><%=orderDetails.getItemName()%></td>
								<td data-target="qty"><%=orderDetails.getQty()%></td>
								<td data-target="price"><%=form.format(orderDetails.getRequestedPrice())%></td>
								<td data-target="poID" style="display: none;"><%= orderDetails.getPoDeId()%></td>
								<td><input type="number" class="form-control"
									placeholder="Price" name="price"></td>
								<td><input type="text" class="form-control"
									placeholder="Description" name="desc"></td>



								<td><input type="hidden" class="form-control"
									value="<%=orderDetails.getPoDeId()%>" name="poDeID"></td>




							</tr>

						</tbody>

						<%
							}
						%>
	
					</table>
					
					<span id="numloc"></span>


					<div class="row">
						<div class="col-lg-4 col-sm-5"></div>
						<div class="col-lg-4 col-sm-5 ml-auto">
							<table class="table table-clear">
								<tbody>

									<tr>
										<td class="left"><strong class="text-dark">Discount
												(...%)</strong></td>

									</tr>
									<tr>
										<td><input type="number" class="form-control"
											placeholder="Discount" name="dis"></td>
								</tbody>
							</table>
						</div>
					</div>


					
						<input type="hidden" name="poID" value="<%=poID%>">
						<div class="row justify-content-center">
						<button type="submit" class="btn btn-primary btn-icon-split " name="btn">
							<span class="icon text-white-50"> <i class="fas fa-check"></i>
							</span> <span class="text">Add Quotation</span>
						</button>
						</div>
				</form>

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