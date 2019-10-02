package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.PurchaseOrderDetails;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class UpdatePurchaseOrderDetails
 */
@WebServlet("/UpdatePurchaseOrderDetails")
public class UpdatePurchaseOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePurchaseOrderDetails() {
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
		
		PurchaseOrderDetails details = new PurchaseOrderDetails();
		details.setPoDeId(request.getParameter("poDeID"));
		details.setItemName(request.getParameter("name"));
		details.setQty(Integer.parseInt(request.getParameter("qty")));
		details.setRequestedPrice(Float.parseFloat(request.getParameter("price")));
		String poID = request.getParameter("poID");
		details.setPoId(poID);
		
		IInventoryManager iInventoryManager = new InventoryManagerServices();
		iInventoryManager.updatePurchaseOrderDetailsById(details);
		System.out.println(details);
		request.setAttribute("poID", poID);
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/EditPurchaseOrder.jsp");
		dispatcher.forward(request, response);
	}

}
