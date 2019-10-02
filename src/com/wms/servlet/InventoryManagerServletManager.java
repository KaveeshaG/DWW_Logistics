package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class InventoryManagerServletManager
 */
@WebServlet("/InventoryManagerServletManager")
public class InventoryManagerServletManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryManagerServletManager() {
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
		String action = request.getParameter("action"); 
		
		if(action.equals("EDITPO")) {
			
			String poID = request.getParameter("poID");
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/EditPurchaseOrder.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("PRI")) {
			
			String poID = request.getParameter("poID");
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventoryQuatationPrint.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("DPO")) {
			
			String poID = request.getParameter("poID");
			manager.deletePurchaseOrderDetailsByPOID(poID);
			manager.deletePurchaseOrder(poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrder.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("VIEW")) {
			
			String poID = request.getParameter("poID");
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("ADDQUO")) {
			
			String poID = request.getParameter("poID");
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/QuotationsForPO.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("VIEWQOD")) {
			
			String poID = request.getParameter("poID");
			String qoID = request.getParameter("qoID");
			request.setAttribute("qoID", qoID);
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/QuotationDetails.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("PRINTQUO")) {
			
			String poID = request.getParameter("poID");
			String qoID = request.getParameter("qoID");
			request.setAttribute("qoID", qoID);
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/QuotationDetailsPrint.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("SUPACCOUNT")) {
			
			
			String supID = request.getParameter("supID");
			request.setAttribute("supID", supID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/SearchSupplierAccount.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
