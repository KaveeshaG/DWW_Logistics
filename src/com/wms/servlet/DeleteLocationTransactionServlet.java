package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.ILocationTransactionService;
import com.wms.service.LocationTransactionImpl;

/**
 * Servlet implementation class DeleteLocationTransactionServlet
 */
@WebServlet("/DeleteLocationTransactionServlet")
public class DeleteLocationTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLocationTransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String ID = request.getParameter("id");			
		
		
		ILocationTransactionService iLocationTransactionService = new LocationTransactionImpl();
		iLocationTransactionService.removeLocationTransactionReq(ID);

		response.sendRedirect("views/GoodHandling/LocationTransactionRequest.jsp");
		
	}

}
