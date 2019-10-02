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
import com.wms.model.Quotation;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class RejectPurchaseOrder
 */
@WebServlet("/RejectPurchaseOrder")
public class RejectPurchaseOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RejectPurchaseOrder() {
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
		IInventoryManager iInventoryManager =  new InventoryManagerServices();
		iInventoryManager.updatePurchaseOrderStatus("REJECTED", poID);
		
		ArrayList<Quotation> list = iInventoryManager.getQuoationList(poID);
		
		
		for (Quotation quotation : list) {
			iInventoryManager.deleteQuoatationByID(quotation.getQuotationID());
		}
		
		InventoryNotifications notifications =  new InventoryNotifications();
		notifications.setDescription("Purchase Order " + poID + " Get Rejected!");
		notifications.setOwner("IM");
		notifications.setRemaining(0);
		notifications.setDataID(poID);
		notifications.setType("REJECTPO");
		iInventoryManager.addIMNotification(notifications);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventryManagerHome.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
