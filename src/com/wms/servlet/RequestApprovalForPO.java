package com.wms.servlet;

import java.io.IOException;

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
 * Servlet implementation class RequestApprovalForPO
 */
@WebServlet("/RequestApprovalForPO")
public class RequestApprovalForPO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestApprovalForPO() {
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
		
		String poID = request.getParameter("poID");
		System.out.println("adfdrgdsthsgfh" + poID);
		IInventoryManager iInventoryManager =  new InventoryManagerServices();
		

		iInventoryManager.updatePurchaseOrderStatus("PENDING", poID);
		
		InventoryNotifications notifications =  new InventoryNotifications();
		notifications.setDescription("Approval needed for Purchase Order - " + poID);
		notifications.setOwner("Manager");
		notifications.setRemaining(0);
		notifications.setDataID(poID);
		notifications.setType("REQSTAPP");
		iInventoryManager.addIMNotification(notifications);
		request.setAttribute("poID", poID);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventryManagerHome.jsp");
		dispatcher.forward(request, response);
	}

}
