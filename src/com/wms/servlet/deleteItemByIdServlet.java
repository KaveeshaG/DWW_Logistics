package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class deleteItemByIdServlet
 */
@WebServlet("/deleteItemByIdServlet")
public class deleteItemByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteItemByIdServlet() {
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
		IInventoryManager iInventoryManager =  new InventoryManagerServices();
		//delete selected item by using ID
		String itemNo =  request.getParameter("itemNo");
		
		
		String action = request.getParameter("action");
		
		if(action.equals("RP")) {
			
			iInventoryManager.deleteItemById(itemNo);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/Inventory.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("RF")) {
			iInventoryManager.deleteItemById(itemNo);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventoryForRefil.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("DD")) {
			
			String poID = request.getParameter("poID");
			request.setAttribute("poID", poID);
			iInventoryManager.deletePurchaseOrderDetailsById(itemNo);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/EditPurchaseOrder.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("DQOBYID")) {
			
			String poID = request.getParameter("poID");
			String qoID = request.getParameter("qoID");
			
			iInventoryManager.deleteQuoatationByID(qoID);
			int count = iInventoryManager.getQuatationCountForPo(poID);
			
			if(count == 0) {
				iInventoryManager.updatePurchaseOrderStatus("CREATED", poID);
			}
			
			request.setAttribute("poID", poID);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
			dispatcher.forward(request, response);
		}
	}

}
