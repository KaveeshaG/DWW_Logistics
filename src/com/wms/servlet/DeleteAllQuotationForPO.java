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
 * Servlet implementation class DeleteAllQuotationForPO
 */
@WebServlet("/DeleteAllQuotationForPO")
public class DeleteAllQuotationForPO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAllQuotationForPO() {
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
		ArrayList<Quotation> list = iInventoryManager.getQuoationList(poID);
		
		
		for (Quotation quotation : list) {
			iInventoryManager.deleteQuoatationByID(quotation.getQuotationID());
		}

		iInventoryManager.updatePurchaseOrderStatus("CREATED", poID);
		request.setAttribute("poID", poID);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/PurchaseOrderDetails.jsp");
		dispatcher.forward(request, response);
	}

}
