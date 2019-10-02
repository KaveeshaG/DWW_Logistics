package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.Inventory;
import com.wms.service.IInventoryManager;
import com.wms.service.InventoryManagerServices;

/**
 * Servlet implementation class AddRefillingItem
 */
@WebServlet("/AddRefillingItem")
public class AddRefillingItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRefillingItem() {
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
		
		//create Inventory class object
				Inventory inventory = new Inventory();
				
				//take values from Inventory.jsp page
				inventory.setName(request.getParameter("itemName"));
				inventory.setAddedDate(request.getParameter("addedDay"));
				inventory.setOwner(request.getParameter("employeeId"));
				inventory.setLocation(request.getParameter("location"));
				inventory.setDescription(request.getParameter("description"));
				inventory.setType("Refil");
				
				if(!((request.getParameter("employeeId").isEmpty()))) {
					inventory.setStatus("Allocated");
					inventory.setOwner(request.getParameter("employeeId"));
				}
				
				else {
					inventory.setStatus("Unallocated");
					inventory.setOwner("None");
				}
				
				IInventoryManager iInventoryManager = new InventoryManagerServices();
				iInventoryManager.addItems(inventory);
				
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventoryForRefil.jsp");
				dispatcher.forward(request, response);
	}

}
