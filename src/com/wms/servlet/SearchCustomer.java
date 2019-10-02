package com.wms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.CustomerAccount;
import com.wms.service.CustomerServices;
import com.wms.service.ICustomer;

/**
 * Servlet implementation class SearchCustomer
 */
@WebServlet("/SearchCustomer")
public class SearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stype = request.getParameter("stype");
		String txt = request.getParameter("txt");
		String resp = "";

		if (!txt.equals("")) {

			if (stype.equals("1")) {

				ICustomer customer = new CustomerServices();
				ArrayList<CustomerAccount> accounts = customer.searchCustomerById(txt);
				for (CustomerAccount account : accounts) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + account.getCustomerId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getCustomerName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getType() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getEmail() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getMobile() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateCustomer\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + account.getCustomerId()
							+ "\"\r\n" + "							name=\"cusId\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"CustomerAccountDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"cusID\"\r\n"
							+ "							value=\"" + account.getCustomerId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);

			} else if (stype.equals("2")) {

				ICustomer customer = new CustomerServices();
				ArrayList<CustomerAccount> accounts = customer.searchCustomerByName(txt);
				for (CustomerAccount account : accounts) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + account.getCustomerId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getCustomerName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getType() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getEmail() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getMobile() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateCustomer\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + account.getCustomerId()
							+ "\"\r\n" + "							name=\"cusId\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"CustomerAccountDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"cusID\"\r\n"
							+ "							value=\"" + account.getCustomerId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);
				
			} else if (stype.equals("3")) {


				ICustomer customer = new CustomerServices();
				ArrayList<CustomerAccount> accounts = customer.searchCustomerByType(txt);
				for (CustomerAccount account : accounts) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + account.getCustomerId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getCustomerName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getType() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getEmail() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getMobile() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateCustomer\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + account.getCustomerId()
							+ "\"\r\n" + "							name=\"cusId\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"CustomerAccountDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"cusID\"\r\n"
							+ "							value=\"" + account.getCustomerId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);
				
				
			} else if (stype.equals("4")) {


				ICustomer customer = new CustomerServices();
				ArrayList<CustomerAccount> accounts = customer.searchCustomerByEmail(txt);
				for (CustomerAccount account : accounts) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + account.getCustomerId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getCustomerName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getType() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getEmail() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getMobile() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateCustomer\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + account.getCustomerId()
							+ "\"\r\n" + "							name=\"cusId\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"CustomerAccountDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"cusID\"\r\n"
							+ "							value=\"" + account.getCustomerId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);
				
				
			} else if (stype.equals("5")) {


				ICustomer customer = new CustomerServices();
				ArrayList<CustomerAccount> accounts = customer.searchCustomerByMobile(txt);
				for (CustomerAccount account : accounts) {

					resp += "<tr>\r\n" + "				<th scope=\"row\">" + account.getCustomerId() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getCustomerName() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getType() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getEmail() + "</th>\r\n"
							+ "				<th scope=\"row\">" + account.getMobile() + "</th>\r\n"
							+ "				<td>\r\n"
							+ "					<form action=\"UpdateCustomer\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" value=\"" + account.getCustomerId()
							+ "\"\r\n" + "							name=\"cusId\" />\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-primary\">Update\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "				<td>\r\n"
							+ "					<form action=\"CustomerAccountDeleteById\" method=\"POST\">\r\n"
							+ "						<input type=\"hidden\" name=\"cusID\"\r\n"
							+ "							value=\"" + account.getCustomerId() + "\">\r\n"
							+ "						<button type=\"submit\" class=\"btn btn-danger m-0\">delete\r\n"
							+ "							Customer</button>\r\n" + "					</form>\r\n"
							+ "				</td>\r\n" + "			</tr>";

				}

				response.getWriter().write(resp);
				
				
			} else {
				response.getWriter().write("1");
			}

		} else {

			response.getWriter().write("0");

		}

	}

}
