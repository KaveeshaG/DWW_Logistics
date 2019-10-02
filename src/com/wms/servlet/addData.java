package com.wms.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.dataModel;
import com.wms.util.dbConnector;


/**
 * Servlet implementation class addData
 */
@WebServlet("/addData")
public class addData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addData() {
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
		
		response.setContentType("text/html");
		
		
		
		dataModel postJob = new dataModel();
		
		postJob.setCabtype(request.getParameter("cabType"));
		postJob.setdate(request.getParameter("date"));
		postJob.settripFrom(request.getParameter("tripFrom"));
		postJob.settripTo(request.getParameter("tripTo"));
		

	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnector db = new dbConnector();					
				
				String getJobId = "SELECT jobId FROM job ORDER BY jobId DESC";
				ResultSet rs = db.getData(getJobId);
				rs.next();			
				
				int newjobId = rs.getInt("jobId") + 2;					
				System.out.println(rs.getInt("jobId"));
					
				postJob.setJobId(newjobId);				
				

				String sql = "insert into job(jobId,cabType,date,tripFrom,tripTo)values('"+postJob.getJobId()+"','"+postJob.getcabType()+"','"+postJob.getdate()+"','"+postJob.gettripFrom()+"','"+postJob.gettripTo()+"')";
				db.setData(sql);		
				
				response.sendRedirect("views/Transport/jobPost.jsp");
								
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	
		
}
				
		
	


