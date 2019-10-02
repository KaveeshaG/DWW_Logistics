package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		
		if (action.equals("IMH")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventryManagerHome.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("IRP")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/Inventory.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("IRF")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventoryForRefil.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("IPO")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrder.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("SUP")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/SupplierAccountTable.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("SALES")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/SupplierSales.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
