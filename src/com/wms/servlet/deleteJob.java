package com.wms.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.dataModel;
import com.wms.util.dbConnector;

/**
 * Servlet implementation class deleteJob
 */
@WebServlet("/deleteJob")
public class deleteJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteJob() {
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
		
		dataModel data = new dataModel();
		data.setDeleteId(Integer.valueOf(request.getParameter("id")));
		
		try {
			dbConnector con = new dbConnector();
			
			String sql = "DELETE FROM job WHERE jobId="+data.getDeleteId();					
			con.setData(sql);			
			
			
		}catch( Exception e) {
			System.out.println(e);
		}
		
		doGet(request, response);
		
	}

}
