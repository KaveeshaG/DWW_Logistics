package com.wms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.Filter;
import com.sun.net.httpserver.Filter.Chain;
import javax.servlet.FilterConfig;
import com.wms.servlet.ErrorMessages;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: KaveeshaG
 */
@WebServlet("/CreateEmpValidation")
public class CreateEmpValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEmpValidation() {
        super();
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("ctreateemployee") != null)
		{
		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			ArrayList<String> errorMsg = new ArrayList<String> ();
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			if(username.equals(""))
			{
				errorMsg.add(ErrorMessages.USERNAME_REQUIRED);
			}
			else if(!(Pattern.matches("^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?",username)))
			{
				errorMsg.add(ErrorMessages.INVALID_USERNAME);
			}
				
			if(password.equals(""))
			{
				errorMsg.add(ErrorMessages.PASSWORD_REQUIRED);
			}
			
			if(errorMsg.size() == 0)
			{
				// pass the request along the filter chain
//				Chain.doFilter(request,response);
			}
			else
			{
				request.setAttribute("errorMsg",errorMsg);
				request.getRequestDispatcher("createemployee.jsp").forward(request, response);
			}
		}
		else
		{
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			httpServletResponse.sendRedirect("createemployee.jsp");
			return;
		}
	}
	
	
	public void destroy() {
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
