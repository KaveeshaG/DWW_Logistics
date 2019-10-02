<%@page import="com.wms.service.GoodHandlingServiceImpl"%>
<%@page import="com.wms.model.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wms.service.IGoodHandlingService"%>

	<jsp:include page="header.jsp"></jsp:include>

	<%
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		ArrayList<Item> item = goodHandlingService.getReqItemList();		
	%>
	
        <!-- Begin Page Content -->
        <div class="container-fluid">

            <div class="row m-2">
                <h1 class="h3 font-weight-bold text-primary">Add Items Request</h1>
            </div>        
              
        <div class="row justify-content-center m-4">
        <div class="col">
            
          <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Add Items Request</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Item Code</th>
                      <th>Item Name</th>
                      <th>Item Description</th>
                      <th>Remark</th>
                      <th>Payment Method</th>
                      <th>Price</th>
                      <th>UOM</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>Item Code</th>
                      <th>Item Name</th>
                      <th>Item Description</th>
                      <th>Remark</th>
                      <th>Payment Method</th>
                      <th>Price</th>
                      <th>UOM</th>
                      <th></th>
                      </tr>
                  </tfoot>
                <tbody>
                <% for(Item I : item){ %>
                    <tr>
                    	<td><%= I.getItemId() %></td>                    	
                    	<td><%= I.getItemName() %></td>
                    	<td><%= I.getItemDes() %></td>
                    	<td><%= I.getRemark() %></td>
                    	<td><%= I.getPaymentMethod() %></td>
                    	<td><%= I.getPrice() %></td>
                    	<td><%= I.getUom() %></td>
                        <td>
                        	<form action="${pageContext.request.contextPath}/InsertItem?step=add" method="POST">
                        		<input type="hidden" name="itemId" value="<%= I.getItemId() %>"/>
                        		<button type="submit" class="btnconfirm btn btn-success btn-icon-split">
				                    <span class="text">Add Item</span>                        		
								</button>
                        	</form>
                        </td>                       
                    </tr>
                <% } %>                    
                </tbody>
            </table>
            </div>
            </div>
        </div>
        </div>
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
      
      <jsp:include page="footer.jsp"></jsp:include>