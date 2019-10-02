package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.CustomValidation;
import com.wms.model.CustomerAccount;
import com.wms.service.CustomerServices;
import com.wms.service.ICustomer;

/**
 * Servlet implementation class EditCustomerServlet
 */
@WebServlet("/EditCustomerServlet")
public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCustomerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String mobile = request.getParameter("number");

		ICustomer customer = new CustomerServices();

//		Customer ID Validation

		boolean isInt2 = false;
		int cid = 0;
		try {
			cid = Integer.parseInt(request.getParameter("customerID"));
			isInt2 = true;
		} catch (Exception e) {
			isInt2 = false;
		}

		if (isInt2) {

			if (customer.isCustomerAvailable(cid)) {

				// Empty Validation
				if (!(name.equals("") || type.equals("") || nic.equals("") || email.equals("") || mobile.equals(""))) {

					// Email Validation
					if (CustomValidation.emailValidation(email)) {

						// Mobile Number Validation
						boolean isInt = false;
						try {
							Integer.parseInt(mobile);
							isInt = true;
						} catch (Exception e) {
							isInt = false;
						}
						System.out.println(isInt + "-" + mobile.length() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

						if (isInt && mobile.length() == 10) {

							CustomerAccount account = new CustomerAccount();

							account.setCustomerId(cid);
							account.setCustomerName(name);
							account.setType(type);
							account.setNic(nic);
							account.setEmail(email);
							account.setMobile(mobile);

							System.out.println("Updated");

							customer.updateCustomerById(account.getCustomerId(), account);

						} else {

							request.setAttribute("error", "Invalid Mobile Number.!");

						}

					} else {

						request.setAttribute("error", "Invalid Email Address.!");

					}

				} else {

					request.setAttribute("error", "Some details are empty.!");

				}

			} else {

				request.setAttribute("error", "Invalid Customer.!");

			}
		} else {

			request.setAttribute("error", "Invalid Customer.!");

		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/views/Customer/CustomerAccount.jsp");
		dispatcher.forward(request, response);

	}

}
