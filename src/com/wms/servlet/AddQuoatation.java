package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.Quotation;
import com.wms.model.QuotationDetails;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class AddQuoatation
 */
@WebServlet("/AddQuoatation")
public class AddQuoatation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuoatation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		IInventoryManager manager = new InventoryManagerServices();
		
		Quotation quotation = new Quotation();
		String poID = request.getParameter("poID");
		quotation.setSupplierName(request.getParameter("supName"));
		quotation.setContact(request.getParameter("con"));
		quotation.setEmail(request.getParameter("email"));
		quotation.setAddLine1(request.getParameter("ad1"));
		quotation.setAddLine2(request.getParameter("ad2"));
		quotation.setPoId(poID);
		quotation.setDiscount(Float.parseFloat(request.getParameter("dis")));
		quotation.setTotal(234);
		
		
		String quotationID = manager.addQuotation(quotation);
		
		
		String price[] = (request.getParameterValues("price"));
		String desc[] = (request.getParameterValues("desc"));
		String poDeID[] = (request.getParameterValues("poDeID"));
		
		
		
		for(int i = 0; i < price.length; i++) {
			QuotationDetails details = new QuotationDetails();
			details.setQuotationID(quotationID);
			details.setPurchaseOrderDeID(poDeID[i]);
			details.setPrice(Float.parseFloat(price[i]));
			details.setDes(desc[i]);
			manager.addQuotationDetails(details);
			
		}
		
		manager.updatePurchaseOrderStatus("RECIEVING", poID);
		
		request.setAttribute("poID", poID);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
