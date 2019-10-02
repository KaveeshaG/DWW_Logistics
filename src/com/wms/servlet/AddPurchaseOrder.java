package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.PurchaseOrderHead;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class AddPurchaseOrder
 */
@WebServlet("/AddPurchaseOrder")
public class AddPurchaseOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPurchaseOrder() {
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
		PurchaseOrderHead head =  new PurchaseOrderHead();
		head.setDate(request.getParameter("date"));
		head.setDescription(request.getParameter("description"));
		
		
		IInventoryManager iInventoryManager =  new InventoryManagerServices();
		String poId =  iInventoryManager.addPurchaseOrderHead(head);
		System.out.println(poId);
		
		request.setAttribute("poID", poId);
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/EditPurchaseOrder.jsp");
		dispatcher.forward(request, response);
	}

}
