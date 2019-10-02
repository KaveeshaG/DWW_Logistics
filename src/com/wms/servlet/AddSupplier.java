package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.SupplierAcount;
import com.wms.model.SupplierProduct;
import com.wms.service.Supplier;
import com.wms.service.SupplierServices;

/**
 * Servlet implementation class AddSupplier
 */
@WebServlet("/AddSupplier")
public class AddSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSupplier() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String action = request.getParameter("action");
		SupplierAcount supplier = new SupplierAcount();

		supplier.setUserName(request.getParameter("UserName"));
		supplier.setPassword(request.getParameter("Password"));
		supplier.setName(request.getParameter("Name"));
		supplier.setAddress(request.getParameter("Address"));
		supplier.setEmail(request.getParameter("Email"));
		supplier.setContactNo(request.getParameter("ContactNumber"));
		supplier.setReview(request.getParameter("Review"));

		Supplier supplier2 = new SupplierServices();
		supplier2.addSuppliers(supplier);

		if (action.equals("SIGNUP")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		
		if (action.equals("IM")){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/SupplierAccountTable.jsp");
			dispatcher.forward(request, response);
		}

	}

}
