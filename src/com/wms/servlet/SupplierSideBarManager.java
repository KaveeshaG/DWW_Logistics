package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SupplierSideBarManager
 */
@WebServlet("/SupplierSideBarManager")
public class SupplierSideBarManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierSideBarManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		
		if(action.equals("HOME")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SupplierAccount.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("APRO")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Products.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("ASER")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Services.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("SUP")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SupplierAccountTable.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("SVIEW")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Display.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("SERVIEW")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Display.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("PKGVIEW")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Display.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("ALLVIEW")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/Display.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("SUPACNT")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SupplierProfile.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("UPDATESUP")) {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/UpdateSupplierAccount.jsp");
			dispatcher.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
