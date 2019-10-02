package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.CustomerServices;
import com.wms.service.ICustomer;

/**
 * Servlet implementation class CustomerAccountDeleteById
 */
@WebServlet("/CustomerAccountDeleteById")
public class CustomerAccountDeleteById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerAccountDeleteById() {
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

//		Customer ID Validation

		boolean isInt = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("cusID"));
			isInt = true;
		} catch (Exception e) {
			isInt = false;
		}

		if (isInt) {

			if (customer.isCustomerAvailable(id)) {

				customer.customerAccountDeleteById(request.getParameter("cusID"));

				request.setAttribute("error", "Customer Deleted.!");

			} else {

				request.setAttribute("error", "Invalid Customer to delete.!");

			}
		} else {

			request.setAttribute("error", "Invalid Customer to delete.!");

		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/views/Customer/CustomerAccount.jsp");
		dispatcher.forward(request, response);
	}

}
