package com.wms.servlet;
import com.wms.service.DataAccess;
import com.wms.model.Employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author KaveeshaG
*/
/**
 * Servlet implementation class CreateEmployee
 */
@WebServlet("/create")
public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
			RequestDispatcher dispatcher = request.getRequestDispatcher("createemployee.jsp");
			dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = req.getParameter("uname");
		String name = req.getParameter("name");
		String nic = req.getParameter("nic");
		String phn = req.getParameter("phn");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String pwd = req.getParameter("pwd");
		String job = req.getParameter("job");
		
		Employee e = new Employee(0, uname, name, nic, phn, email, address, pwd, job);
		DataAccess.addNew(e);
		resp.sendRedirect("views/Admin/emplist.jsp");
	}

}
