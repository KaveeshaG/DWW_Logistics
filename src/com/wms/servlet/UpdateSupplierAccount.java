package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.SupplierAcount;
import com.wms.service.Supplier;
import com.wms.service.SupplierServices;

/**
 * Servlet implementation class UpdateSupplierAccount
 */
@WebServlet("/UpdateSupplierAccount")
public class UpdateSupplierAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierAccount() {
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
		
		SupplierAcount supplier = new SupplierAcount();
		String place = request.getParameter("place");
		supplier.setSupplierId(request.getParameter("supID"));
		supplier.setUserName(request.getParameter("UserName"));
		supplier.setPassword(request.getParameter("Password"));
		supplier.setName(request.getParameter("Name"));
		supplier.setAddress(request.getParameter("Address"));
		supplier.setEmail(request.getParameter("Email"));
		supplier.setContactNo(request.getParameter("ContactNumber"));
		supplier.setReview(request.getParameter("Review"));
		
		System.out.println(supplier);
		
		
		Supplier supplier2 = new SupplierServices();
		supplier2.updateSupplierAccountByID(supplier);
		
		if (place.equals("IM")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/SupplierAccountTable.jsp");
			dispatcher.forward(request, response);
		}else {

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SupplierProfile.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
