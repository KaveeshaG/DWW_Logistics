package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.SupplierProduct;
import com.wms.service.Supplier;
import com.wms.service.SupplierServices;

/**
 * Servlet implementation class SupplierSearchBar
 */
@WebServlet("/SupplierSearchBar")
public class SupplierSearchBar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierSearchBar() {
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
		
		String serchTag = request.getParameter("serchTag");
		Supplier supplier = new SupplierServices();
		SupplierProduct product  = new SupplierProduct();
		
		if(serchTag.isEmpty()) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/PageNotFound.jsp");
			dispatcher.forward(request, response);
		}
		
		else {
			
			if (serchTag.charAt(0) == 'P' && serchTag.charAt(1) == 'R' && serchTag.charAt(2) == 'O') {
				
				product = supplier.getProductByID(serchTag);
				
				if(product.getProductId() == null) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/PageNotFound.jsp");
					dispatcher.forward(request, response);
				}
				
				else {
					
					request.setAttribute("proID", serchTag);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SearchProduct.jsp");
					dispatcher.forward(request, response);
				}
				
				
				
				
			}else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/PageNotFound.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
