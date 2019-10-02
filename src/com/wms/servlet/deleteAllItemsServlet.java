 package com.wms.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.Quotation;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class deleteAllItemsServlet
 */
@WebServlet("/deleteAllItemsServlet")
public class deleteAllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAllItemsServlet() {
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
	
		String action = request.getParameter("action");
		
		if(action.equals("RP")) {
			
			//delete all items from Inventory Table
			IInventoryManager iInventoryManager =  new InventoryManagerServices();
			iInventoryManager.deleteAllItems("Replace");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/Inventory.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("RF")) {
			
			//delete all items from Inventory Table
			IInventoryManager iInventoryManager =  new InventoryManagerServices();
			iInventoryManager.deleteAllItems("Refil");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventoryForRefil.jsp");
			dispatcher.forward(request, response);
		}
		
		
		if(action.equals("DAPO")) {
			
			//delete all items from Inventory Table
			IInventoryManager iInventoryManager =  new InventoryManagerServices();
			iInventoryManager.deleteALLPO();
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrder.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

}
