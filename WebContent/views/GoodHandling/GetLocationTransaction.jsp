<jsp:include page="header.jsp"></jsp:include>

        <!-- Begin Page Content -->
        <%@page import="com.wms.model.LocationTransaction"%>
<div class="container-fluid">

          <!-- Page Heading -->
          <h5 class="h3 mb-4 text-gray-800" >Location Transaction</h5>
  
      <div class="row">

        <div class="col-md-7 border border-info">

                    <div class="row" >
                        <div class="col" >
                          <table class="table table-sm table-borderless">
                            <thead>
                              <tr class="table-light">
                                <th scope="col"><div style="margin-left: 115px">A section</div></th>
                                <th scope="col"><div style="margin-left: 140px">B section</div></th>
                              </tr>
                            </thead>
                            <br><br>
                            <tbody>
                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A10</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                <td><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 50px">B05</a> <a href="#" class="badge badge-danger" style=" height: 30px; padding-top: 10px">400</a></td>
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A09</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                <td><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 50px">B04</a> <a href="#" class="badge badge-danger" style=" height: 30px; padding-top: 10px">400</a></td>
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A08</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                <td><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 50px">B03</a> <a href="#" class="badge badge-danger" style=" height: 30px; padding-top: 10px">400</a></td>
                              </tr>


                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A07</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                <td><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 50px">B02</a> <a href="#" class="badge badge-danger" style=" height: 30px; padding-top: 10px">400</a></td>
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A06</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                <td><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 50px">B01</a> <a href="#" class="badge badge-danger" style=" height: 30px; padding-top: 10px">400</a></td>
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A05</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A04</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A03</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A02</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                               
                              </tr>

                              <tr class="table-light">
                                <th scope="row"><a href="#" class="badge badge-primary" style="width: 250px; height: 30px; padding-top: 10px; margin-left: 25px">A01</a> <a href="#" class="badge badge-success" style=" height: 30px; padding-top: 10px">1000</a></th>
                                
                              </tr>

                            </tbody>
                          </table>
                    </div>
                </div>
            </div>
        <!-- /.col-7 -->

        <div class="col-5">
          
        <div class="form border border-info" style="width: 400px; float: middle; margin: 10px">
        
    <%
    	//LocationTransaction lt = (LocationTransaction) request.getAttribute("LocTran");
    	HttpSession httpSession = request.getSession();
    	
    	if(httpSession.getAttribute("LocTran") != null){
    		LocationTransaction lt = (LocationTransaction) httpSession.getAttribute("LocTran");
	%>
        
    <form action="${pageContext.request.contextPath}/UpdateLocationTransactionServlet" method="POST" class="was-validated">
    
      <div class="form-group">
      <input type="text" name="id" style="margin: 10px 10px 0px 10px; width: 300px" disabled="disabled" value="Location Transaction Id: <%=lt.getId() %>" class="form-control-plaintext"/>
	  </div>



      <!-- <div class="form-group">
          <label for="exampleFormControlSelect1" style="margin: 10px 10px 0px 10px; width: 200px">Add Manager</label>
          <select name="manager" class="form-control" id="exampleFormControlSelect1" style="margin: 5px 10px 10px 10px; width: 100px" required>
              <option>1</option>
              
          </select>
        </div> -->

        
      <div class="form-group">
          <select name = "currentL" class="custom-select" style="margin: 10px 10px 0px 10px; width: 300px " required>
            <option value="">Select Current Location</option>
            <option value="A01">A01</option>
            <option value="A02">A02</option>
            <option value="A03">A03</option>
            <option value="A04">A04</option>
            <option value="A05">A05</option>
            <option value="A06">A06</option>
            <option value="A07">A07</option>
            <option value="A08">A08</option>
            <option value="A09">A09</option>
            <option value="A10">A10</option>
            <option value="B01">B01</option>
            <option value="B02">B02</option>
            <option value="B03">B03</option>
            <option value="B04">B04</option>
            <option value="B05">B05</option>
        </select>
        <div class="invalid-feedback">Please Select Current Location</div>
      </div>

      <div class="form-group">
        <select name="cusName" class="custom-select" style="margin: 10px; width: 300px" required>
            <option value="">Select Customer ID</option>
            <option value="C10000">C10000</option>
            <option value="C20000">C20000</option>
            <option value="C30000">C30000</option>
            <option value="C40000">C40000</option>
            <option value="C50000">C50000</option>
            <option value="C60000">C60000</option>
        </select>
        <div class="invalid-feedback">Please Select Customer</div> 
      </div>

      <div class="form-group">
        <select name="grn" class="custom-select" style="margin: 10px; width: 300px" required>
        	<option value="">Select GRN Number</option>
            <option value="G11111">G11111</option>
            <option value="G22222">G22222</option>
            <option value="G33333">G33333</option>
            <option value="G44444">G44444</option>
            <option value="G55555">G55555</option>
        </select>
        <div class="invalid-feedback">Please Select GRN Number</div>
      </div>

      <div class="form-group">
        <select name="destinationL" class="custom-select" style="margin: 10px; width: 300px" required>
            <option value="">Select Moved Location</option>
            <option value="A01">A01</option>
            <option value="A02">A02</option>
            <option value="A03">A03</option>
            <option value="A04">A04</option>
            <option value="A05">A05</option>
            <option value="A06">A06</option>
            <option value="A07">A07</option>
            <option value="A08">A08</option>
            <option value="A09">A09</option>
            <option value="A10">A10</option>
            <option value="B01">B01</option>
            <option value="B02">B02</option>
            <option value="B03">B03</option>
            <option value="B04">B04</option>
            <option value="B05">B05</option>
        </select>
        <div class="invalid-feedback">  Please Select Moved Location</div> 
      </div>
      
      <div class="form-group">
        <label for="exampleFormControlTextarea1" style="margin: 10px 10px 0px 10px; width: 200px">Reason</label>
          <textarea name="reason" class="form-control" id="exampleFormControlTextarea1" rows="3" style="margin: 5px 10px 30px 10px; width: 350px"  required><%=lt.getReason()%></textarea>
      </div>
      
	  
	  <input type="hidden" name="id" value="<%=lt.getId()%>" /> 
	  <input type="submit" value="Change Location" class="btn btn-outline-success" style="width: 180px; margin: 10px"/>
	  
     </form>
      
      <form method="POST" action="${pageContext.request.contextPath}/DeleteLocationTransactionServlet">
	  		<input type="hidden" name="id" value="<%=lt.getId()%>" />
	  		<input type="submit" value="Delete Request" class="btn btn-outline-danger" style="width: 180px; margin: 10px" />
	  </form>
    </div>

<% } %>
        </div>
        <!-- /.col-4 -->


      </div>
      <!-- /.row -->
  
 

      </div>
        <!-- /.container-fluid -->


<jsp:include page="footer.jsp"></jsp:include>