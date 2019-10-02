package com.wms.servlet;
import com.wms.service.DataAccess;
import com.wms.model.Employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author KaveeshaG
 */
@WebServlet("/employee")
public class AllEmployee extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	List<Employee> employees = DataAccess.getAll();
    	System.out.println(employees.size());
    	
    	for(Employee emp : employees) {
    		System.out.println(emp.getName());
    	}
        
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("AllEmployee", employees);
        
        response.sendRedirect("views/Admin/emplist.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	// create new employee
    	
        
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException{
    		
    		int id = Integer.parseInt(request.getParameter("id"));
    		boolean result = DataAccess.delete(id);
    		
    		if (result) {
    			response.sendRedirect("views/Adminemployee");
    		} else {
    			// show error message
    			System.out.println("Could not delete employee");
    		}
    		
    	
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
