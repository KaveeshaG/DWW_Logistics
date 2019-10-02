<%@page import="com.wms.service.DataAccess"%>
<%@page import="java.util.List"%>
<%@page import="com.wms.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"></jsp:include>

		<%
			ArrayList<Employee> emplist = DataAccess.getAll();	
	
		%>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <p class="mb-4">Table list<a></a>.</p>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>User Name</th>
                      <th>Name</th>
                      <th>NIC</th>
                      <th>Email</th>
                      <th>Address</th>
                      <th>Phone No</th>
                      <th>Job Type</th>
                      <th>Update/Delete</th>
                    </tr>
                  </thead>

                  <tbody>
                    
                    <tr>
                    <%
						for(Employee e : emplist){
					%>
                    	<td class="id"><%= e.getId() %></td>
                    	<td><%= e.getUname()  %></td>
                    	<td><%= e.getName() %></td>
                    	<td><%= e.getNic() %></td>
                    	<td><%= e.getEmail()  %></td>
                    	<td><%= e.getAddress()  %></td>
                    	<td><%= e.getPhn() %></td>
                    	<td><%= e.getJob() %></td>
						<td>
						<center>
                        <button type="button" class="btnupdate btn btn-success btn-circle"><i class="fas fa-edit"></i></button>
                        <button type="button" class="btndelete btn btn-danger btn-circle"><i class="fas fa-trash"></i></button>
                        </center>
						</td>
                      </tr>
                      <% 
						}
                      %>
                      
                    

                  </tbody>
                </table>
              </div>
            </div>
          </div>          

        </div>
        <!-- /.container-fluid -->

        <!-- Delete Request Model -->
			<div class="modal fade" id="deleteReq" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Delete Employee</h5>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
	            <div class="row justify-content-center">	           
	                <span class="h5" id="empdelete"> </span>
	                
	            </div>
 				<div class="row justify-content-center m-2">
	                <form action="${pageContext.request.contextPath}/deleteEmp" method="POST">
	                	<input type="hidden" id="deleteEmpID" name="empId"/>
	                	<button type="submit" class="btn btn-danger">Confirm Delete Request</button>  
	                </form>
 				</div>               		        
			      </div>
			    </div>
			  </div>
			</div>  

      <!-- Update Modal -->
        <div class="modal fade bd-example-modal-lg" id="update" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title">Update</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                </div>
                <div class="modal-body">
                <div class="row-md-12 justify-content-center m-2">
                  <form action="${pageContext.request.contextPath}/updateEmp" method="POST">
                  <input type="hidden" name="emp" id="empForServlet"/>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col-md-12">
                                <label for="vehicleNo">Enter Name :</label>
                                <input type="text" class="form-control form-control-sm" id="name" placeholder="User Name" name="name">
                              </div>
                            </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                  <label for="containerNo">Enter NIC :</label>
                                  <input type="text" class="form-control form-control-sm" id="nic" placeholder="NIC" name="nic"> 
                              </div>
                          </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                <label for="trailerNo">Enter Email :</label>
                                <input type="text" class="form-control form-control-sm" id="email" placeholder="Enter Email" name="email">
                              </div>
                      </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                <label for="trailerNo">Enter Address :</label>
                                <input type="text" class="form-control form-control-sm" id="address" placeholder="Enter Address" name="address">
                              </div>
                      </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row">
                              <div class="col">
                                <label for="trailerNo">Enter Phone :</label>
                                <input type="text" class="form-control form-control-sm" id="phone" placeholder="Enter Phone" name="phone">
                              </div>
                      </div>
                      </div>
                      <div class="form-group">
                          <div class="form-row float-right">
                 		<button type="button" class="btn btn-secondary float-right mr-2" data-dismiss="modal">Close</button>
                		<button type="submit" class="btn btn-success float-right">Save Changes</button>  
                      </div>
                      </div>                         
                
                  </form>
                </div>
                </div>

            </div>
            </div>
        </div>

<jsp:include page="footer.jsp"></jsp:include>

<script>
$(".btnupdate").click(function() {
    var $row = $(this).closest("tr");    // Find the row
    var $id = $row.find(".id").text(); // Find the text in row
      
    
      $.ajax({
        url      : 'http://localhost:8080/Warehouse_Managment_System/updateEmp',
        method   : 'GET', 
        data     : {id: $id},
        success  : function(response){
        	
        	var emp = $.parseJSON(response);
        	
        	$('#name').val(emp.name);
        	$('#nic').val(emp.nic);
        	$('#email').val(emp.email);
        	$('#address').val(emp.address); 
        	$('#phone').val(emp.phn);
        	
        	$('#empForServlet').val(emp.id);
        	
        	$('#update').modal('toggle'); 
			
      }
    });  
}); 


$(".btndelete").click(function() {
	 
    var $row = $(this).closest("tr");    // Find the row
    var $id = $row.find(".id").text(); // Find the text in row
    
    $('#empdelete').text("You Are Going To Delete the Emp Id : " + $id);
    
    //deleteEmpID
    $('#deleteEmpID').val($id);
    
	 $('#deleteReq').modal('toggle');
});
</script>


