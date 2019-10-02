package com.wms.servlet;
import com.wms.service.DataAccess;
import com.google.gson.Gson;
import com.wms.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/updateEmp")
public class UpdateEmployee extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        Employee e = DataAccess.getEmployeeById(Integer.parseInt(request.getParameter("id")));
        
		Gson gson = new Gson();
		
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(e));
		out.flush();
		out.close();
        
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    	int id = Integer.parseInt(req.getParameter("emp"));
		String name = req.getParameter("name");
		String nic = req.getParameter("nic");
		String phn = req.getParameter("phone");
		String email = req.getParameter("email");
		String address = req.getParameter("address");

		
		DataAccess.update(name,nic,email,address,phn,id);
		resp.sendRedirect("views/Admin/emplist.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}