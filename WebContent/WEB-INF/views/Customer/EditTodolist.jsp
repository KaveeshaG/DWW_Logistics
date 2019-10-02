<%@page import="com.wms.model.ToDolist"%>
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

	<%
		ITodolist tolist = new TodolistServices();
		ToDolist todo = null;
		if (request.getAttribute("todo") == null) {
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Customer/ToDolist.jsp");
			dispatcher.forward(request, response);
		} else {
			todo = (ToDolist) request.getAttribute("todo");
		}
	%>


	<div class="container-fluid">
		<div class="row justify-content-center">
			<div class="card shadow m-5">
				<div class="card-header py-3">
					<h5 class="m-0 font-weight-bold text-primary text-center">Edit
						ToDoList</h5>
				</div>
				<div class="card-body">
					<div class="row m-4">
						<div class="row-md-4 mr-5">
							<img src="img/todo.png" style="widows: 300px; height: 300px;">
						</div>
						<div class="row-md-8">
							<form action="EditTodoServlet" method="POST">
								<div class="form-row">
									<div class="col-md-12 mb-3">
										<label for="name">Tasks</label> <input type="text"
											class="form-control" id="task" aria-describedby="emailHelp"
											name="tname" value="<%=todo.getTasksName()%>"> <input
											type="hidden" class="form-control" id="taskid"
											aria-describedby="emailHelp" name="taskid" value="<%=todo.getTaskId()%>">
									</div>

								</div>
								<div class="form-group">
									<label for="exampleInputNic">Status</label> <select
										class="form-control" name="tstatus" id="tstatus">
										<option value="">Select Status</option>
										<%
											if (todo.getStatus().equals("COMPLETE")) {
										%>
										<option selected="selected" value="COMPLETE">COMPLETE</option>
										<option value="NOT COMPLETE">NOT COMPLETE</option>
										<%
											} else {
										%>
										<option value="COMPLETE">COMPLETE</option>
										<option selected="selected" value="NOT COMPLETE">NOT
											COMPLETE</option>
										<%
											}
										%>
									</select>
								</div>

								<div class="form-group">
									<label for="inputState">Priority</label> <select id="tpriority"
										class="form-control" name="tpriority">
										<option value="">Select Priority</option>
										<%
											if (todo.getPriority().equals("HIGH")) {
										%>
										<option selected="selected" value="HIGH">HIGH</option>
										<option value="MEDIUM">MEDIUM</option>
										<option value="LOW">LOW</option>
										<%
											} else if (todo.getPriority().equals("MEDIUM")) {
										%>
										<option value="HIGH">HIGH</option>
										<option selected="selected" value="MEDIUM">MEDIUM</option>
										<option value="LOW">LOW</option>
										<%
											} else {
										%>
										<option value="HIGH">HIGH</option>
										<option value="MEDIUM">MEDIUM</option>
										<option selected="selected" value="LOW">LOW</option>
										<%
											}
										%>
									</select>


								</div>
								<div class="form-group">
									<label for="exampleInputNumber">Comment</label> <input
										type="text" class="form-control" name="tcomment" id="tcomment"
										value="<%=todo.getComment()%>">
								</div>
								<button type="submit"
									class="btn btn-primary btn-lg btn-block mt-4"
									name="updateTodolist" value="">Update Profile</button>
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