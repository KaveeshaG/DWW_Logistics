package com.wms.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.media.sound.SF2GlobalRegion;
import com.wms.model.SupplierProduct;
import com.wms.service.Supplier;
import com.wms.service.SupplierServices;

/**
 * Servlet implementation class AddNewProduct
 */
@WebServlet("/AddNewProduct")
public class AddNewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewProduct() {
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
		
		SupplierProduct product = new SupplierProduct();
		product.setProductName(request.getParameter("productName"));
		product.setProPrice(Double.parseDouble(request.getParameter("productPrice")));
		product.setQty(Integer.parseInt(request.getParameter("productQuentity")));
		product.setWarranty(request.getParameter("warrenty"));
		product.setDescription(request.getParameter("productDescription"));
		product.setSupplierId(request.getParameter("supID"));
		product.setImageName(request.getParameter("imageName"));
		
		System.out.println(product.getSupplierId());
		System.out.println(product);
		
		Supplier supplier = new SupplierServices();
		supplier.addProduct(product);	
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Products.jsp");
		dispatcher.forward(request, response);
		
	}

}
