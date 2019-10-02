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
 * Servlet implementation class UpdateSupplierProduct
 */
@WebServlet("/UpdateSupplierProduct")
public class UpdateSupplierProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSupplierProduct() {
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
		SupplierProduct product = new SupplierProduct();
		String proID = (request.getParameter("proID"));
		
		product.setProductName(request.getParameter("productName"));
		product.setProPrice(Double.parseDouble(request.getParameter("productPrice")));
		product.setQty(Integer.parseInt(request.getParameter("productQuentity")));
		product.setWarranty(request.getParameter("warrenty"));
		product.setDescription(request.getParameter("productDescription"));

		 String newImageName = request.getParameter("imageName");
		 String oldImageName = request.getParameter("imageDbNAme");
		 
		 if(newImageName.isEmpty()) {
			 product.setImageName(oldImageName);
		 }else {
			 product.setImageName(newImageName);
		}

		 Supplier supplier =new SupplierServices();
		 supplier.updateProductByID(proID, product);
		 
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Products.jsp");
		 dispatcher.forward(request, response);
	}

}
