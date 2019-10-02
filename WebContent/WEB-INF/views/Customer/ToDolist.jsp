<%@page import="com.wms.model.ToDolist"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.TodolistServices"%>
<%@page import="com.wms.service.ITodolist"%>



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

	<!-- Begin Page Content -->


	<!-- Page Heading -->

	<div class="card-header py-3 bg-warning">
		<h6 class="m-0 font-weight-bold text-dark">ToDoList Details</h6>




	</div>
	<br></br>
	<!-- /.container-fluid -->
	<table class="table table-striped">
		<thead>

			<tr class="p-3 mb-2 bg-primary text-white"
				style="margin-left: -50%; margin-right: -10%;">
				<th scope="col">Task Id</th>
				<th scope="col">Tasks</th>
				<th scope="col">Status</th>
				<th scope="col">Priority</th>
				<th scope="col">Comment</th>
				<th></th>
				<th></th>
			</tr>

		</thead>

		<tbody id="tbl_body">

			<%
				ITodolist todolists = new TodolistServices();
				ArrayList<ToDolist> lists = todolists.getList();
				for (ToDolist todolist : lists) {
			%>




			<tr>
				<th scope="row"><%=todolist.getTaskId()%></th>
				<th scope="row"><%=todolist.getTasksName()%></th>
				<th scope="row"><%=todolist.getStatus()%></th>
				<th scope="row"><%=todolist.getPriority()%></th>
				<th scope="row"><%=todolist.getComment()%></th>
				<td>
					<form action="UpdateToDo" method="POST">
						<input type="hidden" value="<%=todolist.getTaskId()%>"
							name="taskid" />
						<button type="submit" class="btn btn-primary">Update ToDo</button>
					</form>
				</td>
				<td>
					<form action="TodolistDeleteById" method="POST">
						<input type="hidden" name="listID"
							value="<%=todolist.getTaskId()%>">
						<button type="submit" class="btn btn-danger m-0">delete
							ToDoList</button>
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
				New List</button>
		</div>
	</div>


	<div class="modal fade bd-example-modal-lg" id="exampleModalCenter"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<div class="card-header">
						<h6 class="m-0 font-weight-bold text-dark"
							id="exampleModalCenterTitle">ADD NEW LIST</h6>

					</div>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="row-md-4 m-5">
							<img src="img/todolist.png" style="widows: 300px; height: 300px;">
						</div>
						<div class="row-md-8 m-4">
							<form action="Todolist1Servlet" method="POST">
								<div class="form-group">
									<label for="exampleInputEmail1">Tasks</label> <input
										type="text" class="form-control" name="TasksName"
										aria-describedby="emailHelp" placeholder="Enter Name">
									<small id="emailHelp" class="form-text text-muted"></small>
								</div>

								<div class="form-group">
									<label for="inputState">Status</label> <select id="inputType"
										class="form-control" name="Status">
										<option value="">Select Status</option>
										<option>COMPLETE</option>
										<option>NOT COMPLETE</option>



									</select>
								</div>

								<div class="form-group">
									<label for="inputState">Priority</label> <select id="inputType"
										class="form-control" name="Priority">
										<option value="">Select Priority</option>
										<option>HIGH</option>
										<option>MEDIUM</option>
										<option>LOW</option>

									</select>
								</div>

								<div class="form-group">
									<label for="exampleInputPassword1">Comment</label> <input
										type="text" class="form-control" name="Comment"
										id="exampleInputPassword1" placeholder="comment">
								</div>
								<button type="submit"
									class="btn btn-primary btn-lg btn-block mt-4 mb-3">Add
									List</button>
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
											'<option value="">Select Search Type</option><option value="1">ID</option><option value="2">Status</option><option value="3">Priority</option>');

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
															$("#tbl_body")
																	.html(
																			req.responseText);
														}

													}
												};
												req.open("POST", "SearchToDo",
														true);
												req
														.setRequestHeader(
																"Content-type",
																"application/x-www-form-urlencoded");
												req.send("stype=" + stype
														+ "&txt=" + txt);

											});

						});
	</script>


	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>