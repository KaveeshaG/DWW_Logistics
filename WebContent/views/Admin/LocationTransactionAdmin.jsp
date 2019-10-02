
<%@page import="com.wms.service.LocationTransactionImpl"%>
<%@page import="com.wms.model.LocationTransaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.ILocationTransactionService"%>
<jsp:include page="header.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- DataTales Example -->
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
                    </tr>
                  </tfoot>
                  <tbody>
                    

					<%
                		ILocationTransactionService iLocationTransactionService = new LocationTransactionImpl();
						ArrayList<LocationTransaction> arrayList = iLocationTransactionService.getLocationTransaction();
			
						for(LocationTransaction locTran : arrayList)
						{
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
							<form method="POST" action="${pageContext.request.contextPath}/AdminConfirmLocationTransactionServlet">
							
								<input type="hidden" name="id" value="<%=locTran.getId()%>"/>
								
								<button type="submit" class="btn btn btn-success">Accept</button>
                          		             		
							</form>
		
						</td>
						
						<td>
							<form method="POST" action="${pageContext.request.contextPath}/AdminDeleteLocationTransactionServlet">
							
	  							<input type="hidden" name="id" value="<%=locTran.getId()%>" />
	  							
	  							<button type="submit" class="btn btn-danger" onclick="if(!(confirm('Are you sure you want to detete this request?'))) return false">Reject</button>
	  				
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

        </div>
        <!-- /.container-fluid -->

        <jsp:include page="footer.jsp"></jsp:include>