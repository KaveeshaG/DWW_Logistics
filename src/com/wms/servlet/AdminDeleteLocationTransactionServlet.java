package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.LocationTransaction;
import com.wms.service.ILocationTransactionService;
import com.wms.service.LocationTransactionImpl;

/**
 * Servlet implementation class AdminDeleteLocationTransactionServlet
 */
@WebServlet("/AdminDeleteLocationTransactionServlet")
public class AdminDeleteLocationTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteLocationTransactionServlet() {
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
		response.setContentType("text/html");

		String ID = request.getParameter("id");			
		
		ILocationTransactionService iLocationTransactionService = new LocationTransactionImpl();
		LocationTransaction lt = new LocationTransaction();
		lt.setId(ID);
		
		iLocationTransactionService.adminDeleteTransaction(lt);
	

		response.sendRedirect("views/Admin/LocationTransactionAdmin.jsp");
		 
	}

}
