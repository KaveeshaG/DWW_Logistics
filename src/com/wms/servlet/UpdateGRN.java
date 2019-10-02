package com.wms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wms.model.GRN;
import com.wms.service.GoodHandlingServiceImpl;
import com.wms.service.IGoodHandlingService;


@WebServlet("/UpdateGRN")
public class UpdateGRN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateGRN() {
        super();      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GRN grn = new GRN();
		grn.setContainerNo(request.getParameter("containerNo"));
		grn.setVehicleNo(request.getParameter("vehicleNo"));
		grn.setTrailerNo(request.getParameter("trailerNo"));
		grn.setGRNNo(request.getParameter("GRN"));
		
		IGoodHandlingService goodHandlingService = new GoodHandlingServiceImpl();
		goodHandlingService.updateGRN(grn);
		
		response.sendRedirect("views/GoodHandling/overviewgrn.jsp");
		
	}

}
