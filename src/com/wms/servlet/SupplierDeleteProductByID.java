package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.Supplier;
import com.wms.service.SupplierServices;

/**
 * Servlet implementation class SupplierDeleteProductByID
 */
@WebServlet("/SupplierDeleteProductByID")
public class SupplierDeleteProductByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierDeleteProductByID() {
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
		
		Supplier supplier = new SupplierServices();
		supplier.deleteProductById(request.getParameter("productID"));
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Products.jsp");
		dispatcher.forward(request, response);
	}

}
