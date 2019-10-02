<%@page import="java.text.DecimalFormat"%>
<%@page import="com.wms.model.QuotationDetails"%>
<%@page import="com.wms.model.Quotation"%>
<%@page import="java.util.ArrayList"%>
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
<title>Quotation Details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<!-- page content begins here -->
	
	
	<%
		String qoID =(String) request.getAttribute("qoID");
		String poID =(String) request.getAttribute("poID");
		IInventoryManager manager =  new InventoryManagerServices();
		Quotation quotation  = manager.getQuoationByID(qoID);
		float total = 0, netTotal = 0;
		DecimalFormat form = new DecimalFormat("0.00");
	%>
	
	
	<div class="col-xl-12 col-md-6 mb-12">
		<div class="card border-left-primary shadow h-100 py-2">
			<div class="card-body">
			
			

			

							
						</div>
						<div class="col-xl-12 col-12 ">
					
							
							
							<h5 class="text-right text-dark">
								Quotation ID -
								<%=quotation.getQuotationID()%></h5>
							
							<h5 class="text-right text-dark">
								
								<%=quotation.getSupplierName()%></h5>
							
							<h6 class="text-right text-dark">
								<%=quotation.getAddLine1()%>
								</h6>
								
								<h6 class="text-right text-dark">
								<%=quotation.getAddLine2()%>
								</h6>
								<h6 class="text-right text-dark">
								<%=quotation.getEmail()%>
								</h6>
								
								<h6 class="text-right text-dark">
								<%=quotation.getContact()%>
								</h6>
							
							<h4 class="text-center mt-3 mb-3 text-dark"><u>Quoatation For Purchase Order - <%=poID %> </u></h4>



							<%
							
							ArrayList<QuotationDetails> qoList = manager.getQuotationDetailsById(qoID);
							Iterator<QuotationDetails> it_list = qoList.iterator();
							
						%>
							
								<table class="table table-hover mt-3">
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
								QuotationDetails quotationDetails = new QuotationDetails();
								quotationDetails = it_list.next();
								total += quotationDetails.getQty() * quotationDetails.getPrice();
								
						%>
						
						<tbody>
									<tr id="<%=quotationDetails.getPoDeId()%>">
										<td  data-target="name"><%=quotationDetails.getItemName()%></td>
										<td  data-target="qty"><%=quotationDetails.getQty()%></td>
										<td data-target="price"><%=form.format(quotationDetails.getRequestedPrice())%></td>
										<td   ><%= form.format(quotationDetails.getPrice())%></td>
										<td   ><%= quotationDetails.getDes()%></td>
										
										
									</tr>
									
						</tbody>
						
						<%
							}
						%>
						
						</table>
						
						<%
							float discount = total * quotation.getDiscount() / 100;
							netTotal  = total - discount;
						%>
						<div class="row mt-3">
                                        <div class="col-lg-4 col-sm-5">
                                        </div>
                                        <div class="col-lg-4 col-sm-5 ml-auto">
                                            <table class="table table-clear">
                                                <tbody>
                                                    <tr>
                                                        <td class="left">
                                                            <strong class="text-dark">Sub Total</strong>
                                                        </td>
                                                        <td class="right"><%=form.format(total) %>/-</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="left">
                                                            <strong class="text-dark">Discount (...%)</strong>
                                                        </td>
                                                        <td class="right"><%=quotation.getDiscount() %>%</td>
                                                    </tr>
                                                    
                                                    <tr>
                                                        <td class="left">
                                                            <strong class="text-dark">Total</strong>
                                                        </td>
                                                        <td class="right">
                                                            <strong class="text-danger"><u><%=form.format(netTotal)%>/-</u></strong>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                    
                                    
                                   <div class=" row justify-content-center mt-3"> 
                                    <button type="submit"  class="btn btn-success btn-icon-split ml-2 " data-toggle="modal" data-target="#getApproval">
                    <span class="icon text-white-100">
                      <i class=" far fa-calendar-check"></i>
                    </span>
                    <span class="text">Give Approval</span>
                  </button>
                  </div>
						</div>
				
							</div>
						</div>
				




	<!--GEt approval  -->
  <div class="modal fade bd-example-modal-lg" id="getApproval" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered ml-10" role="document">
      <div class="modal-content">
        <div class="modal-header bg-success">
        <h5 class="text-white" id="exampleModalCenterTitle"><i class="fas fa-minus-circle"></i> ARE YOU WANT TO GIVE APPROVAL</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" style="color: white ">&times;</span>
          </button>
        </div>
        <div class="modal-body">
        
       
        
        	<div class="row ml-5">
        		<div class="mr-5">
        		<form action="GiveApprovalForPurchaseOrder" method="POST">
        		 <input type="hidden" name="poID" value="<%=poID%>">
        		 <input type="hidden" name="qoID" value="<%=qoID%>">
        		<button type="submit"  class="btn btn-success btn-icon-split ">
                    <span class="icon text-white-100">
                      <i class="far fa-calendar-check"></i>
                    </span>
                    <span class="text">Yes, I'm Sure</span>
                  </button></form>
               </div>   
                  <div class="ml-2">
                  <button  class="btn btn-danger btn-icon-split " data-dismiss="modal">
                    <span class="icon text-white-100">
                      <i class="far fa-calendar-times"></i>
                    </span>
                    <span class="text">No, I'm Sorry</span>
                  </button>
                 </div> 
           </div>
      </div>
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