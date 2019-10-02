package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.CustomerAccount;
import com.wms.service.CustomerServices;
import com.wms.service.ICustomer;

/**
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomer() {
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

		ICustomer customer = new CustomerServices();

		boolean isInt2 = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cusId"));
			isInt2 = true;
		} catch (Exception e) {
			isInt2 = false;
		}

		if (isInt2) {

			if (customer.isCustomerAvailable(id)) {

				CustomerAccount customerAccount = customer.getCustomerByID(id);

				request.setAttribute("cus", customerAccount);
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Customer/EditCustomer.jsp");
				dispatcher.forward(request, response);

			} else {

				request.setAttribute("error", "Invalid Customer.!");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/WEB-INF/views/Customer/CustomerAccount.jsp");
				dispatcher.forward(request, response);

			}
		} else {

			request.setAttribute("error", "Invalid Customer.!");
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Customer/CustomerAccount.jsp");
			dispatcher.forward(request, response);

		}

	}

}
