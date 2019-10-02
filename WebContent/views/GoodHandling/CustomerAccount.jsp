<%@page import="com.wms.model.CustomerAccount"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.ICustomer"%>
<%@page import="com.wms.service.CustomerServices"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="vendor/jquery/jquery.min.js"></script>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>

	<!-- Begin Page Content -->


	<!-- Page Heading -->


	<div class="card-header py-3 bg-warning">
		<h6 class="m-0 font-weight-bold text-dark">Customer Details</h6>

	</div>



	<!-- <div class="card-header py-3 bg-warning" style="background-color: red;">
		<h6 class="m-0 font-weight-bold" style="color: white;"></h6>

	</div>-->

	<br>

	<!-- /.container-fluid -->




	<table class="table table-striped">
		<thead>

			<tr class="p-3 mb-2 bg-primary text-white"
				style="margin-left: -50%; margin-right: -10%;">
				<th scope="col">Customer Id</th>
				<th scope="col">Customer Name</th>
				<th scope="col">Customer Type</th>
				<th scope="col">Email</th>
				<th scope="col">Mobile No</th>
				<th></th>
				<th></th>
			</tr>

		</thead>
		<tbody id="tbl_body">
			<%
				ICustomer customer = new CustomerServices();
				ArrayList<CustomerAccount> accounts = customer.getCustomerList();
				for (CustomerAccount account : accounts) {
			%>

			<tr>
				<th scope="row"><%=account.getCustomerId()%></th>
				<th scope="row"><%=account.getCustomerName()%></th>
				<th scope="row"><%=account.getType()%></th>
				<th scope="row"><%=account.getEmail()%></th>
				<th scope="row"><%=account.getMobile()%></th>
				<td>
					<form action="UpdateCustomer" method="POST">
						<input type="hidden" value="<%=account.getCustomerId()%>"
							name="cusId" />
						<button type="submit" class="btn btn-primary">Update
							Customer</button>
					</form>
				</td>
				<td>
					<form action="CustomerAccountDeleteById" method="POST">
						<input type="hidden" name="cusID"
							value="<%=account.getCustomerId()%>">
						<button type="submit" class="btn btn-danger m-0">delete
							Customer</button>
					</form>
				</td>
			</tr>



			<%
				}
			%>
		</tbody>
	</table>


	<div class="container-fluid">
		<div class="row mt-5 mb-5 justify-content-center">

			<button type="submit" class="btn btn-outline-dark btn-lg"
				data-toggle="modal" data-target="#exampleModalCenter">Add
				New Customer</button>
		</div>
	</div>


	<div class="modal fade bd-example-modal-lg" id="exampleModalCenter"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<div class="card-header py-3 bg-warning">
						<h6 class="m-0 font-weight-bold text-dark">ADD NEW CUSTOMER</h6>

					</div>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="row-md-4 m-5">
							<img src="img/customer.png" style="widows: 300px; height: 300px;">
						</div>
						<div class="row-md-8 m-4">
							<form action="CustomerAccountServlet" method="POST">
								<div class="form-group">
									<label for="exampleInput">Customer Name</label> <input
										type="text" class="form-control" name="CustomerName"
										required="required" aria-describedby="emailHelp"
										placeholder="Enter Name"> <small id="emailHelp"
										class="form-text text-muted">Hint : Use TE With
										Customer Name</small>
								</div>
								<div class="form-group">
									<label for="inputState">Customer Type</label> <select
										id="inputType" class="form-control" name="type"
										required="required">
										<option value="">Select type</option>
										<option value="GRN">GRN</option>
										<option value="GDN">GDN</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">NIC Number</label> <input
										type="text" class="form-control" name="NIC"
										required="required" id="exampleInputPassword1"
										placeholder="Enter NIC">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Enter Email</label> <input
										type="email" class="form-control" name="Email"
										required="required" id="exampleInputPassword1"
										placeholder="Enter Email">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">Mobile Number</label> <input
										type="text" class="form-control" name="Number"
										required="required" id="exampleInputPassword1"
										placeholder="Enter Number">
								</div>

								<div class="form-group">
									<label for="exampleInputPassword1">Password </label> <input
										type="password" class="form-control" name="Password"
										required="required" id="exampleInputPassword1"
										placeholder="Enter Password">
								</div>

								<button type="submit"
									class="btn btn-primary btn-lg btn-block mt-4 mb-3">Add
									Customer</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>







	<script language="javascript">
		$(document)
				.ready(
						function() {

							var error = "${error}";
							if (error != "") {
								alert(error);
							}

							$("#setype")
									.html(
											'<option value="">Select Search Type</option><option value="1">ID</option><option value="2">Name</option><option value="3">Type</option><option value="4">Email</option><option value="5">Mobile</option>');
						

							$("#searchbtn")
									.click(
											function() {

												var stype = $("#setype").val();
												var txt = $("#setxt").val();

												var req = new XMLHttpRequest();
												req.onreadystatechange = function() {
													if (this.readyState == 4
															&& this.status == 200) {

														if (req.responseText == "0") {
															alert("Please enter search text.!");
														} else if (req.responseText == "1") {
															alert("Please select valid search type.!");
														} else {
															$("#tbl_body").html(req.responseText);
														}

													}
												};
												req.open("POST","SearchCustomer", true);
												req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
												req.send("stype=" + stype+ "&txt=" + txt);

											});

						});
	</script>


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>

