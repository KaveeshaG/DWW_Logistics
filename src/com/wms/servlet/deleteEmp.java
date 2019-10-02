package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.service.DataAccess;

/**
*
* @author KaveeshaG
*/
@WebServlet("/deleteEmp")
public class deleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public deleteEmp() {
        super();
     
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empID = Integer.parseInt(request.getParameter("empId"));
		
		DataAccess.delete(empID);
		
		response.sendRedirect("views/Admin/emplist.jsp");
		
	}

}
