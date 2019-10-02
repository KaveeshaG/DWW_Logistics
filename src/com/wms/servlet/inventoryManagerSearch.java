package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.Inventory;
import com.wms.model.PurchaseOrderHead;
import com.wms.model.Quotation;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class inventoryManagerSearch
 */
@WebServlet("/inventoryManagerSearch")
public class inventoryManagerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inventoryManagerSearch() {
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
		
		String search = request.getParameter("serchTag");
		IInventoryManager manager =  new InventoryManagerServices();
		
		char i1 = 'I';
		char i2 = 'T';
		char i3 = 'M';
		char i4 = 'P';
		char i5 = 'O';
		char i6 = 'Q';
		
		
		if(search.isEmpty()) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PageNotFound.jsp");
			dispatcher.forward(request, response);
		}
		
		
		else {
			
			if(search.charAt(0) == i1 && search.charAt(1) == i2 && search.charAt(2) == i3) {
				
				Inventory inventory = manager.getInventoryItemById(search);
				if(inventory.getItemNo() == null) {
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PageNotFound.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("inventoryID", search);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventoryItemView.jsp");
					dispatcher.forward(request, response);
				}
			}
			
			
			else if(search.charAt(0) == i4 && search.charAt(1) == i5) {
				
				PurchaseOrderHead head= manager.getPoHeadDetailsList(search);
				
				if(head.getPoId() == null) {
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PageNotFound.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("poID", search);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
					dispatcher.forward(request, response);
				}
			}
			
			else if(search.charAt(0) == i6 && search.charAt(1) == i5) {
				
				Quotation quotation= manager.getQuoationByID(search);
				String qoid = quotation.getQuotationID();
				String poid = quotation.getPoId();
				
				if(qoid == null) {
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PageNotFound.jsp");
					dispatcher.forward(request, response);
				}
				else {
					request.setAttribute("poID", poid);
					request.setAttribute("qoID", qoid);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/QuotationDetails.jsp");
					dispatcher.forward(request, response);
				}
			}
			
			else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PageNotFound.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
	}

}
