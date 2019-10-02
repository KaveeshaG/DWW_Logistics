package com.wms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wms.model.SupplierAcount;
import com.wms.service.Supplier;
import com.wms.service.SupplierServices;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		HttpSession session = request.getSession();
		
		
		
		try {
			
			if (action.equals("REG")) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SignUp.jsp");
				dispatcher.forward(request, response);
			}
			
			if (action.equals("LOGIN")) {
				String un = request.getParameter("userName");
				String pwd = request.getParameter("password");
				
				
				if (un.charAt(0) == 'S' && un.charAt(1) == 'U' && un.charAt(2) == 'P') {
					Supplier supplier = new SupplierServices();
					SupplierAcount acount = supplier.getSupplierDetailsByID(un);
					
					if (acount.getSupplierId().equals(un) && acount.getPassword().equals(pwd)) {
						
						
						session.setAttribute("Supplier", acount);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Supplier/SupplierAccount.jsp");
						dispatcher.forward(request, response);
					}
					
					else {
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
						dispatcher.forward(request, response);
					}
				}
				else if (un.charAt(0) == 'I' && un.charAt(1) == 'M' && pwd.equals("1234")) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/InventoryManager/InventryManagerHome.jsp");
					dispatcher.forward(request, response);
				}
				
				else if(un.equals("cus") && pwd.equals("cus")) {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Customer/CustomerAccount.jsp");
					dispatcher.forward(request, response);					
				}
				
				else {
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
					dispatcher.forward(request, response);
				}
				
				
				
				
				
				
			}
			
		} catch (Exception e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
