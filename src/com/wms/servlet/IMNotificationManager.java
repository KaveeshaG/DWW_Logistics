package com.wms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.InventoryNotifications;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class IMNotificationManager
 */
@WebServlet("/IMNotificationManager")
public class IMNotificationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IMNotificationManager() {
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
		String action = request.getParameter("action");
		String id = request.getParameter("ID");
		String type = request.getParameter("type");

		IInventoryManager manager = new InventoryManagerServices();
		manager.updateIMNotificationStatus(id);

		String poID = request.getParameter("poID");
		request.setAttribute("poID", poID);
		if (type.equals("REQSTAPP")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/ApprovePurchaseOrder.jsp");
			dispatcher.forward(request, response);
		}
		
		if (type.equals("GIVEAPP")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
			dispatcher.forward(request, response);
		}
		
		if (type.equals("REJECTPO")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
			dispatcher.forward(request, response);
		}
		

	}

}
