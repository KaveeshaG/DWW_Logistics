<%@page import="com.wms.service.CustomerServices"%>
<%@page import="com.wms.service.ICustomer"%>
<%@page import="com.wms.model.CustomerAccount"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>

	<%
	ICustomer customer = new CustomerServices();
	//CustomerAccount customerAcc = customer.getCustomerByID(255);
	//System.out.println(customerAcc == null);
		CustomerAccount customerAccount = (CustomerAccount) request.getAttribute("cus");
	%>


	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="card shadow m-5">
				<div class="card-header py-3">
					<h5 class="m-0 font-weight-bold text-primary text-center">Edit
						Customer Profile</h5>
				</div>
				<div class="card-body">
					<div class="row m-4">
						<div class="row-md-4 mr-5">
							<img src="img/customerEdit.png"
								style="widows: 300px; height: 300px;">
						</div>
						<div class="row-md-8">
							<form action="EditCustomerServlet" method="POST">
								<div class="form-row">
									<div class="col-md-6 mb-3">
										<label for="name">Customer Name</label> <input
											type="text" class="form-control" id="name"
											aria-describedby="emailHelp" name="name"
											value="<%=customerAccount.getCustomerName()%>"> <input
											type="hidden" class="form-control" id="customerID"
											aria-describedby="emailHelp" name="customerID"
											value="<%=customerAccount.getCustomerId()%>">
									</div>
									<div class="col-md-6 mb-3">


										<label for="exampleFormControlItem">Type</label> <select
											id="inputType" class="form-control" name="type"
											value="<%=customerAccount.getType()%>">
											<option selected>GRN</option>
											<option>GDN</option>


										</select>


									</div>
								</div>
								<div class="form-group">
									<label for="exampleInputNic">NIC Number</label> <input
										type="text" class="form-control" name="nic"
										id="exampleInputNic" value="<%=customerAccount.getNic()%>">
								</div>

								<div class="form-group">
									<label for="exampleInputEmail">Email Address</label> <input
										type="email" class="form-control" name="email"
										id="exampleInputEmail" aria-describedby="emailHelp"
										value="<%=customerAccount.getEmail()%>">
								</div>
								<div class="form-group">
									<label for="exampleInputNumber">Mobile Number</label> <input
										type="text" class="form-control" name="number"
										id="exampleInputNumber"
										value="<%=customerAccount.getMobile()%>">
								</div>
								<button type="submit"
									class="btn btn-primary btn-lg btn-block mt-4"
									name="updateCustomer"
									value="<%=customerAccount.getCustomerId()%>">Update
									Profile</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>