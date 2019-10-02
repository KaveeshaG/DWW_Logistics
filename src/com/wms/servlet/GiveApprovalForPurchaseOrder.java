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
 * Servlet implementation class GiveApprovalForPurchaseOrder
 */
@WebServlet("/GiveApprovalForPurchaseOrder")
public class GiveApprovalForPurchaseOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveApprovalForPurchaseOrder() {
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
		String qoID = request.getParameter("qoID");
		System.out.println(poID);
		System.out.println(qoID);
		IInventoryManager iInventoryManager =  new InventoryManagerServices();
		iInventoryManager.updatePurchaseOrderStatus("APPROVED", poID);
		iInventoryManager.updateQuotationStatus("APPROVED", qoID);
		
		ArrayList<Quotation> list = iInventoryManager.getQuotationByIdAndStatus("REQUESTING", poID);
		
		for (Quotation quotation : list) {
			iInventoryManager.deleteQuoatationByID(quotation.getQuotationID());
		}
		
		InventoryNotifications notifications =  new InventoryNotifications();
		notifications.setDescription("Purchase Order " + poID + "Get Approved!");
		notifications.setOwner("IM");
		notifications.setRemaining(0);
		notifications.setDataID(poID);
		notifications.setType("GIVEAPP");
		iInventoryManager.addIMNotification(notifications);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventryManagerHome.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
