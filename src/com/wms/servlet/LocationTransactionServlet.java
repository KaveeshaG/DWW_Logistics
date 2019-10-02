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
 * Servlet implementation class LocationTransactionServlet
 */
@WebServlet("/LocationTransactionServlet")
public class LocationTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		LocationTransaction lt = new LocationTransaction();
	
		lt.setCurrentLoc(request.getParameter("currentL"));
		lt.setCustomerId(request.getParameter("cusName"));
		lt.setGRNNo(request.getParameter("grn"));
		lt.setDestiLoc(request.getParameter("destinationL"));
		lt.setReason(request.getParameter("reason"));
		lt.setStatus(0);
		
		
		ILocationTransactionService iLocationTransactionService = new LocationTransactionImpl();
		iLocationTransactionService.locationTransaction(lt);

	
		response.sendRedirect("views/GoodHandling/LocationTransactionRequest.jsp");
		
	}

}
