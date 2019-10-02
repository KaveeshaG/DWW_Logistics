package com.wms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.dataModel;
import com.wms.util.dbConnector;

/**
 * Servlet implementation class addDriverData
 */
@WebServlet("/addDriverData")
public class addDriverData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addDriverData() {
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
		response.setContentType("application/json");     
	

		System.out.println("fsdfdf");
		
		dataModel driverData = new dataModel();
		
		driverData.setName(request.getParameter("Fname") +" "+ request.getParameter("Lname"));
		driverData.setEmail(request.getParameter("email"));
		driverData.setAddress(request.getParameter("address1")+" ",request.getParameter("address2"));
		driverData.setCity(request.getParameter("city"));
		driverData.setGender(request.getParameter("gender"));	
		driverData.setMobileNum(Integer.valueOf(request.getParameter("mobileNum")));
		driverData.setVehicleNum(request.getParameter("vehicleNumber"));
		driverData.setVehicleType(request.getParameter("vehicalType"));
		driverData.setVehicleModel(request.getParameter("vehicleModel"));
		driverData.setRdate(request.getParameter("insuranceRenewalDate"));
		driverData.setTRDate(request.getParameter("taxRenewalDate"));
		
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbConnector db = new dbConnector();				

				String getDriver = "SELECT did FROM driver_info ORDER BY did DESC";
				ResultSet rs = db.getData(getDriver);
				rs.next();			
				
				int newDriver = rs.getInt("did") + 2;		
						
				driverData.setDriverId(newDriver);	
				
				String getVId = "SELECT vid FROM vehicle_info ORDER BY vid DESC";	
				ResultSet rsT = db.getData(getVId);
				rsT.next();
				int newVId = rsT.getInt("vid")+ 2;
				driverData.setVid(newVId);				

				String sql = "insert into driver_info(did,fullName,address,city,email,gender,contactNumber)values('"+driverData.getDriverId()+"','"+driverData.getName()+"','"+driverData.getAddress()+"','"+driverData.getCity()+"','"+driverData.getEmail()+"','"+driverData.getGender()+"','"+driverData.getMobileNumber()+"')";
				db.setData(sql);
				
				String vTSql = "insert into vehicle_info(vid,vNum,vType,vModel,irDate,trDate)values('"+driverData.getVid()+"','"+driverData.getVNum()+"','"+driverData.getVtype()+"','"+driverData.getVmodel()+"','"+driverData.getIRDate()+"','"+driverData.getTRDate()+"')";
				db.setData(vTSql);

			
				response.getWriter().println("success");
				
				} catch (Exception e2) {
					System.out.println(e2);
				}
		

			
	}
	
		

	}


