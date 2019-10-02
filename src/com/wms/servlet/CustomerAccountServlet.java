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
 * Servlet implementation class CustomerAccountServlet
 */
@WebServlet("/CustomerAccountServlet")
public class CustomerAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CustomerAccountServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("CustomerName");
		String type = request.getParameter("type");
		String nic = request.getParameter("NIC");
		String email = request.getParameter("Email");
		String mobile = request.getParameter("Number");
		String pword = request.getParameter("Password");

		// Empty Validation
		if (!(name.equals("") || type.equals("") || nic.equals("") || email.equals("") || mobile.equals("")
				|| pword.equals(""))) {
			// Email Validation
			if (CustomValidation.emailValidation(email)) {

				// Password Validation
				if (pword.length() > 3) {

					// Mobile Number Validation
					boolean isInt = false;
					try {
						Integer.parseInt(mobile);
						isInt = true;
					} catch (Exception e) {
						isInt = false;
					}
//					System.out.println(isInt + "-" + mobile.length() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

					if (isInt && mobile.length() == 10) {

						CustomerAccount account = new CustomerAccount();
						account.setCustomerName(name);
						account.setType(type);
						account.setNic(nic);
						account.setEmail(email);
						account.setMobile(mobile);
						account.setPassword(pword);

						ICustomer customer = new CustomerServices();
						customer.addCustomer(account);

					} else {

						request.setAttribute("error", "Invalid Mobile Number.!");

					}

				} else {

					request.setAttribute("error", "Password is too short.!");

				}

			} else {

				request.setAttribute("error", "Invalid Email Address.!");

			}

		} else {

			request.setAttribute("error", "Some details are empty.!");

		}

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/views/Customer/CustomerAccount.jsp");
		dispatcher.forward(request, response);

	}

}
