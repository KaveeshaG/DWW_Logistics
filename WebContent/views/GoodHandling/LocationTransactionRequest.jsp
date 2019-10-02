  
<%@page import="com.wms.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.*"%>

	<jsp:include page="header.jsp"></jsp:include>

  <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Location Transaction Request Table -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Location Transaction Request</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Current Location</th>
                      <th>Customer ID</th>
                      <th>GRN No</th>
                      <th>Destination Location</th>
                      <th>Reason</th>
                      <th>Edit</th>
                      <th>Remove</th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>ID</th>
                      <th>Current Location</th>
                      <th>Customer ID</th>
                      <th>GRN No</th>
                      <th>Destination Location</th>
                      <th>Reason</th>
                      <th>Edit</th>
                      <th>Remove</th>
                    </tr>
                  </tfoot>
                  <tbody>
                  
                  
                  
                  
                <%
                		ILocationTransactionService iLocationTransactionService = new LocationTransactionImpl();
						ArrayList<LocationTransaction> arrayList = iLocationTransactionService.getLocationTransaction();
			
						for(LocationTransaction locTran : arrayList){
							
							if(locTran.getStatus() == 0){
				%>
			 		<tr>
						<td> <%=locTran.getId() %> </td>
						<td> <%=locTran.getCurrentLoc() %> </td>
						<td> <%=locTran.getCustomerId() %> </td>
						<td> <%=locTran.getGRNNo() %> </td>
						<td> <%=locTran.getDestiLoc() %> </td>
						<td> <%=locTran.getReason() %> </td>
							
						<td> 
							<form method="POST" action="${pageContext.request.contextPath}/getLocationTransactionReq">
								<input type="hidden" name="id" value="<%=locTran.getId()%>"/>
						 		<input type="submit" class="btn btn-info" value= "Edit" class="select-button" /> 
						 	</form>
						</td>
						
						<td> 
							<form method="POST" action="${pageContext.request.contextPath}/DeleteLocationTransactionServlet">
								<input type="hidden" name="id" value="<%=locTran.getId()%>"/>
						 		<input type="submit" class="btn btn-danger" value= "Remove" class="select-button" onclick="if(!(confirm('Are you sure you want to detete this request?'))) return false"/> 
						 	</form>
						</td>	 	 
					</tr>			
				<%	
				   }
						}
	            %>     
                  
                    
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          
          
          
          
          <br><br><br><br><br>
            <!-- Confirmed Location Transaction Request Table -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Confirmed Location Transaction Request</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Current Location</th>
                      <th>Customer ID</th>
                      <th>GRN No</th>
                      <th>Destination Location</th>
                      <th>Reason</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                      <%
                		ILocationTransactionService iLocationTransactionService2 = new LocationTransactionImpl();
						ArrayList<LocationTransaction> arrayList2 = iLocationTransactionService.getLocationTransaction();
			
						for(LocationTransaction locTran : arrayList2){
							
							if(locTran.getStatus() == 1){
				%>
			 		<tr>
			 			<td> <%=locTran.getId() %> </td>
						<td> <%=locTran.getCurrentLoc() %> </td>
						<td> <%=locTran.getCustomerId() %> </td>
						<td> <%=locTran.getGRNNo() %> </td>
						<td> <%=locTran.getDestiLoc() %> </td>
						<td> <%=locTran.getReason() %> </td>
			 		</tr>
						
				
							
				<%	
				   }
						}
	            %>     
                    
                  </tbody>
                </table>
 
              </div>
            </div>
          </div>

 
            <br><br><br><br><br>
            <!-- Rejected Location Transaction Request Table -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Rejected Location Transaction Request</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Current Location</th>
                      <th>Customer ID</th>
                      <th>GRN No</th>
                      <th>Destination Location</th>
                      <th>Reason</th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    <%
                		ILocationTransactionService iLocationTransactionService3 = new LocationTransactionImpl();
						ArrayList<LocationTransaction> arrayList3 = iLocationTransactionService.getLocationTransaction();
			
						for(LocationTransaction locTran : arrayList3){
							
							if(locTran.getStatus() == 2){
				%>
			 		<tr>
			 			<td> <%=locTran.getId() %> </td>
						<td> <%=locTran.getCurrentLoc() %> </td>
						<td> <%=locTran.getCustomerId() %> </td>
						<td> <%=locTran.getGRNNo() %> </td>
						<td> <%=locTran.getDestiLoc() %> </td>
						<td> <%=locTran.getReason() %> </td>
			 		</tr>									
							
				<%	
				   }
						}
	            %>     
                    
                  </tbody>
                </table>
 
              </div>
            </div>
          </div>
              
        </div>
        <!-- /.container-fluid -->
       
	<jsp:include page="footer.jsp"></jsp:include>